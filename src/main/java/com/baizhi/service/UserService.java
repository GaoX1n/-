package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    public User login(String userName,String password);

    int regist(User user);
}
