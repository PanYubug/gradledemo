package com.panyu.jase.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
//        demo1();


        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(100));
        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(100d));
        BigDecimal bigDecimal3 = BigDecimal.valueOf(100d);
        BigDecimal bigDecimal4 = new BigDecimal("100");
        BigDecimal bigDecimal5 = new BigDecimal(String.valueOf(100));

        print(bigDecimal1);
        print(bigDecimal2);
        print(bigDecimal3);
        print(bigDecimal4);
        print(bigDecimal5);

        double num1 = 3.25;
        float num2 = 3.35f;
        System.out.println(String.format("%.1f", num1));
        System.out.println(String.format("%.1f", num2));
        BigDecimal num3 = new BigDecimal("3.35");
        // 小数点后1位，向下舍入
        BigDecimal num4 = num3.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println(num4);
        // 小数点后1位，四舍五入
        BigDecimal num5 = num3.setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(num5);

        System.out.println(new BigDecimal("1").equals(new BigDecimal("1.0")));

    }

    public static void demo1() {
        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.2)));
        System.out.println(new BigDecimal(1.0).add(new BigDecimal(0.8)));
        System.out.println(new BigDecimal(4.015).add(new BigDecimal(100)));
        System.out.println(new BigDecimal(123.3).add(new BigDecimal(100)));

        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));
        System.out.println(new BigDecimal("1.0").add(new BigDecimal("0.8")));
        System.out.println(new BigDecimal("4.015").add(new BigDecimal("100")));
        System.out.println(new BigDecimal("123.3").add(new BigDecimal("100")));
    }

    private static void print(BigDecimal bigDecimal){
        System.out.println(String.format("scale %s precision %s result %s", bigDecimal.scale(), bigDecimal.precision(),bigDecimal.multiply(new BigDecimal("1.001"))));
    }
}
