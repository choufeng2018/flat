package com.xsm.flat.service;

import com.xsm.flat.entity.Remark;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/15.
 */
@Service
public interface RemarkService {
    int insertRemark(Integer fId, String rSendname, String rInfo);

    List<Remark> getAllRemark(String uName);
}
