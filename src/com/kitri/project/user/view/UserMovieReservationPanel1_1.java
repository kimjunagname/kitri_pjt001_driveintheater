package com.kitri.project.user.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.kitri.project.branch.service.BranchService;
import com.kitri.project.movie.service.UserMovieDao;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;

public class UserMovieReservationPanel1_1 extends JPanel {
	UserMovieDao dao;
	public JLabel rateL;
	public JLabel posterL;
	public JLabel titleL;
	public JSlider slider;

	/**
	 * Create the panel.
	 */
	public UserMovieReservationPanel1_1() {
		dao = new UserMovieDao();
		setLayout(null);

		rateL = new JLabel("\uC608\uB9E4\uC728 0.00%");
		rateL.setHorizontalAlignment(SwingConstants.CENTER);
		rateL.setFont(new Font("굴림", Font.PLAIN, 13));
		rateL.setBounds(222, 226, 93, 24);
		add(rateL);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(175, 72, 1, 1);
		add(desktopPane);

		titleL = new JLabel("\uC601\uD654\uC774\uB984\uC601\uD654\uC774\uB984");
		titleL.setHorizontalAlignment(SwingConstants.CENTER);
		titleL.setFont(new Font("굴림", Font.BOLD, 20));
		titleL.setBounds(28, 226, 168, 24);
		add(titleL);

		int num = dao.getBranchMovieCount(1); // 1번 지점
		//1번지점에서 등록한 영화가 없으면 오류
		
		// System.out.println("num에서 문제가 나... num :"+ num);
		slider = new JSlider(1, num, 1); // 지점영화개수 가져오기
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setBounds(32, 262, 283, 23);
		add(slider);

		posterL = new JLabel("");
		posterL.setBounds(65, 10, 250, 210);
		add(posterL);

	}
}
