package com.kitri.project.user.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Choice;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class UserMemberJoin extends JPanel {

  public JTextField idFP2;//ID�Է� TEXT â
  public JTextField pwsFP2; //password Text
  public JTextField re_pwdFP2; //re_password Text
  public Choice choiceP2; //���� ���� 
  public JTextField nameTextFieldP2; //�̸� Text
  public JTextField birthFP2; // BIRTH Text
  public JTextField emailFP2; //Email Text
  public JTextField phoneFP2; //PHONE text
   
  public JButton backBP2; //�ڷΰ��� ��ư
  public JButton idCheackButtonP2; //ID �ߺ�Ȯ�� ��ư
  public JButton emailCheackButtonP2; //email �ߺ� Ȯ�� ��ư
  public JButton cancelButtonP2; //��ҹ�ư
  public JButton memberJoinP2; //���� ��ư
  
  /**
   * Create the panel.
   */
  public UserMemberJoin() {
    setLayout(null);
    
    JLabel labelP2 = new JLabel("ȸ������"); //ȸ������
    labelP2.setHorizontalAlignment(SwingConstants.CENTER);
    labelP2.setFont(new Font("����", Font.BOLD, 18));
    labelP2.setBounds(199, 10, 141, 35);
    add(labelP2);
    
    JLabel idL = new JLabel("ID"); // ID JLabel 
    idL.setFont(new Font("����", Font.PLAIN, 15));
    idL.setBounds(12, 55, 37, 30);
    add(idL);
    
    idFP2 = new JTextField();//ID�Է� TEXT â
    idFP2.setText("ID �Է�"); //ID�Է� TEXT â
    idFP2.setColumns(10);
    idFP2.setBounds(75, 55, 164, 30);
    add(idFP2);
    
    JLabel pwdLP2 = new JLabel("PWD"); //pwdLP2 ��
    pwdLP2.setFont(new Font("����", Font.PLAIN, 15)); //pwdLP2 ��
    pwdLP2.setBounds(12, 95, 37, 30);
    add(pwdLP2);
    
    pwsFP2 = new JTextField(); //password Text
    pwsFP2.setText("PWD �Է� ");//password Text
    pwsFP2.setColumns(10);
    pwsFP2.setBounds(75, 95, 283, 30);
    add(pwsFP2);
    
    re_pwdFP2 = new JTextField(); //re_password Text
    re_pwdFP2.setText("PWD �ѹ��� �Է�"); //re_password Text
    re_pwdFP2.setColumns(10);
    re_pwdFP2.setBounds(75, 140, 283, 30);
    add(re_pwdFP2);
    
    JLabel carModelLP2 = new JLabel("����"); //���� Lable
    carModelLP2.setFont(new Font("����", Font.PLAIN, 15));//���� Lable
    carModelLP2.setBounds(12, 185, 37, 30);
    add(carModelLP2);
    
//  choic �����
  choiceP2 = new Choice(); //���� ���� 
  choiceP2.add("1");           //���� ���� 
  choiceP2.add("2");
  choiceP2.add("3");
  choiceP2.add("4"); 
  choiceP2.select(0); //�迭�� 0���� ������
  choiceP2.setBounds(75, 191, 283, 24);
  add(choiceP2);
    
    JLabel nameLP2 = new JLabel("NAME"); //name Lable
    nameLP2.setFont(new Font("����", Font.PLAIN, 15));//name Lable
    nameLP2.setBounds(12, 230, 51, 30);
    add(nameLP2);
    
    nameTextFieldP2 = new JTextField(); //�̸� Text
    nameTextFieldP2.setText("�̸��Է�");//�̸� Text
    nameTextFieldP2.setColumns(10);
    nameTextFieldP2.setBounds(75, 230, 283, 30);
    add(nameTextFieldP2);
    
    JLabel birthLP2 = new JLabel("BIRTH"); // BIRTH JLabel
    birthLP2.setFont(new Font("����", Font.PLAIN, 15)); // BIRTH JLabel
    birthLP2.setBounds(12, 275, 51, 30);
    add(birthLP2);
    
    birthFP2 = new JTextField(); // BIRTH Text
    birthFP2.setText("������� �Է�");  // BIRTH Text
    birthFP2.setColumns(10);
    birthFP2.setBounds(75, 275, 283, 30);
    add(birthFP2);
    
    JLabel emailLP2 = new JLabel("E-Mail"); //Email label
    emailLP2.setFont(new Font("����", Font.PLAIN, 15));//Email label
    emailLP2.setBounds(12, 320, 51, 30);
    add(emailLP2);
    
    emailFP2 = new JTextField(); //Email Text
    emailFP2.setText("�̸��� �Է�");//Email Text
    emailFP2.setColumns(10);
    emailFP2.setBounds(75, 320, 164, 30);
    add(emailFP2);
    
    JLabel phoneLP2 = new JLabel("PHONE"); // PHONE Lable
    phoneLP2.setFont(new Font("����", Font.PLAIN, 15)); // PHONE Lable
    phoneLP2.setBounds(12, 365, 51, 30);
    add(phoneLP2);
    
    phoneFP2 = new JTextField(); //PHONE text
    phoneFP2.setText("��ȭ��ȣ �Է�");//PHONE text
    phoneFP2.setColumns(10);
    phoneFP2.setBounds(75, 365, 283, 30);
    add(phoneFP2);
    
    backBP2 = new JButton("BACK"); //�ڷΰ��� ��ư
    backBP2.setBounds(12, 10, 68, 30); //�ڷΰ��� ��ư
    add(backBP2);
    
    idCheackButtonP2 = new JButton("�ߺ�Ȯ��"); //ID �ߺ�Ȯ�� ��ư
    idCheackButtonP2.setBounds(253, 55, 105, 30);//ID �ߺ�Ȯ�� ��ư
    add(idCheackButtonP2);
    
    emailCheackButtonP2 = new JButton("�ߺ�Ȯ��"); //email �ߺ� Ȯ�� ��ư
    emailCheackButtonP2.setBounds(253, 320, 105, 30);//email �ߺ� Ȯ�� ��ư
    add(emailCheackButtonP2);
    
//    cancelButtonP2 = new JButton("���"); //��ҹ�ư
//    cancelButtonP2.setBounds(139, 412, 105, 48);
//    add(cancelButtonP2);
    
    memberJoinP2 = new JButton("����"); //���� ��ư
    memberJoinP2.setBounds(253, 412, 105, 48);//���� ��ư
    add(memberJoinP2);

  }
}