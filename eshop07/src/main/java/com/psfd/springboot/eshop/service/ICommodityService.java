package com.psfd.springboot.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.psfd.springboot.eshop.domain.Commodity;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
public interface ICommodityService extends IService<Commodity> {

    void addCommodity(Commodity commodity);

    List<Commodity> queryAllCommodity(Integer page);
}
