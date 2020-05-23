package com.panyu.jase.iodemo;

import java.io.*;

public class TransStreamDemo {
    public static void main(String[] args) throws IOException {
        /**
         * 通过字符流读取中文数据
         */

//        readCNText();
        writeCNText();
    }

    private static void writeCNText() throws IOException {

        FileOutputStream fos = new FileOutputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/cn.txt");

        OutputStreamWriter osw = new OutputStreamWriter(fos);

        osw.write("你好,世界");

//        osw.flush();
//      关闭资源，flush()刷新完，流可以继续使用，close刷新完，直接关闭，流结束了，无法使用。
        osw.close();

    }

    private static void readCNText() throws IOException {

        // 1、操作字节流的字符流对象，必须先有字节流
        FileInputStream fis = new FileInputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/cn.txt");

        // 2、建立字节想字符的桥梁
        InputStreamReader isr = new InputStreamReader(fis);

        int ch = isr.read();
        System.out.println((char) ch);
        isr.close();// 关闭的就是fis
    }
}
