package com.xsm.flat.dao;

import com.xsm.flat.entity.FlatVerify;

public interface FlatVerifyMapper {
    int deleteByPrimaryKey(String fId);

    int insert(FlatVerify record);

    int insertSelective(FlatVerify record);

    FlatVerify selectByPrimaryKey(String fId);

    int updateByPrimaryKeySelective(FlatVerify record);

    int updateByPrimaryKey(FlatVerify record);
}