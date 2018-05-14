package com.xsm.flat.service;

import com.xsm.flat.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/12.
 */
@Service
public interface OrderService {
    Boolean insertOrder(String uId,Integer fId);
    List<Order> getAllOrders(String uId);
}
