package com.kitri.project.user.view;

import com.kitri.project.user.controller.UserLoginController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLogin extends JFrame {
  
//  ������ ����
  public JPanel panel;
  public CardLayout card = new CardLayout();
  public UserLoginPanel p1= new UserLoginPanel();
//  public UserMemberJoin p2= new UserMemberJoin();
  public UserMemberJoinPanel2 p2 = new UserMemberJoinPanel2();
  public UserLoginIdLookupPanel1 p3 = new UserLoginIdLookupPanel1();
  public UserLoginIdLookupPanel2 p3_2 = new UserLoginIdLookupPanel2();
  public UserLoginPWDLookPanel1 p4 = new UserLoginPWDLookPanel1();
  public UserLoginPWDLookPanel2 p4_2 = new UserLoginPWDLookPanel2();
  public UserLoginController userLoginController;
  public UserMenu userMenuframe;
  public UserLogin userLoginFrame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          UserLogin userLoginFrame = new UserLogin();
          userLoginFrame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public UserLogin() {
    //ȭ��â���� �̸� ǥ��
    setTitle("�α���");
  	getContentPane().setBackground(Color.WHITE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 400, 600);
    getContentPane().setLayout(null);
    
    panel = new JPanel();
    panel.setBounds(14, 12, 380, 570);
    getContentPane().add(panel);
    panel.setLayout(card);
    p1.joinButtonp1.setBackground(new Color(51, 204, 255));
    p1.loginButtonp1.setBackground(new Color(51, 204, 255));
    p1.idSuchButtenp1.setBackground(new Color(51, 204, 255));
    p1.pwdSuchButtenp1.setBackground(new Color(51, 204, 255));
    p1.title.setFont(new Font("���� ����", Font.BOLD, 30));
    p1.joinButtonp1.setFont(new Font("���� ����", Font.PLAIN, 12));
    p1.loginButtonp1.setFont(new Font("���� ����", Font.PLAIN, 12));
    p1.idSuchButtenp1.setFont(new Font("���� ����", Font.PLAIN, 14));
    p1.pwdSuchButtenp1.setFont(new Font("���� ����", Font.PLAIN, 14));
    p1.setBackground(Color.WHITE);
    
    panel.add("loginView1", p1);
    p2.BackButtenP5.setFont(new Font("���� ����", Font.PLAIN, 12));
    p2.label.setFont(new Font("���� ����", Font.BOLD, 18));
    p2.setBackground(Color.WHITE);
    panel.add("joinView2", p2);
    panel.add("idsuchView3", p3);
    panel.add("idsuchResultView3_2", p3_2);
    panel.add("pwdsuchView4", p4);
    panel.add("pwdsuchResultView4_2",p4_2);
    
    
    card.show(panel, "loginView1");
    setResizable(false);
    
//  UserLoginControler ����
    UserLoginController userLoginController = new UserLoginController(this);
//  userMenuframe ������ ����
    userMenuframe = new UserMenu();
    
// ����ο��� ��ư �׼ǽ� ������ ����
    p1.joinButtonp1.addActionListener(userLoginController); //ȸ������ ��ư
    p1.loginButtonp1.addActionListener(userLoginController); // �α��� ��ư
    p1.idSuchButtenp1.addActionListener(userLoginController);  // ���̵� ã�� ��ư
    p1.pwdSuchButtenp1.addActionListener(userLoginController); //��й�ȣ ã�� ��ư
    
    p1.idintextp1.addMouseListener((MouseListener) userLoginController);// id �Է�
    p1.pwdintextp1.addMouseListener((MouseListener) userLoginController);//pass �Է�
    
    p2.BackButtenP5.addActionListener(userLoginController);//�ڷΰ��� ��ư
    p2.joinBettonP5.addActionListener(userLoginController);//���� ��ư
 
    p3.emailTextP3.addActionListener(userLoginController);//email text
    p3.nameTextP3.addActionListener(userLoginController); // name text

    p3.emailTextP3.addMouseListener((MouseListener) userLoginController);// name �Է�
    p3.nameTextP3.addMouseListener((MouseListener) userLoginController);//email �Է�
  
    p3.suchButtonP3.addActionListener(userLoginController); //��ȸ ��ư
    p3.backBtnP3.addActionListener(userLoginController);//back ��ư
    
    p3_2.idSuchTextP3_2.addActionListener(userLoginController); //such id text
    p3_2.okButtenP3_2.addActionListener(userLoginController);//��ȸ ��ư
    
    p4.emailTextP4.addActionListener(userLoginController);//email text
    p4.idTextP4.addActionListener(userLoginController);//idtext
    p4.backButtonP4.addActionListener(userLoginController); //back butten
    p4.suchButtenP4.addActionListener(userLoginController);//��ȸ butten

    p4.idTextP4.addMouseListener((MouseListener) userLoginController);// idTextP4 �Է�
    p4.emailTextP4.addMouseListener((MouseListener) userLoginController);//emailTextP4 �Է�
    
    p4_2.pwdTextP4_2.addActionListener(userLoginController);//idtext
    p4_2.okButtenP4_2.addActionListener(userLoginController);//Ȯ�� butten
   
  }
}