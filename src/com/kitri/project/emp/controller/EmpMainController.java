package com.kitri.project.emp.controller;


import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.kitri.project.emp.dto.EmpInfoDto;
import com.kitri.project.emp.view.*;

public class EmpMainController implements ActionListener, ChangeListener{
	
	EmpMain empMain;
	JTabbedPane tabbedPane;
	JPanel nowP;
	
	public EmpMainController(EmpMain empMain) {
		this.empMain = empMain;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		tabbedPane = (JTabbedPane) e.getSource();
		nowP = (JPanel) tabbedPane.getSelectedComponent();
		empMain.tabFrame.card.first(nowP);
	}

}
