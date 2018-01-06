package com.xsm.flat.exception;

import com.alibaba.fastjson.JSONObject;
import com.xsm.flat.base.JsonResult;
import com.xsm.flat.base.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.validation.ConstraintViolationException;

/**
 * Created by 万文杰 on 2018/1/2.
 * 定义全局异常处理
 * @author 万文杰
 * @date 2018/1/2
 * @RestControllerAdvice 是@controlleradvice 与@ResponseBody 的组合注解
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult constraintViolationException(ConstraintViolationException ex) {
        return new JsonResult(ResultCode.NOT_LOGIN);
    }

    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult IllegalArgumentException(IllegalArgumentException ex) {
        return new JsonResult(ResultCode.PARAMS_ERROR);
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public JsonResult noHandlerFoundException(Exception ex) {
        return new JsonResult(ResultCode.NOT_FOUND);
    }

    @ExceptionHandler(value = { ServletException.class })
    @ResponseStatus(HttpStatus.OK)
    public JsonResult invalidAuthorizationException(Exception ex) {
        return new JsonResult(ResultCode.INVALID_AUTHCODE);
    }

    @ExceptionHandler(value = { DeleteException.class })
    @ResponseStatus(HttpStatus.OK)
    public JsonResult deleteException(Exception ex) {
        return new JsonResult(ResultCode.EXCEPTION,ex.getMessage());
    }

    @ExceptionHandler(value = { RegisterException.class })
    @ResponseStatus(HttpStatus.OK)
    public JsonResult registerException(Exception ex) {
        return new JsonResult(ResultCode.EXCEPTION,ex.getMessage());
    }

/*
    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult unknownException(Exception ex) {
        return new JsonResult(ResultCode., 5002, ex.getMessage());
    }*/
}
