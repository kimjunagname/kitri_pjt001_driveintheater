package com.kitri.project.superadmin.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SuperManagerMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuperManagerMain frame = new SuperManagerMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SuperManagerMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC790\uB3D9\uCC28 \uADF9\uC7A5");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 37));
		lblNewLabel.setBounds(354, 143, 284, 102);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(341, 255, 186, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(341, 328, 186, 50);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("로 그 인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(539, 255, 99, 50);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("회원가입");
		button.setBounds(539, 328, 99, 50);
		contentPane.add(button);
	}
}
