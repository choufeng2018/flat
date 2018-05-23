package com.xsm.flat.service;

import com.xsm.flat.entity.Street;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 薛时鸣 on 2018/5/23.
 */
@Service
public interface StreetService {

    List<Street> getNameByCid(Street street);
}
