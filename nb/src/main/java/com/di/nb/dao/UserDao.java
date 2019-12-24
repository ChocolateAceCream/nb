package com.di.nb.dao;


import com.di.nb.domain.NbConfigBean;
import com.di.nb.domain.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    int createUser(UserBean bean);
    int loginUser(UserBean bean);
}
