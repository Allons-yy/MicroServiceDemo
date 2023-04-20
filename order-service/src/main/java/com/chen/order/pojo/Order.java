package com.chen.order.pojo;

import lombok.Data;
import com.chen.user.pojo.User;

@Data
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private User user;
}