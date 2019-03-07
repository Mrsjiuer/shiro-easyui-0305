package com.test.ssm.util;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestUtil {

	public static String getString(HttpServletRequest request, String name) {
		String s = request.getParameter(name);
		if (s != null && s.trim().length() > 0) {

			try {
				return s;
			} catch (Exception e) {
			}

		}
		return null;
	}
	public static Integer getInt(HttpServletRequest request, String name) {
		String s = request.getParameter(name);
		if (s != null && s.trim().length() > 0) {

			try {
				return Integer.parseInt(s);
			} catch (Exception e) {
			}

		}
		return null;
	}

	public static Date getDate(HttpServletRequest request, String name,
			String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String s = request.getParameter(name);
		if (s != null && s.trim().length() > 0) {

			try {
				return format.parse(s);
			} catch (Exception e) {
			}

		}
		return null;
	}
}
