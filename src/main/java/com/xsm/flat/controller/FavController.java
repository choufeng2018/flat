package com.xsm.flat.controller;

import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.Favorite;
import com.xsm.flat.entity.Order;
import com.xsm.flat.service.FavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 查询所有收藏信息
     * @param uId
     * @return
     */
    @RequestMapping(value = "/getAllFav", method = RequestMethod.POST)
    public AjaxResponse getAllOrders(@RequestParam("uId") String uId) {

        List<Favorite> list = favService.getAllFav(uId);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,list);
        return Ares;
    }

    /**
     * 删除收藏信息
     * @param favId
     * @return
     */
    @RequestMapping(value = "/deleteFav", method = RequestMethod.POST)
    public AjaxResponse deleteFav(@RequestParam("favId") String favId) {

       favService.deleteFav(favId);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }

    @RequestMapping(value = "/getFavByTime", method = RequestMethod.POST)
    public AjaxResponse getFavByTime(@RequestParam("uId") String uId) {

        List<Favorite> list = favService.getAllFav(uId);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,list);
        return Ares;
    }
}
