package com.xsm.flat.controller;

import com.github.pagehelper.PageInfo;
import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.Favorite;
import com.xsm.flat.entity.News;
import com.xsm.flat.entity.Remark;
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

    @RequestMapping(value = "/getAllNewsPage", method = RequestMethod.POST)
    public AjaxResponse getAllNewsPage(Integer pageNum,
                                         Integer pageSize) {

        List<News> records = newsService.getAllNewsPage(pageNum,pageSize);
        PageInfo<News> page = new PageInfo<News>(records);
        AjaxResponse res= new AjaxResponse();
        res.setSuccessMessage(true,records);
        res.setPage(page);
        return res;
    }

    /**
     * 更新新闻信息
     * @param news
     * @return
     */
    @RequestMapping(value = "/updateNews", method = RequestMethod.POST)
    public  AjaxResponse updateNews(News news) {

        newsService.updateNews(news);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }

    @RequestMapping(value = "/deleteNews", method = RequestMethod.POST)
    public  AjaxResponse deleteNews(News news) {

        newsService.deleteNews(news);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }
}
