package com.kitri.project.user.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;

public class UserMovieReservationCancelPanel extends JPanel {
  
  public JButton backP2; //µ«µπæ∆∞°±‚
  public JButton payCancleP2; //∞·¿Á√Îº“
  public JTextField moviTitleP2; //øµ»≠¡¶∏Ò
  public JTextField locationP2; //¡ˆ¡°∏Ì
  public JTextField openTimeP2; //ªÛøµ¿œ
  public JTextField mailP2; //∏∂¿œ∏Æ¡ˆ
  public JTextField totalPayP2; //√—∞·¡¶±›æ◊(∏∂¿œ∏Æ¡ˆ + ∞·¿Á±›æ◊)
  public JTextField chPayP2; //∞·¿Á±›æ◊
  
  
  /**
   * Create the panel.
   */
  public UserMovieReservationCancelPanel() {
  	setBackground(new Color(255, 255, 255));
    setLayout(null);
    
    JLabel label = new JLabel("øµ»≠øπ∏≈ ≥ªø™");
    label.setHorizontalAlignment(SwingConstants.RIGHT);
    label.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 23));
    label.setBounds(122, 10, 219, 35);
    add(label);
    
    backP2 = new JButton("BACK"); //µ«µπæ∆∞°±‚
    backP2.setBackground(new Color(51, 204, 255));
    backP2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    backP2.setBounds(12, 10, 68, 30);
    add(backP2);
    
    JLabel label_1 = new JLabel("øµ»≠¡¶∏Ò");
    label_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    label_1.setBounds(38, 125, 140, 35);
    add(label_1);
    
    JLabel label_3 = new JLabel("\uC9C0\uC810");
    label_3.setHorizontalAlignment(SwingConstants.LEFT);
    label_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    label_3.setBounds(38, 187, 80, 25);
    add(label_3);
    
    JLabel label_4 = new JLabel("\uC0C1\uC601\uC77C");
    label_4.setHorizontalAlignment(SwingConstants.LEFT);
    label_4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    label_4.setBounds(40, 232, 140, 25);
    add(label_4);
    
    JLabel label_5 = new JLabel("\uB9C8\uC77C\uB9AC\uC9C0");
    label_5.setHorizontalAlignment(SwingConstants.LEFT);
    label_5.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    label_5.setBounds(40, 277, 80, 25);
    add(label_5);
    
    JLabel label_6 = new JLabel("\uACB0\uC81C\uAE08\uC561");
    label_6.setHorizontalAlignment(SwingConstants.LEFT);
    label_6.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    label_6.setBounds(40, 322, 131, 25);
    add(label_6);
    
    JLabel label_7 = new JLabel("\uCD1D\uACB0\uC81C\uAE08\uC561");
    label_7.setHorizontalAlignment(SwingConstants.LEFT);
    label_7.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    label_7.setBounds(40, 368, 131, 25);
    add(label_7);
    
    payCancleP2 = new JButton("∞·¡¶√Îº“"); //∞·¿Á√Îº“
    payCancleP2.setBackground(new Color(51, 204, 255));
    payCancleP2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    payCancleP2.setBounds(265, 419, 105, 48); //∞·¿Á√Îº“
    add(payCancleP2);
    
    moviTitleP2 = new JTextField();
    moviTitleP2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    moviTitleP2.setEditable(false);
    moviTitleP2.setBounds(159, 134, 211, 24); //øµ»≠¡¶∏Ò
    add(moviTitleP2);
    moviTitleP2.setColumns(10);
    
    locationP2 = new JTextField();
    locationP2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    locationP2.setEditable(false);
    locationP2.setColumns(10);//¡ˆ¡°∏Ì
    locationP2.setBounds(159, 189, 211, 24);
    add(locationP2);
    
    openTimeP2 = new JTextField();
    openTimeP2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    openTimeP2.setEditable(false);
    openTimeP2.setColumns(10); //ªÛøµ¿œ
    openTimeP2.setBounds(159, 234, 211, 24);
    add(openTimeP2);
    
    mailP2 = new JTextField();
    mailP2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    mailP2.setEditable(false);
    mailP2.setColumns(10);//∏∂¿œ∏Æ¡ˆ ∞·¡¶ ±›æ◊
    mailP2.setBounds(159, 279, 211, 24);
    add(mailP2);
    
    chPayP2 = new JTextField();
    chPayP2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    chPayP2.setEditable(false);
    chPayP2.setColumns(10); //∞·¿Á
    chPayP2.setBounds(159, 324, 211, 24);
    add(chPayP2);
    
    totalPayP2 = new JTextField();
    totalPayP2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
    totalPayP2.setEditable(false);
    totalPayP2.setColumns(10);//√—∞·¡¶±›æ◊
    totalPayP2.setBounds(159, 370, 211, 24);
    add(totalPayP2);
   
    
  }
}
