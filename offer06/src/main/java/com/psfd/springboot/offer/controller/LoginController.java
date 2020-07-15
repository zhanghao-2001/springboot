package com.psfd.springboot.offer.controller;


import com.psfd.springboot.offer.bean.User;
import com.psfd.springboot.offer.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Resource
    IUserService userService;

    @RequestMapping("framework/login.do")
    public String loginSkip(){
        return "framework/login";
    }


    @RequestMapping("framework/main.do")
    public String mainSkip(){
        return "framework/main";
    }

    @RequestMapping("framework/outlook.do")
    public String outlookSkip(){
        return "framework/outlook";
    }

    @RequestMapping("framework/loginRegister.do")
    public ModelAndView login(String username, String password, HttpServletRequest request){
        ModelAndView m = new ModelAndView();
        List<User> list = userService.list();
        boolean flag = false;
        for (User user : list) {
            if(user.getUsername().equals(username) && user.getPassword().equals((password))){
                flag = true;
                break;
            }
        }
        if(flag){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            m.setViewName("framework/back_index");
            return m;
        }else{
            m.setViewName("framework/login");
            return m;
        }


    }
}
