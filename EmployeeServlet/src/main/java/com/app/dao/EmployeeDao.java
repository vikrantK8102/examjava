package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.app.model.Employee;

public class EmployeeDao {

	

	    private String jdbcURL = "jdbc:mysql://localhost:3306/vikrant";
	    private String jdbcUsername = "root";
	    private String jdbcPassword = "Goodlu@124";

	    private Connection getConnection() throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	    }

	    public List<Employee> getAllEmployees() throws Exception {
	        List<Employee> list = new ArrayList<>();
	        String sql = "SELECT * FROM employee";
	        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Employee e = new Employee();
	                e.setId(rs.getInt("id"));
	                e.setName(rs.getString("name"));
	                e.setEmail(rs.getString("email"));
	                e.setDepartment(rs.getString("department"));
	                list.add(e);
	            }
	        }
	        return list;
	    }

	    public void insertEmployee(Employee emp) throws Exception {
	        String sql = "INSERT INTO employee (name, email, department) VALUES (?, ?, ?)";
	        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, emp.getName());
	            ps.setString(2, emp.getEmail());
	            ps.setString(3, emp.getDepartment());
	            ps.executeUpdate();
	        }
	    }

	    public void deleteEmployee(int id) throws Exception {
	        String sql = "DELETE FROM employee WHERE id = ?";
	        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, id);
	            ps.executeUpdate();
	        }
	    }

	    public Employee getEmployeeById(int id) throws Exception {
	        String sql = "SELECT * FROM employee WHERE id = ?";
	        Employee emp = new Employee();
	        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                emp.setId(rs.getInt("id"));
	                emp.setName(rs.getString("name"));
	                emp.setEmail(rs.getString("email"));
	                emp.setDepartment(rs.getString("department"));
	            }
	        }
	        return emp;
	    }

	    public void updateEmployee(Employee emp) throws Exception {
	        String sql = "UPDATE employee SET name=?, email=?, department=? WHERE id=?";
	        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, emp.getName());
	            ps.setString(2, emp.getEmail());
	            ps.setString(3, emp.getDepartment());
	            ps.setInt(4, emp.getId());
	            ps.executeUpdate();
	        }
	    }
	}


