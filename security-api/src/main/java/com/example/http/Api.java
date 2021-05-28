package com.example.http;

/**
 * 接口类
 */
public class Api {

	public static <T> Response<T> success() {
		return new Response<T>();
	}
	
	public static <T> Response<T> success(T data) {
		return new Response<T>(true, null, data);
	}
	
	public static <T> Response<T> failure(Error error) {
		return new Response<T>(false, error);
	}
	
	public static <T> Response<T> failure(int code, String msg) {
		return new Response<T>(code, msg, null);
	}
	
	public static <T> Response<T> failure(Error error, T data) {
		return new Response<T>(false, error, data);
	}
	
}
