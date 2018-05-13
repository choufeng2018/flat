package com.xsm.flat.service.impl;

import com.xsm.flat.dao.OrderMapper;
import com.xsm.flat.entity.Order;
import com.xsm.flat.service.OrderService;
import com.xsm.flat.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 薛时鸣 on 2018/5/12.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderMapper orderMapper;

    //需要判断一下，是否本房屋已经下过单了
    @Override
    public Boolean insertOrder(String uId, Integer fId) {
        Boolean isExist=orderMapper.orderCheck(fId);
        if(!isExist){
            Order order = new Order(IdGen.uuid(),uId,fId);
            orderMapper.insertSelective(order);
            return true;
        }
        return false;
    }
}
