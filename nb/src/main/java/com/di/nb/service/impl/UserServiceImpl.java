package com.di.nb.service.impl;

import com.di.nb.dao.UserDao;
import com.di.nb.domain.UserBean;
import com.di.nb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public int createUserService(UserBean bean) {return userDao.createUser(bean);}
    @Override
    public int loginUserService(UserBean bean) {return userDao.loginUser(bean);}
}
