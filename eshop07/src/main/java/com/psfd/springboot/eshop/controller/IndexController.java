package com.psfd.springboot.eshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.psfd.springboot.eshop.domain.Commodity;
import com.psfd.springboot.eshop.domain.Commodityclass;
import com.psfd.springboot.eshop.service.ICommodityService;
import com.psfd.springboot.eshop.service.ICommodityclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ICommodityclassService commodityclassService;

    @Autowired
    private ICommodityService commodityService;

    @RequestMapping({"/", "index"})
    public ModelAndView index(ModelAndView modelAndView) {
        List<Commodityclass> commodityclassList = commodityclassService.list();
        List<Commodity> commodityList = commodityService.list();
        modelAndView.setViewName("index");
        modelAndView.addObject("commodityclassList", commodityclassList);
        modelAndView.addObject("commodityList", commodityList);
        return modelAndView;
    }

    @RequestMapping("/queryCommodityClass")
    public ModelAndView queryCommodityClass(ModelAndView modelAndView, Commodityclass commodityclass) {
        QueryWrapper<Commodity> wrapper = new QueryWrapper<>();
        QueryWrapper<Commodityclass> wrapper1 = new QueryWrapper<>();
        wrapper.eq("commodity_class", commodityclass.getCommodityClassid());
        wrapper1.eq("commodity_classid", commodityclass.getCommodityClassid());
        List<Commodity> commodityList = commodityService.list(wrapper);
        List<Commodityclass> commodityclassList = commodityclassService.list();
        Commodityclass commodityclassOne = commodityclassService.getOne(wrapper1);
        modelAndView.setViewName("showByClass");
        modelAndView.addObject("commodityList", commodityList);
        modelAndView.addObject("commodityclassList", commodityclassList);
        modelAndView.addObject("commodityclassOne", commodityclassOne);
        return modelAndView;
    }

    @RequestMapping("/showCar")
    public ModelAndView showCar(ModelAndView modelAndView, HttpSession session) {
        List<Commodityclass> commodityclassList = commodityclassService.list();
        List<Commodity> commodityList = (List<Commodity>) session.getAttribute("commodityList");
        if (commodityList != null) {
            modelAndView.addObject("commodityList", session.getAttribute("commodityList"));
        }
        modelAndView.setViewName("showCar");
        modelAndView.addObject("commodityclassList", commodityclassList);
        return modelAndView;
    }

    @RequestMapping("/showdetails")
    public ModelAndView showdetails(ModelAndView modelAndView, Commodity commodity) {
        List<Commodityclass> commodityclassList = commodityclassService.list();
        QueryWrapper<Commodity> wrapper = new QueryWrapper<>();
        wrapper.eq("commodity_id", commodity.getCommodityId());
        Commodity commodityOne = commodityService.getOne(wrapper);
        modelAndView.setViewName("showdetails");
        modelAndView.addObject("commodityOne", commodityOne);
        modelAndView.addObject("commodityclassList", commodityclassList);
        return modelAndView;
    }


    @RequestMapping("/addShopCar")
    public ModelAndView addShopCar(Commodity commodity, HttpSession session, ModelAndView modelAndView) {
        List<Commodityclass> commodityclassList = commodityclassService.list();
        Commodity commodityOne = commodityService.getById(commodity.getCommodityId());
        List<Commodity> commodityList = (List<Commodity>) session.getAttribute("commodityList");
        if (commodityList == null) {
            commodityList = new ArrayList<>();
            session.setAttribute("commodityList", commodityList);
            commodityList.add(commodityOne);
        } else {
            commodityList.add(commodityOne);
            session.setAttribute("commodityList", commodityList);
        }
        modelAndView.setViewName("showCar");
        modelAndView.addObject("commodityclassList", commodityclassList);
        modelAndView.addObject("commodityList", session.getAttribute("commodityList"));
        return modelAndView;
    }

    @RequestMapping("/deleteShopCar")
    public ModelAndView deleteShopCar(Commodity commodity, HttpSession session, ModelAndView modelAndView) {
        List<Commodity> commodityList = (List<Commodity>) session.getAttribute("commodityList");
        List<Commodityclass> commodityclassList = commodityclassService.list();
        for (int i = 0; i < commodityList.size(); i++) {
            if (commodityList.get(i).getCommodityId() == commodity.getCommodityId()) {
                commodityList.remove(i);
            }
        }
        session.setAttribute("commodityList", commodityList);
        modelAndView.addObject("commodityclassList", commodityclassList);
        modelAndView.setViewName("showCar");
        modelAndView.addObject("commodityList", session.getAttribute("commodityList"));
        return modelAndView;
    }


}
