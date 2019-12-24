package com.di.nb.service;

import com.di.nb.domain.UserBean;

public interface UserService {
    int createUserService(UserBean bean);
    int loginUserService(UserBean bean);

}
