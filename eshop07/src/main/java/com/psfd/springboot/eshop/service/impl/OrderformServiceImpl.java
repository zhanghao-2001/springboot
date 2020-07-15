package com.psfd.springboot.eshop.service.impl;

import com.psfd.springboot.eshop.domain.Orderform;
import com.psfd.springboot.eshop.dao.OrderformMapper;
import com.psfd.springboot.eshop.service.IOrderformService;
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
public class OrderformServiceImpl extends ServiceImpl<OrderformMapper, Orderform> implements IOrderformService {

    @Autowired
    private OrderformMapper orderformMapper;


    @Override
    public void addOrderForm(Orderform orderform) {
        orderformMapper.addOrderForm(orderform);
    }

    @Override
    public List<Orderform> queryAllOrderForm() {
        return orderformMapper.queryAllOrderForm();
    }


}
