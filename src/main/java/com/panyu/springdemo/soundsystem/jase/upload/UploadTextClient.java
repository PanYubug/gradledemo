package com.panyu.springdemo.soundsystem.jase.upload;

import java.io.*;
import java.net.Socket;

public class UploadTextClient {
    public static void main(String[] args) throws IOException {
        /*
        * 上传文本的客户端，读取本地文本数据，发送给服务端，服务端接收完毕后，回馈"上传成功"字样
        *
        * */


        System.out.println("上传文本客户端启动...... ");
        //客户端socket
        Socket s = new Socket("192.168.10.216",10005);

        //1、确定数据源。本地文件
        BufferedReader bufr = new BufferedReader(new FileReader("abc"));

        //2、确定目的。socket 输出流、

//        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        String line = null;
        while ((line=bufr.readLine()) !=null){
            out.println(line);
        }

        //给服务端发送标记
//        out.println("over");  容易重复

        //使用socket的禁用输出流方法
        s.shutdownInput();

        //3、通过socket读取流获取服务器端返回的数据
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String lineIn = bufIn.readLine();
        System.out.println(lineIn);

        //4、关闭
        bufr.close();
        s.close();

    }
}
