package com.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Emp;
import com.dao.EmpDao;
import com.servletdb.ConnectionDB;
 
public class EmpImpl implements EmpDao {

	ConnectionDB connectionDB= new ConnectionDB();
	
	@Override
	public int addEmp(Emp emp) {
		
	 
		int result=0;
		 
		String addQuery="insert into Employee(eName,ePassword,eEmail,eCity) values(?,?,?,?)";
		
		try {
		 
			PreparedStatement preparedStatement=connectionDB.dbConnection().prepareStatement(addQuery);
		   
			preparedStatement.setString(1, emp.geteName());
			preparedStatement.setString(2, emp.getePassword());
			preparedStatement.setString(3, emp.geteEmail());
			preparedStatement.setString(4, emp.geteCity());
				
			   result = preparedStatement.executeUpdate();
			
			System.out.println(result + "Added");
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	
	}

	@Override
	public int updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		
       int result=0;
		
		String updateQuery="update Employee set eName=?,ePassword=?,eEmail=?,eCity=? where eId=?";
		
		try {
			PreparedStatement preparedStatement=connectionDB.dbConnection().prepareStatement(updateQuery);
		   
			
			preparedStatement.setString(1, emp.geteName());
			preparedStatement.setString(2, emp.getePassword());
			preparedStatement.setString(3, emp.geteEmail());
			preparedStatement.setString(4, emp.geteCity());
			
			preparedStatement.setInt(5, emp.geteId());	
			
			 result = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
		
	}

	@Override
	public int deleteEmp(int empId) {
		// TODO Auto-generated method stub
		int result=0;
		
       String deleteQuery="delete from Employee where eId=?";
		
		try {
			PreparedStatement preparedStatement=connectionDB.dbConnection().prepareStatement(deleteQuery);
		   
			 
			preparedStatement.setInt(1, empId);
			
			
			 result = preparedStatement.executeUpdate();
			
			 
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public Emp getSingleEmp(int eId) {
		 Emp emp=new Emp();  
		 
		String getSingleQuery="select * from Employee where eId=?";
		
		try {
			PreparedStatement preparedStatement=connectionDB.dbConnection().prepareStatement(getSingleQuery);
		   
			 
			preparedStatement.setInt(1,eId);
			
			
			ResultSet rs=preparedStatement.executeQuery();  
			
			if (rs.next()) {
				
				emp.seteId(rs.getInt(1));
				emp.seteName(rs.getString(2));
				emp.setePassword(rs.getString(3));
				emp.seteEmail(rs.getString(4));
				emp.seteCity(rs.getString(5));
			}
								 
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	 
		
		
	}

	@Override
	public List<Emp> getAllEmp() {
		
		List<Emp> list=new ArrayList<Emp>();  
		
			String getAllQuery="select * from Employee";
		
		try {
			PreparedStatement preparedStatement=connectionDB.dbConnection().prepareStatement(getAllQuery);
		   
			ResultSet rs=preparedStatement.executeQuery();  
			
			while (rs.next()) {
				 Emp emp=new Emp();  
				emp.seteId(rs.getInt(1));
				emp.seteName(rs.getString(2));
				emp.setePassword(rs.getString(3));
				emp.seteEmail(rs.getString(4));
				emp.seteCity(rs.getString(5));
				
				list.add(emp);
				
			}
								 
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

 

	
	
	
	
	
	
	
}
