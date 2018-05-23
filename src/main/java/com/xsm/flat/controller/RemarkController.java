package com.xsm.flat.controller;

import com.github.pagehelper.PageInfo;
import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.Favorite;
import com.xsm.flat.entity.Remark;
import com.xsm.flat.entity.User;
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
     * 添加留言
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
     * 查询留言
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

    /**
     * 查询留言信息page分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getAllRemarkPage", method = RequestMethod.POST)
    public AjaxResponse getAllRemarkPage(Integer pageNum,
                                         Integer pageSize) {

        List<Remark> records = remarkService.getRemarkPage(pageNum,pageSize);
        PageInfo<Remark> page = new PageInfo<Remark>(records);
        AjaxResponse res= new AjaxResponse();
        res.setSuccessMessage(true,records);
        res.setPage(page);
        return res;
    }

    /**
     * 更新留言信息
     * @param remark
     * @return
     */
    @RequestMapping(value = "/updateRemark", method = RequestMethod.POST)
    public  AjaxResponse updateRemark(Remark remark) {

        remarkService.updateRemark(remark);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }

}
