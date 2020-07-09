package com.psfd.springboot.offer.controller;

import com.psfd.springboot.offer.service.IUserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    IUserService userService;
}
