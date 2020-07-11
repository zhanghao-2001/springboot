package com.psfd.springboot.eshop.controller;


import com.psfd.springboot.eshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

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
    public String userList() {
        return "user/userList";
    }

    @RequestMapping("/userQuery")
    public String userQuery() {
        return "user/userQuery";
    }


}
