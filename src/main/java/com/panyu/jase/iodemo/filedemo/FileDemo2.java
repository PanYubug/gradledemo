package com.panyu.jase.iodemo.filedemo;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class FileDemo2 {
    public static void main(String[] args) {

        File file = new File("/Users/panyu/java_projects/gradledemo/src");
        String suffix = ".java";
        List<File> files = fileList(file, suffix);
        for (File file1 : files) {
            System.out.println(file1);
        }

    }

    public static List<File> fileList(File file, String suffix) {
        /**
         * 获取一个想要的指定文件的集合。获取javase_code下(包含子目录)的所有的.java的文件对象。并存储到集合中
         *
         * 思路：
         * 1、包含递归
         * 2、在递归过程中需要过滤器
         * 3、满足条件，都添加到集合中
         */

        ArrayList<File> files = new ArrayList<>();
        FilterBySuf filter = new FilterBySuf(suffix);

        getFileList(file, files, filter);

        return files;
    }

    /**
     * 定义一个获取指定过滤器条件的文件的集合
     *
     * @param dir    需要遍历的目录
     * @param list   用于存储符合条件的File对象
     * @param filter 接收指定的过滤器
     */
    public static void getFileList(File dir, List<File> list, FileFilter filter) {

        //1、通过listFiles方法，获取dir当前下的所有的文件和文件夹对象
        File[] files = dir.listFiles();
        //2、遍历该数组
        for (File file : files) {
            if (file.isDirectory()) {
                //3、判断是否是文件夹。如果是，递归。如果不是，那就是文件，就需要对文件进行过滤。
                getFileList(file, list, filter);
            } else {
                //4、通过过滤器对文件进行过滤
                if (filter.accept(file)) {
                    list.add(file);
                }
            }
        }


    }
}
