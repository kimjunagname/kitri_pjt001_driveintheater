//20180511 ��� ��ư ���� ������

package com.kitri.project.user.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class UserLoginIdLookupPanel1 extends JPanel {
  public JTextField emailTextP3;//email text
  public JTextField nameTextP3; // name text
  public JButton cancelButtenP3; //��� ��ư
  public JButton suchButtonP3; //��ȸ ��ư
  public JButton backBtnP3; //back ��ư
  
  /**
   * Create the panel.
   */
  public UserLoginIdLookupPanel1() {
  	setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel lblId = new JLabel("ID \uC870\uD68C");
    lblId.setHorizontalAlignment(SwingConstants.CENTER);
    lblId.setFont(new Font("���� ����", Font.BOLD, 30));
    lblId.setBounds(129, 98, 141, 35);
    add(lblId);
    
    JLabel lblId_1 = new JLabel("NAME");
    lblId_1.setFont(new Font("���� ����", Font.PLAIN, 25));
    lblId_1.setBounds(13, 230, 100, 24);
    add(lblId_1);
    
    nameTextP3 = new JTextField(); //name text
    nameTextP3.setFont(new Font("���� ����", Font.PLAIN, 25)); //name text
    nameTextP3.setText("NAME �Է�");
    nameTextP3.setColumns(10);
    nameTextP3.setBounds(101, 216, 258, 55);
    add(nameTextP3);
    
    JLabel lblEmail = new JLabel("E-Mail");
    lblEmail.setFont(new Font("���� ����", Font.PLAIN, 25));
    lblEmail.setBounds(14, 331, 100, 24);
    add(lblEmail);
    
    emailTextP3 = new JTextField(); //email text
    emailTextP3.setFont(new Font("���� ����", Font.PLAIN, 25));//email text
    emailTextP3.setText("email �Է�");
    emailTextP3.setColumns(10);
    emailTextP3.setBounds(101, 314, 258, 55);
    add(emailTextP3);
    
    backBtnP3 = new JButton("BACK"); //BACK ��ư
    backBtnP3.setFont(new Font("���� ����", Font.PLAIN, 12));
    backBtnP3.setBackground(new Color(51, 204, 255));
    backBtnP3.setBounds(14, 12, 68, 30);//BACK ��ư
    add(backBtnP3);
    
//    cancelButtenP3 = new JButton("���");  //��ҹ�ư
//    cancelButtenP3.setBounds(189, 477, 82, 30);//��ҹ�ư
//    add(cancelButtenP3);
    
    suchButtonP3 = new JButton("��ȸ"); //��ȸ��ư
    suchButtonP3.setFont(new Font("���� ����", Font.PLAIN, 12));
    suchButtonP3.setBackground(new Color(51, 204, 255));
    suchButtonP3.setBounds(276, 477, 82, 30); //��ȸ��ư
    add(suchButtonP3);
    
  }
}
