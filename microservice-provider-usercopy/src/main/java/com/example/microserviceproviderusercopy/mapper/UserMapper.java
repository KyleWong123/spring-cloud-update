package com.example.microserviceproviderusercopy.mapper;

import com.example.microserviceproviderusercopy.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Kyle Wong
 * @Date: 2019/10/9 14:35
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    List<User> findByName(@Param("username") String username);

    List<User> findAll();

}
