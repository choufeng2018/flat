package com.xsm.flat.dao;

import com.xsm.flat.entity.Street;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetMapper {
    int deleteByPrimaryKey(String sId);

    int insert(Street record);

    int insertSelective(Street record);

    Street selectByPrimaryKey(String sId);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);
}