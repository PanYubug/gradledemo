package com.panyu.jase.iodemo;

import java.io.*;

public class TransStreamDemo2 {

    public static void main(String[] args) throws IOException {

//        writeText();
        readText();

    }

    private static void readText() throws IOException {

        FileInputStream fis = new FileInputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/cn2.txt");

        InputStreamReader isr = new InputStreamReader(fis); // 默认码表

        isr = new InputStreamReader(fis, "UTF-8");

        int ch1 = isr.read();

        System.out.println("ch1=" + (char) ch1);


    }

    private static void writeText() throws IOException {

        FileOutputStream fos = new FileOutputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/cn2.txt");

        OutputStreamWriter osw = new OutputStreamWriter(fos); // 使用默认编码表GBK

        osw = new OutputStreamWriter(fos, "UTF-8");

        osw.write("你好");

        osw.close();
    }
}
