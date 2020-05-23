package com.panyu.jase.iodemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyText {
    public static void main(String[] args) throws IOException {
        /**
         * 复制文件
         * 1、读取源数据，将数据写到目的中，用到了流，操作设备上的设备
         * 2、读用到了输入流，写用到输出流
         * 3、操作文件，用到了字节流操作文件的流对象
         */
//        copyText();
        copyTextByBuf();

    }

    private static void copyTextByBuf() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/FileOutputStreamDemo.java");
            fos = new FileOutputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/io_copy.txt");

            byte[] buf = new byte[1024];

            int len = 0;

            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }

        } catch (IOException e) {

        }finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException("程序错误1");
                }
            }
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException("程序错误2");
                }
            }
        }
    }

    private static void copyText() throws IOException {
        //1、创建一个输入流和源数据对象
        FileInputStream fis = new FileInputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/FileInputStreamDemo.java");
        //2、创建一个输出流和目的
        FileOutputStream fos = new FileOutputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/io_copy.txt");

        int len = 0;
//        byte[] buf = new byte[1024];

        while ((len = fis.read()) != -1) {
//            System.out.println(new String(buf,0,len));

            fos.write(len);
        }
        fos.close();
        fis.close();
    }
}
