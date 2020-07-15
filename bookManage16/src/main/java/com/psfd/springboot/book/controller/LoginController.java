package com.psfd.springboot.book.controller;

import com.psfd.springboot.book.bean.BookMassage;
import com.psfd.springboot.book.service.IBookMassageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LuYang
 * @create 2020-07-10 9:58
 */
@Controller

public class LoginController {
    @Resource
    public IBookMassageService iBookMassageService;

    @RequestMapping("login.do")
    public ModelAndView lo(String name,String password){
        List<BookMassage> list = iBookMassageService.list();
        ModelAndView mod = new ModelAndView();
        mod.addObject("booklist",list);
       if(name.equals("admin") && password.equals("admin")){
           mod.setViewName("framework/main");
       }else {
           mod.setViewName("framework/login");
       }
        return mod;
    }
}
