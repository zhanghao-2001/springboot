package com.psfd.springboot.eshop.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
@Controller
@RequestMapping("/admin")
public class CommodityController {

    @RequestMapping("/commodityAddTemp")
    public String commodityAddTemp(){
        return "commodity/commodityAdd";
    }



    @RequestMapping("/queryAllCommodity")
    public ModelAndView queryAllCommodity(ModelAndView modelAndView){
        modelAndView.setViewName("commodity/commodityList");
        return modelAndView;
    }
}
