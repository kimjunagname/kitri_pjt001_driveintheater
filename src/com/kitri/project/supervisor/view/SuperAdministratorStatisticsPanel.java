package com.kitri.project.supervisor.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SuperAdministratorStatisticsPanel extends JPanel {
	private JPanel panel;
	CardLayout card = new CardLayout();

	private JTable table;

	/**
	 * Create the panel.
	 */
	public SuperAdministratorStatisticsPanel() {
		setBounds(0, 0, 940, 510);
		setLayout(null);

		table = new JTable();
		table.setBounds(36, 128, 354, 335);
		add(table);

		JLabel lbljchart = new JLabel("\uADF8\uB798\uD504(Jchart)");
		lbljchart.setBounds(489, 244, 106, 71);
		add(lbljchart);

		JLabel label = new JLabel("\uC601\uD654 \uB204\uC801 \uC608\uB9E4\uD604\uD669");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("±¼¸²", Font.BOLD, 25));
		label.setBounds(80, 73, 218, 30);
		add(label);

		JLabel label_1 = new JLabel("\uD1B5\uACC4");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("±¼¸²", Font.BOLD, 25));
		label_1.setBounds(460, 73, 218, 30);
		add(label_1);

	}

}
