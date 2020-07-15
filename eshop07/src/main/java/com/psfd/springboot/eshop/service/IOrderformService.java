package com.psfd.springboot.eshop.service;

import com.psfd.springboot.eshop.domain.Orderform;
import com.baomidou.mybatisplus.extension.service.IService;
import com.psfd.springboot.eshop.domain.Orderlist;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
public interface IOrderformService extends IService<Orderform> {
    void addOrderForm(Orderform orderform);

    List<Orderform> queryAllOrderForm();

}
