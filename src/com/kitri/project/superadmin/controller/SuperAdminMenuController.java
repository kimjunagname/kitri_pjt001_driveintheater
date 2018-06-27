package com.kitri.project.superadmin.controller;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;

import com.kitri.project.chart.MyChart;
import com.kitri.project.chart.dto.PayChartDto;
import com.kitri.project.chart.service.PayChartService;
import com.kitri.project.emp.controller.EmpInfoController;
import com.kitri.project.emp.view.EmpMain;
import com.kitri.project.movie.dto.MovieDto;
import com.kitri.project.superadmin.service.SuperAdminService;

public class SuperAdminMenuController implements ActionListener, ItemListener {
	EmpMain menu;
	SuperAdminService service;
	String fileName = null;
	PayChartService pService;
	ChartPanel myChartP;
	ChartPanel myMonthChartP;

	
	public SuperAdminMenuController(EmpMain menu) {
		this.menu = menu;
		service = new SuperAdminService(menu);      
		pService = new PayChartService();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == menu.superTabFrame.movieInsertPanel.insertImageB) {
			fileName = service.openFile();
		} else if (ob == menu.superTabFrame.movieInsertPanel.registerMovieB) {
			//// menu.card.show(menu.panel, "insertM");
			// // System.out.println("실행됨");
			//// } else if (ob == menu.insertM.insertImageB) {
			//// fileName = service.openFile();
			//// } else if (ob == menu.insertM.registerMovieB) {
			if (fileName != null) {
				MovieDto dto = new MovieDto();
				// no, title, poster, genre, story, actor
				dto.setMovie_title(menu.superTabFrame.movieInsertPanel.movieTitleTF.getText().trim());
				dto.setMovie_poster(fileName);
				dto.setMovie_genre(menu.superTabFrame.movieInsertPanel.movieGenreTF.getText().trim());
				dto.setMovie_story(menu.superTabFrame.movieInsertPanel.movieStroyTA.getText().trim());
				dto.setMovie_actor(menu.superTabFrame.movieInsertPanel.movieActorTA.getText().trim());
				dto.setMovie_runningtime(
						Integer.parseInt(menu.superTabFrame.movieInsertPanel.movieRuntimeTF.getText().trim()));
				// 유효성검사...나중에.....
				//
				System.out.println("실행실행");
				System.out.println(dto.getMovie_title());
				System.out.println(dto.getMovie_poster());
				System.out.println(dto.getMovie_genre());
				System.out.println(dto.getMovie_story());
				System.out.println(dto.getMovie_actor());
				System.out.println(dto.getMovie_runningtime());
				service.insertMovie(dto);
			} else {// 이미지 등록 x
				JOptionPane.showMessageDialog(menu, "이미지를 등록해주세요", "이미지등록오류", JOptionPane.WARNING_MESSAGE);
			}
			
			
			
			
		}else if(ob == menu.superTabFrame.chartPanel.yearBtn) {
			menu.superTabFrame.chartPanel.panel.removeAll();
			System.out.println("S_C_Controller 매출버튼");
			String[] categoryStr = {"년도", "총 매출금액", "현금매출", "마일리지매출"};
//			String[] valueStr = {"2018"};
//			List<PayChartDto> list = pService.getChartByYear(EmpInfoController.login.getBranch_no(), valueStr[0]);
			int branch_no = menu.superTabFrame.chartPanel.branchC.getSelectedIndex()+1;
			System.out.println("branchNO"+branch_no);
			List<PayChartDto> list = pService.getAllYearsPayChartByBranchNo(branch_no);		//해당 지점 모든 년단위 매출
			List<Object> objList = new ArrayList<>();
			int len = list.size();
			for (int i = 0; i < len; i++) {
				objList.add((Object)list.get(i));
			}
			String[] valueStr = new String[len];
			for (int i = 0; i < valueStr.length; i++) {
				valueStr[i] = list.get(i).getTerm().substring(0, 4);
			}
			
			MyChart mc = new MyChart("연간 매출 차트", "년", "매출금액", categoryStr, valueStr, objList);
			myChartP = new ChartPanel(mc.barChart);
			myChartP.setPreferredSize(new java.awt.Dimension(890, 250));
			menu.superTabFrame.chartPanel.panel.add(myChartP);
			
//			String[] columnNames = new String[]{"지점명", "총 매출금액", "현금매출", "마일리지매출"};
//			DefaultTableModel model = new DefaultTableModel(columnNames, 0);
			DefaultTableModel model = new DefaultTableModel(categoryStr, 0);
			for(int i=0; i<len; i++) {
				Object[] data = {valueStr[i], list.get(i).getTicket_paytotal(), list.get(i).getTicket_paycash(), list.get(i).getTicket_paymileage()};
				model.addRow(data);
			}
			menu.superTabFrame.chartPanel.table.setModel(model);
			menu.superTabFrame.chartPanel.scrollPane.setViewportView(menu.superTabFrame.chartPanel.table);
			menu.superTabFrame.chartPanel.show(true);
//			empMain.tabFrame.card.show(empMain.tabFrame.branchTabPanel, "chartPanel");

			if(myMonthChartP != null) {
				menu.superTabFrame.chartPanel.panel.remove(myMonthChartP);
			}

			
			
			
			
			
			
			
		}else if(ob == menu.superTabFrame.chartPanel.monthBtn) {
			menu.superTabFrame.chartPanel.panel.removeAll();
			System.out.println("SA_C_Controller 월버튼");
//			TODO 월간 차트 데이터 세팅
			String[] categoryStr = {"월", "총 매출금액", "현금매출", "마일리지매출"};
			int branch_no = menu.superTabFrame.chartPanel.branchC.getSelectedIndex()+1;
			List<PayChartDto> list = pService.getAllMonthsPayChartByBranchNo(branch_no);		//해당 지점 모든 월단위 매출 
			List<Object> objList = new ArrayList<>();
			int len = list.size();
			for (int i = 0; i < len; i++) {
				objList.add((Object)list.get(i));
			}
			String[] valueStr = new String[len];
			for (int i = 0; i < valueStr.length; i++) {
				valueStr[i] = list.get(i).getTerm().substring(0, 7);
			}
			
			MyChart monthChart = new MyChart("월간 매출 차트", "월", "매출금액", categoryStr, valueStr, objList);
			myMonthChartP = new ChartPanel(monthChart.barChart);
			myMonthChartP.setPreferredSize(new java.awt.Dimension(890, 250));
			menu.superTabFrame.chartPanel.panel.add(myMonthChartP);
			
			DefaultTableModel model = new DefaultTableModel(categoryStr, 0);
			for(int i=0; i<len; i++) {
				Object[] data = {valueStr[i], list.get(i).getTicket_paytotal(), list.get(i).getTicket_paycash(), list.get(i).getTicket_paymileage()};
				model.addRow(data);
			}
			menu.superTabFrame.chartPanel.table.setModel(model);
			menu.superTabFrame.chartPanel.scrollPane.setViewportView(menu.superTabFrame.chartPanel.table);
//			empMain.tabFrame.card.show(empMain.tabFrame.branchTabPanel, "chartPanel");
			menu.superTabFrame.chartPanel.show(true);
			
			
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}
}
