package com.psfd.springboot.eshop.service.impl;

import com.psfd.springboot.eshop.domain.Admin;
import com.psfd.springboot.eshop.dao.AdminMapper;
import com.psfd.springboot.eshop.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
