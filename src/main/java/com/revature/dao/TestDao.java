package com.revature.dao;

import java.util.List;
import com.revature.model.Test;

public interface TestDao {

	public void insertTestXML(Test emp);
	public void insertTest(Test emp);
	public void updateTest(int id, String name);
	public Test findTestById(int id);
	public List<Test> getAllTests();
	public void deleteTest(int id);
	
}