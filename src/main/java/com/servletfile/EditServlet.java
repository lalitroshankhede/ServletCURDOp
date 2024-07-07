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

 
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	 
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<h1>Update Employee</h1>");  
		
		
	        String uid=request.getParameter("eId");
	        
	        int empId=Integer.parseInt(uid);
	        
	        
	        EmpImpl empImpl=new EmpImpl();
	        
	        
	        Emp emp=empImpl.getSingleEmp(empId);
	        
	        
	        out.print("<form action='EditServlet2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='eId' value='"+emp.geteId()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='eName' value='"+emp.geteName()+"'/></td></tr>");  
	        out.print("<tr><td>Password:</td><td><input type='password' name='ePassword' value='"+emp.getePassword()+"'/></td></tr>");  
	        out.print("<tr><td>Email:</td><td><input type='email' name='eEmail' value='"+emp.geteEmail()+"'/></td></tr>");  
	        out.print("<tr><td>City:</td><td>");  
	        out.print("<select name='eCity' style='width:150px'>");  
	        out.print("<option>Nagpur</option>");  
	        out.print("<option>Delhi</option>");  
	        out.print("<option>Mumbai</option>");  
	        out.print("<option>Pune</option>");  
	        out.print("</select>");  
	        out.print("</td></tr>");  
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	        
	        
	        
	        
	}

}
