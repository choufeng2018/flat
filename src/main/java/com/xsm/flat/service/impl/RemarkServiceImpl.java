package com.xsm.flat.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsm.flat.dao.FlatMapper;
import com.xsm.flat.dao.RemarkMapper;
import com.xsm.flat.dao.UserMapper;
import com.xsm.flat.entity.Remark;
import com.xsm.flat.service.RemarkService;
import com.xsm.flat.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/15.
 */
@Service
@Transactional
public class RemarkServiceImpl implements RemarkService{

    @Autowired
    RemarkMapper remarkMapper;

    @Autowired
    FlatMapper flatMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public int insertRemark( Integer fId, String rSendname, String rInfo) {

        String uId = flatMapper.selectUIdByfId(fId);
        //根据uId查询房子拥有者信息
        String rBelongname = userMapper.selectUserNameByUid(uId);
        Remark remark = new Remark(IdGen.uuid(), fId, rSendname, rBelongname, rInfo);
        return remarkMapper.insertSelective(remark);
    }

    @Override
    public List<Remark> getAllRemark(String uName) {
        return remarkMapper.getAllRemark(uName);
    }

    @Override
    public List<Remark> getRemarkPage(@PathVariable("pageNum") Integer pageNum,
                                      @PathVariable("pageSize") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        return remarkMapper.getRemarkPage();
    }
}
