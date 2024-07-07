package com.servletfile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Emp;
import com.impl.EmpImpl;

 
@SuppressWarnings("serial")
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();  
		
		
		String eName=req.getParameter("eName");
		String ePassword=req.getParameter("ePassword");
		String eEmail=req.getParameter("eEmail");
		String eCity=req.getParameter("eCity");
		
		Emp obj=new Emp();
		
		obj.seteName(eName);
		obj.setePassword(ePassword);
		obj.seteEmail(eEmail);
		obj.seteCity(eCity);
		
		
		EmpImpl empImpl=new EmpImpl();
		
		
		int status=empImpl.addEmp(obj);
		
		if (status>0) {
			
			out.print("<h2> Record Saved Successfully</h2>");
			
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("index.html");
			requestDispatcher.include(req, resp);
			
		}
		
		else
		{
			out.print("Sorry ! unable to save record");
		}
		
		
		
		
		
	}
	 
	 

}
