package com.kitri.project.emp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.project.emp.view.EmpMain;

public class EmpBranchController implements ActionListener {
	EmpMain empMain;

	public EmpBranchController(EmpMain empMain) {
		this.empMain = empMain;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == empMain.tabFrame.branchMainPanel.salesBtn) {
			System.out.println("E_B_Controller 매출버튼");
//		}else if(obj == empMain.tabFrame.branchMainPanel.movieRankBtn) {
//			System.out.println("E_B_Controller 예매율버튼");
		}
	}

}
