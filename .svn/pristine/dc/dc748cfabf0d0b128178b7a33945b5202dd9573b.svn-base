package com.kitri.project.user.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;

public class UserMovieDetail extends JFrame {
	public JButton okB;
	public JLabel actorL;
	public JLabel runningTimeL;
	public JLabel titleL;
	public JTextArea storyTA;
	
	public UserMovieDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 150, 500, 430);
		getContentPane().setLayout(null);
		
		JLabel label2 = new JLabel("\uC601\uD654\uC81C\uBAA9");
		label2.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		label2.setBounds(12, 20, 57, 15);
		getContentPane().add(label2);
		
		titleL = new JLabel("\uB77C\uBCA8");
		titleL.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		titleL.setBounds(81, 20, 369, 15);
		getContentPane().add(titleL);
		
		JLabel label = new JLabel("\uC0C1\uC601\uC2DC\uAC04");
		label.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		label.setBounds(12, 50, 57, 15);
		getContentPane().add(label);
		
		runningTimeL = new JLabel("\uB77C\uBCA8");
		runningTimeL.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		runningTimeL.setBounds(81, 50, 369, 15);
		getContentPane().add(runningTimeL);
		
		JLabel label_1 = new JLabel("\uCD9C\uC5F0\uC9C4");
		label_1.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		label_1.setBounds(12, 80, 57, 15);
		getContentPane().add(label_1);
		
		actorL = new JLabel("\uB77C\uBCA8");
		actorL.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		actorL.setBounds(81, 80, 369, 15);
		getContentPane().add(actorL);
		
		JLabel label_2 = new JLabel("\uC904\uAC70\uB9AC");
		label_2.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		label_2.setBounds(12, 110, 57, 15);
		getContentPane().add(label_2);
		
		okB = new JButton("\uD655\uC778");
		okB.setBounds(192, 350, 97, 23);
		getContentPane().add(okB);
		
		
		storyTA = new JTextArea();
		storyTA.setEditable(false);
		storyTA.setBounds(80, 110, 370, 230);

		JScrollPane scrollPane = new JScrollPane(storyTA);
		scrollPane.setBounds(80, 110, 370, 230);
		getContentPane().add(scrollPane);
		
//		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new UserMovieDetail();
	}
}
