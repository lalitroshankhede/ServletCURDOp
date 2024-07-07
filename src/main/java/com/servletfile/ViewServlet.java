package com.servletfile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Emp;
import com.impl.EmpImpl;

 
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
		
        
        
		EmpImpl empImpl=new EmpImpl();
		
		List<Emp> list=empImpl.getAllEmp();
		
		out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>City</th> <th>Edit</th><th>Delete</th></tr>");  
        
        for (Emp emp : list) {
			
        	out.print("<tr><td>"+emp.geteId()+"</td><td>"+emp.geteName()+"</td><td>"+emp.getePassword()+"</td> <td>"+emp.geteEmail()+"</td><td>"+emp.geteCity()+"</td><td><a href='EditServlet?eId="+emp.geteId()+"'>edit</a></td>  <td><a href='DeleteServlet?eId="+emp.geteId()+"'>delete</a></td></tr>");  
		}
        
	}

}
