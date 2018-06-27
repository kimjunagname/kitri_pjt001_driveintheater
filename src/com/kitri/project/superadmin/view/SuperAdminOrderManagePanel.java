package com.kitri.project.superadmin.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JScrollPane;

public class SuperAdminOrderManagePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SuperAdminOrderManagePanel() {
		setBounds(0, 0, 940, 510);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 197, 46);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC9C0\uC810\uBCC4 \uBC1C\uC8FC \uAD00\uB9AC");
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 10, 185, 30);
		panel.add(lblNewLabel);
		
		JButton agreebtn = new JButton("\uBC1C\uC8FC\uC2B9\uC778 \u25B6");
		agreebtn.setBounds(409, 69, 140, 140);
		add(agreebtn);
		
		JButton loadingbtn = new JButton("\uCDE8\uC18C \u25C0");
		loadingbtn.setBounds(409, 337, 140, 140);
		add(loadingbtn);
		
		JScrollPane orderLoadingPane = new JScrollPane();
		orderLoadingPane.setBounds(22, 69, 375, 408);
		add(orderLoadingPane);
		
		JList list = new JList();
		list.setVisibleRowCount(40);
		orderLoadingPane.setColumnHeaderView(list);
		
		JScrollPane orderAgreePane = new JScrollPane();
		orderAgreePane.setBounds(553, 69, 375, 408);
		add(orderAgreePane);
		
		JList list_1 = new JList();
		list_1.setVisibleRowCount(40);
		orderAgreePane.setColumnHeaderView(list_1);

	}
}
