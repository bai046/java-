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
	
	public static <T> Response<T> failure(Error error, T data) {
		return new Response<T>(false, error, data);
	}
	
}
