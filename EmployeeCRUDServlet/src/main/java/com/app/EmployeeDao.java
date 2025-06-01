package com.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public static void insert(Employee e) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		String sql = "insert into employees(name,email) values(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, e.getName());
		ps.setString(2, e.getEmail());
		ps.executeUpdate();
		con.close();
	}
	
	public static List<Employee> getAllEmp() throws ClassNotFoundException, SQLException{
		List<Employee> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employees");
		while(rs.next()) {
			Employee e = new Employee();
			e.setId(rs.getInt("id"));
			e.setName(rs.getString("name"));
			e.setEmail(rs.getString("email"));
			list.add(e);
		}
	  con.close();
	  return list;
	}
}
