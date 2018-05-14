package com.xsm.flat.service.impl;

import com.xsm.flat.dao.FavoriteMapper;
import com.xsm.flat.entity.Favorite;
import com.xsm.flat.service.FavService;
import com.xsm.flat.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 薛时鸣 on 2018/5/14.
 */
@Service
@Transactional
public class FavServiceImpl implements FavService{

    @Autowired
    FavoriteMapper favoriteMapper;

    @Override
    public Boolean insertFav(String uId, Integer fId) {

        Boolean isExist = favoriteMapper.favCheck(uId, fId);
        if(!isExist){
            Favorite favorite = new Favorite(IdGen.uuid(),uId,fId);
            favoriteMapper.insertSelective(favorite);
            return true;
        }
        return false;
    }
}
