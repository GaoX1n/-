package com.baizhi.service.impl;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(String username,String password) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        return userMapper.login(user);
    }

    @Override
    public int regist(User user) {
        return userMapper.insert(user);
    }
}
