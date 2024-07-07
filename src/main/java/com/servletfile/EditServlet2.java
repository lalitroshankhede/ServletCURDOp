package com.servletfile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Emp;
import com.impl.EmpImpl;

 
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  response.setContentType("text/html");  
		  PrintWriter out=response.getWriter();  
		
		  String sid=request.getParameter("eId");
		  int id=Integer.parseInt(sid);  
		  
		  String name=request.getParameter("eName");  
	        String password=request.getParameter("ePassword");  
	        String email=request.getParameter("eEmail");  
	        String city=request.getParameter("eCity");  
	        
	        Emp emp=new Emp();  
	        emp.seteId(id);
	        emp.seteName(name);
	        emp.setePassword(password);
	        emp.seteEmail(email);
	        emp.seteCity(city);
	        
	        
	        EmpImpl empImpl=new EmpImpl();
	        
	        int result=empImpl.updateEmp(emp);
	        
	        if (result>0) {
				
	        	response.sendRedirect("ViewServlet");
			}
	        else{  
	            out.println("Sorry! unable to update record");  
	        }  
	        
	        
		
		  
		
	}

}
