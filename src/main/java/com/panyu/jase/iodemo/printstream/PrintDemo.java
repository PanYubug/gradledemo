package com.panyu.jase.iodemo.printstream;

import java.io.*;

public class PrintDemo {

    public static void main(String[] args) throws IOException {

        myPrintStream();
        myPrintWiter();

    }

    public static void myPrintStream() throws IOException {
        System.out.println("hello world");

        // System.out.println("hello world")，分解为两步骤。
        PrintStream ps = System.out;

        ps.println("hello world");

        // 演示PrintStream的特有的方法

        File file = new File("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/printstream/printstream.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        PrintStream out = new PrintStream(file);
        out.write(97);

        out.write("353".getBytes());
        out.print(97); // 保证数值的表现形式，其原理就是将数值转成字符串

        out.close();
    }

    public static void myPrintWiter() throws IOException {
        //1、键盘录入
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        //2、定义目的
        PrintWriter pw = new PrintWriter(System.out, true);

        // 改变目的为文件。还想自动刷新
//        pw = new PrintWriter(new FileWriter("1.txt"), true);

        //3、读一行写一行，键盘录入一定要定义结束标记
        String line = null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            pw.println(line.toUpperCase());
//            pw.flush(); // 当PrintWriter参数为true，println,printf,format方法会自动刷出数据
        }

        pw.close();
        // bufr.close() //不需要关闭键盘录入这种标准输入流，一旦关闭，后面获取不到
    }
}
