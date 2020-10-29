package com.panyu.springdemo.soundsystem.jase.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        /*
        * 创建一个服务器为了获取浏览器发送过来的数据。
        *
        * */


        //
        ServerSocket ss = new ServerSocket(9090);

        Socket s = ss.accept();

        System.out.println(s.getInetAddress().getHostAddress()+"......connected");

        //接收浏览器的数据
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];

        int len = in.read(buf);
        String str = new String(buf, 0, len);
        System.out.println(str);

        //给浏览器一个回馈
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        out.println("欢迎光临， 你访问的事自定义的服务器！");

        s.close();
        ss.close();
    }
}
