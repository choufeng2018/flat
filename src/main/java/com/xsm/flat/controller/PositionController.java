package com.xsm.flat.controller;

import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.City;
import com.xsm.flat.entity.Province;
import com.xsm.flat.service.CityService;
import com.xsm.flat.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/queryByPname/{pName}", method = RequestMethod.GET)
    public AjaxResponse queryByPname(@PathVariable("pName") String pName) {

        System.out.println("按照pName查询");
        List<Province> proList = provinceService.getProvincesByPName(pName);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,proList);
        return Ares;
    }

}
