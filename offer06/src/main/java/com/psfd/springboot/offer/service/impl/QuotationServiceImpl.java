package com.psfd.springboot.offer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psfd.springboot.offer.bean.Quotation;
import com.psfd.springboot.offer.dao.IQuotationDao;
import com.psfd.springboot.offer.service.IQuotationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuotationServiceImpl extends ServiceImpl<IQuotationDao, Quotation> implements IQuotationService {
}
