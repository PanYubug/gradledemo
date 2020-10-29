package com.panyu.springdemo.soundsystem.jase.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        /*
         * 创建TCP服务器端。
         * 思路：
         * 1、创建socket服务器端服务。服务器端为了让客户端可以连接上，必须提供端口。监听一个端口。
         *
         * 2、获取客户端对象。通过客户端的socket流和对应的客户端进行通信
         *
         * 3、获取客户端的socket流的读取流。
         *
         * 4、读取数据并显示在服务器端
         *
         * 5、关闭资源
         * */

        System.out.println("服务器启动......");

        //1,创建服务器端对象
        ServerSocket ss = new ServerSocket(10003);
        //2，获取客户端对象。
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"......connected");
        //3，通过客户端对象获取socket流的读取流
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String str = new String(buf,0,len);

        System.out.println(str);

        s.close();
        ss.close();

    }

}

























