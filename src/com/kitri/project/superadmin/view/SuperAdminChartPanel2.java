package com.kitri.project.superadmin.view;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Choice;

public class SuperAdminChartPanel2 extends JPanel {

	public JButton yearBtn;
	public JButton monthBtn;
	public Panel panel;
	public ChartPanel chartPanel;
	public JScrollPane scrollPane;
	public JTable table;
	public Choice branchC;
	/**
	 * Create the panel.
	 */
	public SuperAdminChartPanel2() {
		setName("매출통계");
		setBounds(0, 0, 940, 510);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		yearBtn = new JButton("\uB144");
		yearBtn.setBounds(806, 15, 51, 37);
		yearBtn.setBackground(new Color(51, 204, 255));
		add(yearBtn);
		
		monthBtn = new JButton("\uC6D4");
		monthBtn.setBounds(872, 15, 51, 37);
		monthBtn.setBackground(new Color(51, 204, 255));
		add(monthBtn);
		
		panel = new Panel();
		panel.setBounds(21, 73, 890, 250);
		

		add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 345, 891, 155);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		branchC = new Choice();
		branchC.setBounds(643, 15, 142, 37);
		add(branchC);
		
	}
}
