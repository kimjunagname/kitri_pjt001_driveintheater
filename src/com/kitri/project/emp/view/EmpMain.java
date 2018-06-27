package com.kitri.project.emp.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.project.emp.controller.*;
import com.kitri.project.superadmin.controller.SuperAdminMenuController;
import com.kitri.project.superadmin.view.SuperAdminTabbedFrame;

public class EmpMain extends JFrame {

	public JPanel contentPane;
	public JTextField idTf;
	public JPasswordField pwdTf;
	public JButton loginBtn;
	public JButton joinBtn;

	public EmpMenuTabbedFrame tabFrame;
	public EmpJoin joinFrame;
	public EmpEditInfo editFrame;
	public SuperAdminTabbedFrame superTabFrame;
	
	public EmpMovieEditDelete empMovieEditDelete;
	
	
	
	
	
	EmpEditController empEditController;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					EmpMain frame = new EmpMain();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public EmpMain() {
		ImageIcon icon= icon = new ImageIcon("./featureddrive.jpg");
		tabFrame = new EmpMenuTabbedFrame();
		tabFrame.getContentPane().setBackground(new Color(255, 255, 255));
		joinFrame = new EmpJoin();
		editFrame = new EmpEditInfo();
		superTabFrame= new SuperAdminTabbedFrame();
		
		setTitle("\uC790\uB3D9\uCC28 \uADF9\uC7A5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 600);
		contentPane = new JPanel(){
            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(icon.getImage(), 0, 0, 1000, 600, null);
                // Approach 2: Scale image to size of component
                // Dimension d = getSize();
                // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                // Approach 3: Fix the image position in the scroll pane
                // Point p = scrollPane.getViewport().getViewPosition();
                // g.drawImage(icon.getImage(), p.x, p.y, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC790\uB3D9\uCC28 \uADF9\uC7A5");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 37));
		lblNewLabel.setBounds(354, 143, 284, 102);
		lblNewLabel.setForeground(Color.white);
		contentPane.add(lblNewLabel);
		
		idTf = new JTextField();
		idTf.setBounds(341, 255, 186, 50);
		contentPane.add(idTf);
		idTf.setColumns(10);
		
		pwdTf = new JPasswordField();
		pwdTf.setColumns(10);
		pwdTf.setBounds(341, 328, 186, 50);
		contentPane.add(pwdTf);
		
		loginBtn = new JButton("로 그 인");
		loginBtn.setBackground(new Color(51, 204, 255));
		loginBtn.setBounds(539, 327, 99, 50);
		contentPane.add(loginBtn);
		
		joinBtn = new JButton("회원가입");
		joinBtn.setBackground(new Color(51, 204, 255));
		joinBtn.setBounds(539, 255, 99, 50);
		contentPane.add(joinBtn);
		
		setVisible(true);
		
		EmpMainController control = new EmpMainController(this);
		EmpInfoController infoControl = new EmpInfoController(this);
		EmpMovieController movieControl = new EmpMovieController(this);
		EmpWorkController workControl = new EmpWorkController(this);
//		EmpBranchController branchControl = new EmpBranchController(this);
		EmpChartController chartControl = new EmpChartController(this);
		EmpEditController editControl = new EmpEditController(this);
		
		SuperAdminMenuController superControl= new SuperAdminMenuController(this);
		
	
		joinBtn.addActionListener(infoControl);
		loginBtn.addActionListener(infoControl);
		pwdTf.addActionListener(infoControl);
		
		joinFrame.idChkBtn.addActionListener(infoControl);
		joinFrame.emailChkBtn.addActionListener(infoControl);
		joinFrame.cancelBtn.addActionListener(infoControl);
		joinFrame.joinBtn.addActionListener(infoControl);
		joinFrame.idTf.addKeyListener(infoControl);
		joinFrame.emailTf.addKeyListener(infoControl);
		joinFrame.yearList.addItemListener(infoControl);
		joinFrame.monthList.addItemListener(infoControl);
		
		editFrame.editBtn.addActionListener(infoControl);
		editFrame.cancelBtn.addActionListener(infoControl);
		editFrame.yearC.addItemListener(infoControl);
		editFrame.monthC.addItemListener(infoControl);
		
		
		tabFrame.tabbedPane.addChangeListener(control);

		
		tabFrame.infoBtn.addActionListener(infoControl);
		tabFrame.outBtn.addActionListener(infoControl);
		
		tabFrame.movieMainPanel.editMovieBtn.addActionListener(movieControl);
		tabFrame.movieMainPanel.registerMovieBtn.addActionListener(movieControl);
		
		tabFrame.movieInsertPanel.movieRegisterBtn.addActionListener(movieControl);
		tabFrame.movieInsertPanel.movieTitleC.addItemListener(movieControl);
		tabFrame.movieInsertPanel.startYearC.addItemListener(movieControl);
		tabFrame.movieInsertPanel.startMonthC.addItemListener(movieControl);
		tabFrame.movieInsertPanel.startDateC.addItemListener(movieControl);
		tabFrame.movieInsertPanel.endYearC.addItemListener(movieControl);
		tabFrame.movieInsertPanel.endMonthC.addItemListener(movieControl);
		tabFrame.movieInsertPanel.endDateC.addItemListener(movieControl);
		
		
//		근태관리
		tabFrame.workMainPanel.workInBtn.addActionListener(workControl);
		tabFrame.workMainPanel.workOutBtn.addActionListener(workControl);
		tabFrame.workMainPanel.timeMngBtn.addActionListener(workControl);

//		TODO 통계
		tabFrame.branchMainPanel.salesBtn.addActionListener(chartControl);
//		tabFrame.branchMainPanel.movieRankBtn.addActionListener(chartControl);
		
		tabFrame.chartPanel.yearBtn.addActionListener(chartControl);
		tabFrame.chartPanel.monthBtn.addActionListener(chartControl);
		
		
//		영화 수정등록및 삭제
		
		tabFrame.empMovieEditDelete.movieEditBtn.addActionListener(movieControl);
//		tabFrame.empMovieEditDelete.movieDeleteBtn.addActionListener(movieControl);
//		tabFrame.empMovieEditDelete.movieViewBtn.addActionListener(movieControl);
		
		superTabFrame.movieInsertPanel.insertImageB.addActionListener(superControl);
		superTabFrame.movieInsertPanel.registerMovieB.addActionListener(superControl);
		
		superTabFrame.chartPanel.yearBtn.addActionListener(superControl);
		superTabFrame.chartPanel.monthBtn.addActionListener(superControl);
		superTabFrame.chartPanel.branchC.addItemListener(superControl);
		
		
		
	}
}
