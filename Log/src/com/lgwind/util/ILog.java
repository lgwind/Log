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
     * 通过文件全名获取日志标题
     * @param file
     * @return
     */
    public static String title(String file){
        try{
            //去除文件路径
            String [] temp = file.split("\\\\");
            //去除文件名前缀
            String [] temp2 = temp[temp.length-1].split("-");
            //去除文件名后缀
            String [] temp3 = temp2[temp2.length-1].split("[.]");
            return temp3[0];
        }catch(Exception e){
            System.err.println("ILog.title()函数的传入参数字符串格式有问题");
            e.printStackTrace();
            return "标题参数获取错误";
        }
        
    }
    
    /**
     * 通过文件全名获取日志名字
     * @param file
     * @return
     */
    public static String name(String file){
        try{
            //去除文件路径
            String [] temp = file.split("\\\\");
            //去除文件名前缀
            String [] temp2 = temp[temp.length-1].split("-");
            return temp2[0];
        }catch(Exception e){
            System.err.println("ILog.title()函数的传入参数字符串格式有问题");
            e.printStackTrace();
            return "名字参数获取错误";
        }
    }
    
    /**
     * 日志集合排序
     * @param logList 参与排序的初始数据
     * @param rule 排序规则
     * @return
     */
    public static List<ILog> rank(List<ILog> logList, String rule){
        for(int j=0; j<logList.size(); j++){
        for(int i=0; i<logList.size()-1; i++){
            //若日志时间小于，则移后
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
