package com.kitri.project.supervisor.view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class SuperAdministratorMovieInsertView extends JPanel {
	public JPanel panel;
	public JTextArea movieActorTA;
	public JTextArea movieStroyTA;
	public JTextField movieGenreTF;
	public JButton posterApplybtn;
	public JButton movieApplyBtn;
	public JTextField movieNoTF;
	public JTextField movieTitleTF;
	public JTextField movieruntimeTF;
	public JPanel moviepview;
	public JTextField moviePosterImageTF;
	

	/**
	 * Create the panel.
	 */
	public SuperAdministratorMovieInsertView() {
		setBounds(0, 0, 940, 510);
		setLayout(null);
		
		moviepview = new JPanel();
		moviepview.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		moviepview.setBounds(28, 26, 385, 407);
		add(moviepview);
		moviepview.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC5EC\uAE30\uC5D0 \uB4F1\uB85D\uB41C \uC601\uD654\uD3EC\uC2A4\uD130 \uBCF4\uC5EC\uC900\uB2E4.");
		lblNewLabel.setBounds(106, 189, 201, 15);
		moviepview.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(28, 441, 385, 48);
		add(panel);
		panel.setLayout(null);
		
		posterApplybtn = new JButton("\uD3EC\uC2A4\uD130 \uB4F1\uB85D");
		posterApplybtn.setBounds(265, 0, 108, 38);
		panel.add(posterApplybtn);
		
		moviePosterImageTF = new JTextField();
		moviePosterImageTF.setBounds(0, 6, 260, 28);
		panel.add(moviePosterImageTF);
		moviePosterImageTF.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(436, 26, 492, 463);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel mvtitlelab = new JLabel("\uC601\uD654 \uC81C\uBAA9");
		mvtitlelab.setFont(new Font("����", Font.BOLD, 14));
		mvtitlelab.setBounds(26, 83, 83, 15);
		panel_1.add(mvtitlelab);
		
		JLabel mvruntlab = new JLabel("\uC0C1\uC601\uC2DC\uAC04");
		mvruntlab.setFont(new Font("����", Font.BOLD, 14));
		mvruntlab.setBounds(26, 133, 83, 15);
		panel_1.add(mvruntlab);
		
		JLabel mvgenrelab = new JLabel("\uC7A5\uB974");
		mvgenrelab.setFont(new Font("����", Font.BOLD, 14));
		mvgenrelab.setBounds(26, 177, 83, 15);
		panel_1.add(mvgenrelab);
		
		JLabel mvstorylab = new JLabel("\uC904\uAC70\uB9AC");
		mvstorylab.setFont(new Font("����", Font.BOLD, 14));
		mvstorylab.setBounds(26, 240, 83, 15);
		panel_1.add(mvstorylab);
		
		JLabel mvactorlab = new JLabel("\uCD9C\uC5F0\uC9C4");
		mvactorlab.setFont(new Font("����", Font.BOLD, 14));
		mvactorlab.setBounds(26, 337, 83, 15);
		panel_1.add(mvactorlab);
		
		movieTitleTF = new JTextField();
		movieTitleTF.setBounds(107, 78, 354, 28);
		panel_1.add(movieTitleTF);
		movieTitleTF.setColumns(10);
		
		movieruntimeTF = new JTextField();
		movieruntimeTF.setColumns(10);
		movieruntimeTF.setBounds(107, 128, 318, 28);
		panel_1.add(movieruntimeTF);
		
		JLabel mvnolab = new JLabel("\uC601\uD654\uBC88\uD638");
		mvnolab.setFont(new Font("����", Font.BOLD, 14));
		mvnolab.setBounds(26, 35, 83, 15);
		panel_1.add(mvnolab);
		
		movieNoTF = new JTextField();
		movieNoTF.setColumns(10);
		movieNoTF.setBounds(107, 30, 178, 28);
		panel_1.add(movieNoTF);
		
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
		
		movieApplyBtn = new JButton("\uC601\uD654 \uB4F1\uB85D");
		movieApplyBtn.setBounds(372, 415, 108, 38);
		panel_1.add(movieApplyBtn);
		
		JLabel lblNewLabel_1 = new JLabel("(\uBD84)");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel_1.setBounds(437, 133, 43, 15);
		panel_1.add(lblNewLabel_1);
		

	}
}
