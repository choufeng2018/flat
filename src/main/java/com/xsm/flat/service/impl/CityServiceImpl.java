package com.xsm.flat.service.impl;

import com.xsm.flat.dao.CityMapper;
import com.xsm.flat.entity.City;
import com.xsm.flat.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;


    @Override
    public List<City> getCities(String cName) {

        return cityMapper.selectByCName(cName);
    }
}
