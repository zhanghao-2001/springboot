package com.psfd.springboot.eshop.service.impl;

import com.psfd.springboot.eshop.domain.Orderlist;
import com.psfd.springboot.eshop.dao.OrderlistMapper;
import com.psfd.springboot.eshop.service.IOrderlistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class OrderlistServiceImpl extends ServiceImpl<OrderlistMapper, Orderlist> implements IOrderlistService {

    @Autowired
    private OrderlistMapper orderlistMapper;

    @Override
    public void addOrderList(Orderlist orderlist) {
        orderlistMapper.addOrderList(orderlist);
    }
}
