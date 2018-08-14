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
     * 要查询的姓名
     */
    public static String checkName = "Lgwind";
    /**
     * 日志保存的路径
     */
    public static String logSavePath = "D:/Lgwind/apache-tomcat-6.0.43/webapps/Log/file";
    

	/**
	 * 跳转到日志管理系统首页
	 * @param model
	 * @return
	 */
	@RequestMapping("logPage")
	public String logPage(@RequestParam(value="year",required=false) Integer year, @RequestParam(value="month",required=false) Integer month,Model model) {
		System.out.println("\n跳转到日志管理系统首页");
		//若没有参数year，则引用原来的值
		if(year==null){
		}else{
		    //若有参数year，则引用该参数
		    IData.year=year;
		}
		//若没有参数month，则引用原来的值
		if(month==null){
		}else{
		    //若有参数month，则引用该参数
		    IData.month=month;
		    //当参数月份的值大于12月，则改为下一年1月
		    if(month>12){
		        IData.month=1;
		        IData.year++;
		    }
		    //当参数月份的值小于1月，则改为上一年12月
		    else if(month<1){
		        IData.month=12;
		        IData.year--;
		    }
		}
		//获取选择月的日历天数表字符串数组
		String [] days = IData.days(IData.year, IData.month);
		//返回日历表字符串数组信息
		model.addAttribute("days", days);
		
		//获取指定目录下的所有文件的集合
		List<File> wjList=FileIO.getFiles(logSavePath);
		//获取指定目录下的所有文件的内容集合
		List<String> contentList = FileIO.readFiles(wjList);
		//获取文件集合和内容集合
		List<ILog> logList = new ArrayList<ILog>();
		for(int i=0; i<wjList.size(); i++){
	        ILog log = new ILog();
	        log.setTitle(ILog.title(wjList.get(i).toString()));
		    log.setName(ILog.name(wjList.get(i).toString()));
		    log.setContent(contentList.get(i));
		    logList.add(log);
		}
		logList=ILog.rank(logList, "");
		//返回文件的集合和内容的集合信息
		model.addAttribute("logList", logList);
		
		return "logPage";
	}
	
	/**
	 * 获得点击的天数数据
	 * @param day
	 * @param model
	 * @return
	 */
	@RequestMapping("day")
	public String day(@RequestParam(value="day",required=false) Integer day,Model model) {
	    System.out.print("\n点击是:\n "+IData.year+"年"+IData.month+"月"+day+"日，"+IData.numDay(IData.weekOfDay(IData.year, IData.month, day)));
	    return "redirect:/log/logPage";
	}

	/**
	 * 修改要查询的日志作者名
	 * @return
	 */
	@RequestMapping("checkName")
	public String checkName(@RequestParam(value="name",required=false) String name){
	    System.out.print("\n要查询的日志作者名修改为："+name);
	    checkName=name;
	    return "redirect:/log/logPage";
	}
	
	/**
	 * 添加日志
     * @return
     */
    @RequestMapping("addLog")
    public String addLog(ILog log){
        System.out.print("\n添加日志：\n"+log.getName()+"-"+log.getTitle());
        FileIO.write(logSavePath, log.getName()+"-"+log.getTitle()+".txt", log.getContent(), "GB2312", false);
        return "redirect:/log/logPage";
    }
    
    /**
     * 修改日志
     * @return
     */
    @RequestMapping("updateLog")
    public String updateLog(ILog log){
        System.out.print("\n修改日志：\n"+log.getName()+"-"+log.getTitle());
        FileIO.write(logSavePath, log.getName()+"-"+log.getTitle()+".txt", log.getContent(), "GB2312", true);
        return "redirect:/log/logPage";
    }
    
    /**
     * 删除日志
     * @return
     */
    @RequestMapping("deleteLog")
    public String deleteLog(@RequestParam(value="title",required=false) String title){
        FileIO.delete(logSavePath, title+".txt");
        return "redirect:/log/logPage";
    }
	
	

}
