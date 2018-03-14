package com.xsm.flat.service;

import com.xsm.flat.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    public List<City> getCities(String cName);
}
