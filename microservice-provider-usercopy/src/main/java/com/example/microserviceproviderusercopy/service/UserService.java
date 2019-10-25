package com.example.microserviceproviderusercopy.service;

import com.example.microserviceproviderusercopy.model.User;

import java.util.List;

/**
 * @Author: Kyle Wong
 * @Date: 2019/10/9 14:43
 * @Version 1.0
 */
public interface UserService {
    List<User> findAll();

    List<User> findByName(String username);

}
