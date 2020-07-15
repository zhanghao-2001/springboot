package com.psfd.springboot.eshop.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.psfd.springboot.eshop.domain.Commodity;
import com.psfd.springboot.eshop.domain.Commodityclass;
import com.psfd.springboot.eshop.service.ICommodityService;
import com.psfd.springboot.eshop.service.ICommodityclassService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
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
        Integer count = commodityService.count();
        Integer pageCount = count / 2;
        if (count % 2 != 0) {
            pageCount = pageCount + 1;
        }
        List<Commodity> commodityList = commodityService.queryAllCommodity((1 - 1) * 0);
        System.out.println("commodityList = " + commodityList);
        modelAndView.setViewName("commodity/commodityList");
        modelAndView.addObject("commodityList", commodityList);
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.addObject("page", 1);
        return modelAndView;
    }

    @RequestMapping("/addCommodity")
    @ResponseBody
    public String addCommodity(Commodity commodity, @RequestParam("uploadImage") MultipartFile uploadImage, String commodityClassID, HttpServletRequest request) {
        System.out.println("uploadImage = " + uploadImage);
        String originalFilename = uploadImage.getOriginalFilename();
        System.out.println("originalFilename = " + originalFilename);
        String name = uploadImage.getName();
        System.out.println("name = " + name);
        String image = null;
        try {
            String locationPath = ResourceUtils.getURL("classpath:static").getPath();
            String savePath = locationPath.concat("/upload");
            Commodityclass commodityclass = new Commodityclass();
            commodityclass.setCommodityClassid(Integer.parseInt(commodityClassID));
            commodity.setCommodityClass(commodityclass);
            File file = new File(savePath);
            System.out.println("locationPath = " + locationPath);
            if (!file.exists()) {
                file.mkdir();
            }
            image = savePath + "/" + originalFilename;
            uploadImage.transferTo(new File(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        commodity.setImage("http://localhost:" + request.getServerPort() + "/" + request.getContextPath() + "/upload/" + originalFilename);
        commodity.setRegTime(new Date());
        commodity.setCommodityLeaveNum(commodity.getCommodityAmount());
        commodityService.addCommodity(commodity);
        return "增加商品成功";
    }

    @RequestMapping("/deleteCommodity")
    @ResponseBody
    public String deleteCommodity(Commodity commodity) {
        commodityService.removeById(commodity.getCommodityId());
        return "删除成功";
    }


    @RequestMapping("/commodityPage")
    public ModelAndView page(String page, ModelAndView modelAndView) {
        Integer count = commodityService.count();
        Integer pageCount = count / 2;
        if (count % 2 != 0) {
            pageCount = pageCount + 1;
        }

        if (pageCount <= Integer.parseInt(page)) {
            modelAndView.addObject("page", pageCount);
            page = pageCount.toString();
        } else if (Integer.parseInt(page) == 0) {
            modelAndView.addObject("page", 1);
            page = "1";
        }
        List<Commodity> commodityList = commodityService.queryAllCommodity((Integer.parseInt(page) - 1) * 2);
        modelAndView.setViewName("commodity/commodityList");
        modelAndView.addObject("commodityList", commodityList);
        modelAndView.addObject("page", page);
        modelAndView.addObject("pageCount", pageCount);
        return modelAndView;
    }


}
