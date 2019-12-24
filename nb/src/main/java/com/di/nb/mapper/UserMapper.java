package com.di.nb.mapper;

import com.di.nb.domain.UserBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int createUserMapper(UserBean bean);
    int loginUserMapper(UserBean bean);

}
