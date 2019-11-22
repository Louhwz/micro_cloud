package com.louhwz.register.service;

import com.louhwz.register.entity.User;

public interface RegisterService {
    int register(User user);

    int hasRegistered(String username);
}
