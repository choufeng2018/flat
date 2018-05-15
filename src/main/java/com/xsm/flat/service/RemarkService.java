package com.xsm.flat.service;

import org.springframework.stereotype.Service;

/**
 * Created by 薛时鸣 on 2018/5/15.
 */
@Service
public interface RemarkService {
    int insertRemark(Integer fId, String rSendname, String rInfo);
}
