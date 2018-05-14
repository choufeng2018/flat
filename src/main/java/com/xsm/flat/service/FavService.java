package com.xsm.flat.service;

import org.springframework.stereotype.Service;

/**
 * Created by 薛时鸣 on 2018/5/14.
 */
@Service
public interface FavService {
    Boolean insertFav(String uId,Integer fId);
}
