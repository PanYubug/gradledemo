package com.panyu.springdemo.soundsystem.jase.collectiondemo;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        /*
        * 需求：Map集合中存储学号，姓名
        *
        * */
//        Map<Integer, String> map = new HashMap<Integer, String>();
//        methodDemo(map);

//        Map<String, String> map2 = new HashMap<String, String>();
//        methodGetAll(map2);
        //3、entrySet()
        Map<String, String> map2 = new HashMap<String, String>();
        methodValue(map2);



    }
    public static void methodDemo(Map<Integer, String> map){
        //1、存储键值对。如果键相同，出现值覆盖
        System.out.println(map.put(3,"xiaoqiang"));
        System.out.println(map.put(3,"erhu"));
        map.put(7,"wangcai");
        map.put(2,"daniu");
        System.out.println(map);

        //2、获取map中去全部元素
        System.out.println(map.get(7));
        System.out.println(map.remove(7));


    }

    public static void methodGetAll(Map<String, String> map){
        map.put("xiaoqiang","beijing");
        map.put("wangcai","funiushan");
        map.put("daniu","heifengzhai");
        map.put("erhhu","wohudong");

        //keySet,取出所有的键，并存储到set集合中
        //map集合没有蝶鞍带起，可以，先将map集合转换成set集合，再使用迭代器
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println("key:"+s+","+"value:"+map.get(s));
            System.out.println();
        }

    }
    //Map.Entry:其实就是一个Map接口中的内部接口

    public static void methodEntry(Map<String, String> map){
        Set<Map.Entry<String,String>> entryset1  = map.entrySet();
        for (Iterator<Map.Entry<String, String>> it = entryset1.iterator(); it.hasNext(); ) {
            Map.Entry<String, String> next =  it.next();
            String key = next.getKey();
            String value = next.getValue();
            System.out.println("key:"+key+"value:"+value);


        }
    }

    public static void methodValue(Map<String, String> map){
        Collection<String> values = map.values();
        for (Iterator<String> it = values.iterator(); it.hasNext(); ) {
            String value = it.next();
            System.out.println(value);
        }

    }
}
