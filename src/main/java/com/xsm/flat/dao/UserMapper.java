package com.xsm.flat.dao;

import com.xsm.flat.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(User user);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAll();

    User userLogincheck(User user);

    String selectUserNameByUid(@Param("uId") String uId);

    Boolean isPwdExact(String uPwdnew);

}