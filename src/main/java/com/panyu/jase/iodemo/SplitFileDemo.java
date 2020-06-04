package com.panyu.jase.iodemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SplitFileDemo {

    public static void main(String[] args) throws IOException {
        /**
         * 文件切割
         * 一个读取流，对应多个输出流。而且生成的碎片文件都有有序的编号
         */
        File srcFile = new File("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/IO_2.txt");
        File destDir = new File("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/partfiles");
        fileSplit(srcFile, destDir);
    }

    private static void fileSplit(File srcFile, File destDir) throws IOException {

        if (!destDir.exists()){
            destDir.mkdirs();
        }

        //1、读取源文件
        FileInputStream fis = new FileInputStream(srcFile);

        //2、创建目的引用
        FileOutputStream fos = null;

        //3、创建一个缓冲区
        byte[] buf = new byte[1024*4];
        int count = 0;
        int len = 0;
        //4、往缓冲区存储数据
        while ((len=fis.read(buf))!=-1){

            //5、创建输出流。并明确要写入的文件对象
            File partFile = new File(destDir, (++count) + ".part");
            fos = new FileOutputStream(partFile);
            fos.write(buf, 0, len);
            fos.close();
        }
        //应该在产生碎片文件时，需要产生一个配置文件。记录碎片的个数和源文件的名字
        // partcount=5; filename=1.mp3

        //配置文件中存储的键值信息。使用Properties集合。
        Properties properties = new Properties();
        properties.setProperty("partcount", Integer.toString(count));
        properties.setProperty("filename", srcFile.getName());
        File configFile = new File(destDir, (++count)+".properties");

        fos = new FileOutputStream(configFile);
        properties.store(fos, "sava part file info");

        fos.close();
        fis.close();

    }
}
