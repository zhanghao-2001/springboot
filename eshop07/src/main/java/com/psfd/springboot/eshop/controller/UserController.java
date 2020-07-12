package com.psfd.springboot.eshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.psfd.springboot.eshop.domain.User;
import com.psfd.springboot.eshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping("/userList")
    public ModelAndView userList(ModelAndView modelAndView) {
        List<User> userList = userService.list();
        modelAndView.setViewName("user/userList");
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @RequestMapping("/userQuery")
    public String userQuery() {
        return "user/userQuery";
    }

    @RequestMapping("/queryUserByName")
    public ModelAndView queryUserById(ModelAndView modelAndView, User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("name", user.getName());
        map.put("sex", user.getSex());
        map.put("address", user.getAddress());
        map.put("phone", user.getPhone());
        map.put("post", user.getPost());
        wrapper.allEq(map);
        List<User> userList = userService.list(wrapper);
        modelAndView.setViewName("user/userList");
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }


}
