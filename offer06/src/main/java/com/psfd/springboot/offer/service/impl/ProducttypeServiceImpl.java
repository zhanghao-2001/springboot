package com.psfd.springboot.offer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psfd.springboot.offer.bean.Producttype;
import com.psfd.springboot.offer.dao.IProducttypeDao;
import com.psfd.springboot.offer.service.IProducttypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProducttypeServiceImpl extends ServiceImpl<IProducttypeDao, Producttype> implements IProducttypeService {
}
