package com.xsm.flat.controller;

import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 薛时鸣 on 2018/5/12.
 */
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

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
}
