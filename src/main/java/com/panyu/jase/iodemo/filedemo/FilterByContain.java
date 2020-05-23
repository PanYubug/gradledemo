package com.panyu.jase.iodemo.filedemo;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByContain implements FilenameFilter {

    private String content;

    public FilterByContain(String content) {
        super();
        this.content = content;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.contains(content);
    }
}
