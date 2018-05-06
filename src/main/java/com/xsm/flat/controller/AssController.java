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
     * @param assStarttime
     * @param assEndtime
     * @return
     */
    /*@RequestMapping(value = "/asscheck/{assStarttime}/{assEndtime}", method = RequestMethod.GET)
    public Assumpsit queryProvince(@PathVariable("assStarttime") String assStarttime,
                                   @PathVariable("assEndtime") String assEndtime ) {
        Assumpsit result = assumpsitService.inse(assStarttime,assEndtime);
        return result;
    }*/


    @RequestMapping(value = "/getAllTimeByFid/{fId}", method = RequestMethod.GET)
    public Object getAllTimeByFid(@PathVariable("fId") Integer fId) {
        return assumpsitService.getAllTimeByFid(fId);
    }

    @RequestMapping(value = "/assinsert", method = RequestMethod.POST)
    public Object getAllTimeByFid(@RequestParam("fId") Integer fId,
                                  @RequestParam("uId") String uId,
                                  @RequestParam("assStarttime") String assStarttime ) {
        return assumpsitService.insertAssumpsit(uId, fId, assStarttime);
    }
}
