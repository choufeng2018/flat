package com.xsm.flat.utils;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;


/**
 * Created by 薛时鸣 on 17-10-11.
 */
public class IdGen {
    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String genTradeNum() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String str = df.format(now) + System.currentTimeMillis();
        return str;
    }

    public static String genOrdersNum() {
        Random random = new Random();
        String s = random.nextInt(10) + "";
        String str = s + System.currentTimeMillis();
        return str;
    }
}
