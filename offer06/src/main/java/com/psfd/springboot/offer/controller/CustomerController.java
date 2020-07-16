package com.psfd.springboot.offer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.psfd.springboot.offer.bean.Customer;
import com.psfd.springboot.offer.service.ICustomerService;
import com.psfd.springboot.offer.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @Resource
    ICustomerService customerService;

    @RequestMapping("framework/customerlist.do")
    public ModelAndView customerQuery(int current) {
        ModelAndView m = new ModelAndView();
        if (current <= 0) {
            m.setViewName("framework/main");
        }
        IPage<Customer> page = new Page<>();
        page.setCurrent(current);
        page.setSize(5);
        List<Customer> list = customerService.list();
        List<Customer> temp = new ArrayList<>();
        current = Util.getCurrent(current);
        for (int i = current; i < current + 5; i++) {
            if (i == list.size()) {
                break;
            }
            temp.add(list.get(i));
        }
        page.setRecords(temp);
        page.setTotal(customerService.list().size());
        m.setViewName("customer/customer_list");
        m.addObject("page", page);
        return m;
    }

    @RequestMapping("customer/skip.do")
    public ModelAndView skip(int current, String status) {
        if (status.equals("pre")) {
            return customerQuery(current);
        } else {
            return customerQuery(current);
        }
    }

    @RequestMapping("customer/skipCustomerAdd.do")
    public String skipCustomerAdd() {
        return "customer/customer_add";
    }

    @RequestMapping("customer/customerAdd.do")
    public ModelAndView customerAdd(Customer customer) {
        int size = customerService.list().size();
        int page = 0;
        if (size % 5 != 0) {
            page = (size % 5) + 1;
        } else {
            page = (size % 5);
        }
        customerService.save(customer);
        return customerQuery(page);
    }

    @RequestMapping("customer/customerDelete.do")
    public ModelAndView customerDelete(int id, int current) {
        customerService.removeById(id);
        return customerQuery(current);
    }

    @RequestMapping("customer/customerUpdateSkip.do")
    public ModelAndView updateSkip(int id, int current) {
        ModelAndView m = new ModelAndView();
        List<Customer> list = customerService.list();
        Customer temp = null;
        for (Customer customer : list) {
            if (customer.getId() == id) {
                temp = customer;
                break;
            }
        }
        m.addObject("customer", temp);
        m.addObject("current", current);
        m.setViewName("customer/customer_update");
        return m;
    }

    @RequestMapping("customer/customerUpdate.do")
    public ModelAndView customerUpdate(Customer customer, int current) {
        customerService.updateById(customer);
        return customerQuery(current);
    }

    @RequestMapping("framework/customerQuery.do")
    public String querySkip(){
        return "customer/customer_query";
    }

    @RequestMapping("framework/customerQuery2.do")
    public ModelAndView customerQuery(Customer customer){
        ModelAndView m = new ModelAndView();
        List<Customer> list = customerService.list();
        boolean flag = false;
        for (Customer temp : list) {
            if(temp.getId().equals(customer.getId())){
                flag = judge(customer,temp);
                break;
            }
        }
        if(flag){
            m.addObject("customer",customer);
            m.addObject("status","query");
            m.setViewName("customer/customer_update");
            return m;
        }
        m.setViewName("customer/customer_query");
        return m;
    }

    private boolean judge(Customer customer, Customer temp) {
        if(temp.getName().equals(customer.getName()) && temp.getAddress().equals(customer.getAddress()) && temp.getPhone().equals(customer.getPhone())
        && temp.getRelationman().equals(temp.getRelationman()) && temp.getOtherinfo().equals(customer.getOtherinfo())){
            return true;
        }
        return false;
    }
}
