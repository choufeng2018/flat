package com.xsm.flat.service.impl;

import com.xsm.flat.dao.StreetMapper;
import com.xsm.flat.entity.Street;
import com.xsm.flat.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/23.
 */
@Service
@Transactional
public class StreetServiceImpl implements StreetService {

    @Autowired
    StreetMapper streetMapper;

    @Override
    public List<Street> getNameByCid(Street street) {
        return streetMapper.getNameByCid(street);
    }
}
