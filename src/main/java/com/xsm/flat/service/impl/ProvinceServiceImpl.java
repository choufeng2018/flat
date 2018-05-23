package com.xsm.flat.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsm.flat.dao.CityMapper;
import com.xsm.flat.dao.ProvinceMapper;
import com.xsm.flat.dao.StreetMapper;
import com.xsm.flat.entity.Province;
import com.xsm.flat.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceMapper provinceMapper;
    @Autowired
    CityMapper cityMapper;
    @Autowired
    StreetMapper streetMapper;

    @Override
    public List<Province> getProvinces() {

        return provinceMapper.selectProvince();
    }

    @Override
    public List<Province> getProvincesByPName(String pName) {

        return provinceMapper.selectProvinceByPName(pName);
    }

    @Override
    public List<Province> getProvincesPage(@PathVariable("pageNum") Integer pageNum,
                                           @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return provinceMapper.selectProvince();
    }
}
