package com.xsm.flat.dao;

import com.xsm.flat.entity.Flat;

import java.util.List;

public interface FlatMapper {
    int deleteByPrimaryKey(String fId);

    int insert(Flat record);

    int insertSelective(Flat record);

    Flat selectByPrimaryKey(String fId);

    int updateByPrimaryKeySelective(Flat record);

    int updateByPrimaryKey(Flat record);

    List<Flat> selectBysId(String sId);

    List<Flat> selectAll();

    List<Flat> combineSelect(Flat flat);
}