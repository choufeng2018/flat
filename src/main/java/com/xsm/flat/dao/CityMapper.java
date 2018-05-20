package com.xsm.flat.dao;

import com.xsm.flat.entity.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {
    int deleteByPrimaryKey(String cId);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    List<City> selectByPId(@Param("pId") String pId);

    List<City> selectByCName(@Param("cName") String cName);

    String selectcIdBycName(String cName);
}