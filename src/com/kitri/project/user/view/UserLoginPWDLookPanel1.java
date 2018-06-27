package com.kitri.project.user.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class UserLoginPWDLookPanel1 extends JPanel {
  public JTextField emailTextP4;//email text
  public JTextField idTextP4;//idtext
  
  public JButton backButtonP4; //back butten
  public JButton cancelButtonp4; //��� butten
  public JButton suchButtenP4; //��ȸ butten
  
  /**
   * Create the panel.
   */
  public UserLoginPWDLookPanel1() {
  	setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel lblPwd = new JLabel("PWD \uC870\uD68C");
    lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
    lblPwd.setFont(new Font("���� ����", Font.BOLD, 30));
    lblPwd.setBounds(117, 109, 173, 30);
    add(lblPwd);
    
    JLabel label_1 = new JLabel("ID");
    label_1.setFont(new Font("���� ����", Font.PLAIN, 25));
    label_1.setBounds(14, 209, 100, 24);
    add(label_1);
    
    idTextP4 = new JTextField();  //idtext
    idTextP4.setFont(new Font("���� ����", Font.PLAIN, 25));//idtext
    idTextP4.setText("ID \uC785\uB825");
    idTextP4.setColumns(10);
    idTextP4.setBounds(109, 198, 258, 50);
    add(idTextP4);
    
    JLabel label = new JLabel("E-Mail");
    label.setFont(new Font("���� ����", Font.PLAIN, 25));
    label.setBounds(14, 303, 100, 24);
    add(label);
    
    emailTextP4 = new JTextField(); //email text
    emailTextP4.setFont(new Font("���� ����", Font.PLAIN, 25));//email text
    emailTextP4.setText("EMail \uC785\uB825");
    emailTextP4.setColumns(10);
    emailTextP4.setBounds(109, 290, 258, 55);
    add(emailTextP4);
    
    backButtonP4 = new JButton("BACK"); //back butten
    backButtonP4.setFont(new Font("���� ����", Font.PLAIN, 12));
    backButtonP4.setBackground(new Color(51, 204, 255));
    backButtonP4.setBounds(14, 12, 68, 30); //back butten
    add(backButtonP4);
    
//    cancelButtonp4 = new JButton("\uCDE8\uC18C"); //��� butten
//    cancelButtonp4.setBounds(198, 474, 82, 30); //��� butten
//    add(cancelButtonp4);
    
    suchButtenP4 = new JButton("\uC870\uD68C"); //��ȸ butten
    suchButtenP4.setFont(new Font("���� ����", Font.PLAIN, 12));
    suchButtenP4.setBackground(new Color(51, 204, 255));
    suchButtenP4.setBounds(285, 474, 82, 30); //��ȸ butten
    add(suchButtenP4);
    
  }
  
}
