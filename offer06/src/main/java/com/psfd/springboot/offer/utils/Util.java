package com.psfd.springboot.offer.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static int getCurrent(int current){
        if (current == 1) {
            current--;
        } else {
            current = (current * 5) - 5;
        }
        return current;
    }

    /**
     * 获取创建时间
     * @return
     */
    public static java.sql.Date getCreateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String format = df.format(new Date());// new Date()为获取当前系统时间
        return setString2SQLDate(format);
    }

    private static java.sql.Date setString2SQLDate(String dateStr) {
        SimpleDateFormat dateFormatHiddenHour = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date = null;
        try {
            String s = dateFormatHiddenHour.format(dateFormatHiddenHour.parse(dateStr));
            date = java.sql.Date.valueOf(s);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return date;
    }
}
