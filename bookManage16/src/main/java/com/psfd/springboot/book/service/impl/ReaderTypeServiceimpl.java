package com.psfd.springboot.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psfd.springboot.book.bean.ReaderType;
import com.psfd.springboot.book.dao.IReaderTypeDao;
import com.psfd.springboot.book.service.IReaderTypeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author LuYang
 * @create 2020-07-11 10:22
 */
@Service
@Transactional
public class ReaderTypeServiceimpl extends ServiceImpl<IReaderTypeDao,ReaderType> implements IReaderTypeService {
}
