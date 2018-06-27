package com.kitri.project.superadmin.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.StatementEvent;

public class SuperVisorConnectionProvider {

	public static Connection getConnection() {
		// ?“œ?¼?´ë²? ë©”ëª¨ë¦¬ë¡œ ë¡œë“œ?•˜ê³?, ?„œë²„ì— ?—°ê²°í•˜?Š” ë°˜ë³µ?œ ?™?‘?„ ë¬¶ìŒ.
		try {
			// 1. jdbc ?“œ?¼?´ë²„ë?? ë©”ëª¨ë¦¬ë¡œ ë¡œë“œ?•œ?‹¤.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db Server?— ?—°ê²°í•œ?‹¤.
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "car", "car");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static void close(ResultSet rs, Statement stmt, Connection conn) { // ?‹«?Š” ?™?‘?„ ë°˜ë³µ?˜?–´ ë¬¶ìŒ??
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