package com.xsm.flat.utils;

import java.util.UUID;

/**
 * Created by 薛时鸣 on 2018/5/5.
 */
public class UUIDUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
