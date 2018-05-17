package com.xsm.flat.service.impl;

import com.xsm.flat.dao.NewsMapper;
import com.xsm.flat.entity.News;
import com.xsm.flat.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
