package com.psfd.springboot.offer.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.psfd.springboot.offer.bean.ProductType;
import com.psfd.springboot.offer.service.IProductTypeService;
import com.psfd.springboot.offer.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductTypeController {
    @Resource
    IProductTypeService productTypeService;

    @RequestMapping("framework/productTypeListSkip.do")
    public ModelAndView productTypeList(int current){
        ModelAndView m = new ModelAndView();
        IPage<ProductType> page = new Page<>();
        page.setCurrent(current);
        page.setSize(5);
        List<ProductType> list = productTypeService.list();
        List<ProductType> temp = new ArrayList<>();
        current = Util.getCurrent(current);
        for (int i = current; i < current + 5; i++) {
            if (i == list.size()) {
                break;
            }
            temp.add(list.get(i));
        }
        page.setRecords(temp);
        page.setTotal(list.size());
        m.addObject("page",page);
        m.setViewName("product/productType_list");
        return m;
    }

    @RequestMapping("productType/skip.do")
    public ModelAndView skip(int current,String status){
        if(status.equals("pre")){
            return productTypeList(current);
        }else{
            return productTypeList(current);
        }
    }

    @RequestMapping("product/productTypeAddSkip.do")
    public ModelAndView productTypeAddSkip(int current){
        ModelAndView m = new ModelAndView();
        m.setViewName("product/productType_add");
        m.addObject("current",current);
        return m;
    }

    @RequestMapping("product/productTypeAdd.do")
    public ModelAndView productTypeAdd(ProductType productType,int current){
        int size = productTypeService.list().size();
        productTypeService.save(productType);
        int page = 0;
        if (size % 5 != 0) {
            page = (size % 5) + 1;
        } else {
            page = (size % 5);
        }
        return productTypeList(page);
    }

    @RequestMapping("product/productTypeDelete.do")
    public ModelAndView productTypeDelete(int current,int id){
        productTypeService.removeById(id);
        return productTypeList(current);
    }

    @RequestMapping("product/productTypeUpdateSkip.do")
    public ModelAndView productTypeUpdateSkip(int current,int id){
        ModelAndView m = new ModelAndView();
        List<ProductType> list = productTypeService.list();
        ProductType temp = null;
        for (ProductType productType : list) {
            if(productType.getTypeid().equals(id)){
               temp = productType;
               break;
            }
        }
        m.setViewName("product/productType_update");
        m.addObject("current",current);
        m.addObject("productType",temp);
        return m;
    }

    @RequestMapping("framework/productTypeManage.do")
    public String productTypeManageSkip(){
        return "product/productType_query";
    }

    @RequestMapping("framework/productTypeQuery.do")
    public ModelAndView productTypeQuery(ProductType productType){
        ModelAndView m = new ModelAndView();
        List<ProductType> list = productTypeService.list();
        List<ProductType> temp = new ArrayList<>();
        for (ProductType type : list) {
            if(type.getTypeid().equals(productType.getTypeid()) && type.getTypename().equals(productType.getTypename())){
                temp.add(type);
                break;
            }
        }
        IPage<ProductType> page = new Page<>();
        page.setTotal(temp.size());
        page.setRecords(temp);
        page.setCurrent(1);
        page.setSize(5);
        m.addObject("page",page);
        m.setViewName("product/productType_list");
        return m;
    }
}
