package com.panyu.jase.iodemo.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo2 {

    public static void main(String[] args) throws IOException {

        /**
         * 需求：定义一个功能，记录程序运行的次数。满足5次后，给出提示。试用次数已到，请注册！
         * 思路：
         * 1、计数器
         * 2、计数器的生命周期比应用程序的周期长，需要对计数器的值进行持久化。
         * count = 1， 里面存储的应该是键值方式。map集合，要和设备上的数据关联，需要IO技术。
         * 集合 + IO = properties
         */

        if (checkCount()){
            run();
        }


    }

    private static boolean checkCount() throws IOException {

        boolean isRun = true;

        // 1、将配置文件封装File对象。因为要判断文件是否存在
        File configFile = new File("/Users/panyu/java_projects/gradledemo/src/main/java/com/panyu/jase/iodemo/properties/count.properties");

        if (!configFile.exists()){
            configFile.createNewFile();
        }

        // 记录每次对应的次数
        int count = 0;

        Properties prop = new Properties();

        // 2、定义流对象
        FileInputStream fis = new FileInputStream(configFile);

        // 3、将流中的数据加载到集合中
        prop.load(fis);

        String value = prop.getProperty("count");

        if (value != null){
            count = Integer.parseInt(value);
            if (count==5){
                System.out.println("试用次数已到，请注册！");
                isRun = false;
                return isRun;
            }
        }
        count++;

        prop.setProperty("count", String.valueOf(count));

        // 将集合中的数据存储到配置文件中

        FileOutputStream fos = new FileOutputStream(configFile);

        prop.store(fos, "");

        fos.close();
        fis.close();

        return isRun;
    }

    public static void run(){
        System.out.println("软件运行。。。");
    }
}
