package com.xsm.flat.dao;

import com.xsm.flat.entity.Remark;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemarkMapper {
    int deleteByPrimaryKey(String rId);

    int insert(Remark record);

    int insertSelective(Remark record);

    Remark selectByPrimaryKey(String rId);

    int updateByPrimaryKeySelective(Remark record);

    int updateByPrimaryKey(Remark record);

    List<Remark> getAllRemark(String uName);

    List<Remark> getRemarkPage();
}