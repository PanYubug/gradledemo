package com.panyu.jase.iodemo.filedemo;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) {
//        BaseOperation();
//        listAndListFile();
//        fileNameFilterDemo();
//        fileFilterDemo();
//        File dir = new File("/Users/panyu/java_projects/gradledemo/src");
//        getAllfiles(dir);
//        System.out.println(getSum(10));

    }

    public static void deleteDir(File dir){
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()){
                deleteDir(file);
            }else {
                System.out.println(file+": "+file.delete());
            }
        }
        System.out.println(dir+": "+dir.delete());
    }

    // 遍历指定目录下的内容(包含子目录中的内容)
    public static void getAllfiles(File dir){

        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()){
                getAllfiles(file);
            }else {
                System.out.println(file);
            }
        }

    }

    // 递归：函数自身调用自身。功能被重复使用的时候。
    // 注意：1、使用是，一定要定义条件；2、递归次数过多，会出现栈内存溢出
    public static int getSum(int num){
        if (num==1) return 1;
        return num + getSum(num-1);
    }

    public static void fileFilterDemo() {
        //文件过滤器
        File dir = new File("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu");
        File[] files = dir.listFiles(new FilterByFile());
        for (File file : files) {
            System.out.println(file);
        }
    }

    public static void fileNameFilterDemo() {
        // 获取指定目录下.java文件 list(FilenameFilter filter);
        File dir = new File("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu");
        FilenameFilter filter = new FilterBySuffix(".java");
        // 过滤内容的过滤器，并解耦。给什么过滤器，过滤什么。
        filter = new FilterByContain("Demo");
        String[] names = dir.list(filter);
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void listAndListFile() {
        File dir = new File("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu");
        String[] names = dir.list();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("----------");
        // 可以针对文件进行操作
        File[] filenames = dir.listFiles();
        for (File f : filenames) {
            System.out.println("文件名："+f.getName()+" 文件大小："+f.length()+" 绝对路径："+f.getAbsolutePath());
        }
    }

    public static void BaseOperation() {
        /**
         * File类，常见方法
         * 1、名字。获取名称
         *      String getName()
         * 2、大小。获取大小
         *      Int length()
         * 3、获取类型
         *      没有
         * 4、获取所在的目录
         *      getParent()
         * 5、获取文件的绝对路径
         *      String getAbsolutePath()
         * 6、获取文件的路径
         *      String getPath()
         * 7、获取文件最后一次修改的时间，要求是x年x月x日。时间。
         *      Long lastModified()
         * 8、文件是否隐藏的
         *      boolean isHidden()
         * 9、发现File对象封装的文件或者文件夹是可以存在的也可以是不存在。
         *      那么不存在的可否用file的功能创建呢？
         *      创建功能
         *      boolean createNewFile()
         *      删除功能
         *      boolean delete()
         * 10、一个File对象封装的文件或者文件加到底是否存在呢？
         *      判断存在功能
         *      file.isFile();
         *      file.isDirectory();
         *      boolean exists()
         * 11、getFreeSpace()方法是什么意思？getTotalSpace() getUsableSpace()：返回上的分区提供给该虚拟机的字节数 named此抽象路径名
         *      过此抽象路径名返回分区 named的大小。
         */
        File file = new File("1.txt");
        String fileName = file.getName();
        System.out.println("文件名："+fileName);

        long length = file.length();
        System.out.println("文件的大小："+length);

        System.out.println("文件的父目录："+file.getParent());

        System.out.println("文件的绝对路径："+file.getAbsolutePath());

        // 获取的是file对象中的封装的路径。封装的是什么，获取到的就是什么。
        System.out.println("文件的路径："+file.getPath());

        System.out.println("文件的最后修改时间："+file.lastModified());

        System.out.println("文件是否隐藏："+file.isHidden());

        try {
            // 如果文件存在则返回false，不存在就创建，返回true
            boolean newFile = file.createNewFile();
            System.out.println("创建文件："+newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件是否存在："+file.exists());

        // 删除文件夹时，文件夹中必须没有内容
        // 在删除文件夹时，应先判断是否在文件或文件夹
        // file.isFile();
        // file.isDirectory();
        boolean delete = file.delete();
        System.out.println("删除文件："+delete);

        System.out.println("文件是否存在："+file.exists());

        // 创建文件夹
        File file1 = new File("abc");
        boolean mkdir = file1.mkdir();
        System.out.println(mkdir);
        File file2 = new File("/abc/a/b/c/d/e");
        System.out.println(file2.mkdirs());
    }
}
