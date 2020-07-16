package com.psfd.springboot.offer.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.psfd.springboot.offer.bean.Order;
import com.psfd.springboot.offer.bean.Product;
import com.psfd.springboot.offer.service.ICustomerService;
import com.psfd.springboot.offer.service.IOrderService;
import com.psfd.springboot.offer.service.IProductService;
import com.psfd.springboot.offer.utils.Util;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Resource
    IOrderService orderService;

    @Resource
    ICustomerService customerService;

    @Resource
    IProductService productService;


    @RequestMapping("framework/orderList.do")
    public ModelAndView orderList(int current) {
        ModelAndView m = new ModelAndView();
        List<Order> list = orderService.list();
        IPage<Order> page = new Page<>();
        page.setCurrent(current);
        page.setSize(5);
        current = Util.getCurrent(current);
        List<Order> temp = new ArrayList<>();
        for (int i = current; i < current + 5; i++) {
            if (i == list.size()) {
                break;
            }
            temp.add(list.get(i));
        }
        page.setRecords(temp);
        page.setTotal(list.size());
        m.addObject("page", page);
        m.addObject("product", productService.list());
        m.addObject("customer", customerService.list());
        m.setViewName("order/order_list");
        return m;
    }


    @RequestMapping("order/skip.do")
    public ModelAndView skip(int current) {
        return orderList(current);
    }


    @RequestMapping("order/orderAddSkip.do")
    public ModelAndView addSkip() {
        ModelAndView m = new ModelAndView();
        m.addObject("product", productService.list());
        m.addObject("customer", customerService.list());
        m.setViewName("order/order_add");
        return m;
    }

    @RequestMapping("order/orderAdd.do")
    public ModelAndView orderAdd(Order order) {
        int page = getPage();
        List<Product> list = productService.list();
        Product pro = null;
        for (Product product : list) {
            if (product.getProductid().equals(order.getProductNo())) {
                pro = product;
                break;
            }
        }
        if (pro.getQuantity() < order.getQuantity()) {
            ModelAndView m = new ModelAndView();
            m.setViewName("order/order_add");
            return m;
        }
        order.setOrderTime(Util.getCreateTime());
        orderService.save(order);
        return orderList(page);
    }

    private int getPage() {
        int size = productService.list().size();
        int page = 0;
        if (size % 5 != 0) {
            page = (size / 5) + 1;
        } else {
            page = (size / 5);
        }
        return page;
    }

    @RequestMapping("order/orderDelete.do")
    public ModelAndView orderDelete(int current, int id) {
        orderService.removeById(id);
        int page = getPage();
        if (current > page) {
            current = page;
        }
        return orderList(current);
    }

    @RequestMapping("order/orderUpdateSkip.do")
    public ModelAndView orderUpdateSkip(int current, int id) {
        ModelAndView m = new ModelAndView();
        m.addObject("order", orderService.getById(id));
        m.addObject("current", current);
        m.addObject("customer", customerService.list());
        m.addObject("product", productService.list());
        m.setViewName("order/order_update");
        return m;
    }

    @RequestMapping("order/orderUpdate.do")
    public ModelAndView orderUpdate(Order order, int current) {
        Product product = productService.getById(order.getProductNo());
        Order temp = orderService.getById(order.getOrderNo());
        order.setOrderTime(temp.getOrderTime());
        int tempQuantity = temp.getQuantity() + product.getQuantity();
        int quantity = 0;
        if(order.getQuantity() <= tempQuantity){
            quantity = tempQuantity - order.getQuantity();
            product.setQuantity(quantity);
            productService.updateById(product);
            orderService.updateById(order);
        }else{
            ModelAndView m = new ModelAndView();
            m.setViewName("order/order_update");
            return m;
        }
        return orderList(current);
    }

    @RequestMapping("framework/orderQuerySkip.do")
    public ModelAndView orderQuerySkip(){
        ModelAndView m = new ModelAndView();
        m.addObject("product",productService.list());
        m.addObject("customer",customerService.list());
        m.setViewName("order/order_query");
        return m;
    }

    @RequestMapping("framework/orderQuery.do")
    public ModelAndView orderQuery(Order order){
        Order temp = orderService.getById(order.getOrderNo());
        ModelAndView modelAndView = new ModelAndView();
        if(temp != null){
            if(temp.getCustomerNo().equals(order.getCustomerNo()) && temp.getProductNo().equals(order.getProductNo())
                && temp.getQuantity().equals(order.getQuantity()) && temp.getOtherInfo().equals(order.getOtherInfo())){
                order.setOrderTime(temp.getOrderTime());
                IPage<Order> page = new Page<>();
                page.setCurrent(1);
                List<Order> list = new ArrayList<>();
                list.add(order);
                page.setRecords(list);
                page.setTotal(list.size());
                page.setSize(5);
                modelAndView.addObject("page",page);
                modelAndView.addObject("product",productService.list());
                modelAndView.addObject("customer",customerService.list());
                modelAndView.setViewName("order/order_list");
                return modelAndView;
            }
        }
        modelAndView.setViewName("order/order_query");
        return modelAndView;
    }
}
