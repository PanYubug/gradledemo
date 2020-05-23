package com.panyu.jase.iodemo;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) {

        FileOutputStream fos = null;

        try {
            // 1、穿件字节输出流对象。用于操作文件，在对象初始化时，必须明确数据存储的目的地
            // 注：输出流所关联的目的地，如果不存在，会自动创建；如果存在，则覆盖。
            // (传入true实现续写)
            fos = new FileOutputStream("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo", true);

            // 2、调用输出流的写功能，字符转字节。
            fos.write((LINE_SEPARATOR + "abcd").getBytes());
            // 3、必须关闭，释放资源

        } catch (IOException e) {
            System.out.println(e.toString() + "----");

        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException("程序失败" + e);
                }
            }

        }

    }
}
