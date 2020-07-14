package com.psfd.springboot.eshop.test;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MyConverterOne implements Converter<String, Byte> {


    @Override
    public Byte convert(String s) {
        if (s.equals("男")) {
            return 1;
        }
        return 0;
    }
}
