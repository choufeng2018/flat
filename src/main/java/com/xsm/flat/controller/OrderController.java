package com.xsm.flat.controller;

import com.github.pagehelper.PageInfo;
import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.Order;
import com.xsm.flat.entity.Remark;
import com.xsm.flat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/12.
 */
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 插入订单信息
     * @param fId
     * @param uId
     * @return
     */
    @RequestMapping(value = "/orderinsert", method = RequestMethod.POST)
    public AjaxResponse insertOrder(@RequestParam("fId") Integer fId,
                                  @RequestParam("uId") String uId) {
        Boolean result = orderService.insertOrder(uId, fId);
        AjaxResponse res = new AjaxResponse();
        if(result){
            res.setSuccessMessageUpdate();
            return res;
        }else {
            res.setErrorMessage("已经有此房屋的订单",result);
            return res;
        }
    }

    @RequestMapping(value = "/getAllOrders", method = RequestMethod.POST)
    public AjaxResponse getAllOrders(@RequestParam("uId") String uId) {

        List<Order> list = orderService.getAllOrders(uId);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,list);
        return Ares;
    }

    @RequestMapping(value = "/getAllOrderPage", method = RequestMethod.POST)
    public AjaxResponse getAllOrderPage(Integer pageNum,
                                         Integer pageSize) {

        List<Order> records = orderService.getAllOrderPage(pageNum,pageSize);
        PageInfo<Order> page = new PageInfo<Order>(records);
        AjaxResponse res= new AjaxResponse();
        res.setSuccessMessage(true,records);
        res.setPage(page);
        return res;
    }
}
