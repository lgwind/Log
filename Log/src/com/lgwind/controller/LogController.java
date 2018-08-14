package com.lgwind.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgwind.util.FileIO;
import com.lgwind.util.IData;
import com.lgwind.util.ILog;

@Controller
@RequestMapping("/log")
public class LogController {
    
    /**
     * Ҫ��ѯ������
     */
    public static String checkName = "Lgwind";
    /**
     * ��־�����·��
     */
    public static String logSavePath = "D:/Lgwind/apache-tomcat-6.0.43/webapps/Log/file";
    

	/**
	 * ��ת����־����ϵͳ��ҳ
	 * @param model
	 * @return
	 */
	@RequestMapping("logPage")
	public String logPage(@RequestParam(value="year",required=false) Integer year, @RequestParam(value="month",required=false) Integer month,Model model) {
		System.out.println("\n��ת����־����ϵͳ��ҳ");
		//��û�в���year��������ԭ����ֵ
		if(year==null){
		}else{
		    //���в���year�������øò���
		    IData.year=year;
		}
		//��û�в���month��������ԭ����ֵ
		if(month==null){
		}else{
		    //���в���month�������øò���
		    IData.month=month;
		    //�������·ݵ�ֵ����12�£����Ϊ��һ��1��
		    if(month>12){
		        IData.month=1;
		        IData.year++;
		    }
		    //�������·ݵ�ֵС��1�£����Ϊ��һ��12��
		    else if(month<1){
		        IData.month=12;
		        IData.year--;
		    }
		}
		//��ȡѡ���µ������������ַ�������
		String [] days = IData.days(IData.year, IData.month);
		//�����������ַ���������Ϣ
		model.addAttribute("days", days);
		
		//��ȡָ��Ŀ¼�µ������ļ��ļ���
		List<File> wjList=FileIO.getFiles(logSavePath);
		//��ȡָ��Ŀ¼�µ������ļ������ݼ���
		List<String> contentList = FileIO.readFiles(wjList);
		//��ȡ�ļ����Ϻ����ݼ���
		List<ILog> logList = new ArrayList<ILog>();
		for(int i=0; i<wjList.size(); i++){
	        ILog log = new ILog();
	        log.setTitle(ILog.title(wjList.get(i).toString()));
		    log.setName(ILog.name(wjList.get(i).toString()));
		    log.setContent(contentList.get(i));
		    logList.add(log);
		}
		logList=ILog.rank(logList, "");
		//�����ļ��ļ��Ϻ����ݵļ�����Ϣ
		model.addAttribute("logList", logList);
		
		return "logPage";
	}
	
	/**
	 * ��õ������������
	 * @param day
	 * @param model
	 * @return
	 */
	@RequestMapping("day")
	public String day(@RequestParam(value="day",required=false) Integer day,Model model) {
	    System.out.print("\n�����:\n "+IData.year+"��"+IData.month+"��"+day+"�գ�"+IData.numDay(IData.weekOfDay(IData.year, IData.month, day)));
	    return "redirect:/log/logPage";
	}

	/**
	 * �޸�Ҫ��ѯ����־������
	 * @return
	 */
	@RequestMapping("checkName")
	public String checkName(@RequestParam(value="name",required=false) String name){
	    System.out.print("\nҪ��ѯ����־�������޸�Ϊ��"+name);
	    checkName=name;
	    return "redirect:/log/logPage";
	}
	
	/**
	 * �����־
     * @return
     */
    @RequestMapping("addLog")
    public String addLog(ILog log){
        System.out.print("\n�����־��\n"+log.getName()+"-"+log.getTitle());
        FileIO.write(logSavePath, log.getName()+"-"+log.getTitle()+".txt", log.getContent(), "GB2312", false);
        return "redirect:/log/logPage";
    }
    
    /**
     * �޸���־
     * @return
     */
    @RequestMapping("updateLog")
    public String updateLog(ILog log){
        System.out.print("\n�޸���־��\n"+log.getName()+"-"+log.getTitle());
        FileIO.write(logSavePath, log.getName()+"-"+log.getTitle()+".txt", log.getContent(), "GB2312", true);
        return "redirect:/log/logPage";
    }
    
    /**
     * ɾ����־
     * @return
     */
    @RequestMapping("deleteLog")
    public String deleteLog(@RequestParam(value="title",required=false) String title){
        FileIO.delete(logSavePath, title+".txt");
        return "redirect:/log/logPage";
    }
	
	

}
