package com.xsm.flat.dao;

import com.xsm.flat.entity.Province;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceMapper {
    int deleteByPrimaryKey(String pId);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(String pId);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);

    List<Province> selectProvince();

}