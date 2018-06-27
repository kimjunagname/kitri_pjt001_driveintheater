package com.kitri.project.superadmin.controller;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.kitri.project.emp.view.EmpMain;
import com.kitri.project.superadmin.view.*;

public class SuperAdminTabController implements ActionListener {
	SuperAdminTabbedFrame menu;

	public SuperAdminTabController(SuperAdminTabbedFrame menu) {
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == menu.modifyInfo) {
			System.out.println("정보수정");
		} else if (ob == menu.logoutBtn) {
			EmpMain main= new EmpMain();
			menu.setVisible(false);
		} else if (ob == menu.salesManagePanel.GangNamMonthSales) {
			System.out.println("강남지역 월매출 조회 패널 삽입");
		} else if (ob == menu.salesManagePanel.GangNamDaysSales) {
			System.out.println("강남지역 일매출 조회 패널 삽입");
		} else if (ob == menu.salesManagePanel.GangBukMonthSales) {
			System.out.println("강북지역 월매출 조회 패널 삽입");
		} else if (ob == menu.salesManagePanel.GangBukDaysSales) {
			System.out.println("강북지역 일매출 조회 패널 삽입");
		} else if (ob == menu.salesManagePanel.GangSeoMonthSales) {
			System.out.println("강서지역 월매출 조회 패널 삽입");
		} else if (ob == menu.salesManagePanel.GangSeoDaysSales) {
			System.out.println("강서지역 일매출 조회 패널 삽입");
		} else if (ob == menu.movieInsertPanel.registerMovieB) {
			String movietitle = menu.movieInsertPanel.movieTitleTF.getText();
			String runtime = menu.movieInsertPanel.movieRuntimeTF.getText();
			String genre = menu.movieInsertPanel.movieGenreTF.getText();
			String story = menu.movieInsertPanel.movieStroyTA.getText();
			String actorinfo = menu.movieInsertPanel.movieActorTA.getText();
			String posterpic = menu.movieInsertPanel.imagePathF.getText();
//			if (movieno.isEmpty() == true || movietitle.isEmpty() == true || runtime.isEmpty() == true
//					|| genre.isEmpty() == true || story.isEmpty() == true || actorinfo.isEmpty() == true
//					|| posterpic.isEmpty() == true) {
//				JOptionPane.showMessageDialog(menu.movieInsertPanel, "영화 정보들이 비어있습니다. 확인후 다시 입력해주세요.",
//						"자동차극장 - SuperVisor", JOptionPane.WARNING_MESSAGE);
//			} else {
//				// 영화 정보들 DB이용하여 Insert 처리해준다. 내일 할일 
//				JOptionPane.showMessageDialog(menu.movieInsertPanel, "영화 등록처리가 완료되었습니다.",
//						"자동차극장 - SuperVisor", JOptionPane.INFORMATION_MESSAGE);
//				menu.movieInsertPanel.movieNoTF.setText("");
//				menu.movieInsertPanel.movieTitleTF.setText("");
//				menu.movieInsertPanel.movieruntimeTF.setText("");
//				menu.movieInsertPanel.movieGenreTF.setText("");
//				menu.movieInsertPanel.movieStroyTA.setText("");
//				menu.movieInsertPanel.movieActorTA.setText("");
//				menu.movieInsertPanel.imagePathF.setText("");
//			}
			//오류나서 잠시 주석으로 바꿉니다 ㅠㅠ movieno는 시퀀스로 자동 등록하기로해서 movieinsert패널에서 없앴습니다..
			//dao에서 가져다 쓰시면 될 것 같습니다.. -나영
		}
//		} else if (ob == menu.movieInsertPanel.posterApplybtn) {
//            FileDialog openP = new FileDialog(menu, "영화 포스터 입력", FileDialog.LOAD);
//            openP.setVisible(true);
//            String filename = openP.getDirectory() + File.separator + openP.getFile();
//            BufferedReader in = null;     
//            Image poster = null;         
//            try {
//            	in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename))));
//				menu.movieInsertPanel.moviePosterImageTF.setText(filename);							
//            } catch (Exception e1) {
//				// TODO: handle exception
//            	System.out.println("지정파일이 아닙니다.");
//			}
//            
//
//		}

	}
}
