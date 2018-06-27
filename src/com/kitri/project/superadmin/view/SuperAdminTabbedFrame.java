package com.kitri.project.superadmin.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;

import com.kitri.project.emp.view.EmpMovieEditDelete;
import com.kitri.project.superadmin.controller.SuperAdminMenuController;
import com.kitri.project.superadmin.controller.SuperAdminTabController;

public class SuperAdminTabbedFrame extends JFrame {

	public SuperAdminStatisticsPanel movieReserveStaticPanel = new SuperAdminStatisticsPanel();
	public SuperAdminSalesStaticsPanel salesManagePanel = new SuperAdminSalesStaticsPanel();
	public SuperAdminMovieInsertView movieInsertPanel = new SuperAdminMovieInsertView();
	public SuperAdminMovieDeleteModifyPanel moviedeletemodifyPanel = new SuperAdminMovieDeleteModifyPanel();
	public SuperAdminChartPanel2 chartPanel= new SuperAdminChartPanel2();
	
	//관리자 매출 제이차트 및 제이테이블
	public SuperAdminChartPanel superAdminChartPanel = new SuperAdminChartPanel();
	
	public JPanel contentPane;
	public JLabel nameLabel;
	public JLabel gradeLabel;
	public JButton modifyInfo;
	public JButton logoutBtn;
	public JTabbedPane tabbedPane;
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SuperAdminTabbedFrame frame = new SuperAdminTabbedFrame();
////					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SuperAdminTabbedFrame() {
		setTitle("\uC790\uB3D9\uCC28 \uADF9\uC7A5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 600); // Frame 크기
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nameLabel = new JLabel("\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4!");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setBounds(254, 10, 281, 31);
		contentPane.add(nameLabel);

		gradeLabel = new JLabel("\uC9C1\uCC45 : ");
		gradeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		gradeLabel.setBounds(547, 10, 144, 31);
		contentPane.add(gradeLabel);

		modifyInfo = new JButton("\uC815\uBCF4\uC218\uC815");
		modifyInfo.setBounds(705, 10, 99, 31);
		modifyInfo.setBackground(new Color(51, 204, 255));
		contentPane.add(modifyInfo);

		logoutBtn = new JButton("\uB85C\uADF8\uC544\uC6C3");
		logoutBtn.setBounds(816, 10, 99, 31);
		logoutBtn.setBackground(new Color(51, 204, 255));
		contentPane.add(logoutBtn);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(9, 25, 940, 510); // Tab 영역 크기(Panel 크기)
		contentPane.add(tabbedPane);

//		tabbedPane.addTab("지점별 영화예매율 조회", movieReserveStaticPanel);
		tabbedPane.addTab("지점별 매출조회", chartPanel);
		tabbedPane.addTab("영화 등록", movieInsertPanel);
//		tabbedPane.addTab("영화 수정 / 삭제", moviedeletemodifyPanel);

//		setVisible(true);

		SuperAdminTabController control = new SuperAdminTabController(this);
		
		
		
		modifyInfo.addActionListener(control);
		logoutBtn.addActionListener(control);
//		salesManagePanel.GangNamMonthSales.addActionListener(control);
//		salesManagePanel.GangNamDaysSales.addActionListener(control);
//		salesManagePanel.GangBukMonthSales.addActionListener(control);
//		salesManagePanel.GangBukDaysSales.addActionListener(control);
//		salesManagePanel.GangSeoMonthSales.addActionListener(control);
//		salesManagePanel.GangSeoDaysSales.addActionListener(control);
		movieInsertPanel.registerMovieB.addActionListener(control);
//		movieInsertPanel.posterApplybtn.addActionListener(control);
		//오류나서 일단 주석으로 달아둡니다...- 나영
		moviedeletemodifyPanel.Deletebtn.addActionListener(control);
		moviedeletemodifyPanel.Modifybtn.addActionListener(control);
		moviedeletemodifyPanel.modifyfilebtn.addActionListener(control);
		moviedeletemodifyPanel.listbtn.addActionListener(control);
//		SuperAdminMovieDeleteModifyPanel.addActionListener(control);

		


//		SuperAdminMenuController control2 = new SuperAdminMenuController(this);
//		movieInsertPanel.insertImageB.addActionListener(control);
//		movieInsertPanel.registerMovieB.addActionListener(control);
////		movieInsertPanel.insertM.insertImageB.addActionListener(control);
////		movieInsertPanel.insertM.registerMovieB.addActionListener(control);
	}
}
