package com.psfd.springboot.eshop.service.impl;

import com.psfd.springboot.eshop.dao.CommodityMapper;
import com.psfd.springboot.eshop.domain.Commodity;
import com.psfd.springboot.eshop.service.ICommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public void addCommodity(Commodity commodity) {
        commodityMapper.addCommodity(commodity);
    }

    @Override
    public List<Commodity> queryAllCommodity(Integer page) {
        return commodityMapper.queryAllCommodity(page);
    }
}
