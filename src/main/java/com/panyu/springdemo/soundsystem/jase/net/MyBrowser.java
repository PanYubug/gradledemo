package com.panyu.springdemo.soundsystem.jase.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MyBrowser {

    public static void main(String[] args) throws IOException {
        /*
        *模拟浏览器。发送一些http消息给Tomcat服务器。并获取服务器反馈的信息
        *
        * */

        Socket s = new Socket("192.168.1.253",8080);

        //获取输出流,给服务器发送数据
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println("GET /myweb/2.html HTTP/1.1");
        out.println("Accept:*/*");
        out.println("Connection: close");
        out.println("");

        //
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];

        int len = in.read(buf);
        String str = new String(buf, 0, len);
        System.out.println(str);

        s.close();


    }



}


























