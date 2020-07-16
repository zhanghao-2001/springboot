package com.psfd.springboot.offer.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.psfd.springboot.offer.bean.Product;
import com.psfd.springboot.offer.service.IProductService;
import com.psfd.springboot.offer.service.IProductTypeService;
import com.psfd.springboot.offer.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Resource
    IProductService productService;

    @Resource
    IProductTypeService productTypeService;

    @RequestMapping("framework/productList.do")
    public ModelAndView productList(int current){
        ModelAndView m = new ModelAndView();
        List<Product> list = productService.list();
        IPage<Product> page = new Page<>();
        page.setCurrent(current);
        page.setSize(5);
        current = Util.getCurrent(current);
        List<Product> temp = new ArrayList<>();
        for (int i = current; i < current+5; i++) {
            if(i == list.size()){
                break;
            }
            temp.add(list.get(i));
        }
        page.setRecords(temp);
        page.setTotal(list.size());
        m.addObject("page",page);
        m.addObject("productType",productTypeService.list());
        m.setViewName("product/product_list");
        return m;
    }

    @RequestMapping("product/skip.do")
    public ModelAndView skip(int current,String status){
        if(status.equals("pre")){
            return productList(current);
        }else{
            return productList(current);
        }
    }

    @RequestMapping("product/productAddSkip.do")
    public ModelAndView productAddSkip(){
        ModelAndView m = new ModelAndView();
        m.addObject("productTypeList",productTypeService.list());
        m.setViewName("product/product_add");
        return m;
    }

    @RequestMapping("product/productAdd.do")
    public ModelAndView productAdd(Product product){
        productService.save(product);
        int page = getPage();
        return productList(page);
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

    @RequestMapping("product/productDelete.do")
    public ModelAndView productDelete(int id,int current){
        productService.removeById(id);
        int page = getPage();
        if(current > page){
            current = page;
        }
        return productList(current);
    }

    @RequestMapping("product/productUpdateSkip.do")
    public ModelAndView productUpdateSkip(int id,int current){
        List<Product> list = productService.list();
        ModelAndView m = new ModelAndView();
        for (Product product : list) {
            if(product.getProductid().equals(id)){
                m.addObject("product",product);
                break;
            }
        }
        m.addObject("productTypeList",productTypeService.list());
        m.addObject("current",current);
        m.setViewName("product/product_update");
        return m;
    }

    @RequestMapping("product/productUpdate.do")
    public ModelAndView productUpdate(Product product,int current){
        productService.updateById(product);
        return productList(current);
    }

    @RequestMapping("framework/productQuerySkip.do")
    public ModelAndView productQuerySkip(){
        ModelAndView m = new ModelAndView();
        m.setViewName("product/product_query");
        m.addObject("productTypeList",productTypeService.list());
        return m;
    }

    @RequestMapping("framework/productQuery.do")
    public ModelAndView productQuery(Product product){
        ModelAndView m = new ModelAndView();
        boolean flag = register(product);
        if(flag){
            List<Product> list = new ArrayList<>();
            list.add(product);
            IPage<Product> page = new Page<>();
            page.setTotal(list.size());
            page.setRecords(list);
            page.setCurrent(1);
            page.setSize(5);
            m.addObject("page",page);
            m.addObject("productType",productTypeService.list());
            m.setViewName("product/product_list");
            return m;
        }
        m.addObject("productTypeList",productTypeService.list());
        m.setViewName("product/product_query");
        return m;
    }


    private boolean register(Product product){
        List<Product> list = productService.list();
        for (Product temp : list) {
            if(temp.getProductid().equals(product.getProductid()) && temp.getTypeid().equals(product.getTypeid())
                && temp.getName().equals(product.getName()) && temp.getArea().equals(product.getArea())
                && temp.getOwner().equals(product.getOwner()) && temp.getOtherinfo().equals(product.getOtherinfo())
                && temp.getPrice().equals(product.getPrice()) && temp.getUnit().equals(product.getUnit())
                && temp.getQuantity().equals(product.getQuantity())){
                return true;
            }
        }
        return false;
    }
}
