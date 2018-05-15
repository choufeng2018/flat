package com.xsm.flat.controller;

import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.Favorite;
import com.xsm.flat.entity.Remark;
import com.xsm.flat.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/15.
 */
@RestController
@RequestMapping("/remark")
@CrossOrigin
public class RemarkController {

    @Autowired
    RemarkService remarkService;

    /**
     * 添加收藏
     * @param fId
     * @param rSendname
     * @param rInfo
     * @return
     */
    @RequestMapping(value = "/remarkInsert", method = RequestMethod.POST)
    public AjaxResponse insertRemark(@RequestParam("fId") Integer fId,
                                     @RequestParam("rSendname") String rSendname,
                                     @RequestParam("rInfo") String rInfo) {
         remarkService.insertRemark(fId, rSendname, rInfo);
         AjaxResponse res = new AjaxResponse();
         res.setSuccessMessageUpdate();
         return res;
    }

    /**
     * 查询收藏
     * @param uName
     * @return
     */
    @RequestMapping(value = "/getAllRemark", method = RequestMethod.POST)
    public AjaxResponse getAllRemark(@RequestParam("uName") String uName) {

        List<Remark> list = remarkService.getAllRemark(uName);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,list);
        return Ares;
    }
}
