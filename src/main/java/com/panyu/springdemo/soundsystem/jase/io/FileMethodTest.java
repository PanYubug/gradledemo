package com.panyu.springdemo.soundsystem.jase.io;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class FileMethodTest {
    public static void main(String[] args) throws IOException {


        String all_file = "/Users/panyu/java_projects/jase/src/panyu/jase/io/2.txt";

        File file = new File(all_file);

        methodDemo1(file);
        methodDemo2(file);

    }

    private static void methodDemo2(File file) throws IOException {
        //1，创建
        boolean b = file.createNewFile();
        System.out.println(b);

    }

    public static void methodDemo1(File file) {
        String path = file.getAbsolutePath();
        String path1 = file.getPath();
        System.out.println(path);
        System.out.println(path1);

        long time = file.lastModified();
        Date date = new Date(time);
        String str_date = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(date);
        System.out.println(time);
        System.out.println(str_date);

        boolean b = file.exists();
        System.out.println(b);
        System.out.println(file.isHidden());
    }
}
