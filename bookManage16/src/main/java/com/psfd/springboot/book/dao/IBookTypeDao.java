package com.psfd.springboot.book.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.psfd.springboot.book.bean.BookType;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LuYang
 * @create 2020-07-09 20:37
 */
@Mapper
public interface IBookTypeDao extends BaseMapper<BookType> {

}
