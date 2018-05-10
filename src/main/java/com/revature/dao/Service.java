package com.revature.dao;

import java.util.List;

import com.revature.model.Test;

public class Service {
	static TestDaoImpl test = new TestDaoImpl();
	public static boolean insertTest(Test tst) {
		return test.insertTest(tst);
	}
	public static boolean updateTest(String name, String status) {
		return test.updateTest(name, status);
	}
	public static Test findTestByName(String name) {
		return test.findTestByName(name);
	}
	public static List<Test> getAllTests(){
		return test.getAllTests();
	}
}
