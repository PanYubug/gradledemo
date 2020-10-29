package com.panyu.springdemo.soundsystem.jase.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadTextServer {
    public static void main(String[] args) throws IOException {

        /*
        * 上传文本的服务器端，接收文本数据，并存储到文件中，服务端接收完毕后，回馈"上传成功"字样
        * */

        System.out.println("上床服务器启动......");
        //1、服务器端对象
        ServerSocket ss = new ServerSocket(10005);

        //2、获取客户端
        Socket s = ss.accept();

        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"......connected");

        //3、获取读取流，确定源，网络socket
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //4、确定目的。文件
        PrintWriter pw = new PrintWriter(new FileWriter("server.txt"), true);

        //5、频繁读写
        String line = null;
        while ((line=bufIn.readLine())!=null){

            if ("over".equals(line))
                break;
            pw.println(line);
        }

        //6、给客户端返回信息
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println("上传成功");

        pw.close();
        s.close();
        ss.close();
    }
}
