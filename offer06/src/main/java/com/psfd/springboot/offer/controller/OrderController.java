package com.psfd.springboot.offer.controller;


import com.psfd.springboot.offer.service.IOrderService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class OrderController {
    @Resource
    IOrderService orderService;
}
