package com.xsm.flat.controller;

import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.Province;
import com.xsm.flat.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queryProvince")
public class PositionController {

    @Autowired
    private ProvinceService provinceService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public AjaxResponse queryProvince() {

        System.out.println("sssssss");
        List<Province> list = provinceService.getProvinces();
        AjaxResponse res= new AjaxResponse();
        res.setSuccessMessage(true,list);
        return res;
    }

}