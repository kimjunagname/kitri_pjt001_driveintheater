package com.kitri.project.emp.controller;

import java.awt.event.*;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import com.kitri.project.calendar.MakeCalendar;
import com.kitri.project.emp.movie.service.EmpMovieService;
import com.kitri.project.emp.view.EmpMain;
import com.kitri.project.movie.dto.MovieDto;

public class EmpMovieController implements ActionListener, ItemListener {
	EmpMain empMain;
	EmpMovieService mService;
	List<MovieDto> list;
	MakeCalendar myCalendar;
	public EmpMovieController(EmpMain empMain) {
		this.empMain = empMain;
		mService = new EmpMovieService();
		myCalendar = new MakeCalendar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == empMain.tabFrame.movieMainPanel.editMovieBtn) {
			System.out.println("E_M_Controller 영화 수정버튼");
		}else if(obj == empMain.tabFrame.movieMainPanel.registerMovieBtn) {
			System.out.println("E_M_Controller 영화등록버튼");
			
			empMain.tabFrame.movieInsertPanel.startYearC.removeAll();
			empMain.tabFrame.movieInsertPanel.startMonthC.removeAll();
			empMain.tabFrame.movieInsertPanel.startDateC.removeAll();
			empMain.tabFrame.movieInsertPanel.endYearC.removeAll();
			empMain.tabFrame.movieInsertPanel.endMonthC.removeAll();
			empMain.tabFrame.movieInsertPanel.endDateC.removeAll();
			empMain.tabFrame.movieInsertPanel.time1C.removeAll();
			empMain.tabFrame.movieInsertPanel.time2C.removeAll();
			empMain.tabFrame.movieInsertPanel.time3C.removeAll();
			Calendar c = Calendar.getInstance();
			int nowYear = c.get(Calendar.YEAR);
			for (int i = nowYear; i <= nowYear+2; i++) {
				empMain.tabFrame.movieInsertPanel.startYearC.add(i+"");
				empMain.tabFrame.movieInsertPanel.endYearC.add(i+"");
			}
			
			for (int i = 0; i < 12; i++) {
				empMain.tabFrame.movieInsertPanel.startMonthC.add((i+1)+"");
				empMain.tabFrame.movieInsertPanel.endMonthC.add((i+1)+"");
			}
			for (int i = 0; i < 28; i++) {
				empMain.tabFrame.movieInsertPanel.startDateC.add((i+1)+"");
				empMain.tabFrame.movieInsertPanel.endDateC.add((i+1)+"");
			} 
			
			list = mService.selectAllMovie();
			int len = list.size();
			if(empMain.tabFrame.movieInsertPanel.movieTitleC.getItemCount() != 0) {
				empMain.tabFrame.movieInsertPanel.movieTitleC.removeAll();
			}
			for (int i = 0; i < len; i++) {
				empMain.tabFrame.movieInsertPanel.movieTitleC.add(list.get(i).getMovie_title());
			}
			
			empMain.tabFrame.movieInsertPanel.time2C.add("상영시간1을 선택");
			empMain.tabFrame.movieInsertPanel.time3C.add("상영시간2를 선택");
			int startHour = 18;
			int cnt = 0;
			for (int endHour = 26; startHour < endHour+1; ) {
				if((cnt % 2) == 0) {
					empMain.tabFrame.movieInsertPanel.time1C.add(String.valueOf(startHour) + ":00");
					empMain.tabFrame.movieInsertPanel.time2C.add(String.valueOf(startHour) + ":00");
					empMain.tabFrame.movieInsertPanel.time3C.add(String.valueOf(startHour) + ":00");
				}else {
					empMain.tabFrame.movieInsertPanel.time1C.add(String.valueOf(startHour) + ":30");
					empMain.tabFrame.movieInsertPanel.time2C.add(String.valueOf(startHour) + ":30");
					empMain.tabFrame.movieInsertPanel.time3C.add(String.valueOf(startHour) + ":30");
					startHour++;
				}
				cnt++;
			}
			
			
			empMain.tabFrame.movieInsertPanel.branchNameL.setText(EmpInfoController.login.getBranch_name());
			empMain.tabFrame.movieInsertPanel.movieTitleL.setText(list.get(0).getMovie_title());
			empMain.tabFrame.movieInsertPanel.runTimeL.setText(String.valueOf((list.get(0).getMovie_runningtime())));
			empMain.tabFrame.movieInsertPanel.movieGenreL.setText(list.get(0).getMovie_genre());
			empMain.tabFrame.movieInsertPanel.storyArea.setText(list.get(0).getMovie_story());
			empMain.tabFrame.movieInsertPanel.actorArea.setText(list.get(0).getMovie_actor());
			
			empMain.tabFrame.card.show(empMain.tabFrame.movieTabPanel, "movieInsertPanel");
		}else if(obj == empMain.tabFrame.movieInsertPanel.movieRegisterBtn) {
			System.out.println("E_M_Controller 지점영화등록버튼");
//			TODO 입력값 체크 필요	- 종료일이 시작일보다 늦은가?, 날짜 및 시간의 범위, 시간이 한개라도 입력 되었는가?, 상영 날짜 및 시간 중복여부
			MovieDto selItem = list.get(empMain.tabFrame.movieInsertPanel.movieTitleC.getSelectedIndex());
			selItem.setBranch_no(EmpInfoController.login.getBranch_no());
			String startYearMonthDate = empMain.tabFrame.movieInsertPanel.startYearC.getSelectedItem().trim();
			String startMonth = empMain.tabFrame.movieInsertPanel.startMonthC.getSelectedItem().trim();
			String startDate = empMain.tabFrame.movieInsertPanel.startDateC.getSelectedItem().trim();
			
			if(startMonth.length() == 1) {
				startYearMonthDate += "0";
			}
			startYearMonthDate += startMonth;
			
			if(startDate.length() == 1) {
				startYearMonthDate += "0";
			}
			startYearMonthDate += startDate;
			
			String endYearMonthDate = empMain.tabFrame.movieInsertPanel.endYearC.getSelectedItem().trim();
			String endMonth = empMain.tabFrame.movieInsertPanel.endMonthC.getSelectedItem().trim();
			String endDate = empMain.tabFrame.movieInsertPanel.endDateC.getSelectedItem().trim();
			
			if(endMonth.length() == 1) {
				endYearMonthDate += "0";
			}
			endYearMonthDate += endMonth;
			
			if(endDate.length() == 1) {
				endYearMonthDate += "0";
			}
			endYearMonthDate += endDate;
			
			
			selItem.setMovie_startdate(startYearMonthDate);
			selItem.setMovie_enddate(endYearMonthDate);
			/*
			selItem.setMovie_start1(empMain.tabFrame.movieInsertPanel.time1C.getText().trim());
			selItem.setMovie_start2(empMain.tabFrame.movieInsertPanel.time2C.getText().trim());
			selItem.setMovie_start3(empMain.tabFrame.movieInsertPanel.time3C.getText().trim());
			*/
			String time2 = empMain.tabFrame.movieInsertPanel.time2C.getSelectedItem().trim();
			if(time2.length() > 5) {
				time2 = null;
			}
			String time3 = empMain.tabFrame.movieInsertPanel.time3C.getSelectedItem().trim();
			if(time3.length() > 5) {
				time3 = null;
			}
			selItem.setMovie_start1(empMain.tabFrame.movieInsertPanel.time1C.getSelectedItem().trim());
			selItem.setMovie_start2(time2);
			selItem.setMovie_start3(time3);
			
			//등록 후 뷰변경 - 등록 성공여부 확인 필요
			if(mService.registerMovie(selItem)>0) {
				JOptionPane.showMessageDialog(empMain.tabFrame.movieTabPanel, "상영 영화를 등록했습니다.", "확인",	JOptionPane.INFORMATION_MESSAGE);
				empMain.tabFrame.card.show(empMain.tabFrame.movieTabPanel, "movieMainPanel");
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		
		if(obj == empMain.tabFrame.movieInsertPanel.movieTitleC) {
//			System.out.println(empMain.tabFrame.movieInsertPanel.movieTitleC.getSelectedItem());
			MovieDto selItem = list.get(empMain.tabFrame.movieInsertPanel.movieTitleC.getSelectedIndex());
			empMain.tabFrame.movieInsertPanel.movieTitleL.setText(selItem.getMovie_title());
			empMain.tabFrame.movieInsertPanel.runTimeL.setText(String.valueOf((selItem.getMovie_runningtime())));
			empMain.tabFrame.movieInsertPanel.movieGenreL.setText(selItem.getMovie_genre());
			empMain.tabFrame.movieInsertPanel.storyArea.setText(selItem.getMovie_story());
			empMain.tabFrame.movieInsertPanel.actorArea.setText(selItem.getMovie_actor());
		
			
			
			
		}else if (obj == empMain.tabFrame.movieInsertPanel.startMonthC) {
			if(empMain.tabFrame.movieInsertPanel.startYearC.getSelectedItem().isEmpty()			
					|| empMain.tabFrame.movieInsertPanel.startMonthC.getSelectedItem().isEmpty()) {
				return;
			}
			empMain.tabFrame.movieInsertPanel.startDateC.removeAll();
			
			String year = empMain.tabFrame.movieInsertPanel.startYearC.getSelectedItem();
			String month = empMain.tabFrame.movieInsertPanel.startMonthC.getSelectedItem();
			int lastDate = myCalendar.calcEndDate(year, month);
			for (int i = 1; i <= lastDate; i++) {
				empMain.tabFrame.movieInsertPanel.startDateC.add(i+"");
			}
			
			empMain.tabFrame.movieInsertPanel.endMonthC.removeAll();
			int startMonth = Integer.parseInt(empMain.tabFrame.movieInsertPanel.startMonthC.getSelectedItem().trim());
			for (int i = startMonth; i < 13; i++) {
				empMain.tabFrame.movieInsertPanel.endMonthC.add(i+"");	
			}
			
			
			
		}else if (obj == empMain.tabFrame.movieInsertPanel.startYearC) {
			empMain.tabFrame.movieInsertPanel.endYearC.removeAll();
			empMain.tabFrame.movieInsertPanel.startDateC.removeAll();
			empMain.tabFrame.movieInsertPanel.endDateC.removeAll();
			
			String year = empMain.tabFrame.movieInsertPanel.startYearC.getSelectedItem().trim();
			String month = empMain.tabFrame.movieInsertPanel.startMonthC.getSelectedItem().trim();
			int startYear = Integer.parseInt(year);
			for (int i = startYear; i < startYear+2; i++) {
				empMain.tabFrame.movieInsertPanel.endYearC.add(i+"");	
			}
			
			int lastDate = myCalendar.calcEndDate(year, month);

			for (int i = 1; i <= lastDate; i++) {
				empMain.tabFrame.movieInsertPanel.startDateC.add(i+"");	
				empMain.tabFrame.movieInsertPanel.endDateC.add(i+"");	
			}
			
			
		}else if (obj == empMain.tabFrame.movieInsertPanel.startDateC) {
			empMain.tabFrame.movieInsertPanel.endDateC.removeAll();
			int startDate = Integer.parseInt(empMain.tabFrame.movieInsertPanel.startDateC.getSelectedItem().trim());
			String year = empMain.tabFrame.movieInsertPanel.startYearC.getSelectedItem().trim();
			String month = empMain.tabFrame.movieInsertPanel.startMonthC.getSelectedItem().trim();
			
			int lastDate = myCalendar.calcEndDate(year, month);

			for (int i = startDate; i <= lastDate; i++) {
				empMain.tabFrame.movieInsertPanel.endDateC.add(i+"");	
			}
			
		}else if (obj == empMain.tabFrame.movieInsertPanel.endYearC || obj == empMain.tabFrame.movieInsertPanel.endMonthC) {
			if(empMain.tabFrame.movieInsertPanel.endYearC.getSelectedItem().isEmpty()			
					|| empMain.tabFrame.movieInsertPanel.endMonthC.getSelectedItem().isEmpty()) {
				return;
			}
			empMain.tabFrame.movieInsertPanel.endDateC.removeAll();
			String year = empMain.tabFrame.movieInsertPanel.endYearC.getSelectedItem();
			String month = empMain.tabFrame.movieInsertPanel.endMonthC.getSelectedItem();
			int lastDate = myCalendar.calcEndDate(year, month);
			for (int i = 1; i <= lastDate; i++) {
				empMain.tabFrame.movieInsertPanel.endDateC.add(i+"");
			}
		
		
		}else if(obj == empMain.tabFrame.movieInsertPanel.time1C) {
//			empMain.tabFrame.movieInsertPanel.time2C.removeAll();
//			empMain.tabFrame.movieInsertPanel.time3C.removeAll();
			
//			empMain.tabFrame.movieInsertPanel.time2C.add("상영시간1을 선택");
//			empMain.tabFrame.movieInsertPanel.time3C.add("상영시간2를 선택");
			String time1 = empMain.tabFrame.movieInsertPanel.time1C.getSelectedItem().trim();

			System.out.println(time1);
			int cnt = empMain.tabFrame.movieInsertPanel.time1C.getItemCount();
			
			int idex = 0;
			for (int i = 0; i < cnt; i++) {
				if(time1.equals(empMain.tabFrame.movieInsertPanel.time2C.getSelectedItem().trim())) {
					idex = i;
					break;
				}
			}
			
			for (int i = 1; i < idex; i++) {
				empMain.tabFrame.movieInsertPanel.time2C.remove(i);
			}
		
		
		}else if(obj == empMain.tabFrame.movieInsertPanel.time2C) {
			String time2 = empMain.tabFrame.movieInsertPanel.time2C.getSelectedItem().trim();

			System.out.println(time2);
			int cnt = empMain.tabFrame.movieInsertPanel.time2C.getItemCount();
			
			int idex = 0;
			for (int i = 0; i < cnt; i++) {
				if(time2.equals(empMain.tabFrame.movieInsertPanel.time3C.getSelectedItem().trim())) {
					idex = i;
					break;
				}
			}
			
			for (int i = 1; i < idex; i++) {
				empMain.tabFrame.movieInsertPanel.time3C.remove(i);
			}

		}
	}
}
