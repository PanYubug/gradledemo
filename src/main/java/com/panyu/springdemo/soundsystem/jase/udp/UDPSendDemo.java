package com.panyu.springdemo.soundsystem.jase.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {
    public static void main(String[] args) throws IOException {
        /*
        * 需求：建立udp的发送端
        * 思路：
        * 1、建立可以实现udp传输的socket服务
        * 2、明确具体发送的数据
        * 3、通过socket服务将具体的数据发送出去
        * 4、关闭服务
        * */


        System.out.println("UDP发送端启动......");


        // 1、创建UDP服务
        DatagramSocket ds = new DatagramSocket();
        // 2、明确数据
        String str = "注意力，UDP来了";
        // 3、发送数据 将数据封装到数据包中。
            // 3.1 将数据封装到数据包对象中， 数据包会明确目的地址和端口。
        byte[] buf = str.getBytes();
        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.10.216"), 10000);
            // 3.2 发送
        ds.send(dp);
            //4 关闭
        ds.close();
    }
}
