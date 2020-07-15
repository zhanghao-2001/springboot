package com.psfd.springboot.eshop.service;

import com.psfd.springboot.eshop.domain.Orderlist;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
public interface IOrderlistService extends IService<Orderlist> {

    void addOrderList(Orderlist orderlist);
}
