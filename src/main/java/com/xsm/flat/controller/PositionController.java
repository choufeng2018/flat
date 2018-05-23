package com.xsm.flat.controller;

import com.github.pagehelper.PageInfo;
import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.dao.StreetMapper;
import com.xsm.flat.entity.City;
import com.xsm.flat.entity.Province;
import com.xsm.flat.entity.Street;
import com.xsm.flat.entity.User;
import com.xsm.flat.service.CityService;
import com.xsm.flat.service.ProvinceService;
import com.xsm.flat.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/queryProvince")
@CrossOrigin
public class PositionController {

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;

    @Autowired
    private StreetService streetService;

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

    @RequestMapping(value = "/queryByCname/{cName}", method = RequestMethod.GET)
    public AjaxResponse queryByCname(@PathVariable("cName") String cName){

        List<City> cityList = cityService.getCities(cName);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,cityList);
        return Ares;
    }

    @RequestMapping(value = "/queryProvincePage", method = RequestMethod.GET)
    public AjaxResponse queryProvincePage(Integer pageNum,
                                          Integer pageSize) {

        List<Province> records = provinceService.getProvincesPage(pageNum,pageSize);
        PageInfo<Province> page = new PageInfo<Province>(records);
        AjaxResponse res= new AjaxResponse();
        res.setSuccessMessage(true,records);
        res.setPage(page);
        return res;
    }

    @RequestMapping(value = "/querysNameBycId", method = RequestMethod.POST)
    public AjaxResponse querysNameBycId(Street street) {

        List<Street> list = streetService.getNameByCid(street);
        AjaxResponse res= new AjaxResponse();
        res.setSuccessMessage(true,list);
        return res;
    }

}
