package com.tdn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
	static final String URL = "jdbc:mysql://localhost/aquarium?useSSL=false";
	static final String USER = "java";
	static final String PASS = "Pass";

	public Admin login(String adminid,String password) {
		Admin a=null;
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "SELECT*FROM admin WHERE adminid=? and password=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, adminid);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String adminid = rs.getString("adminid");
				String password =rs.getString("password");

				a=new Admin(adminid,password);
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("loginエラー" + e.getMessage());
		}
		return a;
	}
}
