package com.panyu.selenium.config;

public enum Url {

    BAIDU("baidu","https://www.baidu.com");

    private String name;
    private String url;

    Url(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
