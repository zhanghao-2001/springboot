package com.psfd.springboot.offer.controller;


import com.psfd.springboot.offer.service.IProducttypeService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ProducttypeController {
    @Resource
    IProducttypeService producttypeService;
}
