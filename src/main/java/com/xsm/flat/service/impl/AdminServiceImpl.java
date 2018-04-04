package com.xsm.flat.service.impl;

import com.xsm.flat.dao.AdminMapper;
import com.xsm.flat.entity.Admin;
import com.xsm.flat.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Boolean loginCheck(Admin admin) {

        Admin result = adminMapper.selectByPrimaryKey(admin);

        if(result.getPassword().equals(admin.getPassword())){
            return true;
        }else {
            return false;
        }
    }
}
