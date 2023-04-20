package com.chen.order.mapper;

import org.apache.ibatis.annotations.Select;
import com.chen.order.pojo.Order;

public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);
}
