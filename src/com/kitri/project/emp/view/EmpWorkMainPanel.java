package com.kitri.project.emp.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class EmpWorkMainPanel extends JPanel {
	public JButton workInBtn;
	public JButton workOutBtn;
	public JButton timeMngBtn;

	/**
	 * Create the panel.
	 */
	public EmpWorkMainPanel() {
		setName("���°���");
		setBounds(0, 0, 940, 510);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		workInBtn = new JButton("���");
		workInBtn.setBounds(67, 73, 248, 361);
		workInBtn.setBackground(new Color(51, 204, 255));	
		add(workInBtn);
		
		workOutBtn = new JButton("���");
		workOutBtn.setBounds(361, 73, 248, 361);
		workOutBtn.setBackground(new Color(51, 204, 255));
		add(workOutBtn);
		
		timeMngBtn = new JButton("����� ��Ȳ");
		timeMngBtn.setBounds(130, 90, 670, 330);
		timeMngBtn.setBackground(new Color(51, 204, 255));
		add(timeMngBtn);

	}

}
