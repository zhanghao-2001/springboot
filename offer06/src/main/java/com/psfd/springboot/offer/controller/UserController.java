package com.psfd.springboot.offer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.psfd.springboot.offer.bean.Quotation;
import com.psfd.springboot.offer.bean.User;
import com.psfd.springboot.offer.service.IUserService;
import com.psfd.springboot.offer.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Resource
    IUserService userService;

    @RequestMapping("framework/userList.do")
    public ModelAndView userList(int current){
        ModelAndView m = new ModelAndView();
        List<User> list = userService.list();
        List<User> temp = new ArrayList<>();
        IPage<User> page = new Page<>();
        page.setCurrent(current);
        page.setSize(5);
        current = Util.getCurrent(current);
        for (int i = current; i < current + 5; i++) {
            if (i == list.size()) {
                break;
            }
            temp.add(list.get(i));
        }
        page.setRecords(temp);
        page.setTotal(list.size());
        m.addObject("page",page);
        m.setViewName("user/user_list");
        return m;
    }

    @RequestMapping("user/skip.do")
    public ModelAndView userSkip(int current){
        return userList(current);
    }

    @RequestMapping("user/userDelete.do")
    public ModelAndView userDelete(int current,String name){
        userService.removeById(name);
        int size = userService.list().size();
        int page = getPage(size);
        if (current > page) {
            current = page;
        }
        return userList(current);
    }

    private int getPage(int size) {
        int page = 0;
        if (size % 5 != 0) {
            page = (size / 5) + 1;
        } else {
            page = (size / 5);
        }
        return page;
    }

    @RequestMapping("user/userAddSkip.do")
    public String userAddSkip(){
        return "user/user_add";
    }

    @RequestMapping("user/userAdd.do")
    public ModelAndView userAdd(User user){
        userService.save(user);
        int size = userService.list().size();
        return userList(1);
    }

    @RequestMapping("user/userUpdateSkip.do")
    public ModelAndView userUpdateSkip(int current,String name){
        User user = userService.getById(name);
        ModelAndView m = new ModelAndView();
        m.addObject("user",user);
        m.addObject("current",current);
        m.setViewName("user/user_update");
        return m;
    }

    @RequestMapping("user/userUpdate.do")
    public ModelAndView userUpdate(int current,User user){
        userService.updateById(user);
        return userList(current);
    }

    @RequestMapping("framework/userQuerySkip.do")
    public String userQuerySkip(){
        return "user/user_query";
    }

    @RequestMapping("framework/userQuery.do")
    public ModelAndView userQuery(String username){
        User user = userService.getById(username);
        ModelAndView m = new ModelAndView();
        if(user != null){
            IPage<User> page = new Page<>();
            List<User> list = new ArrayList<>();
            list.add(user);
            page.setTotal(list.size());
            page.setRecords(list);
            page.setCurrent(1);
            page.setSize(5);
            m.addObject("page", page);
            m.setViewName("user/user_list");
            return m;
        }
        m.setViewName("user/user_query");
        return m;
    }
}
