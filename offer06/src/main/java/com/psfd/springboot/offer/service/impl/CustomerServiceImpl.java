package com.psfd.springboot.offer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psfd.springboot.offer.bean.Customer;
import com.psfd.springboot.offer.dao.ICustomerDao;
import com.psfd.springboot.offer.service.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl extends ServiceImpl<ICustomerDao, Customer> implements ICustomerService {
}
