package com.panyu.jase.iodemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SubTransStreamDemo2 {

    public static void main(String[] args) throws IOException {
        //复制一个文本文件
        // 如果对文本中的字符的操作的时候，用字符流最方便。

        copyText();
    }

    private static void copyText() throws IOException {

        // 1、明确数据源，定义字符读取流和数据源关联
        FileReader fr = new FileReader("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/fw.txt");
        // 2、明确数据目的，定义字符输出流，创建存储数据目的。
        FileWriter fw = new FileWriter("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/copy_fw.txt");
        // 3、创建缓冲区
        char[] buf = new char[1024];
        int len = 0;
        while ((len = fr.read(buf)) != -1) {
            fw.write(buf, 0, len);
        }
        fw.close();
        fr.close();

    }
}
