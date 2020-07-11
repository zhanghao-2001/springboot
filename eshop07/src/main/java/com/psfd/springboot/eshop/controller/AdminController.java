package com.psfd.springboot.eshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.psfd.springboot.eshop.domain.Admin;
import com.psfd.springboot.eshop.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
@Controller
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @RequestMapping("/login")
    public String login(Admin admin) {
        System.out.println("admin = " + admin);
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username", admin.getUsername());
        wrapper.eq("password", admin.getPassword());
        int count = adminService.count(wrapper);
        String url = count == 1 ? "index" : "error";
        return url;
    }
}
