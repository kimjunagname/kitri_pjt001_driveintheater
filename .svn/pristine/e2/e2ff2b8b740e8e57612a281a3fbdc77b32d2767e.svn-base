package com.kitri.project.supervisor.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EtchedBorder;

public class SuperAdministratorSalesStaticsPanel extends JPanel implements ActionListener {
	
	public SuperAdministratorSalesGangNameMonthView gangnamDView = new SuperAdministratorSalesGangNameMonthView();
	public SuperAdministratorSalesGanNameDaysView gangnameMView = new SuperAdministratorSalesGanNameDaysView();
	public SuperAdministratorSalesGangBukMonthView gangbukMView = new SuperAdministratorSalesGangBukMonthView();
	public SuperAdministratorSalesGangBukDaysView gangbukDView = new SuperAdministratorSalesGangBukDaysView();
	public SuperAdministratorGangSeoMonthView gangseoMView = new SuperAdministratorGangSeoMonthView();
	public SuperAdministratorGangSeoDaysView gangseoDView = new SuperAdministratorGangSeoDaysView();
	public JButton GangNamMonthSales;
	public JButton GangNamDaysSales;
	public JButton GangBukMonthSales;
	public JButton GangBukDaysSales;
	public JButton GangSeoMonthSales;
	public JButton GangSeoDaysSales;
	
	CardLayout card = new CardLayout();
	private JPanel rspannel;
	/**
	 * Create the panel.
	 */
	public SuperAdministratorSalesStaticsPanel() {
		setBounds(0, 0, 940, 510);
		setLayout(null);

		JPanel local1Panel = new JPanel();
		local1Panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		local1Panel.setBounds(22, 10, 270, 66);
		add(local1Panel);
		local1Panel.setLayout(null);

		GangNamMonthSales = new JButton("\uC6D4 \uB9E4\uCD9C\uC870\uD68C");
		GangNamMonthSales.setBounds(12, 24, 111, 32);
		local1Panel.add(GangNamMonthSales);

		GangNamDaysSales = new JButton("\uC77C \uB9E4\uCD9C\uC870\uD68C");
		GangNamDaysSales.setBounds(135, 24, 111, 32);
		local1Panel.add(GangNamDaysSales);

		JLabel lblNewLabel = new JLabel("\uAC15\uB0A8\uC9C0\uC810");
		lblNewLabel.setBounds(12, 0, 57, 15);
		local1Panel.add(lblNewLabel);

		JPanel local2Pane = new JPanel();
		local2Pane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		local2Pane.setLayout(null);
		local2Pane.setBounds(301, 10, 270, 66);
		add(local2Pane);

		GangBukMonthSales = new JButton("\uC6D4 \uB9E4\uCD9C\uC870\uD68C");
		GangBukMonthSales.setBounds(12, 24, 111, 32);
		local2Pane.add(GangBukMonthSales);

		GangBukDaysSales = new JButton("\uC77C \uB9E4\uCD9C\uC870\uD68C");
		GangBukDaysSales.setBounds(135, 24, 111, 32);
		local2Pane.add(GangBukDaysSales);

		JLabel label = new JLabel("\uAC15\uBD81\uC9C0\uC810");
		label.setBounds(12, 0, 57, 15);
		local2Pane.add(label);

		JPanel local3Panel = new JPanel();
		local3Panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		local3Panel.setLayout(null);
		local3Panel.setBounds(583, 10, 270, 66);
		add(local3Panel);

		GangSeoMonthSales = new JButton("\uC6D4 \uB9E4\uCD9C\uC870\uD68C");
		GangSeoMonthSales.setBounds(12, 24, 111, 32);
		local3Panel.add(GangSeoMonthSales);

		GangSeoDaysSales = new JButton("\uC77C \uB9E4\uCD9C\uC870\uD68C");
		GangSeoDaysSales.setBounds(135, 24, 111, 32);
		local3Panel.add(GangSeoDaysSales);

		JLabel label_1 = new JLabel("\uAC15\uC11C\uC9C0\uC810");
		label_1.setBounds(12, 0, 57, 15);
		local3Panel.add(label_1);
		
		GangNamMonthSales.addActionListener(this);
		GangNamDaysSales.addActionListener(this);
		GangBukMonthSales.addActionListener(this);
		GangBukDaysSales.addActionListener(this);
		GangSeoMonthSales.addActionListener(this);
		GangSeoDaysSales.addActionListener(this);
		
		rspannel = new JPanel();
		rspannel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rspannel.setBounds(22, 84, 906, 416);
		add(rspannel);
		rspannel.setLayout(new CardLayout(0, 0));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
