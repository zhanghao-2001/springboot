package com.psfd.springboot.eshop.service.impl;

import com.psfd.springboot.eshop.dao.CommodityMapper;
import com.psfd.springboot.eshop.domain.Commodity;
import com.psfd.springboot.eshop.service.ICommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
