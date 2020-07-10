package com.psfd.springboot.eshop.service.impl;

import com.psfd.springboot.eshop.domain.User;
import com.psfd.springboot.eshop.dao.UserMapper;
import com.psfd.springboot.eshop.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
