package com.dao;

import java.util.List;

import com.bean.Emp;

public interface EmpDao {

	
	public int addEmp(Emp emp);
	public int updateEmp(Emp emp);
	public int deleteEmp(int empId);
	public Emp getSingleEmp(int eId);
	public List<Emp> getAllEmp();
	
	
	
}
