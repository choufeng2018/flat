package com.xsm.flat.service;

import com.xsm.flat.entity.News;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/17.
 */
@Service
public interface NewsService {

    List<News> getNewsByFid(String fId);
}
