package com.kitri.project.superadmin.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class SuperAdminMainPanel extends JPanel {
	public JButton salesBtnP6; //���� ��ư

	/**
	 * Create the panel.
	 */
	public SuperAdminMainPanel() {
		setName("��������");
		setBounds(0, 0, 940, 510);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		salesBtnP6 = new JButton("����"); //���� ��ư
		salesBtnP6.setBounds(130, 90, 670, 330);
		salesBtnP6.setBackground(new Color(51, 204, 255));
		add(salesBtnP6);

	}

}
