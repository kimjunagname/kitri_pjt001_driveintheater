package com.kitri.project.emp.service;

import java.util.List;

import com.kitri.project.emp.dto.EmpTimeMngDto;

public class EmpTimeMngService {
	EmpTimeMngDao dao;

	public EmpTimeMngService() {
		this.dao = new EmpTimeMngDao();
	}

	public List<EmpTimeMngDto> checkAllByEmpNo(int emp_no) {
		return dao.selectAllByEmpNo(emp_no);
	}

	public List<EmpTimeMngDto> checkAllByBranchNo(int branch_no) {
		return dao.selectAllByBranchNo(branch_no);
	}
	
	//TODO 로그인시/출근버튼액션 시 출근여부 확인 후 출근처리를 위함 
	public String checkInTimeByEmpNo(int timemng_no, int emp_no) {
		return dao.inTimeByEmpNo(timemng_no, emp_no);
	}

	//TODO 로그아웃시/퇴근버튼액션 시 퇴근여부 확인 후 퇴근처리를 위함 
	public String checkOutTimeByEmpNo(int timemng_no, int emp_no) {
		return dao.outTimeByEmpNo(timemng_no, emp_no);
	}
		
	public int attendByEmpNo(int emp_no) {
		return dao.workIn(emp_no);
	}
	
	public int leaveByEmpNo(int timeMng_no, int emp_no) {
		return dao.workOut(timeMng_no, emp_no);
	}
	
	public int checkMngNoByEmpNo(int emp_no) {
		return dao.checkMngNo(emp_no);
	}
}
