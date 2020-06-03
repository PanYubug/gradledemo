package com.panyu.jase.iodemo.datastream;

import java.io.*;

public class DataStreamDemo {

    public static void main(String[] args) throws IOException {


//        writeData();
        readData();
    }

    private static void readData() throws IOException {

        FileInputStream fis = new FileInputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/datastream/data.txt");
        DataInputStream dis = new DataInputStream(fis);

        boolean b = dis.readBoolean();
        System.out.println(b);
        dis.close();
    }

    private static void writeData() throws IOException {
        // 写入基本数据类型。存储到文件
        FileOutputStream fos = new FileOutputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/datastream/data.txt");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeBoolean(true);

        dos.close();

    }
}
