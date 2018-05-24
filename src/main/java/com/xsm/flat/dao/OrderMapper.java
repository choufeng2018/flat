package com.xsm.flat.dao;

import com.xsm.flat.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String oId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String oId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Boolean orderCheck(@Param("fId") Integer fId);

    List<Order> getAllOrders(@Param("uId") String uId);

    List<Order> getAllOrderPage();

}