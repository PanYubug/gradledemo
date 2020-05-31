package com.panyu.jase.iodemo.printstream;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {

    public static void main(String[] args) throws IOException {

        System.out.println("hello world");

        // System.out.println("hello world")，分解为两步骤。
        PrintStream ps = System.out;

        ps.println("hello world");

        // 演示PrintStream的特有的方法

        File file = new File("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/printstream/printstream.txt");
        if (!file.exists()){
            file.createNewFile();
        }

        PrintStream out = new PrintStream(file);
        out.write(97);

        out.write("353".getBytes());
        out.print(97); // 保证数值的表现形式，其原理就是将数值转成字符串

        out.close();

    }
}
