package com.psfd.springboot.eshop.controller;


import com.psfd.springboot.eshop.domain.Commodity;
import com.psfd.springboot.eshop.domain.Commodityclass;
import com.psfd.springboot.eshop.service.ICommodityService;
import com.psfd.springboot.eshop.service.ICommodityclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
public class CommodityController {

    @Autowired
    private ICommodityService commodityService;

    @Autowired
    private ICommodityclassService commodityclassService;

    @RequestMapping("/commodityAddTemp")
    public ModelAndView commodityAddTemp(ModelAndView modelAndView) {
        List<Commodityclass> commodityclassList = commodityclassService.list();
        modelAndView.addObject("commodityclassList", commodityclassList);
        modelAndView.setViewName("commodity/commodityAdd");
        return modelAndView;
    }


    @RequestMapping("/queryAllCommodity")
    public ModelAndView queryAllCommodity(ModelAndView modelAndView) {
        List<Commodity> commodityList = commodityService.list();
        modelAndView.setViewName("commodity/commodityList");
        modelAndView.addObject("commodityList", commodityList);
        return modelAndView;
    }

    @RequestMapping("/addCommodity")
    @ResponseBody
    public String addCommodity(Commodity commodity) {
        System.out.println("commodity = " + commodity);
        commodity.setRegTime(new Date());
        commodity.setCommodityLeaveNum(commodity.getCommodityAmount());
//        commodityService.saveOrUpdate(commodity);
        return "增加商品成功";
    }

    @RequestMapping("/deleteCommodity")
    @ResponseBody
    public String deleteCommodity(Commodity commodity) {
        commodityService.removeById(commodity.getCommodityId());
        return "删除成功";
    }
}
