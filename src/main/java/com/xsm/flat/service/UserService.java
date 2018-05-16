package com.xsm.flat.service;

import com.xsm.flat.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsers(Integer pageNum, Integer pageSize);

    int updateUser(User user);

    int deleteUser(User user);

    int addUser(User user);

    User userLoginCheck(User user);

    Boolean updateUserInfo(User user);
}
