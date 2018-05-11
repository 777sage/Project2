package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.Service;

public class RequestHelper {
	
	public static Object oprocess(HttpServletRequest request) {
		System.out.println("Finding Object");
		switch(request.getRequestURI()) {
		case "/Project2/getAllTests.do":
			System.out.println("getAllTests");
			Object obj = getAllTests();
			System.out.println(obj);
			return obj;
		default:
			System.out.println("default");
			return "404.jsp";
		}
	}
	public static Object getAllTests() {
		System.out.println("Getting All Tests");
		return Service.getAllTests();
	}
}
