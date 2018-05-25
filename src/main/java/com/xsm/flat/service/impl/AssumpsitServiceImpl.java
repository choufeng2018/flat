package com.xsm.flat.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsm.flat.dao.AssumpsitMapper;
import com.xsm.flat.entity.Assumpsit;
import com.xsm.flat.service.AssumpsitService;
import com.xsm.flat.utils.IdGen;
import com.xsm.flat.utils.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

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
        Boolean isExist = assumpsitMapper.assCheck(uId, fId, assStarttime);
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

    @Override
    public int assOnOff(String uId, Integer fId) {
        Assumpsit assumpsit = new Assumpsit(uId,fId);
        assumpsit.setAssOnOff("0");
        System.out.println("------"+assumpsit.getuId());
        return assumpsitMapper.updateByUidFid(assumpsit);
    }

    @Override
    public List<Assumpsit> getAssPage(@PathVariable("pageNum") Integer pageNum,
                                      @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return assumpsitMapper.getAssPage();
    }

    @Override
    public int updateAssPass(Assumpsit assumpsit) {
        assumpsit.setAssStatus("1");
        return assumpsitMapper.updateByPrimaryKeySelective(assumpsit);
    }
}
