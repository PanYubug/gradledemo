package com.panyu.springdemo.soundsystem.jase.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        /*
        * tcp客户端的建立
        * 思路：
        * 1、建立tcp客户端服务
        *   1.1因为是面向连接，必须有连接才可以进行通信
        *   1.2在创建客户端时，必须明确目的地址和端口。
        * 2、一旦连接建立，就有了传输数据的通道。就可以再通道中进行数据传输
        *   这个传输其实就是通过流实现的。这个流就是socket io流
        * 3、只要获取socket io中的写动作就可以数据写到socket流中发给服务端
        * 4、关闭资源
        *
        * */
        System.out.println("客户端启动......");

        //1，创建客户端对象。明确目的地址和端口
        Socket s = new Socket("192.168.10.216", 10003);
        //2, 获取socket流中输出流。将数据发送给服务端
        OutputStream out = s.getOutputStream();
        //3,通过输出流写数据
        out.write(("又注意啦，tcp来了").getBytes());
        //4、关闭资源
        s.close();

    }


































}
