package com.xsm.flat.dao;

import com.xsm.flat.entity.Favorite;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteMapper {
    int deleteByPrimaryKey(String favId);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(String favId);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);

    Boolean favCheck(@Param("uId") String uId, @Param("fId") Integer fId);
}