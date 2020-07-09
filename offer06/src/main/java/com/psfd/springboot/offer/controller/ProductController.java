package com.psfd.springboot.offer.controller;


import com.psfd.springboot.offer.service.IProductService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ProductController {
    @Resource
    IProductService productService;
}
