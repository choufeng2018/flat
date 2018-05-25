package com.xsm.flat.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.Assumpsit;
import com.xsm.flat.entity.Province;
import com.xsm.flat.entity.Remark;
import com.xsm.flat.service.AssumpsitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.plugin.viewer.context.AxBridgeAppletContext;

import java.util.List;

/**
 * Created by 薛时鸣 on 18-4-24.
 *
 * @author 薛时鸣
 * @date 18-4-24
 */
@RestController
@RequestMapping("/assumpsit")
@CrossOrigin
public class AssController {

    @Autowired
    private AssumpsitService assumpsitService;

    /**
     * 预约时间校验
     * @param fId
     * @return
     */
    @RequestMapping(value = "/getAllTimeByFid/{fId}", method = RequestMethod.GET)
    public Object getAllTimeByFid(@PathVariable("fId") Integer fId) {
        return assumpsitService.getAllTimeByFid(fId);
    }

    /**
     * 添加预约信息
     * @param fId
     * @param uId
     * @param assStarttime
     * @return
     */
    @RequestMapping(value = "/assinsert", method = RequestMethod.POST)
    public AjaxResponse getAllTimeByFid(@RequestParam("fId") Integer fId,
                                  @RequestParam("uId") String uId,
                                  @RequestParam("assStarttime") String assStarttime ) {
        Boolean result =  assumpsitService.insertAssumpsit(uId, fId, assStarttime);

        AjaxResponse res = new AjaxResponse();
        if(result){
            res.setSuccessMessageUpdate();
            return res;
        }else {
            res.setErrorMessage("这间房屋您只能约看一次",result);
            return res;
        }
    }

    /**
     * 根据uId查询约看信息
     * @param uId
     * @return
     */
    @RequestMapping(value = "/getAssInfoByUid/{uId}", method = RequestMethod.GET)
    public AjaxResponse getAssInfoByUid(@PathVariable("uId") String uId) {

        List<Assumpsit> asslist = assumpsitService.getAssInfoByUid(uId);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,asslist);
        return Ares;
    }

    @RequestMapping(value = "/assdelete/{assId}", method = RequestMethod.GET)
    public AjaxResponse deleteInfoByFid(@PathVariable("assId") String assId) {
        assumpsitService.deleteInfoByFid(assId);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }

    @RequestMapping(value = "/assOnOff", method = RequestMethod.POST)
    public AjaxResponse updateAssOnOff(@RequestParam("fId") Integer fId,
                                 @RequestParam("uId") String uId){

        assumpsitService.assOnOff(uId,fId);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }

    @RequestMapping(value = "/getAssPage", method = RequestMethod.POST)
    public AjaxResponse getAssPage(Integer pageNum,
                                   Integer pageSize) {

        List<Assumpsit> records = assumpsitService.getAssPage(pageNum,pageSize);
        PageInfo<Assumpsit> page = new PageInfo<Assumpsit>(records);
        AjaxResponse res= new AjaxResponse();
        res.setSuccessMessage(true,records);
        res.setPage(page);
        return res;
    }
}
