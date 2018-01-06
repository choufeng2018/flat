package com.xsm.flat.base;

/**
 * Created by 万文杰 on 2017/10/28.
 *
 * @author 万文杰
 * @date 2017/10/28
 */
public class JsonResult {
    private String code;
    private String message;
    private Object data;

    public JsonResult() {
        this.setCode(ResultCode.SUCCESS);
        this.setMessage("成功！");

    }

    public JsonResult(ResultCode code) {
        this.setCode(code);
        this.setMessage(code.msg());
    }

    public JsonResult(ResultCode code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public JsonResult(ResultCode code, String message, Object data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    public String getCode() {
        return code;
    }
    public void setCode(ResultCode code) {
        this.code = code.val();
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
