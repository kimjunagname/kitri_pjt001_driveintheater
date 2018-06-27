package com.kitri.project.user.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Choice;

public class UserMovieReservationPanel2 extends JPanel {
	public JButton backB;
	public Choice showdayC;
	public Choice showtimeC;
	public Choice cartypeC;
	public JTextField mileageF;
	public JButton paymentB;
	public JButton paymentCancelB;
	public JLabel branchL;
	public JLabel totalpriceL;
	public JLabel title;

	/**
	 * Create the panel.
	 * 
	 */
	public UserMovieReservationPanel2() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		title = new JLabel("\uC601\uD654\uC81C\uBAA9");
		title.setHorizontalAlignment(SwingConstants.LEFT);
		title.setFont(new Font("���� ����", Font.BOLD, 23));
		title.setBounds(22, 65, 140, 35);
		add(title);
		
		JLabel label_2 = new JLabel("\uC9C0\uC810");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("���� ����", Font.PLAIN, 18));
		label_2.setBounds(22, 110, 80, 25);
		add(label_2);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(175, 72, 1, 1);
		add(desktopPane);
		
		backB = new JButton("BACK");
		backB.setBackground(new Color(51, 204, 255));
		backB.setFont(new Font("���� ����", Font.PLAIN, 12));
		backB.setBounds(12, 10, 68, 30);
		add(backB);
		
		JLabel titleL = new JLabel("\uC601\uD654\uC608\uB9E4");
		titleL.setHorizontalAlignment(SwingConstants.RIGHT);
		titleL.setFont(new Font("���� ����", Font.BOLD, 25));
		titleL.setBounds(199, 10, 141, 35);
		add(titleL);
		
		branchL = new JLabel("\uC9C0\uC810\uC740\uBD88\uBCC0");
		branchL.setHorizontalAlignment(SwingConstants.LEFT);
		branchL.setFont(new Font("���� ����", Font.PLAIN, 12));
		branchL.setBounds(125, 110, 211, 25);
		add(branchL);
		
		JLabel label_3 = new JLabel("\uC0C1\uC601\uC77C");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("���� ����", Font.PLAIN, 12));
		label_3.setBounds(22, 145, 80, 25);
		add(label_3);
		
		showdayC = new Choice();
		showdayC.setFont(new Font("����", Font.PLAIN, 18));
		showdayC.setBounds(125, 145, 211, 25);
		add(showdayC);
		
		JLabel label_4 = new JLabel("\uC0C1\uC601\uC2DC\uAC04");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("���� ����", Font.PLAIN, 12));
		label_4.setBounds(22, 180, 80, 25);
		add(label_4);
		
		showtimeC = new Choice();
		showtimeC.setFont(new Font("����", Font.PLAIN, 18));
		showtimeC.setBounds(125, 180, 211, 25);
		add(showtimeC);
		
		JLabel label_5 = new JLabel("\uCC28\uC885");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("���� ����", Font.PLAIN, 12));
		label_5.setBounds(22, 215, 80, 25);
		add(label_5);
		
		cartypeC = new Choice();
		cartypeC.setFont(new Font("����", Font.PLAIN, 18));
		cartypeC.setBounds(125, 215, 211, 25);
		add(cartypeC);
		
		JLabel label_6 = new JLabel("\uB9C8\uC77C\uB9AC\uC9C0");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("���� ����", Font.PLAIN, 12));
		label_6.setBounds(22, 250, 80, 25);
		add(label_6);
		
		mileageF = new JTextField();
		mileageF.setColumns(10);
		mileageF.setBounds(125, 250, 182, 25);
		add(mileageF);
		
		JLabel label_7 = new JLabel("\uC6D0");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("���� ����", Font.PLAIN, 12));
		label_7.setBounds(319, 250, 39, 25);
		add(label_7);
		
		totalpriceL = new JLabel("0");
		totalpriceL.setHorizontalAlignment(SwingConstants.RIGHT);
		totalpriceL.setFont(new Font("����", Font.BOLD, 23));
		totalpriceL.setBounds(220, 349, 89, 35);
		add(totalpriceL);
		
		paymentCancelB = new JButton("\uCDE8\uC18C");
		paymentCancelB.setFont(new Font("���� ����", Font.PLAIN, 12));
		paymentCancelB.setBackground(new Color(51, 204, 255));
		paymentCancelB.setBounds(125, 394, 105, 48);
		add(paymentCancelB);
		
		paymentB = new JButton("\uACB0\uC81C");
		paymentB.setFont(new Font("���� ����", Font.PLAIN, 12));
		paymentB.setBackground(new Color(51, 204, 255));
		paymentB.setBounds(242, 393, 105, 48);
		add(paymentB);
		
		JLabel label = new JLabel("\uCD1D \uAE08\uC561 : ");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("���� ����", Font.BOLD, 23));
		label.setBounds(107, 349, 120, 35);
		add(label);
		
		JLabel label_9 = new JLabel("\uC6D0");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setFont(new Font("���� ����", Font.BOLD, 23));
		label_9.setBounds(319, 349, 39, 35);
		add(label_9);

	}
}
