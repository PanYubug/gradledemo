package com.panyu.springdemo.soundsystem.jase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoPan {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        System.out.println(dateFormat);

        String str_date = "2013-07-17";
        DateFormat dateFormat2 = DateFormat.getDateInstance();
        Date date = dateFormat2.parse(str_date);
        System.out.println(date);

    }
}
