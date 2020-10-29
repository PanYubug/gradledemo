package com.panyu.springdemo.soundsystem.jase;


/*
 *
 * String类构造函数可以将字节数组，或者字符数组构造成字符串对象
 * 1、长度
 * 2、获取指定位置字符
 * 3、获取字符所处的位置
 * 4、
 *
 *
 * 11、字符串可以比较大小吗？如果有。将字符串数组排序
 * 记住：基本类型数值可以通过比较运算符比较大小和相等。><==
 *       对象也可以比较是否相等，谁大谁小。都是通过方法完成的。
 *       对象比较相同：object类中boolean equals（object obj）：子类一般情况下都会腹泻，简历自己判断的条件
 *       对象比大小用的也是方法该功能有三种情况。所以使用int类型。正数 负数 0
 *       前者大鱼后者返回证书，前者小雨后者返回负数 前者等于后者返回零
 *
 * */


public class StringDemo {
    public static void main(String[] args) {

        /*
         * String演示
         *1、一旦初始化就不会被改变
         *
         *
         * */
        String str = "abcd";
//        str = "hello";
        String str1 = new String("abcd");
        System.out.println(str == str1);
        System.out.println(str.equals(str1));//true 字符串的equals覆盖了object类，比较值

        //str和str1的区别
        /*
         *str在内存中只有一个对象
         * str1在内存中有两个对象
         *
         *
         * */

        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
        int len = s1.length();

        char ch = s1.charAt(0);

        int index = s1.indexOf('a');

        System.out.println(len);
        System.out.println(ch);
        System.out.println(index);

        int num = s1.compareTo(s2);
        System.out.println(num);

        String[] strs = {"nba", "abc", "cba", "hha", "qq", "hihi"};
        sortstrs(strs);
        printArray1(strs);


    }

    private static void printArray1(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            if (i != strs.length - 1) {
                System.out.println(strs[i] + ",");
            } else {
                System.out.println(strs[i]);
            }
        }
    }


    public static void sortstrs(String[] strs) {
        for (int x = 0; x < strs.length - 1; x++) {
            for (int y = x + 1; y < strs.length; y++) {
                if (strs[x].compareTo(strs[y]) > 0) {
                    swap(strs, x, y);
                }
            }
        }
    }

    private static void swap(String[] strs, int x, int y) {
        String temp = strs[x];
        strs[x] = strs[y];
        strs[y] = temp;
    }
}




