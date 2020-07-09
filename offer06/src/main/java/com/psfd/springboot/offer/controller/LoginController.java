package com.psfd.springboot.offer.controller;


import com.psfd.springboot.offer.bean.User;
import com.psfd.springboot.offer.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LoginController {

    @Resource
    IUserService userService;

    @RequestMapping("framework/login.do")
    public String loginSkip(){
        List<User> list = userService.list();
        System.out.println(list.size());
        return "framework/login";
    }
}
