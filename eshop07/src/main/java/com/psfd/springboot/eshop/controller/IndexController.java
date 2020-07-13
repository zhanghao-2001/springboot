package com.psfd.springboot.eshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.psfd.springboot.eshop.domain.Commodity;
import com.psfd.springboot.eshop.domain.Commodityclass;
import com.psfd.springboot.eshop.service.ICommodityService;
import com.psfd.springboot.eshop.service.ICommodityclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ICommodityclassService commodityclassService;

    @Autowired
    private ICommodityService commodityService;

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView) {
        List<Commodityclass> commodityclassList = commodityclassService.list();
        modelAndView.setViewName("index");
        modelAndView.addObject("commodityclassList", commodityclassList);
        return modelAndView;
    }

    @RequestMapping("/queryCommodityClass")
    public ModelAndView queryCommodityClass(ModelAndView modelAndView, Commodityclass commodityclass) {
        QueryWrapper<Commodity> wrapper = new QueryWrapper<>();
        wrapper.eq("commodity_class", commodityclass.getCommodityClassid());
        List<Commodity> commodityList = commodityService.list(wrapper);
        List<Commodityclass> commodityclassList = commodityclassService.list();
        modelAndView.setViewName("index");
        modelAndView.addObject("commodityList", commodityList);
        modelAndView.addObject("commodityclassList", commodityclassList);
        return modelAndView;
    }


}
