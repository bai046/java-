package com.example.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtils {
	
	public static String toJSONString(Object object) {
		return toJSONString(object, false);
	}
	
	public static String toJSONString(Object object, boolean isFiltNullValue) {
		if (!isFiltNullValue) {
			return JSON.toJSONString(object, SerializerFeature.WriteMapNullValue);
		}
		return JSON.toJSONString(object);
	}

}
