package com.kitri.project.user.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.kitri.project.user.controller.UserMenuController;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Color;

public class UserMenu extends JFrame {
	public JLabel userName;
	public JButton logoutButton; // �α׾ƿ�
	public JPanel panel;
	public CardLayout card = new CardLayout();
	public UserMenuPanel p1 = new UserMenuPanel();
	public UserMovieReservationPanel1 p2_1 = new UserMovieReservationPanel1();
	public UserMovieReservationPanel2 p2_2 = new UserMovieReservationPanel2();
	// public UserMovieReservationPanel3 p2_3 = new UserMovieReservationPanel3();
	public UserMovieReservationLookupPanel p3 = new UserMovieReservationLookupPanel();
	public UserMovieReservationCancelPanel p4 = new UserMovieReservationCancelPanel();
	public UserModifyInfoPanel p5 = new UserModifyInfoPanel();
	public UserBenefitPanel p6 = new UserBenefitPanel();
	public UserMileageBenefitView p7 = new UserMileageBenefitView();
//	public UserMovieReservationCancelPanel p8 = new UserMovieReservationCancelPanel();
	public UserMovieDetail p9= new UserMovieDetail();
	public JButton button_1;	
	public UserLogin userLogin; // �α��� â
	public JLabel userGrade;

	public final JLabel label_2 = new JLabel("\uB4F1\uAE09");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMenu userMenuframe = new UserMenu();
					userMenuframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserMenu() {
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		getContentPane().setLayout(null);

		userName = new JLabel("\uD64D\uAE38\uB3D9");
		userName.setFont(new Font("���� ����", Font.PLAIN, 18));
		userName.setBounds(12, 10, 76, 20);
		getContentPane().add(userName);

		logoutButton = new JButton("\uB85C\uADF8\uC544\uC6C3");// �α׾ƿ�
		logoutButton.setBackground(new Color(51, 204, 255));
		logoutButton.setFont(new Font("���� ����", Font.PLAIN, 12));
		logoutButton.setBounds(259, 10, 123, 45);
		getContentPane().add(logoutButton);

		panel = new JPanel();
		panel.setBounds(12, 78, 370, 470);
		getContentPane().add(panel);
		panel.setLayout(card);

		//��ȭ���ų���
		p1.ticketPayBtn.setText("\uB9C8\uC77C\uB9AC\uC9C0 & \uD61C\uD0DD\uC870\uD68C");
		p1.ticketPayBtn.setText("��ȭ���� ����");

		panel.add("menu", p1);
		panel.add("MovieReservationP", p2_1);
		panel.add("MovieReservationP2", p2_2);
		// panel.add("MovieReservationP3", p2_3);
		panel.add("view3", p3);
		panel.add("view4", p4);
		panel.add("ModifyInfoP", p5);
		panel.add("UserBenefitPanel", p6);
		panel.add("UserMileageView", p7);
//		panel.add("UserPayCancelView", p8);

		card.show(panel, "menu");
		setResizable(false);

		UserMenuController control = new UserMenuController(this);

		logoutButton.addActionListener(control);
		p1.ticketPayBtn.addActionListener(control);
		p1.movieReservationBtn.addActionListener(control);
		p1.mileageBtn.addActionListener(control);
		p1.modifyInfoBtn.addActionListener(control);
//		p1.log.addActionListener(control);// �α׾ƿ� ������
		p2_1.backB.addActionListener(control);
		p2_1.reservationB.addActionListener(control);
		p2_1.choice.addItemListener(control);
		p2_1.movieInfoB.addActionListener(control);
		p2_1.p1_1.slider.addChangeListener(control);
		p2_1.p1_2.slider.addChangeListener(control);
		p2_2.backB.addActionListener(control);
		p2_2.paymentB.addActionListener(control);
		p2_2.paymentCancelB.addActionListener(control);
		p2_2.cartypeC.addItemListener(control);
		// p2_2.nextB.addActionListener(control);
		// p2_3.backB.addActionListener(control);
		// p2_3.payment_cancelB.addActionListener(control);
		
		p4.backP2.addActionListener(control); //�ڷΰ���
		p4.payCancleP2.addActionListener(control); //�������
		
		p5.backB.addActionListener(control);
		p5.modifyB.addActionListener(control);
//		p5.monthC.addItemListener(control);
		p6.back.addActionListener(control);
		p6.upBtn.addActionListener(control);
		p7.backB.addActionListener(control);
//		p8.backP2.addActionListener(control);
//		p8.payCancleP2.addActionListener(control);
		p9.okB.addActionListener(control);

		label_2.setFont(new Font("���� ����", Font.PLAIN, 15));
		label_2.setBounds(12, 35, 36, 20);

		getContentPane().add(label_2);

		JLabel label_1 = new JLabel("\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4.");
		label_1.setFont(new Font("���� ����", Font.PLAIN, 18));
		label_1.setBounds(71, 10, 129, 20);
		getContentPane().add(label_1);

		userGrade = new JLabel("\uC77C\uBC18");
		userGrade.setFont(new Font("���� ����", Font.PLAIN, 15));
		userGrade.setBounds(47, 35, 76, 20);
		getContentPane().add(userGrade);
	}
}
