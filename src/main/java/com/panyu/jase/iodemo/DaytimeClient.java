package com.panyu.jase.iodemo;

import java.io.*;
import java.net.Socket;

public class DaytimeClient {

    public static final String SERVER = "www.baidu.com";
    public static final int PORT = 80;
    public static final int TIMEOUT = 15000;

    public static void main(String[] args) {
        socketClientDemo(args);
    }

    public static void socketClientDemo(String[] args) {
        String hostname = args.length > 0 ? args[0] : SERVER;
        Socket socket = null;

        try {
            // 首先，在端口13打开与time.nist.gov的连接
            // （这不只是创建这个对象，实际上它会在网络上建立连接。如果超时或者由于服务器未在端口13上监听而失败，构造函数会抛出一个IOException异常，所以通常要包在try-catch或try-with-resources块中）
            socket = new Socket(hostname, PORT);
            // 设置过期时间
            socket.setSoTimeout(TIMEOUT);
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "UTF-8");
            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char) c);
            }
            System.out.println(time);
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {

                }
            }
        }
    }

    public static void socketClientDemo1(String[] args) {
        String hostname = args.length > 0 ? args[0] : SERVER;
        Socket socket = null;

        try {
            // 首先，在端口13打开与time.nist.gov的连接
            // （这不只是创建这个对象，实际上它会在网络上建立连接。如果超时或者由于服务器未在端口13上监听而失败，构造函数会抛出一个IOException异常，所以通常要包在try-catch或try-with-resources块中）
            socket = new Socket(hostname, PORT);
            // 设置过期时间
            socket.setSoTimeout(TIMEOUT);
            OutputStream out = socket.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));

            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            for (String word : args) {
                define(word, writer, reader);
            }

            writer.write("quit\r\n");
            writer.flush();

        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {

                }
            }
        }
    }

    private static void define(String word, Writer writer, BufferedReader reader) throws IOException, UnsupportedEncodingException {
        writer.write("DEFINE eng-lat" + word + "\r\n");
        writer.flush();

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            if (line.startsWith("250 ")) {
                return;
            } else if (line.startsWith("552 ")) {
                System.out.println("No definition found for" + word);
                return;
            } else if (line.matches("\\d\\d\\d .*")) continue;
            else if (line.trim().equals(".")) continue;
            else System.out.println(line);
        }
    }

    public static void demo() {
        try (Socket connection = new Socket("www.baidu.com", 80)) {
            Writer out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            out.write("GET / HTTP 1.0\r\n\r\n");
            out.flush();
            connection.shutdownOutput();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void demo2() {
        
    }

}
