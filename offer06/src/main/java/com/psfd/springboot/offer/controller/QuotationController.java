package com.psfd.springboot.offer.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.psfd.springboot.offer.bean.Quotation;
import com.psfd.springboot.offer.service.ICustomerService;
import com.psfd.springboot.offer.service.IProductService;
import com.psfd.springboot.offer.service.IQuotationService;
import com.psfd.springboot.offer.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuotationController {

    @Resource
    IQuotationService quotationService;

    @Resource
    ICustomerService customerService;

    @Resource
    IProductService productService;

    @RequestMapping("framework/quotationList.do")
    public ModelAndView quotationList(int current) {
        ModelAndView m = new ModelAndView();
        List<Quotation> list = quotationService.list();
        List<Quotation> temp = new ArrayList<>();
        IPage<Quotation> page = new Page<>();
        page.setCurrent(current);
        page.setSize(5);
        current = Util.getCurrent(current);
        for (int i = current; i < current + 5; i++) {
            if (i == list.size()) {
                break;
            }
            temp.add(list.get(i));
        }
        page.setRecords(temp);
        page.setTotal(list.size());
        m.addObject("page", page);
        m.addObject("customer", customerService.list());
        m.addObject("product", productService.list());
        m.setViewName("quotation/quotation_list");
        return m;
    }


    @RequestMapping("quotation/skip.do")
    public ModelAndView skip(int current) {
        return quotationList(current);
    }

    @RequestMapping("quotation/quotationAddSkip.do")
    public ModelAndView addSkip() {
        ModelAndView m = new ModelAndView();
        m.addObject("product", productService.list());
        m.addObject("customer", customerService.list());
        m.setViewName("quotation/quotation_add");
        return m;
    }


    @RequestMapping("quotation/quotationAdd.do")
    public ModelAndView quotationAdd(Quotation quotation) {
        quotation.setQuotationTime(Util.getCreateTime());
        quotationService.save(quotation);
        int size = quotationService.list().size();
        int page = getPage(size);
        return quotationList(page);
    }

    private int getPage(int size) {
        int page = 0;
        if (size % 5 != 0) {
            page = (size / 5) + 1;
        } else {
            page = (size / 5);
        }
        return page;
    }

    @RequestMapping("quotation/quotationDelete.do")
    public ModelAndView quotationDelete(int id, int current) {
        quotationService.removeById(id);
        int size = quotationService.list().size();
        int page = getPage(size);
        if (current > page) {
            current = page;
        }
        return quotationList(current);
    }


    @RequestMapping("quotation/quotationUpdateSkip.do")
    public ModelAndView quotationUpdateSkip(int id, int current) {
        Quotation quotation = quotationService.getById(id);
        ModelAndView m = new ModelAndView();
        m.addObject("quotation", quotation);
        m.addObject("customer", customerService.list());
        m.addObject("product", productService.list());
        m.addObject("current", current);
        m.setViewName("quotation/quotation_update");
        return m;
    }


    @RequestMapping("quotation/quotationUpdate.do")
    public ModelAndView quotationUpdate(int current, Quotation quotation) {
        quotationService.updateById(quotation);
        return quotationList(current);
    }

    @RequestMapping("framework/quotationQuery.do")
    public ModelAndView querySkip() {
        ModelAndView m = new ModelAndView();
        m.addObject("product", productService.list());
        m.addObject("customer", customerService.list());
        m.setViewName("quotation/quotation_query");
        return m;
    }

    @RequestMapping("framework/quotationQueryRegister.do")
    public ModelAndView query(Quotation quotation) {
        Quotation temp = quotationService.getById(quotation.getQuotationNo());
        ModelAndView m = new ModelAndView();
        if (temp != null) {
            if (temp.getCustomerId().equals(quotation.getCustomerId()) && temp.getOtherInfo().equals(quotation.getOtherInfo())
                    && temp.getProductId().equals(quotation.getProductId()) && temp.getQuotationMan().equals(quotation.getQuotationMan())) {
                IPage<Quotation> page = new Page<>();
                List<Quotation> list = new ArrayList<>();
                list.add(temp);
                page.setTotal(list.size());
                page.setRecords(list);
                page.setCurrent(1);
                page.setSize(5);
                m.addObject("page", page);
                m.addObject("product", productService.list());
                m.addObject("customer", customerService.list());
                m.setViewName("quotation/quotation_list");
                return m;
            }
        }
        m.setViewName("quotation/quotation_query");
        return m;
    }
}
