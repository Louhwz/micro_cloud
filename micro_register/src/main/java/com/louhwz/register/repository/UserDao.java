package com.louhwz.register.repository;

import com.louhwz.register.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Mapper
public interface UserDao{
    int selectByUserName(String userName);

    int insertUser(User user);
}
