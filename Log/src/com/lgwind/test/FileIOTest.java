package com.lgwind.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lgwind.util.FileIO;

public class FileIOTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testRead() {
        String content=FileIO.read("D:/LinuxWorkspace/LogSys/WebContent/file","日志-name-2018-04-13.txt");
//        String content=FileIO.read("D:","testfile.txt");
        System.out.println("读取的内容是：\n"+content);
    }

    @Test
    public void testWrite() {
        fail("Not yet implemented");
    }
    
    @Test
    public void getFilesTest(){
        List<File> fileList=FileIO.getFiles("D:/LinuxWorkspace/LogSys/WebContent/file");
        for(int i=0; i<fileList.size(); i++){
            System.out.println(fileList.get(i));
        }
    }

}
