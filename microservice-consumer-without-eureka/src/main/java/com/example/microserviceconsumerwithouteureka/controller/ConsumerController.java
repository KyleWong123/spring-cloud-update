package com.example.microserviceconsumerwithouteureka.controller;

import com.example.microserviceconsumerwithouteureka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: Kyle Wong
 * @Date: 2019/10/10 14:27
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class
ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/findall")
    public List<User> findAll() {
        List<User> userList = restTemplate.getForObject("http://microserviceUser/user/findall", List.class);
        return userList;
    }

    @GetMapping("/log")
    public void logInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microserviceUser");
        log.info("实例ID：" + serviceInstance.getInstanceId() + "主机IP：" + serviceInstance.getHost() + "端口号：" + serviceInstance.getPort());
    }

}
