package com.panyu.selenium.config;

public enum Config {
    CHROME_DRIVER("webdriver.chrome.driver"),
    EXE(""),
    USERNAME(""),
    PASSWORD(""),
    ;

    // System.setProperty("webdriver,firefox.bin", "./././");

    public String getName() {
        return name;
    }

    private String name;

    Config(String name) {
        this.name = name;
    }
}
