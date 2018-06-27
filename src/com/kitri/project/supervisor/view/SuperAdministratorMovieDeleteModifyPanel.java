package com.kitri.project.supervisor.view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class SuperAdministratorMovieDeleteModifyPanel extends JPanel {
	public Vector<Vector<String>> rowData; // rowData = DB에 입출력되는 데이터
	
	public JPanel panel;
	public JTextArea movieActorTA;
	public JTextArea movieStroyTA;
	public JTextField movieGenreTF;
	public JTextField movieNoTF;
	public JTextField movieTitleTF;
	public JTextField movieruntimeTF;
	public JPanel moviepview;
	public JTextField moviePosterImageTF;
	public JLabel posterlabel;
	public JTextField movieTitle_TF;
	public JTextField movierun_TF;
	public JTextField movienoTF;
	public JTextField moviegenre_TF;
	public JTextField movieposter_TF;
	public JButton Deletebtn;
	public JButton Modifybtn;
	public JButton modifyfilebtn;
	public JTable table;
	public JButton listbtn;

	/**
	 * Create the panel.
	 */
	public SuperAdministratorMovieDeleteModifyPanel() {
		setBounds(0, 0, 940, 510);
		setLayout(null);
		rowData = new Vector<Vector<String>>();
		Vector<String> colData = new Vector<String>(); // colData = 컬럼명을 벡터로 지정.
		colData.add("영화번호"); 
		colData.add("영화제목"); 
		colData.add("영화포스터");
		colData.add("장르");
		colData.add("줄거리");
		colData.add("출연진");
		colData.add("런타임");
		setLayout(null);
		
		table = new JTable(rowData, colData); 
		JScrollPane jsp = new JScrollPane(table); 
		jsp.setBounds(12, 20, 412, 480);
		add(jsp); 
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				// 마우스를 클릭했을때
				int selection = table.getSelectedRow();
				Vector<String> vc = rowData.get(selection); 
//				Integer no = Integer.parseInt(vc.get(0));
//				String no1 = String.valueOf(no);
//				movieNoTF.setText(no1);
//				
//				Integer runtime = Integer.parseInt(vc.get(6));
//				String runtime1 = String.valueOf(runtime);
//				movierun_TF.setText(runtime1);
				
//				movieTitleTF.setText(vc.get(1));
//				movieposter_TF.setText(vc.get(2)); 
//				movieGenreTF.setText(vc.get(3));
//				movieStroyTA.setText(vc.get(4));
//				movieActorTA.setText(vc.get(5));
			}
		});
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setLayout(null);
		panel_1.setBounds(436, 20, 504, 480);
		add(panel_1);
		
		JLabel label = new JLabel("\uC601\uD654 \uC81C\uBAA9");
		label.setFont(new Font("굴림", Font.BOLD, 14));
		label.setBounds(26, 57, 83, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\uC0C1\uC601\uC2DC\uAC04");
		label_1.setFont(new Font("굴림", Font.BOLD, 14));
		label_1.setBounds(26, 95, 83, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\uC7A5\uB974");
		label_2.setFont(new Font("굴림", Font.BOLD, 14));
		label_2.setBounds(26, 133, 83, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("\uC904\uAC70\uB9AC");
		label_3.setFont(new Font("굴림", Font.BOLD, 14));
		label_3.setBounds(26, 187, 83, 15);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("\uCD9C\uC5F0\uC9C4");
		label_4.setFont(new Font("굴림", Font.BOLD, 14));
		label_4.setBounds(26, 265, 55, 15);
		panel_1.add(label_4);
		
		movieTitle_TF = new JTextField();
		movieTitle_TF.setColumns(10);
		movieTitle_TF.setBounds(107, 52, 354, 28);
		panel_1.add(movieTitle_TF);
		
		movierun_TF = new JTextField();
		movierun_TF.setColumns(10);
		movierun_TF.setBounds(107, 90, 318, 28);
		panel_1.add(movierun_TF);
		
		JLabel label_5 = new JLabel("\uC601\uD654\uBC88\uD638");
		label_5.setFont(new Font("굴림", Font.BOLD, 14));
		label_5.setBounds(26, 24, 83, 15);
		panel_1.add(label_5);
		
		movienoTF = new JTextField();
		movienoTF.setColumns(10);
		movienoTF.setBounds(108, 19, 178, 28);
		panel_1.add(movienoTF);
		
		moviegenre_TF = new JTextField();
		moviegenre_TF.setColumns(10);
		moviegenre_TF.setBounds(107, 128, 354, 28);
		panel_1.add(moviegenre_TF);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 166, 354, 75);
		panel_1.add(scrollPane);
		
		JTextArea moviestory_TA = new JTextArea();
		scrollPane.setViewportView(moviestory_TA);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(107, 251, 354, 75);
		panel_1.add(scrollPane_1);
		
		JTextArea movieactor_TA = new JTextArea();
		scrollPane_1.setViewportView(movieactor_TA);
		
		Modifybtn = new JButton("\uC601\uD654 \uC218\uC815");
		Modifybtn.setBounds(248, 417, 108, 38);
		panel_1.add(Modifybtn);
		
		JLabel label_6 = new JLabel("(\uBD84)");
		label_6.setFont(new Font("굴림", Font.BOLD, 14));
		label_6.setBounds(437, 95, 43, 15);
		panel_1.add(label_6);
		
		movieposter_TF = new JTextField();
		movieposter_TF.setColumns(10);
		movieposter_TF.setBounds(115, 346, 251, 28);
		panel_1.add(movieposter_TF);
		
		JLabel label_7 = new JLabel("\uD3EC\uC2A4\uD130 \uD30C\uC77C");
		label_7.setFont(new Font("굴림", Font.BOLD, 14));
		label_7.setBounds(26, 352, 83, 15);
		panel_1.add(label_7);
		
		modifyfilebtn = new JButton("\uC218\uC815\uD30C\uC77C \uB4F1\uB85D");
		modifyfilebtn.setBounds(372, 340, 108, 38);
		panel_1.add(modifyfilebtn);
		
		Deletebtn = new JButton("\uC601\uD654 \uC0AD\uC81C");
		Deletebtn.setBounds(368, 417, 108, 38);
		panel_1.add(Deletebtn);
		
		listbtn = new JButton("\uBAA9\uB85D \uC870\uD68C");
		listbtn.setBounds(128, 417, 108, 38);
		panel_1.add(listbtn);
		
	}
}
