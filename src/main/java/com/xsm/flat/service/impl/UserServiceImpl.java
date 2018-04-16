package com.xsm.flat.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsm.flat.config.JavaWebToken;
import com.xsm.flat.dao.UserMapper;
import com.xsm.flat.entity.Admin;
import com.xsm.flat.entity.User;
import com.xsm.flat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUsers(@PathVariable("pageNum") Integer pageNum,
                               @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAll();
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteByPrimaryKey(user);
    }

    @Override
    public int addUser(User user) {
        JavaWebToken token = new JavaWebToken();
        String javaTocken = token.createJavaWebToken(user.getuName());
        user.setToken(javaTocken);
        return userMapper.insertSelective(user);
    }

    @Override
    public Boolean userLoginCheck(User user) {
        User result = userMapper.userLogincheck(user);

        if(result == null){
            return false;
        }else {
            if (result.getuPwd().equals(user.getuPwd())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
