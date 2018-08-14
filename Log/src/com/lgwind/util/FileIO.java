package com.lgwind.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    
    /**
     * 读取文件
     * @param path 文件路径
     * @param name 文件名
     * @return
     */
    public static String read(String path, String name){
        return read(path +"\\"+name); // 路径)
    }
    
    /**
     * 读取文件
     * @param pathname 文件路径+名字
     * @return
     */
    public static String read(String pathname) {
        // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
        try {
            
            File filename = new File(pathname); // 要读取以上路径的input.txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            //返回的数据
            String content = "";
            //读取每行的内容
            String line = "";
            //读取一行内容
            line = br.readLine();
            while (line != null) {
                content += line+"<br>";
                line = br.readLine(); // 一次读入一行数据
            }
            br.close(); // 最后记得关闭文件
            return content;
        } catch (Exception e) {
            System.out.println("读取文件失败");
            e.printStackTrace();
            return "读取文件失败";
        }

    }
    
    /**
     * 获取文件内容的集合
     * @param wjList 文件集合
     * @return
     */
    public static List<String> readFiles(List<File> wjList){
        List<String> fileList = new ArrayList<String>();
        for(int i=0; i<wjList.size(); i++){
            fileList.add(read(wjList.get(i).toString()));
        }
        return fileList;
    }

    /**
     * 写入文件
     * @param path 文件路径
     * @param name 文件名
     * @param content 文件内容
     * @param format 文件内容格式
     * @param update 是否是修改文件
     */
    public static void write(String path, String name, String content, String format, boolean update) {
        write(path+"\\"+name, content, format, update);
    }
    
    
    /**
     * 写入文件
     * @param pathname 文件路径+名字
     * @param content
     * @param format 文件内容格式
     * @param update 是否是修改文件
     */
    public static void write(String pathname, String content, String format, boolean update) {
        // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
        try {
//            File writename = new File("src//txt//output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            File writename = new File(pathname); 
            //若文件已存在
            if(writename.exists() && !update){
                System.out.print("\n该文件已存在");
            }
            //若文件不存在则创建新文件
            else
            {
                writename.createNewFile(); // 创建新文件
                FileOutputStream writerStream = new FileOutputStream(writename);
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                        writerStream, format));
                // out.write("我会写入文件啦\r\n"); // 写入内容\r\n即为换行
                // out.write("\uFEFF");//写入标志位，没有标志位会生成无bom格式
                out.write(content);// 写入内容
                out.flush(); // 把缓存区内容压入文件
                out.close(); // 最后记得关闭文件
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取目录下的所有文件
     * @param filepath 路径
     * @return
     */
    public static List<File> getFiles(String filepath){
        File file = new File(filepath);    //File类型可以是文件也可以是文件夹
        File[] fileList = file.listFiles();//将该目录下的所有文件放置在一个File类型的数组中
        List<File> wjList = new ArrayList<File>();//新建一个文件集合
        //遍历该目录下的所有文件和文件夹
        for (int i = 0; i < fileList.length; i++) {
           if (fileList[i].isFile()) {//判断是否为文件
                wjList.add(fileList[i]);
           }
        }
        return wjList;
    }
    
    

    /**
     * 删除单个文件
     *
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean delete(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }
    
    /**
     * 
     * @param path 要删除的文件路径
     * @param name 要删除的文件名
     * @return
     */
    public static boolean delete(String path, String name) {
        return delete(path+"\\"+name);
    }
    
}