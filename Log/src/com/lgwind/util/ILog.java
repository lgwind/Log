package com.lgwind.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ILog {
    
    private String title;
    private String name;
    private String content;
    
    public ILog() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ILog(String title, String name, String content) {
        super();
        this.title = title;
        this.name = name;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ILog [title=" + title + ", name=" + name + ", content="
                + content + "]";
    }
    
    /**
     * ͨ���ļ�ȫ����ȡ��־����
     * @param file
     * @return
     */
    public static String title(String file){
        try{
            //ȥ���ļ�·��
            String [] temp = file.split("\\\\");
            //ȥ���ļ���ǰ׺
            String [] temp2 = temp[temp.length-1].split("-");
            //ȥ���ļ�����׺
            String [] temp3 = temp2[temp2.length-1].split("[.]");
            return temp3[0];
        }catch(Exception e){
            System.err.println("ILog.title()�����Ĵ�������ַ�����ʽ������");
            e.printStackTrace();
            return "���������ȡ����";
        }
        
    }
    
    /**
     * ͨ���ļ�ȫ����ȡ��־����
     * @param file
     * @return
     */
    public static String name(String file){
        try{
            //ȥ���ļ�·��
            String [] temp = file.split("\\\\");
            //ȥ���ļ���ǰ׺
            String [] temp2 = temp[temp.length-1].split("-");
            return temp2[0];
        }catch(Exception e){
            System.err.println("ILog.title()�����Ĵ�������ַ�����ʽ������");
            e.printStackTrace();
            return "���ֲ�����ȡ����";
        }
    }
    
    /**
     * ��־��������
     * @param logList ��������ĳ�ʼ����
     * @param rule �������
     * @return
     */
    public static List<ILog> rank(List<ILog> logList, String rule){
        for(int j=0; j<logList.size(); j++){
        for(int i=0; i<logList.size()-1; i++){
            //����־ʱ��С�ڣ����ƺ�
//            System.out.print(logList.get(i).getTitle().replaceAll("[^0-9]", ""));
            if(Integer.parseInt(logList.get(i).getTitle().replaceAll("[^0-9]", "")) 
                    < Integer.parseInt(logList.get(i+1).getTitle().replaceAll("[^0-9]", ""))){
                logList.add(i, logList.get(i+1));
                logList.remove(i+2);
//                System.out.print(i);
            }
        }
        }
        return logList;
    }
    
}
