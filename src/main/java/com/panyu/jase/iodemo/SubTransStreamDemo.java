package com.panyu.jase.iodemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SubTransStreamDemo {

    public static void main(String[] args) throws IOException {

        /**
         * 转换流的子类
         * 专门用于操作文本的流对象
         */

//        writeText();
        readText();
    }

    private static void readText() throws IOException {

        FileReader fr = new FileReader("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/fw.txt");
        int ch = 0;
        while ((ch=fr.read())!=-1){
            System.out.print((char)ch);
        }
        fr.close();

    }

    private static void writeText() throws IOException {

        //1、创建一个用于操作文件袋额字符输出流对象,内部使用了默认的编码表，而且只能操作文件。
        FileWriter fw = new FileWriter("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/fw.txt");
        // 等效于，
//        FileOutputStream fos = new FileOutputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/fw.txt");
//        OutputStreamWriter osw = new OutputStreamWriter(fos);


        fw.write("你好，转换流子类。");

        fw.close();

    }
}
