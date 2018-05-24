package com.xsm.flat.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsm.flat.dao.FlatVerifyMapper;
import com.xsm.flat.entity.FlatVerify;
import com.xsm.flat.service.FlatVerifyService;
import com.xsm.flat.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/5.
 */
@Service
@Transactional
public class FlatVerifyServiceImpl implements FlatVerifyService {

    @Autowired
    FlatVerifyMapper flatVerifyMapper;

    @Override
    public int add(FlatVerify flatVerify) {
        flatVerify.setfId(UUIDUtils.getUUID());
        flatVerify.setfStatus("0");
        return flatVerifyMapper.insertSelective(flatVerify);
    }

    @Override
    public List<FlatVerify> getVerifyByuId(String uId) {
        return flatVerifyMapper.selectByuId(uId);
    }

    @Override
    public List<FlatVerify> getAllVerifyPage(@PathVariable("pageNum") Integer pageNum,
                                             @PathVariable("pageSize") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        return flatVerifyMapper.getAllVerifyPage();
    }

    @Override
    public int verifyFlatInfo(FlatVerify flatVerify) {

        if (flatVerify.getPassFlag() == 1){
            flatVerify.setfStatus("1");
            return  flatVerifyMapper.verifyFlatPass(flatVerify);
        }else {
            flatVerify.setfStatus("0");
            return  flatVerifyMapper.verifyFlatNoPass(flatVerify);
        }


    }


}
