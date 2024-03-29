package com.test.ssm.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class JsonUtil {
	/**
	 * 将Java对象转化为JSON字符�?
	 */
	public static String getJSON(Object obj) {
		if (null == obj) {
			return "";
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			// 转换date类型的时候，时间�?
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			String jsonStr = mapper.writeValueAsString(obj);
			return jsonStr;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 将JSON字符串转化为Java对象，集�?
	 */
	public static <T> T getObj(String json, TypeReference<T> ref) throws IOException {
		if (null == json || json.length() == 0) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		return (T) mapper.readValue(json, ref);
	}

	/**
	 * 将JSON字符串转化为Java对象，一个对�?
	 */
	public static Object getObj(String json, Class pojoClass) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			return mapper.readValue(json, pojoClass);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
