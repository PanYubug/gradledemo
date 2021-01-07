package com.panyu.selenium.casedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.baidu.com");
            driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");

            // Get attribute of current active element
            String attr = driver.switchTo().activeElement().getAttribute("title");
            System.out.println(attr);
        } finally {
            driver.quit();
        }
    }


}
