package com.panyu.selenium.casedemo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Demo {


    public static void main(String[] args) throws Exception {

        // RemoteWebDriver的基本使用
        // 第一个参数：表示服务器的地址。第二个参数：表示预期的执行对象，其他浏览器都可以以此类推
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub/"), DesiredCapabilities.chrome());
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
        JavascriptExecutor js = driver;
        js.executeScript("alert('我现在在服务器')");
        Thread.sleep(2000);
        driver.quit();

//        WebDriver driver = new ChromeDriver();
//        try {
//            driver.get("https://www.baidu.com");
//            driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");
//
//            // Get attribute of current active element
//            String attr = driver.switchTo().activeElement().getAttribute("title");
//            System.out.println(attr);
//        } finally {
//            driver.quit();
//        }
    }


}
