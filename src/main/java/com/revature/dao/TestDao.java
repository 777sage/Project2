package com.revature.dao;

import java.util.List;
import com.revature.model.Test;

public interface TestDao {

	public void insertTest(Test emp);
	public void updateTest(String name, String status);
	public Test findTestByName(String name);
	public List<Test> getAllTests();
	public void deleteTest(int id);
	
}