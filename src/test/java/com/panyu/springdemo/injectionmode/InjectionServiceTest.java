package com.panyu.springdemo.injectionmode;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(BlockJUnit4ClassRunner.class)
public class InjectionServiceTest {

    private ClassPathXmlApplicationContext context;

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("classpath:spring-injection.xml");
    }

    @Test
    public void injectionSay() {
        InjectionService injectionService = (InjectionService) context.getBean("injectionService");
        injectionService.say("world");
    }

    @Test
    public void autoWireSay(){
        AutoWireService autoWireService = (AutoWireService) context.getBean("autoWireService");
        autoWireService.say();
    }


}