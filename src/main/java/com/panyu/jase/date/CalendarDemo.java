package com.panyu.jase.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarDemo {

    public static void main(String[] args) {
        /*
           c.get(Calendar.MONTH)获取的月比正常月份少一个月
           c.get(Calendar.DAY_OF_WEEK)获取到的指定时间是一周的第几天，周日为第一天

         */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar c = Calendar.getInstance();
        System.out.println(c);
        /*
        java.util.GregorianCalendar[
        time=1608800781443,
        areFieldsSet=true,
        areAllFieldsSet=true,
        lenient=true,
        zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",
        offset=28800000,
        dstSavings=0,
        useDaylight=false,
        transitions=19,
        lastRule=null],
        firstDayOfWeek=1,
        minimalDaysInFirstWeek=1,
        ERA=1,
        YEAR=2020,
        MONTH=11,
        WEEK_OF_YEAR=52,
        WEEK_OF_MONTH=4,
        DAY_OF_MONTH=24,
        DAY_OF_YEAR=359,
        DAY_OF_WEEK=5,
        DAY_OF_WEEK_IN_MONTH=4,
        AM_PM=1,
        HOUR=5,
        HOUR_OF_DAY=17,
        MINUTE=6,
        SECOND=21,
        MILLISECOND=443,
        ZONE_OFFSET=28800000,
        DST_OFFSET=0]
         */
        System.out.println("获取到的指定时间是一周的第"+c.get(Calendar.DAY_OF_WEEK)+"天，周日为第一天");
        System.out.println("获取到的指定时间是一年的第"+c.get(Calendar.MONTH)+"个月，比实际月份少一个月");
    }


}
