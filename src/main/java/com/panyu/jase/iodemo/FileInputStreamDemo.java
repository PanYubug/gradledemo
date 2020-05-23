package com.panyu.jase.iodemo;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

    private static final int DEFAULT_SIZE = 1024;

    public static void main(String[] args) {
        /**
         * 读取文件数据
         */
        FileInputStream fis = null;

//        File file = new File("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/Person.java");
//        if (!file.exists()){
//            throw RuntimeException("文件不存在");
//        }

        try {
            fis = new FileInputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/Person.java");
            //创建一个字节数组
            byte[] buf = new byte[DEFAULT_SIZE];
            int len = 0;
            while ((len = fis.read(buf))!=-1){
                System.out.println(new String(buf, 0, len));
            }
        } catch (IOException e) {
            //将异常信息写到日志文件中
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    //一般可以throw RuntimeException异常，或者将异常信息写到日志文件中。进行记录
                    throw new RuntimeException("程序异常");
                }
            }
        }

    }
}
