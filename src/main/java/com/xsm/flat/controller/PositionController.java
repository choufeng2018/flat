package com.xsm.flat.controller;

import com.xsm.flat.entity.Province;
import com.xsm.flat.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/queryProvince")
public class PositionController {

    @Autowired
    private ProvinceService provinceService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public List<Province> queryProvince() {

        System.out.println("sssssss");
        List<Province> list = provinceService.getProvinces();
        return list;
    }

}
