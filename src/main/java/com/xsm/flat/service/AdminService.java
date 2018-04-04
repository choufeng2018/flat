package com.xsm.flat.service;

import com.xsm.flat.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    Boolean loginCheck(Admin admin);
}
