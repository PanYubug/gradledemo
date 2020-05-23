package com.panyu.jase.iodemo.filedemo;

import java.io.File;
import java.io.FilenameFilter;

public class FilterBySuffix implements FilenameFilter {

    private String suffix;

    public FilterBySuffix(String suffix) {
        super();
        this.suffix = suffix;
    }

    /**
     * @param name 被遍历目录中的文件夹或者文件的名称
     */
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }

}
