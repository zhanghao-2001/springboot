package com.psfd.springboot.eshop.test;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class MyConverter implements Converter<String, Date> {


    @Override
    public Date convert(String time) {
        System.out.println("time = " + time);
        if (!StringUtils.isEmpty(time)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return sdf.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
