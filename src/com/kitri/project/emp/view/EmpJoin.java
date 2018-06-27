package com.kitri.project.emp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.List;

public class EmpJoin extends JFrame {

	public JPanel contentPane;
	public JTextField idTf;
	public JPasswordField pwdTf;
	public JPasswordField pwdChkTf;
	public JTextField nameTf;
	public Choice yearList;
	public JTextField phoneTf;
	public JTextField emailTf;
	public JButton idChkBtn;
	public JButton emailChkBtn;
	public JButton cancelBtn;
	public JButton joinBtn;
	public Choice jobC;
	public Choice branchC;
	public Choice monthList;
	public Choice dateList;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpJoin frame = new EmpJoin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public EmpJoin() {
		setTitle("\uC790\uB3D9\uCC28 \uADF9\uC7A5 - \uD68C\uC6D0\uAC00\uC785");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514*");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(78, 35, 73, 40);
		contentPane.add(lblNewLabel_1);
		
		idTf = new JTextField();
		idTf.setBounds(173, 35, 153, 40);
		contentPane.add(idTf);
		idTf.setColumns(10);
		
		idChkBtn = new JButton("\uC911\uBCF5\uD655\uC778");
		idChkBtn.setBounds(348, 35, 97, 40);
		idChkBtn.setBackground(new Color(51, 204, 255));
		contentPane.add(idChkBtn);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638*");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(78, 90, 73, 40);
		contentPane.add(label);
		
		pwdTf = new JPasswordField();
		pwdTf.setColumns(10);
		pwdTf.setBounds(173, 90, 272, 40);
		contentPane.add(pwdTf);
		
		JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778*");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(63, 145, 97, 40);
		contentPane.add(label_1);
		
		pwdChkTf = new JPasswordField();
		pwdChkTf.setColumns(10);
		pwdChkTf.setBounds(173, 146, 272, 40);
		contentPane.add(pwdChkTf);
		
		JLabel label_2 = new JLabel("\uC774\uBA54\uC77C*");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(78, 315, 73, 40);
		contentPane.add(label_2);
		
		nameTf = new JTextField();
		nameTf.setColumns(10);
		nameTf.setBounds(173, 204, 272, 40);
		contentPane.add(nameTf);
		
		yearList = new Choice();
		yearList.setBounds(173, 269, 62, 40);
		contentPane.add(yearList);
		
		JLabel label_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(78, 406, 73, 40);
		contentPane.add(label_3);
		
		emailTf = new JTextField();
		emailTf.setColumns(10);
		emailTf.setBounds(173, 316, 153, 40);
		contentPane.add(emailTf);
		
		phoneTf = new JTextField();
		phoneTf.setColumns(10);
		phoneTf.setBounds(173, 407, 272, 40);
		contentPane.add(phoneTf);
		
		emailChkBtn = new JButton("\uC911\uBCF5\uD655\uC778");
		emailChkBtn.setBounds(348, 315, 97, 40);
		emailChkBtn.setBackground(new Color(51, 204, 255));
		contentPane.add(emailChkBtn);
		
		JLabel label_5 = new JLabel("\uC9C1 \uCC45*");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(78, 357, 73, 40);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\uC9C0 \uC810");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(284, 357, 73, 40);
		contentPane.add(label_6);
		
		jobC = new Choice();
		jobC.setBounds(173, 367, 82, 21);
		contentPane.add(jobC);
		
		branchC = new Choice();
		branchC.setBounds(363, 367, 82, 40);
		contentPane.add(branchC);
		
		JLabel label_7 = new JLabel("\uC774 \uB984*");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(78, 203, 73, 40);
		contentPane.add(label_7);
		
		JLabel label_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(78, 259, 73, 40);
		contentPane.add(label_4);
		
		cancelBtn = new JButton("\uCDE8  \uC18C");
		cancelBtn.setBounds(173, 462, 105, 50);
		cancelBtn.setBackground(new Color(51, 204, 255));
		contentPane.add(cancelBtn);
		
		joinBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		joinBtn.setBounds(340, 462, 105, 50);
		joinBtn.setBackground(new Color(51, 204, 255));
		contentPane.add(joinBtn);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(475, 155, 407, 339);
		contentPane.add(canvas);
		
		monthList = new Choice();
		monthList.setBounds(275, 269, 47, 40);
		contentPane.add(monthList);
		
		dateList = new Choice();
		dateList.setBounds(363, 269, 62, 40);
		contentPane.add(dateList);
		
		JLabel label_11 = new JLabel("\uB144");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(232, 259, 40, 40);
		contentPane.add(label_11);
		
		JLabel label_8 = new JLabel("\uC6D4");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(317, 259, 40, 40);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("\uC77C");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(417, 259, 40, 40);
		contentPane.add(label_9);
	}
}
