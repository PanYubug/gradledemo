package com.panyu.springdemo.soundsystem.jase.upload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer {
    public static void main(String[] args) throws IOException {


        //服务端对象
        ServerSocket ss = new ServerSocket(10006);
        while (true) {
            Socket s = ss.accept();

            new Thread(new UploadPic(s)).start();

        }
//        ss.close();
    }
}
