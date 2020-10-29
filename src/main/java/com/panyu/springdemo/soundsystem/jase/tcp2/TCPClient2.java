package com.panyu.springdemo.soundsystem.jase.tcp2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient2 {
    public static void main(String[] args) throws IOException {


        /*
         * 需求：客户端发送数据给服务器端，并读取服务器端反馈的数据
         *
         * */
        //1、创建socket客户端
        System.out.println("客户端2启动......");
        Socket s = new Socket("192.168.10.216", 10004);
        //2、获取socket输出流
        OutputStream out = s.getOutputStream();
        out.write("服务端我来了。".getBytes());

        //3、获取socket的读取流。读取服务端发回的数据
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String str = new String(buf, 0, len);
        System.out.println(str);
        s.close();

    }
}





























