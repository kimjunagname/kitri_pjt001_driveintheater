package com.kitri.project.supervisor.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

public class SuperAdministratorSalesGangNameMonthView extends JPanel {
	private JTable gNMonthTable;

	/**
	 * Create the panel.
	 */
	public SuperAdministratorSalesGangNameMonthView() {
		setBounds(0, 0, 906, 416);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 20, 897, 45);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAC15\uB0A8\uC9C0\uC5ED \uC6D4 \uB9E4\uCD9C\uD604\uD669");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 17));
		lblNewLabel.setBounds(12, 10, 174, 25);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(22, 75, 349, 292);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 467, 470, 33);
		add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(481, 75, 413, 292);
		add(panel_3);
		panel_3.setLayout(null);
		
		gNMonthTable = new JTable();
		gNMonthTable.setBounds(12, 10, 389, 272);
		panel_3.add(gNMonthTable);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(494, 467, 413, 33);
		add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC15\uB0A8\uC9C0\uC5ED \uC6D4 \uB9E4\uCD9C \uADF8\uB798\uD504");
		lblNewLabel_1.setBounds(124, 377, 132, 15);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("\uAC15\uB0A8\uC9C0\uC5ED \uC6D4 \uB9E4\uCD9C \uD604\uD669");
		label.setBounds(649, 377, 144, 15);
		add(label);

	}
}
