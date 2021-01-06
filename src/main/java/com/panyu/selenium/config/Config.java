package com.panyu.selenium.config;

public enum Config {
    CHROME_DRIVER("webdriver.chrome.driver"),
    EXE("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/selenium/config/chromedriver"),
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
