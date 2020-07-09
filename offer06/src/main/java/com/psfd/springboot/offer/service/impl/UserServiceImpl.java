package com.psfd.springboot.offer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.psfd.springboot.offer.bean.User;
import com.psfd.springboot.offer.dao.IUserDao;
import com.psfd.springboot.offer.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<IUserDao, User> implements IUserService {
}
