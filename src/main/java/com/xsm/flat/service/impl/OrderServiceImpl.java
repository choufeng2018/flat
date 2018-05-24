package com.xsm.flat.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsm.flat.dao.FlatMapper;
import com.xsm.flat.dao.OrderMapper;
import com.xsm.flat.entity.Flat;
import com.xsm.flat.entity.Order;
import com.xsm.flat.service.OrderService;
import com.xsm.flat.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/12.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    FlatMapper flatMapper;

    //需要判断一下，是否本房屋已经下过单了
    @Override
    public Boolean insertOrder(String uId, Integer fId) {
        Boolean isExist=orderMapper.orderCheck(fId);
        if(!isExist){

            Order order = new Order(IdGen.uuid(),uId,fId);
            orderMapper.insertSelective(order);
            //将房屋状态置为已签约
            Flat flat =new Flat(uId,fId);
            flat.setfStatus("1");
            flatMapper.updateFlatStatus(flat);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> getAllOrders(String uId) {
        return orderMapper.getAllOrders(uId);
    }

    @Override
    public List<Order> getAllOrderPage(@PathVariable("pageNum") Integer pageNum,
                                       @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return orderMapper.getAllOrderPage();
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int deleteOrder(Order order) {
        return orderMapper.deleteByPrimaryKey(order);
    }
}
