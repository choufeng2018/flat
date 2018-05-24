package com.xsm.flat.service;

import com.xsm.flat.entity.Flat;
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

    List<FlatVerify> getAllVerifyPage(Integer pageNum, Integer pageSize);

    int verifyFlatInfo(FlatVerify flatVerify);
}
