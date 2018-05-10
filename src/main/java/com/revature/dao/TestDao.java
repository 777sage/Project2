package com.revature.dao;

import java.util.List;
import com.revature.model.Test;

public interface TestDao {

	public boolean insertTest(Test emp);
	public boolean updateTest(String name, String status);
	public Test findTestByName(String name);
	public List<Test> getAllTests();
	public boolean deleteTest(int id);
	
}