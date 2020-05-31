package com.panyu.jase.iodemo.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

    public static void main(String[] args) throws IOException {

        //properties的基本演示。存setProperty和取getProperty
//        methodDemo();

        //properties的特有方法store，存储数据
//        methodDemo2();

        //读取数据
        methodDemo3();


    }

    private static void methodDemo3() throws IOException {

        File file = new File("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/properties/properties_info.properties");

        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(file);

        // 读取流和数据文件关联
        prop.load(fis);

        prop.setProperty("zhangsan", "18");

        FileOutputStream fos = new FileOutputStream(file);

        prop.store(fos, "");

        prop.list(System.out);

        fos.close();
        fis.close();
    }

    private static void methodDemo2() throws IOException {
        Properties prop = new Properties();

        prop.setProperty("zhangsan", "20");
        prop.setProperty("lisi", "23");
        prop.setProperty("wangwu", "21");

        //将集合中的数据持久化存储到设备上
        //需要输出流对象
        FileOutputStream fos = new FileOutputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/properties/properties_info.properties");

        //使用prop的store方法
        prop.store(fos, "my demo, person info");

        fos.close();

    }


    private static void methodDemo() {

        //1、创建一个properties集合
        Properties prop = new Properties();

        prop.setProperty("zhangsan", "20");
        prop.setProperty("lisi", "23");
        prop.setProperty("wangwu", "21");

        // out即为：PrintStream类型
        // list方法即为下面方法
        // 该方法用于调试。少用。
        prop.list(System.out);

        System.out.println("---------------");

        Set<String> set = prop.stringPropertyNames();
        System.out.println(set);
        for (String name : set) {
            String age = prop.getProperty(name);
            System.out.println(name +"---"+ age);
        }

    }
}
