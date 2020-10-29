package com.panyu.springdemo.soundsystem.jase.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {

    public static void main(String[] args) throws IOException {

        //解析url中的数据。使用URL对象
        String str_url = "http://192.168.1.253:8080/myweb/2.html?name=lisi";

        URL url = new URL(str_url);

        System.out.println("getProtocol:"+url.getProtocol());
        System.out.println("getHost:"+url.getHost());
        System.out.println("getPort:"+url.getPort());
        System.out.println("getPath:"+url.getPath());
        System.out.println("getFile:"+url.getFile());
        System.out.println("getQuery:"+url.getQuery());

        //通过openConnection();获取到该远程资源的链接对象
        URLConnection conn = url.openConnection();

        //调用连接对象的读取方法。准备读取资源
        InputStream in = conn.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String str = new String(buf, 0, len);
        System.out.println(str);

    }
}







































