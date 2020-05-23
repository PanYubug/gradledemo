package com.panyu.jase.iodemo.filedemo;

import java.io.File;
import java.io.FileFilter;

public class FilterByFile implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isFile();
        // 也是可以过滤后缀名等。
//        return pathname.getName().endsWith(".java");
    }
}
