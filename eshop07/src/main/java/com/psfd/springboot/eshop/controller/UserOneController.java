package com.psfd.springboot.eshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.psfd.springboot.eshop.domain.Admin;
import com.psfd.springboot.eshop.domain.Commodity;
import com.psfd.springboot.eshop.domain.User;
import com.psfd.springboot.eshop.service.IOrderformService;
import com.psfd.springboot.eshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class UserOneController {

    @Autowired
    private IUserService userService;


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(ModelAndView modelAndView, User user, HttpSession session) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        wrapper.eq("password", user.getPassword());
        int count = userService.count(wrapper);
        if (count == 1) {
            modelAndView.setViewName("success");
            modelAndView.addObject("message", "登录成功");
            modelAndView.addObject("jumpAddress", "index");
            user = userService.getOne(wrapper);
            session.setAttribute("user", user);
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
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
