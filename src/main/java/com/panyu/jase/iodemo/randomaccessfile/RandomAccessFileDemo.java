package com.panyu.jase.iodemo.randomaccessfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

    public static void main(String[] args) throws IOException {

        writeFile();
        readFile();
    }

    private static void readFile() throws IOException {

        //随机读取，只要通过设置指针的位置即可
        RandomAccessFile raf = new RandomAccessFile("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/randomaccessfile/random.txt", "rw");
        raf.seek(8*1);
        byte[] buf = new byte[4];
        raf.read(buf);
        String name = new String(buf);

        int age = raf.readInt();
        System.out.println(name +": "+age);
        raf.close();

    }

    private static void writeFile() throws IOException {

        //1、创建一个随机访问文件的对象。文件不存在，则创建，存在，则不创建不覆盖
        RandomAccessFile raf = new RandomAccessFile("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/randomaccessfile/random.txt", "rw");
        //2、写入姓名和年龄
        raf.write("张三".getBytes());
        raf.writeInt(97);

        raf.seek(8);
        raf.write("王五".getBytes());
        raf.writeInt(188);
        System.out.println(raf.getFilePointer());
        raf.close();
    }
}
