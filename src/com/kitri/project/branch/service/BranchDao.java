package com.kitri.project.branch.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.project.sql.CarSql;

public class BranchDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CarSql myCon = null;

	public BranchDao() {
		myCon = new CarSql();
	}

	public List<String> selectBranchNameAll() {
		List<String> list = new ArrayList<>();
		try {
			con = myCon.connect();
			String sql = "select branch_name from branch";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("branch_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
			return list;
		}
	}

}
