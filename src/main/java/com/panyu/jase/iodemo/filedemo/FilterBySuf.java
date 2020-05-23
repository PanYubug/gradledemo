package com.panyu.jase.iodemo.filedemo;

import java.io.File;
import java.io.FileFilter;

public class FilterBySuf implements FileFilter {

    private String Suf;

    public FilterBySuf(String suf) {
        super();
        Suf = suf;
    }

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(Suf);
    }
}
