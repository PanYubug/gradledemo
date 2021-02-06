package com.panyu.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo2 {

    @RequestMapping("/demoHello")
    public String demoHello(){
        return "hello demo!";
    }

}
