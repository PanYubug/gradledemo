package com.panyu.jase.iodemo.objectstream;

import com.panyu.Person;

import java.io.*;

public class ObjectOutputStreamDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // 将一个对象存储到持久化（硬盘）的设备上
//        writeObj();
        readObj();
    }

    private static void readObj() throws IOException, ClassNotFoundException {
        // 1、定义流对象关联存储了对象文件
        FileInputStream fis = new FileInputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/objectstream/obj.object");
        // 2、建立用于读取对象的功能对象
        ObjectInputStream ois = new ObjectInputStream(fis);

        Person obj = (Person)ois.readObject();

        System.out.println(obj);


    }

    private static void writeObj() throws IOException {
        // 1、明确存储对象的文件
        FileOutputStream fos = new FileOutputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/objectstream/obj.object");
        // 2、给操作文件对象加入写入对象功能
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // 3、调用了写入对象的方法
        oos.writeObject(new Person("wangcai", 20));
        // 关闭资源
        oos.close();

    }
}
