package com.kitri.project.superadmin.view;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SuperAdminChartPanel extends JPanel {

	public JButton yearBtnP7;//년
	public JButton monthBtnP7;//월
	public Panel panelP7; //차트
	public ChartPanel chartPanelP7; 
	public JScrollPane scrollPaneP7;
	public JTable tableP7; //제이테이블
	public JButton buttonP7;//지점 버튼
	/**
	 * Create the panel.
	 */
	public SuperAdminChartPanel() {
		setName("매출통계");
		setBounds(0, 0, 940, 510);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		yearBtnP7 = new JButton("년"); //년
		yearBtnP7.setBounds(806, 15, 51, 37); //년
		yearBtnP7.setBackground(new Color(51, 204, 255));
		add(yearBtnP7);
		
		monthBtnP7 = new JButton("월"); //월
		monthBtnP7.setBounds(872, 15, 51, 37); //월
		monthBtnP7.setBackground(new Color(51, 204, 255));
		add(monthBtnP7);
		
		panelP7 = new Panel();
		panelP7.setBounds(21, 73, 890, 250);
		add(panelP7);
		
		scrollPaneP7 = new JScrollPane(); //제이페널
		scrollPaneP7.setBounds(21, 345, 891, 155);
		add(scrollPaneP7);
		
		tableP7 = new JTable(); //j테이블
		scrollPaneP7.setViewportView(tableP7);
		
		buttonP7 = new JButton("지점");//지점 버튼
		buttonP7.setFont(new Font("굴림", Font.PLAIN, 11)); //지점버튼
		buttonP7.setBackground(new Color(51, 204, 255));
		buttonP7.setBounds(742, 15, 51, 37);
		add(buttonP7);
	}
}