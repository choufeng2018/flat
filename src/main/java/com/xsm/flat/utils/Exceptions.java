package com.xsm.flat.utils;

/**
 * Created by 薛时鸣 on 2017-10-11.
 * description:异常的工具类.
 */


public class Exceptions {



    /**
      * 将CheckedException转换为UncheckedException.
      */
    public static RuntimeException unchecked(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e);
        }
    }
}
