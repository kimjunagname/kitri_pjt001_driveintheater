package com.kitri.project.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.kitri.project.user.dto.UserDto;
import com.kitri.project.user.service.UserDao;
import com.kitri.project.user.service.UserService;
import com.kitri.project.user.view.*;

public class UserMenuController implements ActionListener, ItemListener, ChangeListener {
  public UserMenu menu;
  public UserService service;
  
  public UserDto userDto;
  public UserDto user;
  
  public UserMenuController(UserMenu menu) {
    this.menu = menu;
    service = new UserService(menu);
  }
  
  @SuppressWarnings("deprecation")
  @Override
  public void actionPerformed(ActionEvent e) {
    Object ob = e.getSource();
    if (ob == menu.p1.mileageBtn) {
      menu.card.show(menu.panel, "UserBenefitPanel");
    } else if (ob == menu.p1.modifyInfoBtn) {
      // System.out.println("메뉴의 userName은 "+ menu.userName.getText().trim());
      user = service.getUserByName(menu.userName.getText().trim());
      menu.p5.idF.setText(user.getUser_id());
      menu.p5.nameF.setText(user.getUser_name());
      menu.p5.emailF.setText(user.getUser_email());
      menu.p5.phoneF.setText(user.getUser_phone());
      // menu.p5.carModelC.set
      // 기존 정보 셋팅
      menu.card.show(menu.panel, "ModifyInfoP"); // 정보수정
    } else if (ob == menu.p1.movieReservationBtn) {
      System.out.println("영화예매 버튼 클릭");
      service.changeMovieInfo(1, 0); // 영화초기화
      menu.card.show(menu.panel, "MovieReservationP"); // 영화예매
     
      
    } else if (ob == menu.logoutButton) { // 로그아웃 >> 로그인창으로 이동
      // System.out.println(ob); //검증
      UserLogin userLogin = new UserLogin(); // 직접 userLogin 객체 생성
      userLogin.setVisible(true); // 화면 보여주기 설정
      menu.setVisible(false); // 기존 뷰 닫기
      // System.out.println("로그아웃"); //검증
    } else if (ob == menu.p1.ticketPayBtn) {
      menu.card.show(menu.panel, "view4");
      System.out.println("예매내역으로 이동");
      
      String userName = menu.userName.getText(); // 메뉴창에 있는 유저 이름을 가져와라
      System.out.println("usermenucontroller - " + userName);
      
      userDto = service.maSuchId(userName); // 서비스에 있는 maSuchId 메소드 호출해서 ID 가져와라
      System.out.println("usermenucontroller - userDto " + userDto);
      
      menu.p4.moviTitleP2.setText(userDto.getaMOVIE_TITLE());// 영화제목
      System.out.println("핵심" + userDto.getaMOVIE_TITLE());
      menu.p4.locationP2.setText(userDto.getaBRANCH_NAME()); // 지점명
      menu.p4.openTimeP2.setText(userDto.getaMOVIE_PALYDATE());// 상영일
      System.out.println("핵심" + userDto.getaMOVIE_PALYDATE());
      
      int chpay = userDto.getaTICKET_PAYCASH(); // String > int 변환
      String chpay1 = Integer.toString(chpay);
      menu.p4.chPayP2.setText(chpay1);// 현금결재
      
      int payMileage = userDto.getaTICKET_PAYMILEAGE();
      String payMileage1 = Integer.toString(payMileage);
      menu.p4.mailP2.setText(payMileage1);// 마일리지 결재
      
      int payTotal = userDto.getaTICKET_PAYTOTAL();
      String payTotal1 = Integer.toString(payTotal);
      menu.p4.totalPayP2.setText(payTotal1);// 총금액
      
      System.out.println("dao : " + userDto.getaUSER_ID() + "" + userDto.getaUSER_NO() + ""
          + userDto.getaMOVIE_PALYDATE() + "" + userDto.getaMOVIE_TITLE() + "" + userDto.getaBRANCH_NAME() + ""
          + userDto.getaTICKET_PAYCASH() + "" + userDto.getaTICKET_PAYMILEAGE() + "" + userDto.getaTICKET_PAYTOTAL());
      menu.p4.setVisible(true);
      menu.card.show(menu.panel, "view4");
      
    } else if (ob == menu.p4.backP2) {
      menu.p4.setVisible(false);// p4를 내리고
      menu.card.show(menu.p1, "menu"); // 메뉴로 돌아감
      menu.p1.setVisible(true);// p1을 보여라
      // System.out.println("menu.p4.backP2" + menu.p4.backP2);
      
    } else if (ob == menu.p2_1.backB) {
      menu.card.show(menu.panel, "menu"); // 메뉴로 돌아감
    } else if (ob == menu.p2_1.reservationB) { // 예매 누르면 >> 예매창으로 이동 필요
      menu.card.show(menu.panel, "MovieReservationP2");
    } else if (ob == menu.p2_1.movieInfoB) { // 예매 누르면 >> 예매창으로 이동 필요
      service.getMovieDetail(); // 수정수정수정
      menu.p9.setVisible(true);
    } else if (ob == menu.p2_2.backB) {
      menu.card.show(menu.panel, "MovieReservationP");
    } else if (ob == menu.p2_2.paymentB) {
      if (menu.p2_2.totalpriceL.getText().equals("0"))
        JOptionPane.showMessageDialog(menu.panel, "차종을 선택해주세요", "차종선택오류", JOptionPane.WARNING_MESSAGE);
      else {
        String userName = menu.userName.getText(); // 메뉴에 있는 유저이름
        int branchNo = menu.p2_2.branchL.getText().equals("서울") ? 1 : 2;
        int movieNo;
        if (branchNo == 1)
          movieNo = menu.p2_1.p1_1.slider.getValue();
        else // 2일떄
          movieNo = menu.p2_1.p1_2.slider.getValue(); // 슬라이더에서 값 받아오기
        String showDay = menu.p2_2.showdayC.getSelectedItem();
        String showTime = menu.p2_2.showtimeC.getSelectedItem();
        String carType = menu.p2_2.cartypeC.getSelectedItem();
        int total = Integer.parseInt(menu.p2_2.totalpriceL.getText());
        int mileage = 0;
        if (!menu.p2_2.mileageF.equals("")) // 비지않았다면
          mileage = Integer.parseInt(menu.p2_2.mileageF.getText());
        
        int num = service.insertReservation(userName, branchNo, movieNo, showDay, showTime, carType, total, mileage);
        
        if (num >= 1)
          JOptionPane.showMessageDialog(menu.panel, "영화예매에 성공하셨습니다");
        else
          JOptionPane.showMessageDialog(menu.panel, "영화예매에 실패하셨습니다");
      }
    } else if (ob == menu.p2_2.paymentCancelB) {
      menu.card.show(menu.panel, "menu");
      menu.p1.setVisible(true);// p1을 보여라
      // } else if (ob == menu.p2_2.nextB) {
      // menu.card.show(menu.panel, "MovieReservationP3");
      // } else if (ob == menu.p2_3.backB) {
      // menu.card.show(menu.panel, "MovieReservationP2");
      // } else if (ob == menu.p2_3.payment_cancelB) {
      // menu.card.show(menu.panel, "menu");
    } else if (ob == menu.p5.backB) {
      menu.card.show(menu.panel, "menu"); // 메뉴로 돌아감
    } else if (ob == menu.p5.modifyB) {
      String id = menu.p5.idF.getText();
      String pwd = new String(menu.p5.passwordField_1.getPassword());
      String re_pwd = new String(menu.p5.passwordField_2.getPassword());
      String carType = menu.p5.carModelC.getSelectedItem().trim();
      String name = menu.p5.nameF.getText().trim();
      String email = menu.p5.emailF.getText().trim();
      String phone = menu.p5.phoneF.getText().trim();
      
      int result = 0;
      
      if (pwd.equals("") || re_pwd.equals("")) {
        JOptionPane.showMessageDialog(menu.panel, "비밀번호가 입력되지 않았습니다", "비밀번호 입력 오류", JOptionPane.WARNING_MESSAGE);
      } else if (!pwd.equals(re_pwd)) {
        JOptionPane.showMessageDialog(menu.panel, "비밀번호가 맞지 않습니다", "비밀번호 입력 오류", JOptionPane.WARNING_MESSAGE);
        
        menu.p5.passwordField_1.setText("");
        menu.p5.passwordField_2.setText("");
      } else {
        result = service.modifyUserInfo(id, pwd, re_pwd, carType, name, email, phone);
      }
      
      if (result >= 1) {
        // System.out.println("userUpdate 성공");
        menu.p5.passwordField_1.setText("");
        menu.p5.passwordField_2.setText("");
        menu.card.show(menu.panel, "menu");
      } else
        System.out.println("userUpdate 실패");
    } else if (ob == menu.p6.back) {
      menu.card.show(menu.panel, "menu");
    } else if (ob == menu.p6.upBtn) {
      menu.card.show(menu.panel, "UserMileageView");
    } else if (ob == menu.p7.backB) {
      menu.card.show(menu.panel, "menu");
    } else if (ob == menu.p4.backP2) {
      menu.p4.setVisible(false);
      menu.card.show(menu.panel, "menu");
      menu.setVisible(false);
      
    } else if (ob == menu.p4.payCancleP2) {
      
      System.out.println("UserMenun 컨트롤러 - 취소버튼 클릭");
      // 메뉴창에 있는 유저 이름을 가져와라
      String userName = menu.userName.getText();
      System.out.println("user menu controller - " + userName);
      
      int result = 0;
      result = service.deletPayNo(userName); // 서비스에 있는 maSuchId 메소드 호출해서 ID 가져와라
      System.out.println("usermenucontroller - result " + result);
      
      if (result >= 1) {
        System.out.println("UserMenuController - 결재 취소 성공");
        JOptionPane.showMessageDialog(menu, "결재가 취소 되었습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
        menu.card.show(menu.panel, "menu"); // 결재 취소 버튼 누르면 알럿트 창뜨고, 취소 메뉴창으로 이동 예정 - menu 대신 다른곳으로 LIST
      } else {
        System.out.println("UserMenuController - 결재 취소 실패");
        JOptionPane.showMessageDialog(menu, "결재가 실패 하였습니다. 관리자에게 문의 하세요.", "정보", JOptionPane.INFORMATION_MESSAGE);
      }
      
    } else if (ob == menu.p9.okB) { // 예매 누르면 >> 예매창으로 이동 필요
      menu.p9.setVisible(false);
    }
  }
  
  @Override
  public void itemStateChanged(ItemEvent e) {
    Object ob = e.getSource();
    
    // System.out.println("choice 값은 "+menu.p2_1.choice.getSelectedIndex());
    // 영화예매 choice
    if (ob == menu.p2_1.choice) {
      if (menu.p2_1.choice.getSelectedItem().equals("서울")) {
        service.changeMovieInfo(1, 0);
        menu.p2_1.card.show(menu.p2_1.movieInfoP, "p1_1");
      } else if (menu.p2_1.choice.getSelectedItem().equals("인천")) {
        service.changeMovieInfo(2, 0);
        menu.p2_1.card.show(menu.p2_1.movieInfoP, "p1_2");
      } else
        System.out.println("잘못넣었따...");
    } else if (ob == menu.p2_2.cartypeC) {
      // System.out.println("선택아이템은"+menu.p2_2.cartypeC.getSelectedItem());
      if (menu.p2_2.cartypeC.getSelectedItem().equals("소형차"))
        menu.p2_2.totalpriceL.setText("7000"); // 시간나면 db에서 끌어오기
      else if (menu.p2_2.cartypeC.getSelectedItem().equals("중형차"))
        menu.p2_2.totalpriceL.setText("8000");
      else if (menu.p2_2.cartypeC.getSelectedItem().equals("대형차"))
        menu.p2_2.totalpriceL.setText("9000");
      else
        menu.p2_2.totalpriceL.setText("0");
      menu.p2_2.totalpriceL.setVisible(false);
      menu.p2_2.totalpriceL.setVisible(true);
    }
    // 월에 따라 날짜 변경
    // if (ob == menu.p5.monthC) {
    // service.changeDay();
    // }
    
  }
  
  @Override
  public void stateChanged(ChangeEvent e) {
    // JSlider용
    Object ob = e.getSource();
    
    // System.out.println("slider 값은 "+ menu.p2_1.p1_1.slider.getValue());
    if (ob == menu.p2_1.p1_1.slider) {
      System.out.println(menu.p2_1.choice.getSelectedIndex());
      int idx = menu.p2_1.choice.getSelectedIndex();
      int value = menu.p2_1.p1_1.slider.getValue(); // 0부터 시작함
      // System.out.println("J슬라이더 값 얻어오기 : "+ value);
      service.changeMovieInfo(idx + 1, value - 1);
    } else if (ob == menu.p2_1.p1_2.slider) {
      int idx = menu.p2_1.choice.getSelectedIndex();
      int value = menu.p2_1.p1_2.slider.getValue(); // 0부터 시작함
      // System.out.println("idx값 : "+idx+ " J슬라이더 값 : "+ value);
      service.changeMovieInfo(idx + 1, value - 1);
    }
  }
}