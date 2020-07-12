package com.psfd.springboot.eshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.psfd.springboot.eshop.domain.Admin;
import com.psfd.springboot.eshop.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(Admin admin, HttpSession session) {
        System.out.println("admin = " + admin);
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username", admin.getUsername());
        wrapper.eq("password", admin.getPassword());
        wrapper.select("admin_id");
        Integer count = adminService.count(wrapper);
        Admin admin1 = adminService.getOne(wrapper);
        session.setAttribute("adminId", admin1.getAdminId());
        return count.toString();
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public String updatePassword(String password, String newPassword, String newPasswordOne, HttpSession session) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("admin_id", session.getAttribute("adminId"));
        Admin admin = adminService.getOne(wrapper);
        if (newPassword.equals(newPasswordOne)) {
            if (admin.getPassword().equals(password)) {
                admin.setPassword(newPassword);
                adminService.saveOrUpdate(admin);
                return "修改密码成功";
            } else {
                return "密码输入错误";
            }
        } else {
            return "两次输入的密码不一致";
        }
    }
}
