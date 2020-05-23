package com.panyu.jase.iodemo;

import java.io.*;

public class CopyPicByBufferDemo {

    public static void main(String[] args) throws IOException {
        copyPicByBuffer();
    }

    private static void copyPicByBuffer() throws IOException {

        // 演示缓冲区

        //1、创建具体的流对象。
        FileInputStream fis = new FileInputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/Demo.java");
        //对流进行缓冲
        BufferedInputStream bufis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/io_copy1.txt");

        BufferedOutputStream bufos = new BufferedOutputStream(fos);

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len=bufis.read(buf))!=-1){
            bufos.write(buf, 0, len);
            bufos.flush();
        }

        fos.close();
        fis.close();
    }
}
