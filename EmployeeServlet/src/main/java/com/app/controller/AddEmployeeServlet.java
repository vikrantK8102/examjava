package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.app.dao.EmployeeDao;
import com.app.model.Employee;


@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddEmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String dept = request.getParameter("department");
	        
	        Employee emp = new Employee();
	        emp.setName(name);
	        emp.setEmail(email);
	        emp.setDepartment(dept);
	        
	        try {
	            EmployeeDao dao = new EmployeeDao();
	            dao.insertEmployee(emp);
	            response.sendRedirect("list");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
		doGet(request, response);
	}

}
