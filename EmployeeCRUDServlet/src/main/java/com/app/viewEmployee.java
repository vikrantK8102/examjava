package com.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/view")
public class viewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public viewEmployee() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("/text/html");
		PrintWriter out = response.getWriter();
		try {
			List<Employee> list;
			list = EmployeeDao.getAllEmp();
					out.print("<h2>All Employees</h2>");
					out.print("<table><tr><th>Id</th><th>Name</th><th>Email</th></tr></table>");
					for(Employee e:list) {
						out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td></tr>");
						out.print("</table></br>");
						out.print("<a href='add.html'>add emp</a>");
					}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
			} 
			
			
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
