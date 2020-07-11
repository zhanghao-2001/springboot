package com.psfd.springboot.eshop.controller;


import com.psfd.springboot.eshop.service.IOrderlistService;
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
public class OrderlistController {

    @Autowired
    private IOrderlistService orderlistService;

    @RequestMapping("/orderQuery")
    public String orderQuery() {
        return "order/orderQuery";
    }
}
