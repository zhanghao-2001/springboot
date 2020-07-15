package com.psfd.springboot.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LuYang
 * @create 2020-07-09 20:33
 */
@Controller
@RequestMapping("test")
public class TestController {


    @RequestMapping("login")
    public String login(){
        return "framework/login";

    }

    @RequestMapping("")
    public String test(){
        return "";
    }

}
