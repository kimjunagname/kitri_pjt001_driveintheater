package com.kitri.project.emp.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpTicketingMainPanel extends JPanel {

	public JButton buyTicketBtn;
	public JButton cancelTicketBtn;

	/**
	 * Create the panel.
	 */
	public EmpTicketingMainPanel() {
		setName("예매관리");
		setBounds(0, 0, 940, 510);
		setLayout(null);
		
		buyTicketBtn = new JButton("예매");
		buyTicketBtn.setBounds(112, 67, 305, 345);
		add(buyTicketBtn);
		
		cancelTicketBtn = new JButton("예매 취소");
		cancelTicketBtn.setBounds(473, 67, 305, 339);
		add(cancelTicketBtn);

	}

}
