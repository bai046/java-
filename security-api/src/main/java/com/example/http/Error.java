package com.example.http;

/**
 * 错误类
 */
public enum Error {
  SUCCESS(200, "成功"),
  FAILURE(1000, "失败"),
  
  /* 参数错误：1001～1999 */
  PARAM_NOT_VALID(1001, "参数无效"),
  PARAM_IS_BLANK(1002, "参数为空"),
  PARAM_TYPE_ERROR(1003, "参数类型错误"),
  PARAM_NOT_COMPLETE(1004, "参数缺失"),

  /* 用户错误 */
  USER_NOT_LOGIN(2001, "用户未登录"),
  USER_ACCOUNT_EXPIRED(2002, "账号已过期"),
  USER_CREDENTIALS_ERROR(2003, "密码错误"),
  USER_CREDENTIALS_EXPIRED(2004, "密码过期"),
  USER_ACCOUNT_DISABLE(2005, "账号不可用"),
  USER_ACCOUNT_LOCKED(2006, "账号被锁定"),
  USER_ACCOUNT_NOT_EXIST(2007, "账号不存在"),
  USER_ACCOUNT_ALREADY_EXIST(2008, "账号已存在"),
  USER_ACCOUNT_USE_BY_OTHERS(2009, "账号下线"),
  USER_NO_PERMISSION(2010, "没有权限");
	
  /* 业务错误 */
	
	private Integer code;
  private String msg;
  
	Error(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
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

	/**
	 * 获取code对应的消息
	 * @param code
	 * @return
	 */
	public static String getMsgByCode(Integer code) {
		for (Error item : values()) {
			if (item.getCode().equals(code)) {
				return item.getMsg();
			}
		}
		return null;
	}
	
}
