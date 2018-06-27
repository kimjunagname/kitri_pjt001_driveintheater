package com.kitri.project.emp.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EmpMovieMainPanel extends JPanel {

	public JButton editMovieBtn;
	public JButton registerMovieBtn;

	/**
	 * Create the panel.
	 */
	public EmpMovieMainPanel() {
		setName("영화관리");
		setBounds(0, 0, 940, 510);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		editMovieBtn = new JButton("\uC601\uD654 \uBCC0\uACBD \uBC0F \uC0AD\uC81C");
		editMovieBtn.setBounds(130, 90, 270, 330);
		editMovieBtn.setBackground(new Color(51, 204, 255));
		add(editMovieBtn);
		
		registerMovieBtn = new JButton("\uC601\uD654 \uB4F1\uB85D");
		registerMovieBtn.setBounds(530, 90, 270, 330);
		registerMovieBtn.setBackground(new Color(51, 204, 255));
		add(registerMovieBtn);
		
	}
}
