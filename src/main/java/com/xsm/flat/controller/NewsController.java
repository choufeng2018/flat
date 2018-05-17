package com.xsm.flat.controller;

import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.Favorite;
import com.xsm.flat.entity.News;
import com.xsm.flat.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/17.
 */
@RestController
@RequestMapping("/news")
@CrossOrigin
public class NewsController {

    @Autowired
    NewsService newsService;

    @RequestMapping(value = "/getNewsByFid", method = RequestMethod.POST)
    public AjaxResponse getAllOrders(@RequestParam("fId") String fId) {

        List<News> list = newsService.getNewsByFid(fId);
        AjaxResponse Ares = new AjaxResponse();
        Ares.setSuccessMessage(true,list);
        return Ares;
    }

}
