package com.xsm.flat.utils;

import com.github.pagehelper.PageInfo;
import com.xsm.flat.base.JsonResult;
import com.xsm.flat.base.ResultCode;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 万文杰 on 2017/10/11.
 */
public class WebUtil {

    /**
     * 判断是否是ajax 请求
     * @param request
     * @return
     */
    public static boolean  isAjaxRequest(HttpServletRequest request){
        return ("XMLHttpRequest".equalsIgnoreCase(request
                .getHeader("X-Requested-With")));
    }

    public static PageInfo initPage(PageInfo pageInfo){
        if(pageInfo.getPageNum()==0){pageInfo.setPageNum(1);}
        if(pageInfo.getPageSize()==0){pageInfo.setPageSize(10);}
        return pageInfo;
    }


    public static Object returnJson(int result){
        switch (result){
            case 0:return WebUtil.exception();
            default:return WebUtil.success(null);
        }
    }


    public static Object returnJson(boolean bool,int result){
        if(bool){
            return WebUtil.paramError();
        }else{
            switch (result){
                case 0:return WebUtil.exception();
                default:return WebUtil.success(null);
            }
        }
    }

    public static Object returnJson(boolean bool,List result){
        if(bool){
            return WebUtil.paramError();
        }else{
            return WebUtil.success(result);
        }
    }

    public static JsonResult paramError(){
        return new JsonResult(ResultCode.PARAMS_ERROR,ResultCode.PARAMS_ERROR.msg(),null);
    }
    public static JsonResult paramError(ResultCode resultCode){
        return new JsonResult(resultCode,resultCode.msg(),null);
    }
    public static JsonResult sysError(){
        return new JsonResult(ResultCode.SYS_ERROR,ResultCode.SYS_ERROR.msg(),null);
    }
    public static JsonResult exception(){
        return new JsonResult(ResultCode.EXCEPTION,ResultCode.EXCEPTION.msg(),null);
    }
    public static JsonResult success(Object obj){
        return new JsonResult(ResultCode.SUCCESS,ResultCode.SUCCESS.msg(),obj);
    }
}
