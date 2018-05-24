package com.xsm.flat.dao;

import com.xsm.flat.entity.News;

import java.util.List;

public interface NewsMapper {

    int deleteByPrimaryKey(News news);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(String nId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<News> getNewsByFid(String fId);

    List<News> getAllNewsPage();
}