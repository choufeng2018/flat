package com.xsm.flat.service;

import com.xsm.flat.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsers();

    int updateUser(User user);
}
