package com.kitri.project.cartype;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.project.sql.CarSql;

public class CarTypeDao {
	Connection con;
	Statement stmt;
	ResultSet rs;
	CarSql myCon;

	public CarTypeDao() {
		myCon = new CarSql();
	}

	public List<String> selectCarTypeNameAll() {
		List<String> list = new ArrayList<String>();
		try {
			con = myCon.connect();
			String sql= "select * from CAR_MANAGE";
			stmt= con.createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString("cartype_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, stmt, con);
		}
		return list;
	}
}
