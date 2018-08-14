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
     * ��ȡ�ļ�
     * @param path �ļ�·��
     * @param name �ļ���
     * @return
     */
    public static String read(String path, String name){
        return read(path +"\\"+name); // ·��)
    }
    
    /**
     * ��ȡ�ļ�
     * @param pathname �ļ�·��+����
     * @return
     */
    public static String read(String pathname) {
        // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw
        try {
            
            File filename = new File(pathname); // Ҫ��ȡ����·����input.txt�ļ�
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // ����һ������������reader
            BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
            //���ص�����
            String content = "";
            //��ȡÿ�е�����
            String line = "";
            //��ȡһ������
            line = br.readLine();
            while (line != null) {
                content += line+"<br>";
                line = br.readLine(); // һ�ζ���һ������
            }
            br.close(); // ���ǵùر��ļ�
            return content;
        } catch (Exception e) {
            System.out.println("��ȡ�ļ�ʧ��");
            e.printStackTrace();
            return "��ȡ�ļ�ʧ��";
        }

    }
    
    /**
     * ��ȡ�ļ����ݵļ���
     * @param wjList �ļ�����
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
     * д���ļ�
     * @param path �ļ�·��
     * @param name �ļ���
     * @param content �ļ�����
     * @param format �ļ����ݸ�ʽ
     * @param update �Ƿ����޸��ļ�
     */
    public static void write(String path, String name, String content, String format, boolean update) {
        write(path+"\\"+name, content, format, update);
    }
    
    
    /**
     * д���ļ�
     * @param pathname �ļ�·��+����
     * @param content
     * @param format �ļ����ݸ�ʽ
     * @param update �Ƿ����޸��ļ�
     */
    public static void write(String pathname, String content, String format, boolean update) {
        // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw
        try {
//            File writename = new File("src//txt//output.txt"); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�
            File writename = new File(pathname); 
            //���ļ��Ѵ���
            if(writename.exists() && !update){
                System.out.print("\n���ļ��Ѵ���");
            }
            //���ļ��������򴴽����ļ�
            else
            {
                writename.createNewFile(); // �������ļ�
                FileOutputStream writerStream = new FileOutputStream(writename);
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                        writerStream, format));
                // out.write("�һ�д���ļ���\r\n"); // д������\r\n��Ϊ����
                // out.write("\uFEFF");//д���־λ��û�б�־λ��������bom��ʽ
                out.write(content);// д������
                out.flush(); // �ѻ���������ѹ���ļ�
                out.close(); // ���ǵùر��ļ�
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * ��ȡĿ¼�µ������ļ�
     * @param filepath ·��
     * @return
     */
    public static List<File> getFiles(String filepath){
        File file = new File(filepath);    //File���Ϳ������ļ�Ҳ�������ļ���
        File[] fileList = file.listFiles();//����Ŀ¼�µ������ļ�������һ��File���͵�������
        List<File> wjList = new ArrayList<File>();//�½�һ���ļ�����
        //������Ŀ¼�µ������ļ����ļ���
        for (int i = 0; i < fileList.length; i++) {
           if (fileList[i].isFile()) {//�ж��Ƿ�Ϊ�ļ�
                wjList.add(fileList[i]);
           }
        }
        return wjList;
    }
    
    

    /**
     * ɾ�������ļ�
     *
     * @param fileName
     *            Ҫɾ�����ļ����ļ���
     * @return �����ļ�ɾ���ɹ�����true�����򷵻�false
     */
    public static boolean delete(String fileName) {
        File file = new File(fileName);
        // ����ļ�·������Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ��
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("ɾ�������ļ�" + fileName + "�ɹ���");
                return true;
            } else {
                System.out.println("ɾ�������ļ�" + fileName + "ʧ�ܣ�");
                return false;
            }
        } else {
            System.out.println("ɾ�������ļ�ʧ�ܣ�" + fileName + "�����ڣ�");
            return false;
        }
    }
    
    /**
     * 
     * @param path Ҫɾ�����ļ�·��
     * @param name Ҫɾ�����ļ���
     * @return
     */
    public static boolean delete(String path, String name) {
        return delete(path+"\\"+name);
    }
    
}