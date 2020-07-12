package com.psfd.springboot.eshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.psfd.springboot.eshop.domain.Orderform;
import com.psfd.springboot.eshop.domain.User;
import com.psfd.springboot.eshop.service.IOrderformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public ModelAndView orderList(ModelAndView modelAndView) {
        List<Orderform> orderFormList = orderformService.list();
        modelAndView.addObject("orderFormList", orderFormList);
        modelAndView.setViewName("order/orderList");
        modelAndView.addObject("orderFormList", orderFormList);
        return modelAndView;
    }

    @RequestMapping("/queryOrderById")
    public ModelAndView queryAllOrderQuery(Orderform orderform, ModelAndView modelAndView, String name) {
        QueryWrapper<Orderform> wrapper = new QueryWrapper<>();
        orderform.setUser(new User());
        orderform.getUser().setUsername(name);
        System.out.println("orderform = " + orderform);
        wrapper.eq("order_form_id", orderform.getOrderFormId());
//        List<Orderform> orderFormList = orderformService.list(wrapper);
//        modelAndView.addObject("orderFormList", orderFormList);
        modelAndView.setViewName("order/orderList");
        return modelAndView;
    }

}
