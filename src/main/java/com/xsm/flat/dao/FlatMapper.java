package com.xsm.flat.dao;

import com.xsm.flat.entity.Flat;
import com.xsm.flat.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlatMapper {
    int deleteByPrimaryKey(Flat flat);

    int insert(Flat record);

    int insertSelective(Flat record);

    Flat selectByPrimaryKey(String fId);

    int updateByPrimaryKeySelective(Flat record);

    int updateByPrimaryKey(Flat record);

    List<Flat> selectBysId(String sId);

    List<Flat> selectBypName(String pName);

    List<Flat> combineSelect(Flat flat);

    List<Flat> selectFlatByfId(String fId);

    List<Flat> fuzzySearchFlat(Flat flat);

    int updateFlatStatus(Flat flat);

    String selectUIdByfId(@Param("fId") Integer fId);

    List<Flat> selectAll();
}