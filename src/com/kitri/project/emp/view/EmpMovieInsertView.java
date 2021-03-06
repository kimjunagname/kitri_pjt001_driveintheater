package com.kitri.project.emp.view;

import java.awt.*;

import javax.swing.*;

public class EmpMovieInsertView extends JPanel {
	public JButton movieRegisterBtn;
	public JLabel branchNameL;
	public Choice time1C;
	public Choice time2C;
	public Choice time3C;
	public JLabel movieTitleL;
	public JLabel runTimeL;
	public JLabel movieGenreL;
	public Choice movieTitleC;
	public TextArea storyArea;
	public TextArea actorArea;
	public Choice startYearC;
	public Choice startMonthC;
	public Choice startDateC;
	public Choice endYearC;
	public Choice endMonthC;
	public Choice endDateC;

	public EmpMovieInsertView() {

		setBounds(0, 0, 940, 510);
		setLayout(null);
		setBackground(new Color(255, 255, 255));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(543, 26, 385, 463);
		panel_1.setBackground(new Color(255, 255, 255));
		add(panel_1);
		panel_1.setLayout(null);

		JLabel mvruntlab = new JLabel("\uC0C1\uC601\uC2DC\uC791\uC77C");
		mvruntlab.setFont(new Font("����", Font.BOLD, 14));
		mvruntlab.setBounds(17, 83, 78, 15);
		panel_1.add(mvruntlab);

		JLabel mvstorylab = new JLabel("\uC0C1\uC601\uC2DC\uAC041");
		mvstorylab.setFont(new Font("����", Font.BOLD, 14));
		mvstorylab.setBounds(29, 190, 83, 15);
		panel_1.add(mvstorylab);

		JLabel mvactorlab = new JLabel("\uC0C1\uC601\uC2DC\uAC042");
		mvactorlab.setFont(new Font("����", Font.BOLD, 14));
		mvactorlab.setBounds(29, 245, 83, 15);
		panel_1.add(mvactorlab);

		JLabel mvnolab = new JLabel("\uC9C0\uC810");
		mvnolab.setFont(new Font("����", Font.BOLD, 14));
		mvnolab.setBounds(26, 35, 83, 15);
		panel_1.add(mvnolab);

		branchNameL = new JLabel();
		branchNameL.setBounds(123, 29, 125, 28);
		panel_1.add(branchNameL);

		movieRegisterBtn = new JButton("\uC601\uD654 \uB4F1\uB85D");
		movieRegisterBtn.setBounds(263, 410, 108, 38);
		movieRegisterBtn.setBackground(new Color(51, 204, 255));
		panel_1.add(movieRegisterBtn);

		time1C = new Choice();
		time1C.setBounds(126, 186, 161, 24);
		panel_1.add(time1C);

		time2C = new Choice();
		time2C.setBounds(126, 241, 161, 24);
		panel_1.add(time2C);

		JLabel label = new JLabel("\uC0C1\uC601\uC2DC\uAC043");
		label.setFont(new Font("����", Font.BOLD, 14));
		label.setBounds(29, 294, 83, 15);
		panel_1.add(label);

		time3C = new Choice();
		time3C.setBounds(126, 290, 161, 24);
		panel_1.add(time3C);

		JLabel label_1 = new JLabel("\uC0C1\uC601\uC885\uB8CC\uC77C");
		label_1.setFont(new Font("����", Font.BOLD, 14));
		label_1.setBounds(17, 136, 78, 15);
		panel_1.add(label_1);
		
		startYearC = new Choice();
		startYearC.setBounds(101, 75, 62, 27);
		panel_1.add(startYearC);
		
		JLabel label_9 = new JLabel("\uB144");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(160, 65, 40, 40);
		panel_1.add(label_9);
		
		startMonthC = new Choice();
		startMonthC.setBounds(203, 75, 47, 27);
		panel_1.add(startMonthC);
		
		JLabel label_10 = new JLabel("\uC6D4");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(245, 65, 40, 40);
		panel_1.add(label_10);
		
		startDateC = new Choice();
		startDateC.setBounds(291, 75, 62, 27);
		panel_1.add(startDateC);
		
		JLabel label_11 = new JLabel("\uC77C");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(345, 65, 40, 40);
		panel_1.add(label_11);
		
		endYearC = new Choice();
		endYearC.setBounds(101, 130, 62, 27);
		panel_1.add(endYearC);
		
		JLabel label_12 = new JLabel("\uB144");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(160, 120, 40, 40);
		panel_1.add(label_12);
		
		endMonthC = new Choice();
		endMonthC.setBounds(203, 130, 47, 27);
		panel_1.add(endMonthC);
		
		JLabel label_13 = new JLabel("\uC6D4");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(245, 120, 40, 40);
		panel_1.add(label_13);
		
		endDateC = new Choice();
		endDateC.setBounds(291, 130, 62, 27);
		panel_1.add(endDateC);
		
		JLabel label_14 = new JLabel("\uC77C");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(345, 120, 40, 40);
		panel_1.add(label_14);

		movieTitleC = new Choice();
		movieTitleC.setBounds(190, 26, 296, 27);
		add(movieTitleC);

		JLabel label_2 = new JLabel("\uC601\uD654\uC120\uD0DD");
		label_2.setFont(new Font("����", Font.BOLD, 15));
		label_2.setBounds(88, 37, 83, 15);
		add(label_2);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(42, 15, 492, 474);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);

		JLabel label_3 = new JLabel("\uC601\uD654 \uC81C\uBAA9");
		label_3.setFont(new Font("����", Font.BOLD, 14));
		label_3.setBounds(26, 83, 83, 15);
		panel.add(label_3);

		JLabel label_4 = new JLabel("\uC0C1\uC601\uC2DC\uAC04");
		label_4.setFont(new Font("����", Font.BOLD, 14));
		label_4.setBounds(26, 133, 83, 15);
		panel.add(label_4);

		JLabel label_5 = new JLabel("\uC7A5\uB974");
		label_5.setFont(new Font("����", Font.BOLD, 14));
		label_5.setBounds(26, 177, 83, 15);
		panel.add(label_5);

		JLabel label_6 = new JLabel("\uC904\uAC70\uB9AC");
		label_6.setFont(new Font("����", Font.BOLD, 14));
		label_6.setBounds(26, 240, 64, 15);
		panel.add(label_6);

		JLabel label_7 = new JLabel("\uCD9C\uC5F0\uC9C4");
		label_7.setFont(new Font("����", Font.BOLD, 14));
		label_7.setBounds(26, 379, 64, 15);
		panel.add(label_7);

		movieTitleL = new JLabel();
		movieTitleL.setBounds(107, 78, 354, 28);
		panel.add(movieTitleL);

		runTimeL = new JLabel();
		runTimeL.setBounds(107, 128, 318, 28);
		panel.add(runTimeL);

		movieGenreL = new JLabel();
		movieGenreL.setBounds(107, 172, 354, 28);
		panel.add(movieGenreL);

		storyArea = new TextArea();
		storyArea.setBounds(107, 215, 354, 123);
		panel.add(storyArea);

		actorArea = new TextArea();
		actorArea.setBounds(107, 351, 354, 110);
		panel.add(actorArea);

		JLabel label_8 = new JLabel("(\uBD84)");
		label_8.setFont(new Font("����", Font.BOLD, 14));
		label_8.setBounds(437, 133, 43, 15);
		panel.add(label_8);

		setVisible(true);

	}
}
