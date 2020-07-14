package com.psfd.springboot.eshop.controller;

import com.psfd.springboot.eshop.domain.User;
import com.psfd.springboot.eshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class UserOneController {

    @Autowired
    private IUserService userService;


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(ModelAndView modelAndView, User user) {
        user.setRegTime(new Date());
        userService.saveOrUpdate(user);
        modelAndView.setViewName("success");
        modelAndView.addObject("message", "注册用户成功");
        modelAndView.addObject("jumpAddress", "registerUser");
        return modelAndView;
    }
}
