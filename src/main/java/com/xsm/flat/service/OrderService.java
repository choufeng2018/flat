package com.xsm.flat.service;

import org.springframework.stereotype.Service;

/**
 * Created by 薛时鸣 on 2018/5/12.
 */
@Service
public interface OrderService {
    Boolean insertOrder(String uId,Integer fId);
}
