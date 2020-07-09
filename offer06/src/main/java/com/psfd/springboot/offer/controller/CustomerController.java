package com.psfd.springboot.offer.controller;

import com.psfd.springboot.offer.service.ICustomerService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class CustomerController {

    @Resource
    ICustomerService customerService;
}
