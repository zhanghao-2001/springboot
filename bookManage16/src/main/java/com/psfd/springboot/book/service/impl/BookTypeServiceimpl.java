package com.psfd.springboot.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psfd.springboot.book.bean.BookType;
import com.psfd.springboot.book.dao.BookTypeDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author LuYang
 * @create 2020-07-09 20:42
 */
@Service
@Transactional
public class BookTypeServiceimpl  extends ServiceImpl<BookTypeDao, BookType> {
}
