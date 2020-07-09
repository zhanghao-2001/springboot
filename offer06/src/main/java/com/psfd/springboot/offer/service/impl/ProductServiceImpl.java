package com.psfd.springboot.offer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psfd.springboot.offer.bean.Product;
import com.psfd.springboot.offer.dao.IProductDao;
import com.psfd.springboot.offer.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl extends ServiceImpl<IProductDao, Product> implements IProductService {
}
