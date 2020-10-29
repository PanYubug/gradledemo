package com.panyu.springdemo.soundsystem.jase.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class NoteBookMain {
    public static void main(String[] args) throws Exception {

        NoteBook book = new NoteBook();

        book.run();
//        book.useUSB(null);

        //希望的是，后期出现设备之后，可不可以不用修改NoteBookMain代码。且不断加入新设备
        //通过反射来解决问题

        //对外提供配置文件
        File configFile = new File("usb.properties");
        if (!configFile.exists()){
            configFile.createNewFile();
        }

        //读取流和配置文件关联
        FileInputStream fis = new FileInputStream(configFile);
        Properties prop = new Properties();

        //将六中的数据加载到prop
        prop.load(fis);
        for (int i = 1; i < prop.size(); i++) {
            String className = prop.getProperty("usb"+i);

            Class clazz = Class.forName(className);
            USB usb = (USB)clazz.newInstance();
            book.useUSB(usb);
            
        }
        fis.close();
        

    }
}
