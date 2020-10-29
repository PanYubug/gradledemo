package com.panyu.springdemo.soundsystem.jase.upload;

import java.io.*;
import java.net.Socket;

public class UploadPicClient {
    public static void main(String[] args) throws IOException {

        //1、创建socket客户端
        Socket s = new Socket("192.168.10.216", 10006);

        File picFile = new File("1.jpg");
        FileInputStream fis = new FileInputStream(picFile);

        OutputStream out = s.getOutputStream();

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len=fis.read(buf))!=-1){
            out.write(buf, 0, len);
        }

        //读取服务端数据
        InputStream in = s.getInputStream();
        byte[] bufIn = new byte[1024];
        int lenIn = in.read(bufIn);
        String str = new String(bufIn,0, lenIn);
        System.out.println(str);

    }
}
