package com.panyu.jase.iodemo.sequenceinputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/*
ObjectInputStream与ObjectOutputStream
被操作的对象需要实现Serializable（标记接口）
对象的序列化和反序列化
特点：用于操作对象
解决问题：可以将对象进行序列化和反序列化。注意：对象序列化一定要实现Serializable接口。为了给类定义一个SeriaVersionUID。
功能：ObjectInputStream readObject()	ObjectOutputStream writeObject()
 */
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
        // 创建目的。文件
        FileOutputStream fos = new FileOutputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/sequenceinputstream/4.txt");
        //频繁的读写操作
        //1、创建缓冲区
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }

        // 关闭流
        fos.close();
        sis.close();

    }
}
