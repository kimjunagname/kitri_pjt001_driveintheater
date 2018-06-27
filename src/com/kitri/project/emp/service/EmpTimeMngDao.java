package com.kitri.project.emp.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.project.emp.dto.EmpTimeMngDto;
import com.kitri.project.sql.CarSql;

public class EmpTimeMngDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CarSql myCon = null;
	public EmpTimeMngDao() {
		myCon = new CarSql();
	}

	//TODO selectByEmpNo test필요
//	직원이 본인의 근태확인
	public List<EmpTimeMngDto> selectAllByEmpNo(int emp_no){
		List<EmpTimeMngDto> list = new ArrayList<>();
		try {
			con = myCon.connect();
			StringBuffer sql = new StringBuffer("select t.emp_no, e.emp_name, t.emp_intime, t.emp_outtime, j.job_name, b.branch_name ");
			sql.append("from emp_timemanage t, emp_info e, job j, branch b ");
			sql.append("where t.emp_no = ? ");
			sql.append("and e.emp_no = t.emp_no and j.job_no = e.job_no and b.branch_no = e.branch_no ");
			sql.append("order by timemng_no desc");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, emp_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpTimeMngDto dto = new EmpTimeMngDto();
				dto.setEmp_no(rs.getInt("emp_no"));
				dto.setEmp_name((rs.getString("emp_name")));
				dto.setEmp_intime(rs.getString("emp_intime"));
				dto.setEmp_outtime(rs.getString("emp_outtime"));
				dto.setJob_name(rs.getString("job_name"));
				dto.setBranch_name(rs.getString("branch_name"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
			return list;
		}
	}
	
	//TODO selectByBranchNo test필요
//	지점관리자가 관리지점의 직원들의 근태확인
	public List<EmpTimeMngDto> selectAllByBranchNo(int branch_no){
		List<EmpTimeMngDto> list = new ArrayList<>();
		try {
			con = myCon.connect();
			StringBuffer sql = new StringBuffer("select t.emp_no, e.emp_name, t.emp_intime, t.emp_outtime, j.job_name, b.branch_name ");
			sql.append("from emp_timemanage t, emp_info e, job j, branch b ");
			sql.append("where b.branch_no = ? ");
			sql.append("and e.emp_no = t.emp_no and j.job_no = e.job_no and b.branch_no = e.branch_no ");
			sql.append("order by timemng_no desc");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, branch_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpTimeMngDto dto = new EmpTimeMngDto();
				dto.setEmp_no(rs.getInt("emp_no"));
				dto.setEmp_name((rs.getString("emp_name")));
				dto.setEmp_intime(rs.getString("emp_intime"));
				dto.setEmp_outtime(rs.getString("emp_outtime"));
				dto.setJob_name(rs.getString("job_name"));
				dto.setBranch_name(rs.getString("branch_name"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
			return list;
		}
	}
	
	//TODO boolean inTimeByEmpNo(int emp_no) 테스트필요
	//직원번호로 출근여부 확인 - service에서 출근여부 확인 후 출근처리
	public String inTimeByEmpNo(int timemng_no, int emp_no) {
		String inTime = "";
		try {
			con = myCon.connect();
			String sql = "select emp_intime from emp_timemanage where emp_no = ? and timemng_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp_no);
			pstmt.setInt(2, timemng_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				inTime = rs.getString("emp_intime");
				return inTime;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
			return inTime;
			
		}
	}
	
	//TODO boolean outTimeByEmpNo(int emp_no) 테스트필요
	//직원번호로 퇴근여부 확인 - service에서 퇴근여부 확인 후 퇴근처리
	public String outTimeByEmpNo(int timemng_no, int emp_no) {
		String OutTime = "";
		try {
			con = myCon.connect();
			String sql = "select emp_outtime from emp_timemanage where emp_no = ? and timemng_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp_no);
			pstmt.setInt(2, timemng_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				OutTime = rs.getString("emp_outtime");
				return OutTime;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
			return OutTime;
			
		}
	}

	//TODO int workIn(int emp_no) 사원번호로 출근처리 테스트 필요
	public int workIn(int emp_no) {
		int result = 0;
		try {
			con = myCon.connect();
			String sql = "insert into emp_timemanage (timemng_no, emp_no, emp_intime) values(timemng_no_seq.nextval, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp_no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(pstmt, con);
			return result;
		}
		
	}
	//TODO int workOut(int emp_no) 사원번호로 퇴근처리 테스트 필요
	public int workOut(int timeMng_no, int emp_no) {
		int result = 0;
		try {
			con = myCon.connect();
//			String sql = "insert into emp_timemanage (emp_no, emp_outtime) values(?, sysdate)";
			String sql = "update emp_timemanage set emp_outtime = sysdate where emp_no = ? and timemng_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp_no);
			pstmt.setInt(2, timeMng_no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(pstmt, con);
			return result;
		}
	}
	
	public int checkMngNo(int emp_no) {
		int timeMng_no = 0;
		try {
			con = myCon.connect();
			String sql = "select max(timemng_no) timemng_no from emp_timemanage where emp_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				timeMng_no = rs.getInt("timemng_no");
				return timeMng_no;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
			return timeMng_no;
		}
	}
}
