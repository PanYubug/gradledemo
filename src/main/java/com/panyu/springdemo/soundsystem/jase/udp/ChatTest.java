package com.panyu.springdemo.soundsystem.jase.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatTest {
    public static void main(String[] args) throws IOException {

        /*
         *
         * 通过UDP协议
         * 完成一个聊天程序
         * 一个负责发送数据的任务，一个负责接收数据的任务，两个任务同时执行，可以使用多线程技术
         *
         * 创建socket服务
         * 发送端
         *
         *
         * */
        System.out.println("");
        DatagramSocket send = new DatagramSocket(9999);
        DatagramSocket rece = new DatagramSocket(10001);

        new Thread(new Send(send)).start();
        new Thread(new Rece(rece)).start();

    }

}

//负责发送的任务，通过UDPsocket发送。
class Send implements Runnable {

    //任务对象一建立，需要socket对象
    private DatagramSocket ds;

    Send(DatagramSocket ds) {
        this.ds = ds;
    }


    @Override
    public void run() {
        //具体发送数据的任务内容
        //1、要发送的数据来自哪里？键盘录入。
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        //1、1读取数据
        String line = null;
        try {
            while ((line = bufr.readLine()) != null) {


                //1.2将数据变成字节数组封装到数据包中
                //2、数据封装到数据包中
                byte[] buf = line.getBytes();
                DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.10.216"), 10001);
                //3、将数据包发送出去
                this.ds.send(dp);
                if ("over".equals(line)) {
                    break;
                }
            }

            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

//负责接收的任务
class Rece implements Runnable {

    // 需要一个socket对象
    private DatagramSocket ds;

    Rece(DatagramSocket ds) {
        this.ds = ds;
    }


    @Override
    public void run() {

        while (true) {
            //接收的具体的任务内容
            //1、因为接收的数据最终都会存储到数据包中，而数据包中必须有字节数组
            byte[] buf = new byte[1024];
            //2、创建数据包对象
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            //3、将收到的数据存储到数据包中
            try {
                ds.receive(dp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //4、获取数据
            String ip = dp.getAddress().getHostAddress();

            String data = new String(dp.getData(), 0, dp.getLength());

            System.out.println(ip + ":" + data);
            if ("over".equals(data)){
                System.out.println(ip+"....离开聊天室");
                break;
            }
        }

    }
}

