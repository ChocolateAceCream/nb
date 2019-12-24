package com.di.nb.dao.impl;

import com.di.nb.dao.UserDao;
import com.di.nb.domain.UserBean;
import com.di.nb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int createUser(UserBean bean){
        return userMapper.createUserMapper(bean);
    }

    @Override
    public int loginUser(UserBean bean){
        return userMapper.loginUserMapper(bean);
    }
}
