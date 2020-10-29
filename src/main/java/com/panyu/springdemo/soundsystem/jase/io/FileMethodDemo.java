package com.panyu.springdemo.soundsystem.jase.io;

import java.io.File;

public class FileMethodDemo {

    public static void main(String[] args) {
        File file = new File("1.txt");
        String file_name = file.getName();
        System.out.println(file_name);

        long len = file.length();
        System.out.println(len);

        System.out.println(file.getParent());



    }
}
