package com.panyu.jase.iodemo.datastream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {

    public static void main(String[] args) {

        ByteArrayInputStream bis = new ByteArrayInputStream("abcde".getBytes());

        //内置一个自动增加的byte数组
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int by = 0;
        while ((by = bis.read()) != -1) {
            bos.write(by);
        }

        System.out.println(bos.toString());
    }
}
