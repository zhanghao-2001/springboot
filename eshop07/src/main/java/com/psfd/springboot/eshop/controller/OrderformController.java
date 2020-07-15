package com.psfd.springboot.eshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.psfd.springboot.eshop.domain.Orderform;
import com.psfd.springboot.eshop.domain.User;
import com.psfd.springboot.eshop.service.IOrderformService;
import com.psfd.springboot.eshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Autowired
    private IUserService userService;

    @RequestMapping("/orderList")
    public ModelAndView orderList(ModelAndView modelAndView) {
        List<Orderform> orderFormList = orderformService.queryAllOrderForm();
        modelAndView.addObject("orderFormList", orderFormList);
        modelAndView.setViewName("order/orderList");
        modelAndView.addObject("orderFormList", orderFormList);
        return modelAndView;
    }

    @RequestMapping("/queryOrderById")
    public ModelAndView queryAllOrderQuery(Orderform orderform, ModelAndView modelAndView, String username) {
        QueryWrapper<Orderform> wrapper = new QueryWrapper<>();
        QueryWrapper<User> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("username", username);
        User user = userService.getOne(wrapper1);
        wrapper.eq("order_form_id", orderform.getOrderFormId());
        wrapper.like("submit_time", formatDate(orderform.getSubmitTime()));
        wrapper.eq("user_id", user.getUserId());
        wrapper.like("consignment_time", formatDate(orderform.getSubmitTime()));
        wrapper.eq("ipaddress", orderform.getIpaddress());
        List<Orderform> orderFormList = orderformService.list(wrapper);
        orderFormList.get(0).setUser(user);
        modelAndView.setViewName("order/orderList");
        modelAndView.addObject("orderFormList", orderFormList);
        return modelAndView;
    }

    public String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

}
