package com.psfd.springboot.eshop.controller;


import com.psfd.springboot.eshop.domain.Commodityclass;
import com.psfd.springboot.eshop.service.ICommodityclassService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
@Controller
public class CommodityclassController {

    @Autowired
    private ICommodityclassService commodityclassService;

    @RequestMapping("/addCommodityClass")
    @ResponseBody
    public String addCommodityClass(Commodityclass commodityclass) {
        commodityclassService.saveOrUpdate(commodityclass);
        return "增加商品种类成功";
    }

    @RequestMapping("/queryAllCommodityClass")
    public String queryAllCommodityClass() {
        return "commodityClassList";
    }


}
