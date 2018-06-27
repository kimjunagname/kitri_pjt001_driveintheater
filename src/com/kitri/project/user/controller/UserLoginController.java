package com.kitri.project.user.controller;

import java.awt.event.*;
import javax.swing.*;
import com.kitri.project.cartype.CarTypeService;
import com.kitri.project.user.dto.UserDto;
import com.kitri.project.user.service.UserLoginService;
import com.kitri.project.user.view.UserLogin;
import com.kitri.project.user.view.UserMenu;

//ActionListener�� �ޱ� ���� ActionListener ���
public class UserLoginController implements ActionListener, MouseListener {
  
  public UserLogin login; // UserLogin ���� ����
  public UserMenu userMenu;
  public UserLoginService userLoginService; // UserService ���� ����
  public UserDto userDto;
  public String id;
  public String pass;
  public String nameP3, emailP3;
  public String idTextP4, emailTextP4;
  public CarTypeService cservice = new CarTypeService();

  public String user_ID;//���̵�
  public String user_PWD;//��ȣ
  public String user_PWD1;//��ȣ 
//  public int carType_NO;//������ȣ
  public String carType_NO;//������ȣ
  public String user_NAME;//�̸�
  public String user_EMAIL;//�̸���
  public String user_PHONE;//�ڵ���

  
  public UserLoginController(UserLogin login) {
    // UserLogin ��� UserLoginController ����
    this.login = login;
    userLoginService = new UserLoginService(); // userservice�� ����
  }
  
  
  public UserLoginController(UserMenu userMenu) {
    this.userMenu = userMenu;
    userMenu = new UserMenu();
  }
  
  
  
  @Override
  public void actionPerformed(ActionEvent e) {
    // UserLogin ��ư �׼ǽ� �ൿ ����
    Object ob = e.getSource();
    if (ob == login.p1.joinButtonp1) {// ȸ������ �� �̵�
      System.out.println("ȸ�� ���� ��ư Ŭ��");
      login.card.show(login.panel, "joinView2");
    } else if (ob == login.p1.loginButtonp1) {// UserMenu �̵�
      
      System.out.println("�α��� ��ư Ŭ��");
      
      //1. login �信�� id(���� �ҹ���ȭ), pwd �� ��������
      id = login.p1.idintextp1.getText().trim().toLowerCase();
      pass = new String(login.p1.pwdintextp1.getPassword());
      
      //2. login �信�� id, pwd �� ��� ����
      System.out.println("�信�� controller�� ������ id: " + id + "\t pass: " + pass);
      
      //3. userDto(id, pass) ȣ���ؼ� null �ƴ� �� ��������
      userDto = userLoginService.login(id, pass);
      System.out.println("userDto: " + userDto);
      
      //4. �α��� ���� -- memberDto�� ������ ������(��񿡼� ���� ����� ������ ���)
      if (userDto != null) {
        JOptionPane.showMessageDialog(login, "�α��� ����", "����", JOptionPane.INFORMATION_MESSAGE);
        
        //userDto ���� Ŭ������ ������ ��ü�� userloginService�� nameSuch �޼ҵ忡 id �� �ֱ�
        userDto = userLoginService.nameSuch(id);    
        String name = userDto.getUser_name();
        
            System.out.println(name);
            //�α��� �޴� ȭ�鿡 �̸� ǥ��
            login.userMenuframe.userName.setText(name);
            
            System.out.println("��Ʈ�ѷ� id" + id);
            System.out.println("��Ʈ�ѷ� userDto" + userDto);
            System.out.println("��Ʈ�ѷ� userDto.getUser_name():" + userDto.getUser_name());          
            System.out.println("��Ʈ�ѷ� name:" + name);
            
           System.out.println("��Ʈ�ѷ� id" + id);
           userDto = userLoginService.gradeSuch(id);
           String gread = userDto.getGrade_name();
           System.out.println("��Ʈ�ѷ� userDto" + userDto.getGrade_name());
           System.out.println("��Ʈ�ѷ� userDto.getGrade_name():" + userDto.getGrade_name());          
           System.out.println("��Ʈ�ѷ� gread:" + gread);
           login.userMenuframe.userGrade.setText(gread);
           
            login.userMenuframe.setVisible(true);
            login.setVisible(false);

          
      } else {
        login.setVisible(true); // �α��� ȭ�� �����ֱ� ����
        login.setVisible(false);
      }
      
    } else if (ob == login.p1.idSuchButtenp1) {// id �̵�
      login.card.show(login.panel, "idsuchView3");
      System.out.println("ID ã�� ��ư Ŭ��");
    } else if (ob == login.p1.pwdSuchButtenp1) {// pwd �̵�
      login.card.show(login.panel, "pwdsuchView4");
      System.out.println("PWD ã�� ��ư Ŭ��");
      /////////////////////////////////////////////////////////// P2
    } else if (ob == login.p2.joinBettonP5) {// ���� ��ư
      
      System.out.println("���� ��ư Ŭ��");
//      // UserMemberJoinPanel2 �信�� id, pwd, ����, �̸�, e-mail, ��ȭ��ȣ  �� ��������      
      user_ID = login.p2.idTextP5.getText().trim();//���̵�
      
      user_PWD = new String(login.p2.passwordFieldP5_1.getPassword());//��ȣ
      user_PWD1  = new String(login.p2.passwordFieldP5_2.getPassword());
      carType_NO = login.p2.carModelCP5.getSelectedItem();
//      carType_NO = (Integer.parseInt(login.p2.carModelCP5.getSelectedItem())) ;//������ȣ
      user_NAME = login.p2.nameTextp5.getText();//�̸�
      user_EMAIL = login.p2.emailTextP5.getText();//�̸���
      user_PHONE = login.p2.phoneTextP5.getText();//��ȭ��ȣ
               
      System.out.println("�信�� controller�� ������ user_ID: " + user_ID + "\t user_PWD: " + user_PWD +   "\t user_PWD1: " + user_PWD1 +    "\t carType_NO: " + carType_NO
                                        + "\t user_NAME: " +user_NAME+ "\t user_EMAIL: " + user_EMAIL+ "\t user_PHONE: " + user_PHONE); 
      // sertivic(id, pass) ȣ���ؼ� �� ��������
      userDto = userLoginService.join(user_ID, user_PWD,user_PWD1, carType_NO, user_NAME, user_EMAIL, user_PHONE);

      if (userDto == null) {// �α��� ���� -- memberDto�� ������ ������(��񿡼� ���� ����� ������ ���)
        JOptionPane.showMessageDialog(login.userLoginFrame, "ȸ�� ������ �����Ͽ����ϴ�. �α��� ȭ������ �̵��մϴ�.","����", JOptionPane.WARNING_MESSAGE);
        UserLogin userLogin = new UserLogin(); // ���� userLogin ��ü ����
        userLogin.setVisible(true); // �α��� ȭ�� �����ֱ� ����
        login.setVisible(false);
      } else {
        JOptionPane.showMessageDialog(login.userLoginFrame, "�ٽ� �ۼ��Ͽ� �ֽñ� �ٶ��ϴ�.","����", JOptionPane.WARNING_MESSAGE);  
      }
        
    } else if (ob == login.p2.BackButtenP5) {// �ڷΰ��� ��ư
//       JOptionPane.showMessageDialog(login.userLoginFrame, "BACK ��ư�� Ŭ�� �ϼ̽��ϴ�.","BACK", JOptionPane.WARNING_MESSAGE);
      UserLogin userLogin = new UserLogin(); // ���� userLogin ��ü ����
      userLogin.setVisible(true); // �α��� ȭ�� �����ֱ� ����
      login.setVisible(false); // ȸ�� ���� ȭ�� �ݱ�
    }
    /////////////////////////////////////////////////////////// P3
      else if (ob == login.p3.suchButtonP3) {// ��ȸ ��ư
      
      System.out.println("��ȸ��ư Ŭ��");
      // name, email �� ��������
      nameP3 = login.p3.nameTextP3.getText().trim();
      emailP3 = login.p3.emailTextP3.getText().trim();
      
      // id such �信�� name, email �� ���
      System.out.println("�信�� controller�� ������ id: " + nameP3 + "\t pass: " + emailP3);
      
      // userDto(name, email) ȣ���ؼ� �� ��������
      userDto = userLoginService.idsuch(nameP3, emailP3);
      System.out.println("��Ʈ�ѷ� - userDto: " + userDto.getUser_id());
      
      if (userDto != null) {// (��񿡼� ���� ����� ������ ���)
        JOptionPane.showMessageDialog(login, "id ��ȸ����", "����", JOptionPane.INFORMATION_MESSAGE);
        
        login.p3_2.idSuchTextP3_2.setText(userDto.getUser_id());
        login.card.show(login.panel, "p3_2");
        login.p3_2.setVisible(true);
        login.p3.setVisible(false);
        
      }
    } else if (ob == login.p3.backBtnP3) {// Iback ��ư
      // JOptionPane.showMessageDialog(login.userLoginFrame, "BACK ��ư�� Ŭ�� �ϼ̽��ϴ�.", "����
      // �ȳ�", JOptionPane.INFORMATION_MESSAGE);
      UserLogin userLogin = new UserLogin(); // ���� userLogin ��ü ����
      userLogin.setVisible(true); // �α��� ȭ�� �����ֱ� ����
      login.setVisible(false); // ȸ�� ���� ȭ�� �ݱ�
      
    }
    /////////////////////////////////////////////////////////// P4
    else if (ob == login.p4.backButtonP4) {// back butten
      // JOptionPane.showMessageDialog(login.userLoginFrame, "BACK ��ư�� Ŭ�� �ϼ̽��ϴ�.", "����
      // �ȳ�", JOptionPane.INFORMATION_MESSAGE);
      UserLogin userLogin = new UserLogin(); // ���� userLogin ��ü ����
      userLogin.setVisible(true); // �α��� ȭ�� �����ֱ� ����
      login.setVisible(false); // ȸ�� ���� ȭ�� �ݱ�
      
    } else if (ob == login.p4.suchButtenP4) {// ��ȸ butten
      System.out.println("��ȸ��ư Ŭ��");
      // idTextP4, emailTextP4, �� ��������
      idTextP4 = login.p4.idTextP4.getText().trim();
      emailTextP4 = login.p4.emailTextP4.getText().trim();
      
      // pwsuch �信�� idTextP4, emailTextP4 �� ���
      System.out.println("�信�� controller�� ������ idTextP4: " + idTextP4 + "\t emailTextP4: " + emailTextP4);
      
      // userDto(idTextP4, emailTextP4) ȣ���ؼ� �� ��������
      userDto = userLoginService.pwdsuch(idTextP4, emailTextP4);
      System.out.println("��Ʈ�ѷ� - userDto: " + userDto.getUser_pwd());
      
      if (userDto != null) {// (��񿡼� ���� ����� ������ ���)
        // JOptionPane.showMessageDialog(login, "��ȸ����", "����",
        // JOptionPane.INFORMATION_MESSAGE);
        login.card.show(login.panel, "pwdsuchResultView4_2");
        login.p4_2.pwdTextP4_2.setText(userDto.getUser_pwd());
        login.p4.setVisible(false);
        
      }
    }
    
    ////////////////////////////////////////////////////// P3_2
    else if (ob == login.p3_2.idSuchTextP3_2) {// id text
    } else if (ob == login.p3_2.okButtenP3_2) {// Ȯ�� ��ư
      System.out.println("Ȯ�� ��ư Ŭ��");
      UserLogin userLogin = new UserLogin(); // ���� userLogin ��ü ����
      userLogin.setVisible(true); // �α��� ȭ�� �����ֱ� ����
      login.p3_2.setVisible(false);
      // ȸ�� ���� ȭ�� �ݱ�
    }
    
    /////////////////////////////////////////////////////////// P4_2
    else if (ob == login.p4_2.pwdTextP4_2) {// pwdtext
    
    } else if (ob == login.p4_2.okButtenP4_2) { // Ȯ�� butten
      System.out.println("Ȯ�� ��ư Ŭ��");
      login.p4_2.setVisible(false); // �α��� ȭ�� �����ֱ� ����
      login.p1.setVisible(true);
    }
    
  }

   //���콺 ������ ���ؼ� Ŭ���� �ؽ�Ʈ �� �ʱ�ȭ
  @Override
  public void mouseClicked(MouseEvent e) {
    Object ob = e.getSource();
    if (ob == login.p1.idintextp1) { // id
      login.p1.idintextp1.setText("");
    } else if (ob == login.p1.pwdintextp1) { // pwd
      login.p1.pwdintextp1.setText("");
    } else if (ob == login.p3.nameTextP3) { // name
      login.p3.nameTextP3.setText("");
    } else if (ob == login.p3.emailTextP3) { // email
      login.p3.emailTextP3.setText("");
    } else if (ob == login.p4.idTextP4) { // id
      login.p4.idTextP4.setText("");
    } else if (ob == login.p4.emailTextP4) { // email
      login.p4.emailTextP4.setText("");
    } 
  }
  
  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }
}