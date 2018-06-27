package com.kitri.project.user.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class UserLoginSample extends JFrame {
	private JTextField txtUsername;
	private JPasswordField textField;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginSample frame = new UserLoginSample();
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
	public UserLoginSample() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 500);
		getContentPane().setLayout(null);
		
		JButton btnJoin = new JButton("JOIN");
		btnJoin.setAction(action);
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJoin.setBounds(12, 325, 124, 43);
		getContentPane().add(btnJoin);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setAction(action_1);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(148, 325, 124, 43);
		getContentPane().add(btnLogin);
		
		txtUsername = new JTextField();
		txtUsername.setText("ID\uB97C \uC785\uB825 \uD558\uC138\uC694");
		txtUsername.setColumns(10);
		txtUsername.setBounds(23, 185, 235, 43);
		getContentPane().add(txtUsername);
		
		JLabel lblDriveInTheater = new JLabel("Drive In Theater");
		lblDriveInTheater.setHorizontalAlignment(SwingConstants.CENTER);
		lblDriveInTheater.setFont(new Font("±¼¸²", Font.BOLD, 25));
		lblDriveInTheater.setBounds(34, 59, 208, 79);
		getContentPane().add(lblDriveInTheater);
		
		textField = new JPasswordField();
		textField.setText("username");
		textField.setColumns(10);
		textField.setBounds(23, 249, 235, 43);
		getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("ID\uCC3E\uAE30");
		btnNewButton.setBounds(57, 414, 105, 27);
		getContentPane().add(btnNewButton);
		
		JButton btnPwd = new JButton("PWD \uCC3E\uAE30");
		btnPwd.setBounds(167, 414, 105, 27);
		getContentPane().add(btnPwd);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
