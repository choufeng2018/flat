package com.xsm.flat.dao;

import com.xsm.flat.entity.Street;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetMapper {
    int deleteByPrimaryKey(String sId);

    int insert(Street record);

    int insertSelective(Street record);

    Street selectByPrimaryKey(String sId);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);

    List<Street> selectByCId(@Param("cId") String cId);
}