package com.xsm.flat.dao;

import com.xsm.flat.entity.Assumpsit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssumpsitMapper {
    int deleteByPrimaryKey(String fId);

    int insert(Assumpsit record);

    int insertSelective(Assumpsit record);

    Assumpsit selectByPrimaryKey(String assId);

    int updateByPrimaryKeySelective(Assumpsit record);

    int updateByPrimaryKey(Assumpsit record);

    Boolean assCheck(@Param("uId") String uId,@Param("fId") Integer fId, @Param("assStarttime")String assStarttime);

    List<String> getAllTimeByFid(@Param("fId") Integer fId);

    List<Assumpsit> getAssInfoByUid(@Param("uId") String uId);

    int updateByUidFid(Assumpsit record);

}