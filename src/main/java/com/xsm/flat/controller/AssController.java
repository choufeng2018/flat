package com.xsm.flat.controller;

import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.Assumpsit;
import com.xsm.flat.entity.Province;
import com.xsm.flat.service.AssumpsitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Object getAllTimeByFid(@RequestParam("fId") Integer fId,
                                  @RequestParam("uId") String uId,
                                  @RequestParam("assStarttime") String assStarttime ) {
        return assumpsitService.insertAssumpsit(uId, fId, assStarttime);
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

}
