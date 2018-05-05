package com.xsm.flat.service;

import com.xsm.flat.entity.FlatVerify;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/5.
 */
@Service
public interface FlatVerifyService {
    int add (FlatVerify flatVerify);

    List<FlatVerify> getVerifyByuId(String uId);
}
