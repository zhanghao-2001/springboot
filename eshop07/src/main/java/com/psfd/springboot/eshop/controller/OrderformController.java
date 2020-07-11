package com.psfd.springboot.eshop.controller;


import com.psfd.springboot.eshop.service.IOrderformService;
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
public class OrderformController {

    @Autowired
    private IOrderformService orderformService;

    @RequestMapping("/orderList")
    public String orderList() {
        return "order/orderList";
    }

}
