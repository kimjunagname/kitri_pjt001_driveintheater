package com.kitri.project.user.view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.Color;

public class UserLoginPanel extends JPanel {

  
  //���� ����
  public JLabel title; //
  
  public JTextField idintextp1;
  public JPasswordField pwdintextp1;
  
  public JButton joinButtonp1;
  public JButton loginButtonp1;
  public JButton pwdSuchButtenp1;   
  public JButton idSuchButtenp1;

  /**
   * Create the panel.
   */
  public UserLoginPanel() {
  	setBackground(Color.WHITE);
    setLayout(null);
    
    title = new JLabel("Car Theater");
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setFont(new Font("���� ����", Font.BOLD, 30));
    title.setBounds(73, 97, 237, 67);
    add(title);
    
    
    JLabel idL = new JLabel("ID");
    idL.setFont(new Font("���� ����", Font.PLAIN, 25));
    idL.setBounds(43, 212, 37, 30);
    add(idL);
    
    idintextp1 = new JTextField();
    idintextp1.setFont(new Font("���� ����", Font.PLAIN, 20));
    idintextp1.setText("ID �Է� ���ּ���");
    idintextp1.setColumns(10);
    idintextp1.setBounds(117, 202, 224, 59);
    add(idintextp1);
    
    JLabel pwdL = new JLabel("PWD");
    pwdL.setFont(new Font("���� ����", Font.PLAIN, 25));
    pwdL.setBounds(43, 308, 57, 30);
    add(pwdL);
    
    pwdintextp1 = new JPasswordField();
    pwdintextp1.setFont(new Font("���� ����", Font.PLAIN, 20));
    pwdintextp1.setText("PWD\uC785\uB825");
    pwdintextp1.setColumns(10);
    pwdintextp1.setBounds(117, 298, 224, 59);
    add(pwdintextp1);
    
    joinButtonp1 = new JButton("JOIN");
    joinButtonp1.setFont(new Font("���� ����", Font.PLAIN, 12));
    joinButtonp1.setBounds(59, 395, 131, 48);
    add(joinButtonp1);
    
    loginButtonp1 = new JButton("LOGIN");
    loginButtonp1.setFont(new Font("���� ����", Font.PLAIN, 12));
    loginButtonp1.setBounds(204, 395, 140, 48);
    add(loginButtonp1);
  

    pwdSuchButtenp1 = new JButton("PWD ã��");
    pwdSuchButtenp1.setFont(new Font("���� ����", Font.PLAIN, 14));
    pwdSuchButtenp1.setBounds(261, 505, 105, 30);
    add(pwdSuchButtenp1);
    
    idSuchButtenp1 = new JButton("ID ã��");
    idSuchButtenp1.setFont(new Font("���� ����", Font.PLAIN, 14));
    idSuchButtenp1.setBounds(142, 505, 105, 30);
    add(idSuchButtenp1);

  }
}
