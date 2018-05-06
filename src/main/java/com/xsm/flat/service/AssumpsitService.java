package com.xsm.flat.service;

import com.xsm.flat.entity.Assumpsit;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/6.
 */
@Service
public interface AssumpsitService {
    Boolean insertAssumpsit(String uId,Integer fId, String assStarttime);
    List<String> getAllTimeByFid(Integer fId);
}
