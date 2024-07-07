package com.servletfile;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.impl.EmpImpl;

 
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		 String sid=request.getParameter("eId");  
	        int id=Integer.parseInt(sid);  
	        
	        
	        EmpImpl empImpl=new EmpImpl();
	        
	        empImpl.deleteEmp(id);
	        
	        
	        response.sendRedirect("ViewServlet");
		
	        
		
	}

}
