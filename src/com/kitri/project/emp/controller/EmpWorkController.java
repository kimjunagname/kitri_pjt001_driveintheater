package com.kitri.project.emp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.kitri.project.emp.dto.EmpTimeMngDto;
import com.kitri.project.emp.service.EmpTimeMngService;
import com.kitri.project.emp.view.EmpMain;

public class EmpWorkController implements ActionListener {
	EmpMain empMain;
	EmpTimeMngService tService;
	int timeMng_no = 0;
	int emp_no = 0;
	
	public EmpWorkController(EmpMain empMain) {
		this.empMain = empMain;
		tService = new EmpTimeMngService();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(emp_no != EmpInfoController.login.getEmp_no()) {
			emp_no = EmpInfoController.login.getEmp_no();
			timeMng_no = 0;
		}
		if(obj == empMain.tabFrame.workMainPanel.workInBtn) {
			System.out.println("E_W_Controller 출근버튼");
			if(timeMng_no == 0) {						//근태관리번호 == 0
				tService.attendByEmpNo(emp_no);			//출근
				
				timeMng_no = tService.checkMngNoByEmpNo(emp_no);	//근태관리번호얻기
				JOptionPane.showMessageDialog(empMain.tabFrame.workMainPanel, "출근시간: "+tService.checkInTimeByEmpNo(timeMng_no, emp_no), "출근완료", JOptionPane.INFORMATION_MESSAGE);
				
				if(timeMng_no != 0) {
					empMain.tabFrame.workMainPanel.workInBtn.setEnabled(false);
				}
			}else {
				System.out.println("출근완료");
			}
			
		}else if(obj == empMain.tabFrame.workMainPanel.workOutBtn) {
			System.out.println("E_W_Controller 퇴근버튼");
			if((tService.checkOutTimeByEmpNo(timeMng_no, emp_no) == null)){
				System.out.println("퇴근전");
				if(tService.leaveByEmpNo(timeMng_no, emp_no) > 0 ) {
					JOptionPane.showMessageDialog(empMain.tabFrame.workMainPanel, "퇴근시간: "+tService.checkOutTimeByEmpNo(timeMng_no, emp_no), "퇴근완료", JOptionPane.INFORMATION_MESSAGE);
					empMain.tabFrame.workMainPanel.workOutBtn.setEnabled(false);
				}
			}else {
				System.out.println("퇴근완료");
			}
			
		}else if(obj == empMain.tabFrame.workMainPanel.timeMngBtn) {
			System.out.println("E_W_Controller 근태관리버튼");
			List<EmpTimeMngDto> list = null;
			String[] columnNames = new String[]{"직원번호", "직원명", "출근시간", "퇴근시간"};
			
			if("지점관리자".equals(EmpInfoController.login.getJob_name())) {
				list = tService.checkAllByBranchNo(EmpInfoController.login.getBranch_no());
			}else if ("직원".equals(EmpInfoController.login.getJob_name())) {
				list = tService.checkAllByEmpNo(emp_no);
			}
			DefaultTableModel model = new DefaultTableModel(columnNames, 0);
			int len = list.size();
			for (int i = 0; i < len; i++) {
				Object[] data = {list.get(i).getEmp_no(), list.get(i).getEmp_name(), list.get(i).getEmp_intime(), list.get(i).getEmp_outtime()};
				model.addRow(data);
			}
			empMain.tabFrame.timeManagePanel.table.setModel(model);
			empMain.tabFrame.timeManagePanel.scrollPane.setViewportView(empMain.tabFrame.timeManagePanel.table);
			empMain.tabFrame.card.show(empMain.tabFrame.workTabPanel, "timeManagePanel");
		}
	}

}
