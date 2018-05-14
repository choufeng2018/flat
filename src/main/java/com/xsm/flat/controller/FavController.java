package com.xsm.flat.controller;

import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.service.FavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 薛时鸣 on 2018/5/14.
 */
@RestController
@RequestMapping("/fav")
@CrossOrigin
public class FavController {

    @Autowired
    private FavService favService;

   @RequestMapping(value = "/favinsert", method = RequestMethod.POST)
   public AjaxResponse insertFav(@RequestParam("fId") Integer fId,
                                   @RequestParam("uId") String uId) {
       Boolean result = favService.insertFav(uId, fId);
       AjaxResponse res = new AjaxResponse();
       if(result){
           res.setSuccessMessageUpdate();
           return res;
       }else {
           res.setErrorMessage("您已经收藏过本房屋了！",result);
           return res;
       }
   }
}
