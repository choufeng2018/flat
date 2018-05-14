package com.xsm.flat.service;

import com.xsm.flat.entity.Favorite;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/14.
 */
@Service
public interface FavService {
    Boolean insertFav(String uId,Integer fId);
    List<Favorite> getAllFav(String uId);
    int deleteFav(String favId);
}
