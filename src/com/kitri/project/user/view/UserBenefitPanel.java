package com.kitri.project.user.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UserBenefitPanel extends JPanel {
	public JButton back;
	private JLabel label;
	private JLabel lblNewLabel;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	public JButton upBtn;

	// ������ �� ����
	
	
	/**
	 * Create the panel.
	 */
	public UserBenefitPanel() {
		setBackground(new Color(255, 255, 255));
		setBounds(12, 78, 370, 470);
		setLayout(null);

		label = new JLabel("\uB9C8\uC77C\uB9AC\uC9C0 \uC870\uD68C");
		label.setFont(new Font("���� ����", Font.BOLD, 25));
		label.setBounds(192, 0, 166, 43);
		add(label);

		lblNewLabel = new JLabel("\uD604\uC7AC\uB4F1\uAE09 : \uC77C\uBC18");
		lblNewLabel.setFont(new Font("���� ����", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 117, 236, 31);
		add(lblNewLabel);

		label_1 = new JLabel("\uB9C8\uC77C\uB9AC\uC9C0 \uC801\uB9BD\uB960 : 1.0%");
		label_1.setFont(new Font("���� ����", Font.PLAIN, 15));
		label_1.setBounds(12, 158, 236, 31);
		add(label_1);

		label_2 = new JLabel("\uAD00\uB78C\uD69F\uC218 : 4\uD68C");
		label_2.setFont(new Font("���� ����", Font.PLAIN, 15));
		label_2.setBounds(12, 200, 236, 31);
		add(label_2);

		label_3 = new JLabel("\uB9C8\uC77C\uB9AC\uC9C0 3000\uC810");
		label_3.setFont(new Font("���� ����", Font.PLAIN, 15));
		label_3.setBounds(12, 241, 236, 31);
		add(label_3);

		upBtn = new JButton("\uB4F1\uC5C5 \uC548\uB0B4 ");
		upBtn.setBackground(new Color(51, 204, 255));
		upBtn.setFont(new Font("���� ����", Font.BOLD, 15));
		upBtn.setBounds(98, 331, 219, 69);
		add(upBtn);
		
		back = new JButton("BACK"); // �ڷΰ��� ��ư
		back.setBackground(new Color(0, 204, 255));
		back.setFont(new Font("���� ����", Font.PLAIN, 12));
		back.setBounds(12, 10, 68, 30); // �ڷΰ��� ��ư
		add(back);

	}

}
