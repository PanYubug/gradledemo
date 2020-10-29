package com.panyu.springdemo.soundsystem.jase.tcp2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 {
    public static void main(String[] args) throws IOException {
        /*
        * 服务端收到客户端的数据并反馈数据给客户端。应答
        *
        * */

        System.out.println("服务器端2启动......");
        //1，创建服务端socket对象
        ServerSocket ss = new ServerSocket(10004);
        //2，获取客户端对象
        Socket s = ss.accept();

        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"......connected");

        //3，获取socket读取流
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String str = new String(buf, 0, len);

        System.out.println(str);
        //4，给客户端反馈数据 socket输出流
        OutputStream out = s.getOutputStream();
        out.write("哦了，我知道你来了".getBytes());
        s.close();
        ss.close();
    }
}
