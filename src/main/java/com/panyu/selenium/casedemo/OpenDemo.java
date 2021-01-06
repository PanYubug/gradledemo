package com.panyu.selenium.casedemo;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenDemo {
    public static void main(String[] args) {
        ChromeDriver dr = new ChromeDriver();
        dr.get("https://www.baidu.com");
        // 复杂的
//        dr.navigate().to("https://www.baidu.com");
        // 获取当前的url
        System.out.println(dr.getCurrentUrl());
        // 获取Title
        System.out.println(dr.getTitle());

        // 返回
        dr.navigate().back();
        // 往前
        dr.navigate().forward();
        // 刷新
        dr.navigate().refresh();
        // window handle
        String originalWindow = dr.getWindowHandle();
        System.out.println(dr.getWindowHandles().size());
        dr.findElement(By.linkText("点击一下，了解更多")).click();
        // wait延迟等待
        WebDriverWait wait = new WebDriverWait(dr, 5);
        wait.until(new ExpectedCondition<WebElement>(){
            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver text) {
                return text.findElement(By.id("kw"));
            }
        }).click();

        //循环遍历直到发现新的窗口句柄
        for (String windowHandle : dr.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                dr.switchTo().window(windowHandle);
                break;
            }
        }

        //等待窗口加载完内容
//        wait.until(titleIs("百度"));
        dr.switchTo().window(originalWindow);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Store the web element
        WebElement iframe = dr.findElement(By.cssSelector("#modal>iframe"));
        //Switch to the frame
        dr.switchTo().frame(iframe);
        //Now we can click the button
        dr.findElement(By.tagName("button")).click();
        // 关闭标签或窗口
        dr.close();
        // 所有
        dr.quit();
    }
}
