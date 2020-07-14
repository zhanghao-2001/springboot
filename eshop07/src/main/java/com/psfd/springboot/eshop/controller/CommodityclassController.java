package com.psfd.springboot.eshop.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.psfd.springboot.eshop.domain.Commodityclass;
import com.psfd.springboot.eshop.service.ICommodityclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
        Integer count = commodityclassService.count();
        Integer pageCount = count / 2;
        if (count % 2 != 0) {
            pageCount = pageCount + 1;
        }
        IPage<Commodityclass> iPage = new Page<>(1, 2);
        IPage<Commodityclass> page1 = commodityclassService.page(iPage);
        List<Commodityclass> commodityClassList = page1.getRecords();
        modelAndView.setViewName("commodityclass/commodityClassList");
        modelAndView.addObject("commodityClassList", commodityClassList);
        modelAndView.addObject("page", 1);
        modelAndView.addObject("pageCount", pageCount);
        return modelAndView;
    }

    @RequestMapping("/commodityclassPage")
    public ModelAndView page(String page, ModelAndView modelAndView) {
        Integer count = commodityclassService.count();
        Integer pageCount = count / 2;
        if (count % 2 != 0) {
            pageCount = pageCount + 1;
        }
        System.out.println("page = " + page);

        if (pageCount <= Integer.parseInt(page)) {
            modelAndView.addObject("page", pageCount);
            page = pageCount.toString();
        } else if (Integer.parseInt(page) == 0) {
            modelAndView.addObject("page", 1);
            page = "1";
        } else {
            modelAndView.addObject("page", page);
        }
        IPage<Commodityclass> iPage = new Page<>(Integer.parseInt(page), 2);
        IPage<Commodityclass> page1 = commodityclassService.page(iPage);
        List<Commodityclass> commodityClassList = page1.getRecords();
        modelAndView.addObject("commodityClassList", commodityClassList);
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.setViewName("commodityclass/commodityClassList");

        return modelAndView;
    }


}
