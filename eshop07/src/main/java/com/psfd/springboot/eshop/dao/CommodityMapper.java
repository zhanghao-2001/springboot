package com.psfd.springboot.eshop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.psfd.springboot.eshop.domain.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
public interface CommodityMapper extends BaseMapper<Commodity> {

}
