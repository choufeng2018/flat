package com.xsm.flat.service.impl;

import com.xsm.flat.dao.CityMapper;
import com.xsm.flat.dao.ProvinceMapper;
import com.xsm.flat.dao.StreetMapper;
import com.xsm.flat.entity.Province;
import com.xsm.flat.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {



    @Override
    public List<Province> getProvinces() {
        return null;
    }
}
