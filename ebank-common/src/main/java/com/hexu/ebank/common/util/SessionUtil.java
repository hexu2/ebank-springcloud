package com.hexu.ebank.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SessionUtil {
	
	private static Map<HttpSession,String> sessionMap = new HashMap<HttpSession,String>();

	public static Map<HttpSession, String> getSessionMap() {
		return sessionMap;
	}


}
