package com.kitri.project.emp.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.*;

public class EmpMenuTabbedFrame extends JFrame {

	public JPanel movieTabPanel;
//	public JPanel ticketingTabPanel;
	public JPanel workTabPanel;
	public JPanel branchTabPanel;
	
	
	public CardLayout card;
	
	public EmpMovieMainPanel movieMainPanel;
	public EmpMovieInsertView movieInsertPanel;
//	public EmpTicketingMainPanel ticketingMainPanel;
	public EmpWorkMainPanel workMainPanel;
	public EmpTimeManagePanel timeManagePanel;
	public EmpBranchMainPanel branchMainPanel;
	public EmpChartPanel chartPanel;
	public EmpMovieEditDelete empMovieEditDelete;
	
	
	public JPanel contentPane;
	public JLabel nameLabel;
	public JLabel gradeLabel;
	public JButton infoBtn;
	public JButton outBtn;
	public JTabbedPane tabbedPane;


	/**
	 * Create the frame.
	 */
	public EmpMenuTabbedFrame() {
		card = new CardLayout();
		movieTabPanel = new JPanel();
//		ticketingTabPanel = new JPanel();
		workTabPanel = new JPanel();
		branchTabPanel = new JPanel();
		
		movieMainPanel = new EmpMovieMainPanel();// 생성자를 만들어준다.
		movieInsertPanel = new EmpMovieInsertView();
//		ticketingMainPanel = new EmpTicketingMainPanel();
		workMainPanel = new EmpWorkMainPanel();
		timeManagePanel = new EmpTimeManagePanel();
		branchMainPanel = new EmpBranchMainPanel();
		chartPanel = new EmpChartPanel();
		empMovieEditDelete = new EmpMovieEditDelete();

		
		setTitle("\uC790\uB3D9\uCC28 \uADF9\uC7A5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 600); // Frame 크기
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255));

		nameLabel = new JLabel("");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(439, 10, 116, 31);
		contentPane.add(nameLabel);

		gradeLabel = new JLabel("");
		gradeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		gradeLabel.setBounds(555, 10, 116, 31);
		contentPane.add(gradeLabel);

		infoBtn = new JButton("\uC815\uBCF4\uC218\uC815");
		infoBtn.setBounds(705, 10, 99, 31);
		infoBtn.setBackground(new Color(51, 204, 255));
		contentPane.add(infoBtn);

		outBtn = new JButton("\uB85C\uADF8\uC544\uC6C3");
		outBtn.setBounds(816, 10, 99, 31);
		outBtn.setBackground(new Color(51, 204, 255));
		contentPane.add(outBtn);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(9, 25, 940, 510); // Tab 영역 크기(Panel 크기)
		tabbedPane.setBackground(new Color(255, 255, 255));
		contentPane.add(tabbedPane);


		movieTabPanel.setLayout(card);
		movieTabPanel.setName("movieTabPanel");
//		ticketingTabPanel.setLayout(card);
		workTabPanel.setLayout(card);
		branchTabPanel.setLayout(card);
		
		movieTabPanel.add("movieMainPanel", movieMainPanel);
		movieTabPanel.add("movieInsertPanel", movieInsertPanel);
		
	
		
		workTabPanel.add("workMainPanel", workMainPanel);
		workTabPanel.add("timeManagePanel", timeManagePanel);
		
		
		
		branchTabPanel.add("branchMainPanel", branchMainPanel);
		branchTabPanel.add("chartPanel", chartPanel);
		
		
		
		
		tabbedPane.addTab("영화관리", movieTabPanel);
//		tabbedPane.addTab("예매관리", ticketingMainPanel);
		tabbedPane.addTab("근태관리", workTabPanel);
		tabbedPane.addTab("지점관리", branchTabPanel);
		

		card.show(movieTabPanel, "movieMainPanel");
		setResizable(false);
		setVisible(false);
	}
}
