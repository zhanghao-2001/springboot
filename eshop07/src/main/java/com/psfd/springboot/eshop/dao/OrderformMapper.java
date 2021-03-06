package com.psfd.springboot.eshop.dao;

import com.psfd.springboot.eshop.domain.Orderform;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
@Mapper
@Repository
public interface OrderformMapper extends BaseMapper<Orderform> {
    void addOrderForm(Orderform orderform);

    List<Orderform> queryAllOrderForm();


}
