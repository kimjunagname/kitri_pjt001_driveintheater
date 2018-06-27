package com.kitri.project.supermanager.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.StatementEvent;

public class SuperVisorConnectionProvider {

	public static Connection getConnection() {
		// 드라이버 메모리로 로드하고, 서버에 연결하는 반복된 동작을 묶음.
		try {
			// 1. jdbc 드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db Server에 연결한다.
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "car", "car");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static void close(ResultSet rs, Statement stmt, Connection conn) { // 닫는 동작도 반복되어 묶음​
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
		}
	}
}