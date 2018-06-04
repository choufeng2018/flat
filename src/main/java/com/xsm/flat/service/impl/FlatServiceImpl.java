package com.xsm.flat.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsm.flat.dao.CityMapper;
import com.xsm.flat.dao.FlatMapper;
import com.xsm.flat.dao.ProvinceMapper;
import com.xsm.flat.dao.StreetMapper;
import com.xsm.flat.entity.Flat;
import com.xsm.flat.service.FlatService;
import com.xsm.flat.utils.IdGen;
import com.xsm.flat.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by 薛时鸣 on 18-4-11.
 *
 * @author 薛时鸣
 * @date 18-4-11
 */
@Service
@Transactional
public class FlatServiceImpl implements FlatService{

    @Autowired
    FlatMapper flatMapper;

    @Autowired
    ProvinceMapper provinceMapper;

    @Autowired
    CityMapper cityMapper;

    @Autowired
    StreetMapper streetMapper;

    @Override
    public int addFlat(Flat flat) {
//        flat.setpId("1");
//        flat.setsId("3");
//        flat.setpName("上海市");
        System.out.println("============>"+flat.getpName());
        String pId = provinceMapper.selectPidBypName(flat.getpName());
        String sId = streetMapper.selectsIdBysName(flat.getsName());
        List<Flat> flatCount = flatMapper.selectAll();
        int idCount = flatCount.size();
        flat.setfId(idCount+1);
        flat.setpId(pId);
        flat.setsId(sId);
        return flatMapper.insertSelective(flat);
    }

    @Override
    public List<Flat> selectBysId(String sId) {
         List<Flat> list = flatMapper.selectBysId(sId);
        return  list;
    }

    @Override
    public List<Flat> selectBypName(String pName) {
        return flatMapper.selectBypName(pName);
    }

    @Override
    public List<Flat> combineSelect(Flat flat) {
        return flatMapper.combineSelect(flat);

    }

    @Override
    public List<Flat> selectFlatByfId(String fId) {
        List<Flat> list = flatMapper.selectFlatByfId(fId);
        return list;
    }

    @Override
    public List<Flat> fuzzySearchFlat(Flat flat) {
        return flatMapper.fuzzySearchFlat(flat);
    }

    @Override
    public List<Flat> selectAll(@PathVariable("pageNum") Integer pageNum,
                                @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return flatMapper.selectAll();
    }

    @Override
    public int deleteFlat(Flat flat) {
        return flatMapper.deleteByPrimaryKey(flat);
    }

    @Override
    public int updateFlat(Flat flat) {
        return flatMapper.updateByPrimaryKeySelective(flat);
    }

}
