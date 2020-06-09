package com.tdn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * 入館日DAO
 *
 */
public class TimeTableDAO {
	// 定数宣言
	static final String URL =  "jdbc:mysql://localhost/aquarium?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

	/**
	 *
	 * @param t 入館日情報
	 *
	 */

	public void insert(TimeTable t) {
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			//SQL文定義
			String sql = "INSERT INTO date_table (did,uid,date) VALUES(0,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			//各?部分にユーザ情報を挿入
			stmt.setInt(1,t.getUid());
			stmt.setTimestamp(2, t.getDate());

			//SQL文を実行
			stmt.execute();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("insertエラー" + e.getMessage());
		}
	}
}
