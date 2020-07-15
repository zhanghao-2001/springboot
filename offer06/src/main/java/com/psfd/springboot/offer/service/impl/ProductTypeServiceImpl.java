package com.psfd.springboot.offer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psfd.springboot.offer.bean.ProductType;
import com.psfd.springboot.offer.dao.IProductTypeDao;
import com.psfd.springboot.offer.service.IProductTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductTypeServiceImpl extends ServiceImpl<IProductTypeDao, ProductType> implements IProductTypeService {
}
