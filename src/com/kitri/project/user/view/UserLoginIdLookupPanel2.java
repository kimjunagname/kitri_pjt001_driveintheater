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

public class UserLoginIdLookupPanel2 extends JPanel {
  public JTextField idSuchTextP3_2; //such id text
  public JButton backButtenP3_2; //back ��ư
  public JButton okButtenP3_2; //��ȸ ��ư

  /**
   * Create the panel.
   */
  public UserLoginIdLookupPanel2() {
  	setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel lblId = new JLabel("ID ��ȸ ���");
    lblId.setHorizontalAlignment(SwingConstants.CENTER);
    lblId.setFont(new Font("���� ����", Font.BOLD, 30));
    lblId.setBounds(113, 125, 174, 35);
    add(lblId);
    
    idSuchTextP3_2 = new JTextField(); //such id text
    idSuchTextP3_2.setFont(new Font("���� ����", Font.PLAIN, 25));  //such id text
    idSuchTextP3_2.setText("ID");
    idSuchTextP3_2.setColumns(10);
    idSuchTextP3_2.setBounds(74, 250, 258, 55);
    add(idSuchTextP3_2);
    
    okButtenP3_2 = new JButton("Ȯ��"); //Ȯ�ι�ư
    okButtenP3_2.setBackground(new Color(51, 204, 255));
    okButtenP3_2.setFont(new Font("���� ����", Font.PLAIN, 12));
    okButtenP3_2.setBounds(276, 477, 82, 30); //Ȯ�ι�ư
    add(okButtenP3_2);
    
  }
}
