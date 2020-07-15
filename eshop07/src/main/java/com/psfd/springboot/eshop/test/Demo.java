package com.psfd.springboot.eshop.test;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        Random r = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            String string = r.nextInt(10) + "";
            stringBuffer.append(string);
        }
        System.out.println("stringBuffer = " + stringBuffer);
    }
}
