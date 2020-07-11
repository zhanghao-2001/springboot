package com.psfd.springboot.eshop.controller;


import com.psfd.springboot.eshop.domain.Commodityclass;
import com.psfd.springboot.eshop.service.ICommodityclassService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
public class CommodityclassController {

    @Autowired
    private ICommodityclassService commodityclassService;
    @RequestMapping("/addCommodityClass")
    @ResponseBody
    public String addCommodityClass(Commodityclass commodityclass) {
        commodityclassService.saveOrUpdate(commodityclass);
        return "增加商品种类成功";
    }


    @RequestMapping("/commodityClassAddTemp")
    public String commodityClassAddTemp() {
        return "commodityclass/commodityClassAdd";
    }


    @RequestMapping("/queryAllCommodityClass")
    public ModelAndView queryAllCommodityClass(ModelAndView modelAndView) {
        modelAndView.setViewName("commodityclass/commodityClassList");
        return modelAndView;
    }


}
