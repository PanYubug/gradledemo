package com.panyu.springdemo;

import com.panyu.springdemo.soundsystem.CompactDisc;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationSpring {
    public static void main(String[] args) {
        System.out.println("ApplicationSpring is running......");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_xm_-constructor.xml");
//        CompactDisc cd = context.getBean(CompactDisc.class);
        CompactDisc cd = (CompactDisc) context.getBean("compactDisc1");
        cd.play();

    }
}
