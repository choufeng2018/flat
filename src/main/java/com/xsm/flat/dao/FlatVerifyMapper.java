package com.xsm.flat.dao;

import com.xsm.flat.entity.FlatVerify;

import java.util.List;

public interface FlatVerifyMapper {
    int deleteByPrimaryKey(String fId);

    int insert(FlatVerify record);

    int insertSelective(FlatVerify record);

    FlatVerify selectByPrimaryKey(String fId);

    int updateByPrimaryKeySelective(FlatVerify record);

    int updateByPrimaryKey(FlatVerify record);

    List<FlatVerify> selectByuId(String uId);

    List<FlatVerify> getAllVerifyPage();

    int verifyFlatPass(FlatVerify flatVerify);

    int  verifyFlatNoPass(FlatVerify flatVerify);
}