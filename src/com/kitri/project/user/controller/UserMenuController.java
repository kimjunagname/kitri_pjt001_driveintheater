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
      // System.out.println("�޴��� userName�� "+ menu.userName.getText().trim());
      user = service.getUserByName(menu.userName.getText().trim());
      menu.p5.idF.setText(user.getUser_id());
      menu.p5.nameF.setText(user.getUser_name());
      menu.p5.emailF.setText(user.getUser_email());
      menu.p5.phoneF.setText(user.getUser_phone());
      // menu.p5.carModelC.set
      // ���� ���� ����
      menu.card.show(menu.panel, "ModifyInfoP"); // ��������
    } else if (ob == menu.p1.movieReservationBtn) {
      System.out.println("��ȭ���� ��ư Ŭ��");
      service.changeMovieInfo(1, 0); // ��ȭ�ʱ�ȭ
      menu.card.show(menu.panel, "MovieReservationP"); // ��ȭ����
     
      
    } else if (ob == menu.logoutButton) { // �α׾ƿ� >> �α���â���� �̵�
      // System.out.println(ob); //����
      UserLogin userLogin = new UserLogin(); // ���� userLogin ��ü ����
      userLogin.setVisible(true); // ȭ�� �����ֱ� ����
      menu.setVisible(false); // ���� �� �ݱ�
      // System.out.println("�α׾ƿ�"); //����
    } else if (ob == menu.p1.ticketPayBtn) {
      menu.card.show(menu.panel, "view4");
      System.out.println("���ų������� �̵�");
      
      String userName = menu.userName.getText(); // �޴�â�� �ִ� ���� �̸��� �����Ͷ�
      System.out.println("usermenucontroller - " + userName);
      
      userDto = service.maSuchId(userName); // ���񽺿� �ִ� maSuchId �޼ҵ� ȣ���ؼ� ID �����Ͷ�
      System.out.println("usermenucontroller - userDto " + userDto);
      
      menu.p4.moviTitleP2.setText(userDto.getaMOVIE_TITLE());// ��ȭ����
      System.out.println("�ٽ�" + userDto.getaMOVIE_TITLE());
      menu.p4.locationP2.setText(userDto.getaBRANCH_NAME()); // ������
      menu.p4.openTimeP2.setText(userDto.getaMOVIE_PALYDATE());// ����
      System.out.println("�ٽ�" + userDto.getaMOVIE_PALYDATE());
      
      int chpay = userDto.getaTICKET_PAYCASH(); // String > int ��ȯ
      String chpay1 = Integer.toString(chpay);
      menu.p4.chPayP2.setText(chpay1);// ���ݰ���
      
      int payMileage = userDto.getaTICKET_PAYMILEAGE();
      String payMileage1 = Integer.toString(payMileage);
      menu.p4.mailP2.setText(payMileage1);// ���ϸ��� ����
      
      int payTotal = userDto.getaTICKET_PAYTOTAL();
      String payTotal1 = Integer.toString(payTotal);
      menu.p4.totalPayP2.setText(payTotal1);// �ѱݾ�
      
      System.out.println("dao : " + userDto.getaUSER_ID() + "" + userDto.getaUSER_NO() + ""
          + userDto.getaMOVIE_PALYDATE() + "" + userDto.getaMOVIE_TITLE() + "" + userDto.getaBRANCH_NAME() + ""
          + userDto.getaTICKET_PAYCASH() + "" + userDto.getaTICKET_PAYMILEAGE() + "" + userDto.getaTICKET_PAYTOTAL());
      menu.p4.setVisible(true);
      menu.card.show(menu.panel, "view4");
      
    } else if (ob == menu.p4.backP2) {
      menu.p4.setVisible(false);// p4�� ������
      menu.card.show(menu.p1, "menu"); // �޴��� ���ư�
      menu.p1.setVisible(true);// p1�� ������
      // System.out.println("menu.p4.backP2" + menu.p4.backP2);
      
    } else if (ob == menu.p2_1.backB) {
      menu.card.show(menu.panel, "menu"); // �޴��� ���ư�
    } else if (ob == menu.p2_1.reservationB) { // ���� ������ >> ����â���� �̵� �ʿ�
      menu.card.show(menu.panel, "MovieReservationP2");
    } else if (ob == menu.p2_1.movieInfoB) { // ���� ������ >> ����â���� �̵� �ʿ�
      service.getMovieDetail(); // ������������
      menu.p9.setVisible(true);
    } else if (ob == menu.p2_2.backB) {
      menu.card.show(menu.panel, "MovieReservationP");
    } else if (ob == menu.p2_2.paymentB) {
      if (menu.p2_2.totalpriceL.getText().equals("0"))
        JOptionPane.showMessageDialog(menu.panel, "������ �������ּ���", "�������ÿ���", JOptionPane.WARNING_MESSAGE);
      else {
        String userName = menu.userName.getText(); // �޴��� �ִ� �����̸�
        int branchNo = menu.p2_2.branchL.getText().equals("����") ? 1 : 2;
        int movieNo;
        if (branchNo == 1)
          movieNo = menu.p2_1.p1_1.slider.getValue();
        else // 2�ϋ�
          movieNo = menu.p2_1.p1_2.slider.getValue(); // �����̴����� �� �޾ƿ���
        String showDay = menu.p2_2.showdayC.getSelectedItem();
        String showTime = menu.p2_2.showtimeC.getSelectedItem();
        String carType = menu.p2_2.cartypeC.getSelectedItem();
        int total = Integer.parseInt(menu.p2_2.totalpriceL.getText());
        int mileage = 0;
        if (!menu.p2_2.mileageF.equals("")) // �����ʾҴٸ�
          mileage = Integer.parseInt(menu.p2_2.mileageF.getText());
        
        int num = service.insertReservation(userName, branchNo, movieNo, showDay, showTime, carType, total, mileage);
        
        if (num >= 1)
          JOptionPane.showMessageDialog(menu.panel, "��ȭ���ſ� �����ϼ̽��ϴ�");
        else
          JOptionPane.showMessageDialog(menu.panel, "��ȭ���ſ� �����ϼ̽��ϴ�");
      }
    } else if (ob == menu.p2_2.paymentCancelB) {
      menu.card.show(menu.panel, "menu");
      menu.p1.setVisible(true);// p1�� ������
      // } else if (ob == menu.p2_2.nextB) {
      // menu.card.show(menu.panel, "MovieReservationP3");
      // } else if (ob == menu.p2_3.backB) {
      // menu.card.show(menu.panel, "MovieReservationP2");
      // } else if (ob == menu.p2_3.payment_cancelB) {
      // menu.card.show(menu.panel, "menu");
    } else if (ob == menu.p5.backB) {
      menu.card.show(menu.panel, "menu"); // �޴��� ���ư�
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
        JOptionPane.showMessageDialog(menu.panel, "��й�ȣ�� �Էµ��� �ʾҽ��ϴ�", "��й�ȣ �Է� ����", JOptionPane.WARNING_MESSAGE);
      } else if (!pwd.equals(re_pwd)) {
        JOptionPane.showMessageDialog(menu.panel, "��й�ȣ�� ���� �ʽ��ϴ�", "��й�ȣ �Է� ����", JOptionPane.WARNING_MESSAGE);
        
        menu.p5.passwordField_1.setText("");
        menu.p5.passwordField_2.setText("");
      } else {
        result = service.modifyUserInfo(id, pwd, re_pwd, carType, name, email, phone);
      }
      
      if (result >= 1) {
        // System.out.println("userUpdate ����");
        menu.p5.passwordField_1.setText("");
        menu.p5.passwordField_2.setText("");
        menu.card.show(menu.panel, "menu");
      } else
        System.out.println("userUpdate ����");
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
      
      System.out.println("UserMenun ��Ʈ�ѷ� - ��ҹ�ư Ŭ��");
      // �޴�â�� �ִ� ���� �̸��� �����Ͷ�
      String userName = menu.userName.getText();
      System.out.println("user menu controller - " + userName);
      
      int result = 0;
      result = service.deletPayNo(userName); // ���񽺿� �ִ� maSuchId �޼ҵ� ȣ���ؼ� ID �����Ͷ�
      System.out.println("usermenucontroller - result " + result);
      
      if (result >= 1) {
        System.out.println("UserMenuController - ���� ��� ����");
        JOptionPane.showMessageDialog(menu, "���簡 ��� �Ǿ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
        menu.card.show(menu.panel, "menu"); // ���� ��� ��ư ������ �˷�Ʈ â�߰�, ��� �޴�â���� �̵� ���� - menu ��� �ٸ������� LIST
      } else {
        System.out.println("UserMenuController - ���� ��� ����");
        JOptionPane.showMessageDialog(menu, "���簡 ���� �Ͽ����ϴ�. �����ڿ��� ���� �ϼ���.", "����", JOptionPane.INFORMATION_MESSAGE);
      }
      
    } else if (ob == menu.p9.okB) { // ���� ������ >> ����â���� �̵� �ʿ�
      menu.p9.setVisible(false);
    }
  }
  
  @Override
  public void itemStateChanged(ItemEvent e) {
    Object ob = e.getSource();
    
    // System.out.println("choice ���� "+menu.p2_1.choice.getSelectedIndex());
    // ��ȭ���� choice
    if (ob == menu.p2_1.choice) {
      if (menu.p2_1.choice.getSelectedItem().equals("����")) {
        service.changeMovieInfo(1, 0);
        menu.p2_1.card.show(menu.p2_1.movieInfoP, "p1_1");
      } else if (menu.p2_1.choice.getSelectedItem().equals("��õ")) {
        service.changeMovieInfo(2, 0);
        menu.p2_1.card.show(menu.p2_1.movieInfoP, "p1_2");
      } else
        System.out.println("�߸��־���...");
    } else if (ob == menu.p2_2.cartypeC) {
      // System.out.println("���þ�������"+menu.p2_2.cartypeC.getSelectedItem());
      if (menu.p2_2.cartypeC.getSelectedItem().equals("������"))
        menu.p2_2.totalpriceL.setText("7000"); // �ð����� db���� �������
      else if (menu.p2_2.cartypeC.getSelectedItem().equals("������"))
        menu.p2_2.totalpriceL.setText("8000");
      else if (menu.p2_2.cartypeC.getSelectedItem().equals("������"))
        menu.p2_2.totalpriceL.setText("9000");
      else
        menu.p2_2.totalpriceL.setText("0");
      menu.p2_2.totalpriceL.setVisible(false);
      menu.p2_2.totalpriceL.setVisible(true);
    }
    // ���� ���� ��¥ ����
    // if (ob == menu.p5.monthC) {
    // service.changeDay();
    // }
    
  }
  
  @Override
  public void stateChanged(ChangeEvent e) {
    // JSlider��
    Object ob = e.getSource();
    
    // System.out.println("slider ���� "+ menu.p2_1.p1_1.slider.getValue());
    if (ob == menu.p2_1.p1_1.slider) {
      System.out.println(menu.p2_1.choice.getSelectedIndex());
      int idx = menu.p2_1.choice.getSelectedIndex();
      int value = menu.p2_1.p1_1.slider.getValue(); // 0���� ������
      // System.out.println("J�����̴� �� ������ : "+ value);
      service.changeMovieInfo(idx + 1, value - 1);
    } else if (ob == menu.p2_1.p1_2.slider) {
      int idx = menu.p2_1.choice.getSelectedIndex();
      int value = menu.p2_1.p1_2.slider.getValue(); // 0���� ������
      // System.out.println("idx�� : "+idx+ " J�����̴� �� : "+ value);
      service.changeMovieInfo(idx + 1, value - 1);
    }
  }
}