package com.xsm.flat.service.impl;

import com.xsm.flat.dao.AssumpsitMapper;
import com.xsm.flat.entity.Assumpsit;
import com.xsm.flat.service.AssumpsitService;
import com.xsm.flat.utils.IdGen;
import com.xsm.flat.utils.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/6.
 */
@Service
@Transactional
public class AssumpsitServiceImpl implements AssumpsitService {

    @Autowired
    AssumpsitMapper assumpsitMapper;

    @Override
    public Boolean insertAssumpsit(String uId,Integer fId, String assStarttime) {
        Boolean isExist = assumpsitMapper.assCheck(fId, assStarttime);
        if(!isExist){
            Assumpsit assumpsit = new Assumpsit(IdGen.uuid(),fId,uId,assStarttime);
            assumpsitMapper.insertSelective(assumpsit);
            return true;
        }
        return false;
    }

    @Override
    public List<String> getAllTimeByFid(Integer fId) {
        return assumpsitMapper.getAllTimeByFid(fId);
    }

    @Override
    public List<Assumpsit> getAssInfoByUid(String uId) {

        return assumpsitMapper.getAssInfoByUid(uId);
    }

    @Override
    public int deleteInfoByFid(String assId) {
        return assumpsitMapper.deleteByPrimaryKey(assId);
    }
}
