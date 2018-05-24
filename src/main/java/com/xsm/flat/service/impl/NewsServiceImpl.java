package com.xsm.flat.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsm.flat.dao.NewsMapper;
import com.xsm.flat.entity.News;
import com.xsm.flat.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/17.
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public List<News> getNewsByFid(String fId) {
        return newsMapper.getNewsByFid(fId);
    }

    @Override
    public List<News> getAllNewsPage(@PathVariable("pageNum") Integer pageNum,
                                     @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return newsMapper.getAllNewsPage();
    }

    @Override
    public int updateNews(News news) {
        return newsMapper.updateByPrimaryKeySelective(news);
    }

    @Override
    public int deleteNews(News news) {
        return newsMapper.deleteByPrimaryKey(news);
    }
}
