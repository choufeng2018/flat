package com.xsm.flat.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AjaxResponse {

	private String state;

    private String message ;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	private Boolean success;

    private Object data;
    
    private final String SUCCESS_STATE="200";
    
    private final String ERROR_STATE="999";

	private Object page = new Object();

    public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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

	public Object getPage() {
		return page;
	}

	public void setPage(Object page) {
		this.page = page;
	}

	/**
     * 成功提示
     * @param success
     * @param data //后端数据
     */
    public void  setSuccessMessage(Boolean success, List data){
    	this.setState(SUCCESS_STATE);
        this.setSuccess(success);
        this.setData(data);// page 里重复返回
        this.setMessage("查询完毕");
    }
    
    /**
     * 失败提示
     * @param message
     * @param result
     */
    public void  setErrorMessage(String message, Object result){
    	this.setState(ERROR_STATE);
        this.setMessage(message);
        this.setData(result);
    }

	/**
	 * 更新数据成功
	 */
	public void  setSuccessMessageUpdate(){
		this.setState(SUCCESS_STATE);
		this.setMessage("更新数据成功");
		this.setSuccess(true);
		this.setData("null");
	}


}
