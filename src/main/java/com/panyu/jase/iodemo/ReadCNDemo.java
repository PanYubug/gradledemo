package com.panyu.jase.iodemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadCNDemo {

    public static void main(String[] args) throws IOException {
//        writeCNText();
        readCNText();
    }

    private static void readCNText() throws IOException {

        //
        FileInputStream fis = new FileInputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/cn.txt");

        byte[] buf = new byte[1024];
        int len = fis.read(buf);
        //按照默认编码表（GBK）解码
        String s = new String(buf, 0, len);
        System.out.println(s);

        fis.close();
    }

    private static void writeCNText() throws IOException {

        FileOutputStream fos = new FileOutputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/cn.txt");

        fos.write("你好".getBytes());

        fos.close();
    }
}
