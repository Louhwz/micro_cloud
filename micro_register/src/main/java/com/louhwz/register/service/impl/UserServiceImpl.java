package com.louhwz.register.service.impl;

import com.louhwz.register.entity.User;
import com.louhwz.register.repository.UserDao;
import com.louhwz.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements RegisterService {

    @Autowired
    private UserDao userDao;

    @Override
    public int register(User user){
        int result = userDao.selectByUserName(user.getUserName());
        System.out.println("数据库中存在此条数据吗？:"+result);
        if(result>0)    return -1;
        return userDao.insertUser(user);
    }

    @Override
    public int hasRegistered(String username) {
        int result=userDao.selectByUserName(username);

        return result;
    }
}
