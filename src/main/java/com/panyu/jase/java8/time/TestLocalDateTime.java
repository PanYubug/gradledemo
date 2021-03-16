package com.panyu.jase.java8.time;

import org.testng.annotations.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestLocalDateTime {

    //6、ZonedDate、ZonedTime、ZoneDateTime
    @Test
    public void test8() {
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("America/Marigot"));
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);
    }

    @Test
    public void test7() {
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }

    //5、DateTimeFormatter：格式化时间/日期
    @Test
    public void test6() {

        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();
        String strDate = ldt.format(dtf);
        System.out.println(strDate);

        System.out.println("----------------");

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = ldt.format(dtf2);
        System.out.println(strDate2);

        LocalDateTime newDate = ldt.parse(strDate2, dtf2);
        System.out.println(newDate);
    }

    //4、TemporalAdjuster、TemporalAdjusters：时间校正器。
    @Test
    public void test5() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        LocalDate nextSunday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(nextSunday);

        LocalDateTime ldt5 = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dow = ldt4.getDayOfWeek();
            if (dow.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }

    //3、
    // Duration：计算两个时间之间的间隔
    // Period：计算两个日期之间的间隔
    @Test
    public void test4() {
        LocalDate ld1 = LocalDate.of(2015, 1, 1);
        LocalDate ld2 = LocalDate.now();

        Period period = Period.between(ld1, ld2);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    @Test
    public void test3() {
        Instant ins1 = Instant.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        Instant ins2 = Instant.now();

        Duration duration = Duration.between(ins1, ins2);
        System.out.println(duration.toMillis());

        System.out.println("--------------------");

        LocalTime lt1 = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        LocalTime lt2 = LocalTime.now();

        System.out.println(Duration.between(lt1, lt2).toMillis());
    }


    //2、Instant：时间戳（以Unix元年：1970年1月1日 00:00:00到某个时间之间的毫秒值）
    @Test
    public void test2() {
        Instant ins1 = Instant.now();//默认获取UTC时区
        System.out.println(ins1);

        OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(ins1.toEpochMilli());

        Instant ins2 = Instant.ofEpochSecond(60);
        System.out.println(ins2);
    }

    //1、LocalDate、LocalTime、LocalDateTime
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2015, 10, 12, 13, 22, 33);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.plusYears(2);
        System.out.println(ldt3);

        LocalDateTime ldt4 = ldt.minusMonths(2);
        System.out.println(ldt4);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
    }
}
