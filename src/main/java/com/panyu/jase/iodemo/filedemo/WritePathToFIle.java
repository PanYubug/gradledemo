package com.panyu.jase.iodemo.filedemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.panyu.jase.iodemo.filedemo.FileDemo2.fileList;

public class WritePathToFIle {

    public static void main(String[] args) throws IOException {

        File dir = new File("/Users/panyu/java_projects/gradledemo/src");

        List<File> list = fileList(dir, ".java");

//        for (File file : list) {
//            System.out.println(file);
//        }

        // 将集合中的符合条件的文件对象的绝对路径写入到一个文件中

        File destFile = new File("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/javalist.txt");

        write2File(list, destFile);


    }

    private static void write2File(List<File> list, File destFile) throws IOException {

        // 1、需要流对象。既然是写入字符

        BufferedWriter bufw = null;
        try {
            bufw = new BufferedWriter(new FileWriter(destFile));

            // 2、遍历集合
            for (File file : list) {
                bufw.write(file.getAbsolutePath());
                bufw.newLine();
                bufw.flush();
            }
        } catch (IOException e) {

        } finally {
            if (bufw != null) {
                try {
                    bufw.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭失败");
                }
            }
        }

    }
}
