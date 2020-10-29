package com.panyu.springdemo.soundsystem.jase.upload;

import java.io.*;
import java.net.Socket;

public class UploadPic implements Runnable {

    private Socket s;

    public UploadPic(Socket s) {
        super();
        this.s = s;
    }

    @Override
    public void run() {

        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + "......connected");

        InputStream in = null;
        try {
            in = s.getInputStream();
            File dir = new File("/Users/panyu");
            if (!dir.exists()) {
                dir.mkdir();
            }
            int count = 1;
            File file = new File(dir, ip + ".jpg");
            while (file.exists()) {
                file = new File(dir, ip + "(" + count + ").jpg ");
                count++;
            }
            FileOutputStream fos = new FileOutputStream(file);

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }

            //回馈客户端数据
            OutputStream out = s.getOutputStream();
            out.write("上传图片成功".getBytes());

            fos.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
