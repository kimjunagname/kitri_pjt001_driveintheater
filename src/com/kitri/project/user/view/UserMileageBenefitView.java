package com.kitri.project.user.view;

import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UserMileageBenefitView extends JPanel {
	public JButton backB;
	/**
	 * Create the panel.
	 */
	public UserMileageBenefitView() {
		setBackground(new Color(255, 255, 255));
		setBounds(12, 78, 370, 470);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(12, 10, 346, 48);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB4F1\uC5C5 \uC548\uB0B4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("���� ����", Font.BOLD, 25));
		lblNewLabel.setBounds(117, 10, 223, 35);
		panel.add(lblNewLabel);
		
		backB = new JButton("BACK");
		backB.setBackground(new Color(51, 204, 255));
		backB.setBounds(0, 10, 68, 30);
		backB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		backB.setFont(new Font("���� ����", Font.BOLD, 10));
		panel.add(backB);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(12, 68, 346, 204);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uB4F1\uAE09\uBCC4 \uC548\uB0B4 ");
		lblNewLabel_1.setFont(new Font("���� ����", Font.BOLD, 17));
		lblNewLabel_1.setBounds(12, 24, 109, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\uC77C\uBC18");
		label.setFont(new Font("���� ����", Font.BOLD, 13));
		label.setBounds(12, 60, 57, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\uC2E4\uBC84");
		label_1.setFont(new Font("���� ����", Font.BOLD, 13));
		label_1.setBounds(12, 107, 57, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\uACE8\uB4DC");
		label_2.setFont(new Font("���� ����", Font.BOLD, 13));
		label_2.setBounds(12, 159, 57, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("\uAC00\uC785\uC2DC \uC790\uB3D9");
		label_3.setFont(new Font("���� ����", Font.PLAIN, 13));
		label_3.setBounds(107, 60, 117, 15);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("\uAD00\uB78C\uD69F\uC218 5\uD68C\uC2DC ");
		label_4.setFont(new Font("���� ����", Font.PLAIN, 13));
		label_4.setBounds(107, 107, 128, 15);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("\uAD00\uB78C\uD69F\uC218 10\uD68C\uC2DC ");
		label_5.setFont(new Font("���� ����", Font.PLAIN, 13));
		label_5.setBounds(107, 159, 128, 15);
		panel_1.add(label_5);
	}
}
