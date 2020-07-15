package com.psfd.springboot.eshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.psfd.springboot.eshop.domain.*;
import com.psfd.springboot.eshop.service.ICommodityService;
import com.psfd.springboot.eshop.service.ICommodityclassService;
import com.psfd.springboot.eshop.service.IOrderformService;
import com.psfd.springboot.eshop.service.IOrderlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class IndexController {

    @Autowired
    private ICommodityclassService commodityclassService;

    @Autowired
    private ICommodityService commodityService;

    @Autowired
    private IOrderformService orderformService;

    @Autowired
    private IOrderlistService orderlistService;


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
        Map<Integer, Integer> nums = (Map<Integer, Integer>) session.getAttribute("nums");
        if (commodityList != null) {
            modelAndView.addObject("commodityList", session.getAttribute("commodityList"));
        }
        if (nums != null) {
            modelAndView.addObject("nums", nums);
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
        Map<Integer, Commodity> commodityMap = (Map<Integer, Commodity>) session.getAttribute("commodityMap");
        Map<Integer, Integer> nums = (Map<Integer, Integer>) session.getAttribute("nums");
        if (nums == null) {
            nums = new HashMap<>();
            nums.put(commodityOne.getCommodityId(), 1);
        }
        if (commodityMap == null) {
            commodityMap = new HashMap<>();
        } else {
            Integer count = nums.get(commodityOne.getCommodityId());
            System.out.println("count = " + count);
            if (count == null) {
                count = 1;
                nums.put(commodityOne.getCommodityId(), count);
            } else {
                count++;
                nums.put(commodityOne.getCommodityId(), count);
            }
        }
        commodityMap.put(commodityOne.getCommodityId(), commodityOne);
        List<Commodity> commodityList = new ArrayList<>();
        Set<Integer> set = commodityMap.keySet();
        for (Integer integer : set) {
            commodityList.add(commodityMap.get(integer));
        }
        session.setAttribute("nums", nums);
        session.setAttribute("commodityMap", commodityMap);
        session.setAttribute("commodityList", commodityList);
        modelAndView.addObject("commodityclassList", commodityclassList);
        modelAndView.addObject("commodityList", commodityList);
        modelAndView.addObject("nums", nums);
        modelAndView.setViewName("showCar");
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


    @RequestMapping("/registerUser")
    public ModelAndView registerUser(ModelAndView modelAndView) {
        List<Commodityclass> commodityclassList = commodityclassService.list();
        modelAndView.addObject("commodityclassList", commodityclassList);
        modelAndView.setViewName("registerUser");
        return modelAndView;
    }

    @RequestMapping("/payment")
    public ModelAndView payment(HttpSession session, ModelAndView modelAndView) {
        User user = (User) session.getAttribute("user");
        System.out.println("user = " + user);
        List<Commodity> commodityList = (List<Commodity>) session.getAttribute("commodityList");
        Map<Integer, Integer> nums = (Map<Integer, Integer>) session.getAttribute("nums");
        if (nums != null && user != null) {
            for (Commodity commodity : commodityList) {
                Orderform orderform = new Orderform();
                orderform.setUser(user);
                orderform.setOrderFromNo(getRandom());
                orderform.setSubmitTime(new Date());
                orderform.setConsignmentTime(new Date());
                orderform.setIpaddress("127.0.0.1");
                orderform.setRemark("必须保证商品质量问题");
                orderform.setTotalPrice(commodity.getCommodityPrice() * nums.get(commodity.getCommodityId()));
                orderform.setIsPayoff(1);
                orderform.setIsConsignment(1);
                Orderlist orderlist = new Orderlist();
                orderlist.setCommodity(commodity);
                orderlist.setOrderForm(orderform);
                orderlist.setAmount(nums.get(commodity.getCommodityId()));
                orderformService.addOrderForm(orderform);
                orderlistService.addOrderList(orderlist);
            }
        }
        List<Commodityclass> commodityclassList = commodityclassService.list();
        modelAndView.setViewName("showCar");
        if (user == null) {
            modelAndView.setViewName("login");
        }
        modelAndView.addObject("commodityclassList", commodityclassList);
        return modelAndView;
    }


    public String getRandom() {
        Random r = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            String string = r.nextInt(10) + "";
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }


}
