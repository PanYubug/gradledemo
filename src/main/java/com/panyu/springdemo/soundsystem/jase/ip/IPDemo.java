package com.panyu.springdemo.soundsystem.jase.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {
    public static void main(String[] args) throws UnknownHostException {
        /*
        * IP对象
        *
        * */

        // 本地主机
//        InetAddress ip = InetAddress.getLocalHost();

        // 获取其他主机ip

        InetAddress ip2 = InetAddress.getByName("www.sina.com.cn");
        System.out.println(ip2);
        String ip_str = ip2.getHostAddress();
        System.out.println(ip_str);
        String ip_name = ip2.getHostName();
        System.out.println(ip_name);




    }
}
