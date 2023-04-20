package com.chen.order.service;

import com.chen.feign.clients.UserClient;
import com.chen.order.mapper.OrderMapper;
import com.chen.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.chen.user.pojo.User;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    //    @Autowired
//    private RestTemplate restTemplate;
//
//
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        // 2.用RestTemplate发起http请求，查询用户
//        String url = "http://userservice/user/" + order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
//        // 3.封装user到Order
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }
    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.用Feign远程调用
        User user = userClient.findById(order.getUserId());
        // 3.封装user到Order
        order.setUser(user);
        // 4.返回
        return order;
    }
}

