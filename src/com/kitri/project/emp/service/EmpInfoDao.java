package com.kitri.project.emp.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.project.emp.dto.EmpInfoDto;
import com.kitri.project.sql.CarSql;

public class EmpInfoDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CarSql myCon = null;

	public EmpInfoDao() {
		myCon = new CarSql();
	}

	public int insertEmp(EmpInfoDto emp) {
		int cnt = 0;
		try {
			con = myCon.connect();
			String sql = "insert into emp_info values(emp_no_seq.nextval, ?, ?, ?, to_date(?, 'yyyymmdd'), ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emp.getEmp_id());
			pstmt.setString(2, emp.getEmp_pwd());
			pstmt.setString(3, emp.getEmp_name());
			pstmt.setString(4, emp.getEmp_birth());
			pstmt.setString(5, emp.getEmp_email());
			pstmt.setString(6, emp.getEmp_phone());
			pstmt.setInt(7, emp.getJob_no());
			pstmt.setInt(8, emp.getBranch_no());
			cnt = pstmt.executeUpdate();
//			System.out.println(cnt);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(pstmt, con);
		}
		return cnt;
	}

	public int updateEmp(EmpInfoDto emp) {
		int result = 0;
		try {
			con = myCon.connect();
			String sql = "update emp_info set emp_pwd = ?, emp_birth = to_date(?, 'yyyymmdd'), emp_phone = ? where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emp.getEmp_pwd());
			pstmt.setString(2, emp.getEmp_birth());
			pstmt.setString(3, emp.getEmp_phone());
			pstmt.setString(4, emp.getEmp_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(pstmt, con);
		}
		return result;
	}

	public void deleteEmp(EmpInfoDto emp) {

	}

	public EmpInfoDto selectByName(String name) {
		EmpInfoDto emp = null;
		try {
			con = myCon.connect();
			String sql = "select * from emp_info where emp_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				emp = new EmpInfoDto();
				emp.setEmp_no(rs.getInt("emp_no"));
				emp.setEmp_id(rs.getString("emp_id"));
				emp.setEmp_pwd(rs.getString("emp_pwd"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_birth(rs.getString("emp_birth"));
				emp.setEmp_email(rs.getString("emp_email"));
				emp.setEmp_phone(rs.getString("emp_phone"));
				emp.setJob_no(rs.getInt("job_no"));
				emp.setBranch_no(rs.getInt("branch_no"));
			} else {
				//TODO service에서 처리
				System.out.println("E_I_Dao "+name + "과 일치하는 직원은 없습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
		}
		return emp;
	}

	public EmpInfoDto selectByNo(int no) {
		EmpInfoDto emp = null;
		try {
			con = myCon.connect();
			String sql = "select e.emp_no, e.emp_id, e.emp_pwd, e.emp_name, to_char(e.emp_birth, 'yyyymmdd') emp_birth, e.emp_email, e.emp_phone, e.job_no, j.job_name, e.branch_no, b.branch_name from emp_info e, job j, branch b where emp_no = ? and e.job_no = j.job_no and e.branch_no = b.branch_no";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				emp = new EmpInfoDto();
				emp.setEmp_no(rs.getInt("emp_no"));
				emp.setEmp_id(rs.getString("emp_id"));
				emp.setEmp_pwd(rs.getString("emp_pwd"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_birth(rs.getString("emp_birth"));
				emp.setEmp_email(rs.getString("emp_email"));
				emp.setEmp_phone(rs.getString("emp_phone"));
				emp.setJob_no(rs.getInt("job_no"));
				emp.setJob_name(rs.getString("job_name"));
				emp.setBranch_no(rs.getInt("branch_no"));
				emp.setBranch_name(rs.getString("branch_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
		}
		return emp;
	}

	public EmpInfoDto selectById(String id) {
		EmpInfoDto emp = null;
		try {
			con = myCon.connect();
			String sql = "select emp_no, emp_id, emp_pwd, emp_name, emp_birth, emp_email, emp_phone, job_no, branch_no from emp_info where emp_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				emp = new EmpInfoDto();
				emp.setEmp_no(rs.getInt("emp_no"));
				emp.setEmp_id(rs.getString("emp_id"));
				emp.setEmp_pwd(rs.getString("emp_pwd"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_birth(rs.getString("emp_birth"));
				emp.setEmp_email(rs.getString("emp_email"));
				emp.setEmp_phone(rs.getString("emp_phone"));
				emp.setJob_no(rs.getInt("job_no"));
				emp.setBranch_no(rs.getInt("branch_no"));
			} else {
				//TODO service에서 처리
				System.out.println(id + "과 일치하는 직원은 없습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
		}
		return emp;
	}

	public EmpInfoDto selectByEmail(String email) {
		EmpInfoDto emp = null;
		try {
			con = myCon.connect();
			String sql = "select * from emp_info where email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				emp = new EmpInfoDto();
				emp.setEmp_no(rs.getInt("emp_no"));
				emp.setEmp_id(rs.getString("emp_id"));
				emp.setEmp_pwd(rs.getString("emp_pwd"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_birth(rs.getString("emp_birth"));
				emp.setEmp_email(rs.getString("emp_email"));
				emp.setEmp_phone(rs.getString("emp_phone"));
				emp.setJob_no(rs.getInt("job_no"));
				emp.setBranch_no(rs.getInt("branch_no"));
			} else {
				//TODO service에서 처리
				System.out.println("dao" + email + "과 일치하는 직원은 없습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
		}
		return emp;
	}

	public ArrayList<EmpInfoDto> selectEmpAll() {
		ArrayList<EmpInfoDto> list = new ArrayList<>();
		try {
			con = myCon.connect();
			String sql = "select * from emp_info";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpInfoDto emp = new EmpInfoDto();
				emp.setEmp_no(rs.getInt("emp_no"));
				emp.setEmp_id(rs.getString("emp_id"));
				emp.setEmp_pwd(rs.getString("emp_pwd"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_birth(rs.getString("emp_birth"));
				emp.setEmp_email(rs.getString("emp_email"));
				emp.setEmp_phone(rs.getString("emp_phone"));
				emp.setJob_no(rs.getInt("job_no"));
				emp.setBranch_no(rs.getInt("branch_no"));
				list.add(emp);
			}
			//TODO service에서 처리
			System.out.println("dao 직원이 존재하지 않습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
		}
		return list;
	}

	public EmpInfoDto login(String id, String pwd) {
		EmpInfoDto emp = null;
		try {
			con = myCon.connect();
			String sql = "select e.emp_no, e.emp_id, e.emp_pwd, e.emp_name, to_char(e.emp_birth, 'yyyymmdd') emp_birth, e.emp_email, e.emp_phone, e.job_no, j.job_name, e.branch_no, b.branch_name from emp_info e, job j, branch b where emp_id=? and emp_pwd=? and e.job_no = j.job_no and e.branch_no = b.branch_no";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				emp = new EmpInfoDto();
				emp.setEmp_no(rs.getInt("emp_no"));
				emp.setEmp_id(rs.getString("emp_id"));
				emp.setEmp_pwd(rs.getString("emp_pwd"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_birth(rs.getString("emp_birth"));
				emp.setEmp_email(rs.getString("emp_email"));
				emp.setEmp_phone(rs.getString("emp_phone"));
				emp.setJob_no(rs.getInt("job_no"));
				emp.setJob_name(rs.getString("job_name"));
				emp.setBranch_no(rs.getInt("branch_no"));
				emp.setBranch_name(rs.getString("branch_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
		}
		return emp;
	}

	public boolean isNotExistId(String id) {				
		boolean flag = false;
		try {
			con = myCon.connect();
			String sql = "select emp_id from emp_info where emp_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				flag = true;				//id가 존재하면 true
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
			System.out.println("E_I_Dao "+flag);
		}
		return flag;
	}

	public boolean isNotExistEmail(String email) {
		boolean flag = false;
		try {
			con = myCon.connect();
			String sql = "select emp_email from emp_info where emp_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
		}
		return flag;
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
		}
		return list;
	}
}
