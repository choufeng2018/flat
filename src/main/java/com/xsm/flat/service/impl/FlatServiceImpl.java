package com.xsm.flat.service.impl;

import com.xsm.flat.dao.FlatMapper;
import com.xsm.flat.entity.Flat;
import com.xsm.flat.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private FlatMapper flatMapper;

    @Override
    public int addFlat(Flat flat) {
        flat.setpId("1");
        flat.setsId("3");
        return flatMapper.insert(flat);
    }
}
