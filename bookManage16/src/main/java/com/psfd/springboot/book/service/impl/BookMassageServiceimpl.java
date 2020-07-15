package com.psfd.springboot.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psfd.springboot.book.bean.BookMassage;
import com.psfd.springboot.book.dao.IBookMassageDao;
import com.psfd.springboot.book.service.IBookMassageService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * @author LuYang
 * @create 2020-07-10 10:46
 */
@Service
@Transactional
public class BookMassageServiceimpl extends ServiceImpl<IBookMassageDao, BookMassage> implements IBookMassageService {


}
