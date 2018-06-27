package com.kitri.project.superadmin.view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class SuperAdminMovieInsertView extends JPanel {
	public JPanel panel;
	public JTextArea movieActorTA;
	public JTextArea movieStroyTA;
	public JTextField movieGenreTF;
	public JButton insertImageB;
	public JButton registerMovieB;
	public JTextField movieTitleTF;
	public JTextField movieRuntimeTF;
	public JTextField imagePathF;
	public JLabel imageL;

	public SuperAdminMovieInsertView() {
		setBounds(0, 0, 940, 510);
		setLayout(null);
		setBackground(new Color(255, 255, 255));

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(28, 441, 385, 48);
		add(panel);
		panel.setLayout(null);

		insertImageB = new JButton("\uD3EC\uC2A4\uD130 \uB4F1\uB85D");
		insertImageB.setBounds(265, 0, 108, 38);
		insertImageB.setBackground(new Color(51, 204, 255));
		panel.add(insertImageB);

		imagePathF = new JTextField();
		imagePathF.setBounds(0, 6, 260, 28);
		panel.add(imagePathF);
		imagePathF.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(436, 26, 492, 463);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel mvtitlelab = new JLabel("\uC601\uD654 \uC81C\uBAA9");
		mvtitlelab.setFont(new Font("±¼¸²", Font.BOLD, 14));
		mvtitlelab.setBounds(26, 83, 83, 15);
		panel_1.add(mvtitlelab);

		JLabel mvruntlab = new JLabel("\uC0C1\uC601\uC2DC\uAC04");
		mvruntlab.setFont(new Font("±¼¸²", Font.BOLD, 14));
		mvruntlab.setBounds(26, 133, 83, 15);
		panel_1.add(mvruntlab);

		JLabel mvgenrelab = new JLabel("\uC7A5\uB974");
		mvgenrelab.setFont(new Font("±¼¸²", Font.BOLD, 14));
		mvgenrelab.setBounds(26, 177, 83, 15);
		panel_1.add(mvgenrelab);

		JLabel mvstorylab = new JLabel("\uC904\uAC70\uB9AC");
		mvstorylab.setFont(new Font("±¼¸²", Font.BOLD, 14));
		mvstorylab.setBounds(26, 240, 83, 15);
		panel_1.add(mvstorylab);

		JLabel mvactorlab = new JLabel("\uCD9C\uC5F0\uC9C4");
		mvactorlab.setFont(new Font("±¼¸²", Font.BOLD, 14));
		mvactorlab.setBounds(26, 337, 83, 15);
		panel_1.add(mvactorlab);

		movieTitleTF = new JTextField();
		movieTitleTF.setBounds(107, 78, 354, 28);
		panel_1.add(movieTitleTF);
		movieTitleTF.setColumns(10);

		movieRuntimeTF = new JTextField();
		movieRuntimeTF.setColumns(10);
		movieRuntimeTF.setBounds(107, 128, 318, 28);
		panel_1.add(movieRuntimeTF);

		movieGenreTF = new JTextField();
		movieGenreTF.setColumns(10);
		movieGenreTF.setBounds(107, 172, 354, 28);
		panel_1.add(movieGenreTF);

		JScrollPane StorySP = new JScrollPane();
		StorySP.setBounds(107, 215, 354, 75);
		panel_1.add(StorySP);

		movieStroyTA = new JTextArea();
		StorySP.setViewportView(movieStroyTA);

		JScrollPane ActorSP = new JScrollPane();
		ActorSP.setBounds(107, 309, 354, 75);
		panel_1.add(ActorSP);

		movieActorTA = new JTextArea();
		ActorSP.setViewportView(movieActorTA);

		registerMovieB = new JButton("\uC601\uD654 \uB4F1\uB85D");
		registerMovieB.setBounds(372, 415, 108, 38);
		registerMovieB.setBackground(new Color(51, 204, 255));
		panel_1.add(registerMovieB);

		JLabel lblNewLabel_1 = new JLabel("(\uBD84)");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 14));
		lblNewLabel_1.setBounds(437, 133, 43, 15);
		panel_1.add(lblNewLabel_1);

		imageL = new JLabel("");
		imageL.setBounds(28, 26, 385, 401);
		add(imageL);

	}
}
