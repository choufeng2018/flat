package com.xsm.flat.controller;

import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 薛时鸣 on 2018/5/15.
 */
@RestController
@RequestMapping("/remark")
@CrossOrigin
public class RemarkController {

    @Autowired
    RemarkService remarkService;

    @RequestMapping(value = "/remarkInsert", method = RequestMethod.POST)
    public AjaxResponse insertRemark(@RequestParam("fId") Integer fId,
                                     @RequestParam("rSendname") String rSendname,
                                     @RequestParam("rInfo") String rInfo) {
         remarkService.insertRemark(fId, rSendname, rInfo);
         AjaxResponse res = new AjaxResponse();
         res.setSuccessMessageUpdate();
         return res;
    }
}
