package com.tdn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * 管理者DAO
 *
 */
public class AdminDAO {
	static final String URL = "jdbc:mysql://localhost/aquarium?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

/**
 *
 * @param adminId 管理者ID
 * @param password 管理者IDのパスワード
 * @return IDとパスワードが不一致の場合null.一致の場合、admin情報(Admin型)
 */
	public Admin login(String adminId,String password) {
		Admin a=null;
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "SELECT*FROM admin WHERE adminId=? and password=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, adminId);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String adminId = rs.getString("adminId");
				String password =rs.getString("password");

				a=new Admin(adminId,password);
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("loginエラー" + e.getMessage());
		}
		return a;
	}
}
