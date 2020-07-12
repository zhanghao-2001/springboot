package com.psfd.springboot.eshop.controller;


import com.psfd.springboot.eshop.domain.Commodity;
import com.psfd.springboot.eshop.domain.Commodityclass;
import com.psfd.springboot.eshop.service.ICommodityService;
import com.psfd.springboot.eshop.service.ICommodityclassService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
    public String addCommodity(Commodity commodity, @RequestParam("uploadImage") MultipartFile uploadImage, HttpServletRequest request) {
        System.out.println("uploadImage = " + uploadImage);
        commodity.setRegTime(new Date());
        commodity.setCommodityLeaveNum(commodity.getCommodityAmount());
        commodityService.saveOrUpdate(commodity);
        return "增加商品成功";
    }

    @RequestMapping("/deleteCommodity")
    @ResponseBody
    public String deleteCommodity(Commodity commodity) {
        commodityService.removeById(commodity.getCommodityId());
        return "删除成功";
    }
}
