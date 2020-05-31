package com.panyu.jase.iodemo.printstream;

import java.io.*;

public class PrintWriterDemo {

    public static void main(String[] args) throws IOException {

        //1、键盘录入
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        //2、定义目的
        PrintWriter pw = new PrintWriter(System.out, true);

        // 改变目的为文件。还想自动刷新
//        pw = new PrintWriter(new FileWriter("1.txt"), true);

        //3、读一行写一行，键盘录入一定要定义结束标记
        String line = null;
        while ((line=bufr.readLine()) != null){
            if ("over".equals(line)){
                break;
            }
            pw.println(line.toUpperCase());
//            pw.flush(); // 当PrintWriter参数为true，println,printf,format方法会自动刷出数据
        }

        pw.close();
        // bufr.close() //不需要关闭键盘录入这种标准输入流，一旦关闭，后面获取不到
    }
}
