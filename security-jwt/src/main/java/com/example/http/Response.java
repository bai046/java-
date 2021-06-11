package com.example.http;

/**
 * 响应类
 */
public class Response<T> {

	private Integer code;
	private String msg;
	private T data;
	
	public Response(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Response() {
		this.init(true, null, null);
	}
	
	public Response(boolean isOk) {
		this.init(isOk, null, null);
	}

	public Response(boolean isOk, Error error) {
		this.init(isOk, error, null);
	}
	
	public Response(boolean isOk, T data) {
		this.init(isOk, null, data);
	}

	public Response(boolean isOk, Error error, T data) {
		this.init(isOk, error, data);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public void init(boolean isOk, Error error, T data) {
		this.code = isOk ? Error.SUCCESS.getCode()
				: (error == null ? Error.FAILURE.getCode() : error.getCode());
		this.msg = isOk ? Error.SUCCESS.getMsg()
				: (error == null ? Error.FAILURE.getMsg() : error.getMsg());
		this.data = data;
	}

}
