package com.xsm.flat.service;

import com.xsm.flat.entity.Flat;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 薛时鸣 on 18-4-11.
 *
 * @author 薛时鸣
 * @date 18-4-11
 */
@Service
public interface FlatService {

    int addFlat (Flat flat);

     List<Flat> selectBysId (String sId);

     List<Flat> selectBypName(String pName);

     List<Flat> combineSelect(Flat flat);

    List<Flat> selectFlatByfId (String fId);

    List<Flat> fuzzySearchFlat(Flat flat);

    List<Flat> selectAll(Integer pageNum, Integer pageSize);

    int deleteFlat (Flat flat);

    int updateFlat (Flat flat);
}
