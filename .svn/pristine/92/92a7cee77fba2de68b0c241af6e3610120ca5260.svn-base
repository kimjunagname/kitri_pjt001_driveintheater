package com.kitri.project.supervisor.view;



import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SuperAdministratorMenu extends JFrame {

  SuperAdministratorStatisticsPanel p1 = new SuperAdministratorStatisticsPanel();
  
  private JPanel panel;
  CardLayout card = new CardLayout();
  
  private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuperAdministratorMenu frame = new SuperAdministratorMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SuperAdministratorMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC601\uD654 \uB204\uC801 \uC608\uB9E4");
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 25));
		lblNewLabel.setBounds(32, 10, 414, 65);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("\uC815\uBCF4\uC218\uC815");
		button.setBounds(738, 12, 99, 31);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		button_1.setBounds(849, 12, 99, 31);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("\uC9C1\uCC45 : ");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(583, 12, 116, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4!");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(472, 12, 99, 31);
		contentPane.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(8, 60, 940, 481);
    getContentPane().add(panel);
    panel.setLayout(card);
    
    panel.add("view1", p1);
    card.show(panel, "view1");
    setResizable(false);
		
		
		
	}
}
