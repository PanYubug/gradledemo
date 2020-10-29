package com.panyu.springdemo.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/springconfig/applicationContext-property.xml")
public class AppTest {

    @Autowired
    private CDPlayer cdPlayer1;

    @Test
    public void test(){
        cdPlayer1.play();
    }
}
