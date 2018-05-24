package com.xsm.flat.controller;

import com.github.pagehelper.PageInfo;
import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.FlatVerify;
import com.xsm.flat.entity.News;
import com.xsm.flat.service.FlatVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/5.
 */
@RestController
@RequestMapping("/verify")
@CrossOrigin
public class FlatVerifyController {

    @Autowired
    private FlatVerifyService flatVerifyService;

    @RequestMapping(value = "/addFlatVerify", method = RequestMethod.POST)
    public AjaxResponse addFlat(FlatVerify flatVerify) {

        flatVerifyService.add(flatVerify);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }

    @RequestMapping(value = "/queryVerifyStatus/{uId}", method = RequestMethod.POST)
    public AjaxResponse queryVerify(@PathVariable("uId") String uId) {

       List verifyInfo =  flatVerifyService.getVerifyByuId(uId);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true, verifyInfo);
        return Ares;
    }

    @RequestMapping(value = "/getAllVerifyPage", method = RequestMethod.POST)
    public AjaxResponse getAllVerifyPage(Integer pageNum,
                                       Integer pageSize) {

        List<FlatVerify> records = flatVerifyService.getAllVerifyPage(pageNum,pageSize);
        PageInfo<FlatVerify> page = new PageInfo<FlatVerify>(records);
        AjaxResponse res= new AjaxResponse();
        res.setSuccessMessage(true,records);
        res.setPage(page);
        return res;
    }
}
