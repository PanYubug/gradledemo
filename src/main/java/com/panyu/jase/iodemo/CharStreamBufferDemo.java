package com.panyu.jase.iodemo;

import java.io.*;

public class CharStreamBufferDemo {

    public static void main(String[] args) throws IOException {
        /**
         * 演示字符流的缓存区
         * BufferedWriter
         * BufferedReader
         */
//        writeTextByBuffered();
        readTextByBuffered();

        //读取键盘录入。Scanner=流+正则表达式。方法都是按照某种规则在读取数据
//        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
//        bufr.readLine();

    }

    private static void readTextByBuffered() throws IOException {

        FileReader fr = new FileReader("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/bufw.txt");
        BufferedReader buffr = new BufferedReader(fr);
        String line = null;
        while ((line = buffr.readLine()) != null) {
            System.out.println(line);
        }

        buffr.close();

    }

    private static void writeTextByBuffered() throws IOException {
        //1、明确目的
        FileWriter fw = new FileWriter("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/bufw.txt");

        //2、明确要缓冲的流对象
        BufferedWriter bufw = new BufferedWriter(fw);
        //3、
        for (int x = 1; x <= 4; x++) {
            bufw.write(x + "abc");
            bufw.newLine();
        }
        bufw.close();

//        bufw.write("abc");
//        bufw.newLine(); //System.getProperty("line.separator");
//        bufw.write("hello");

    }
}
