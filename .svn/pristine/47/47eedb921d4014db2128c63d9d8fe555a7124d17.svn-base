package com.kitri.project.job.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.project.sql.CarSql;

public class JobDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CarSql myCon = null;

	public JobDao() {
		myCon = new CarSql();
	}

	public List<String> selectJobNameAll() {
		List<String> list = new ArrayList<>();
		try {
			con = myCon.connect();
			String sql = "select job_name from job";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("job_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
			return list;
		}
	}

}
