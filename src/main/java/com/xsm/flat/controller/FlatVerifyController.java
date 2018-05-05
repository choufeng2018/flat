package com.xsm.flat.controller;

import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.FlatVerify;
import com.xsm.flat.service.FlatVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 薛时鸣 on 2018/5/5.
 */
@RestController
@RequestMapping("/verify")
@CrossOrigin
public class FlatVerifyController {

    @Autowired
    private FlatVerifyService flatVerifyService;

    @RequestMapping(value = "addFlatVerify", method = RequestMethod.POST)
    public AjaxResponse addFlat(FlatVerify flatVerify) {

        flatVerifyService.add(flatVerify);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }

}
