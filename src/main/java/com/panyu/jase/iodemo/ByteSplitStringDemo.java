package com.panyu.jase.iodemo;

import java.io.UnsupportedEncodingException;

public class ByteSplitStringDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {

        /**
         * 按照字节数截取一个字符串，"abc你好"，如果截取到半个中文，舍弃。比如截取4字节，abc. 截取5个字节abc你。
         * 定义功能实现。
         * 字符串-->字节数组。编码
         * 字节数组-->字符串。解码
         *
         * 友情提示：GB2312编码一个中文是两个字节，而且两个字节的最高位都是1，也就是说是一个负数。
         *
         *
         * 思路：
         * 1、提示告诉我中文两个字节都是负数
         * 2、判断截取的最后一个字节是否是负数
         * 如果不是，直接截取
         * 如果是的，就往回判断前一个是否是负数，并记录住负数的个数，如果连续的负数有奇数个，舍弃最后一个字节
         * 如果连续的负数是偶数个，不舍弃
         */
        
        //字符串转成字节数组
        String str = "abc你好";
        byte[] buf = str.getBytes("GBK");
        for (byte b : buf) {

            System.out.println(b);
        }
        for (int i = 0; i < buf.length; i++) {
            String temp = cutStringByCount(str, i+1);
            System.out.println("截取"+(i+1)+"个字节是： "+temp);
        }


    }

    private static String cutStringByCount(String str, int len) throws UnsupportedEncodingException {
        //1、将字符串转成字节数组。因为判断截取的字节是否是负数。现有字节。
        byte[] buf = str.getBytes("GBK");
        //2、定义计数器，记录住负数的个数
        int count = 0;
        //3、对字节数组进行遍历，应该从截取长度的最后一个字节开始判断，并往回判断。
        for (int x = len-1; x >=0; x--) {
            //4、遍历过程中，只要满足负数就进行计数
            if (buf[x] < 0){
                count++;
            }else {
                break;
            }
        }
        //5、对遍历后，计数器的值进行判断，奇数，就舍弃最后字节并将字节数组转成字符串;偶数，不舍弃，将字节数组转成字符串
        if (count%2==0){
            return new String(buf, 0, len);
        }else {
            return new String(buf, 0, len-1);
        }
    }
}
