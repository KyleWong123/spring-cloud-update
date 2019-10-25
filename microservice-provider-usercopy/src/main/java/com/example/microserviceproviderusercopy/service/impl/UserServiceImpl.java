package com.example.microserviceproviderusercopy.service.impl;

import com.example.microserviceproviderusercopy.mapper.UserMapper;
import com.example.microserviceproviderusercopy.model.User;
import com.example.microserviceproviderusercopy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Kyle Wong
 * @Date: 2019/10/9 14:44
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findByName(String username) {
        return userMapper.findByName(username);
    }
}
