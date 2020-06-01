package com.panyu.jase.iodemo.sequenceinputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class SequenceInputStreamDemo {

    public static void main(String[] args) throws IOException {

        // 演示序列流 SequenceInputStream
        // 如何获取一个Enumeration呢？Vector有，效率低，使用ArrayList
        ArrayList<FileInputStream> al = new ArrayList<>();
        // 添加三个输入流对象，和指定的文件关联
        for (int i = 0; i < 3; i++) {
            al.add(new FileInputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/sequenceinputstream/1.txt"));
        }

        // 怎么通过ArrayList获取枚举接口。可以使用Collections工具类中的方法
        Enumeration<FileInputStream> en = Collections.enumeration(al);
        // 创建序列流对象，需要传递Enumeration。
        SequenceInputStream sis = new SequenceInputStream(en);

    }
}
