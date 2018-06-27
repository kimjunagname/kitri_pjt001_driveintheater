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

	public JButton yearBtnP7;//��
	public JButton monthBtnP7;//��
	public Panel panelP7; //��Ʈ
	public ChartPanel chartPanelP7; 
	public JScrollPane scrollPaneP7;
	public JTable tableP7; //�������̺�
	public JButton buttonP7;//���� ��ư
	/**
	 * Create the panel.
	 */
	public SuperAdminChartPanel() {
		setName("�������");
		setBounds(0, 0, 940, 510);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		yearBtnP7 = new JButton("��"); //��
		yearBtnP7.setBounds(806, 15, 51, 37); //��
		yearBtnP7.setBackground(new Color(51, 204, 255));
		add(yearBtnP7);
		
		monthBtnP7 = new JButton("��"); //��
		monthBtnP7.setBounds(872, 15, 51, 37); //��
		monthBtnP7.setBackground(new Color(51, 204, 255));
		add(monthBtnP7);
		
		panelP7 = new Panel();
		panelP7.setBounds(21, 73, 890, 250);
		add(panelP7);
		
		scrollPaneP7 = new JScrollPane(); //�������
		scrollPaneP7.setBounds(21, 345, 891, 155);
		add(scrollPaneP7);
		
		tableP7 = new JTable(); //j���̺�
		scrollPaneP7.setViewportView(tableP7);
		
		buttonP7 = new JButton("����");//���� ��ư
		buttonP7.setFont(new Font("����", Font.PLAIN, 11)); //������ư
		buttonP7.setBackground(new Color(51, 204, 255));
		buttonP7.setBounds(742, 15, 51, 37);
		add(buttonP7);
	}
}