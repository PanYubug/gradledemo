package com.panyu.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BankTransferMoney {
    double maxMoney() default 10000;
}
