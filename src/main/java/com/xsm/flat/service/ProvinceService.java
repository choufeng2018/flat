package com.xsm.flat.service;


import com.xsm.flat.entity.Province;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProvinceService {

    public List<Province> getProvinces();

    public List<Province> getProvincesByPName(String pName);

    public List<Province> getProvincesPage(Integer pageNum, Integer pageSize);

}
