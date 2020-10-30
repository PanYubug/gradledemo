package com.panyu.springdemo;

import com.panyu.springdemo.soundsystem.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/springconfig/applicationContext_xm_-constructor.xml")
public class PersonFactoryTest {

    @Autowired
    private Person person1;

    @Autowired
    private Person person2;

    @Test
    public void test01(){
        System.out.println(person1.toString());
        System.out.println(person2.toString());
    }

}