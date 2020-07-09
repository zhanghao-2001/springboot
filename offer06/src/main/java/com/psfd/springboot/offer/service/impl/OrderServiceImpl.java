package com.psfd.springboot.offer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psfd.springboot.offer.bean.Order;
import com.psfd.springboot.offer.dao.IOrderDao;
import com.psfd.springboot.offer.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl extends ServiceImpl<IOrderDao, Order> implements IOrderService {
}
