package com.kitri.project.user.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UserMovieReservationLookupPanel extends JPanel {
  private JTextField textField;
  
  /**
   * Create the panel.
   */
  public UserMovieReservationLookupPanel() {
  	setBackground(new Color(255, 255, 255));
    setLayout(null);
    
    JLabel label = new JLabel("\uC608\uB9E4\uC870\uD68C");
    label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
    label.setBounds(104, 0, 156, 60);
    add(label);
    
    JLabel label_1 = new JLabel("\uACB0\uC7AC\uBC88\uD638");
    label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
    label_1.setBounds(14, 92, 100, 24);
    add(label_1);
    
    JLabel label_2 = new JLabel("\uC601\uD654\uC81C\uBAA9");
    label_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
    label_2.setBounds(14, 160, 100, 24);
    add(label_2);
    
    textField = new JTextField();
    textField.setBounds(109, 92, 137, 24);
    add(textField);
    textField.setColumns(10);
    
    JComboBox comboBox = new JComboBox();
    comboBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
    comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uBC14\uB78C\uACFC \uD568\uAED8 \uC0AC\uB77C\uC9C0\uB2E4", "\uD1A0\uB974 \uB77C\uADF8\uB77C\uB85C\uD06C"}));
    comboBox.setBounds(109, 162, 137, 24);
    add(comboBox);
    
    JButton button = new JButton("\uC870\uD68C");
    button.setBackground(new Color(51, 204, 255));
    button.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    button.setBounds(164, 318, 82, 30);
    add(button);
    
    JButton button_1 = new JButton("\uCDE8\uC18C");
    button_1.setBackground(new Color(51, 204, 255));
    button_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
    button_1.setBounds(77, 318, 82, 30);
    add(button_1);
    
  }
  
}
