package com.kitri.project.emp.controller;

import java.awt.event.*;
import java.util.List;

import javax.swing.JOptionPane;

import com.kitri.project.emp.movie.service.EmpMovieService;
import com.kitri.project.emp.view.EmpMain;
import com.kitri.project.emp.view.EmpMovieEditDelete;


	public class EmpEditController implements ActionListener, MouseListener{
//		EmpMain empMain;
		
		
		EmpMain empMain;
		EmpMovieEditDelete editDelete;
		EmpMovieService mService;
//		List<EmpMovieInsertDto> list;
		
		
		
		
		public EmpEditController(EmpMain empMain ) {
			this.empMain = empMain;
			mService = new EmpMovieService();
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
	
			if(obj == empMain.tabFrame.empMovieEditDelete.movieViewBtn) {
				System.out.println("��ȭ��ȸ");		
				empMain.empMovieEditDelete.setVisible(true);
			}else if(obj == empMain.tabFrame.empMovieEditDelete.movieDeleteBtn) {
				System.out.println("��ȭ����");
				JOptionPane.showMessageDialog(empMain,"�����Ǿ����ϴ�.","�޽���",JOptionPane.WARNING_MESSAGE);
				empMain.empMovieEditDelete.setVisible(true);
				}else if(obj == empMain.tabFrame.empMovieEditDelete.movieEditBtn) {
				System.out.println("��ȭ����");
				JOptionPane.showMessageDialog(empMain,"�����Ǿ����ϴ�.","�޽���", 0);	
				
				
				
			}
		}
				   //���콺 ������ ���ؼ� Ŭ���� �ؽ�Ʈ �� �ʱ�ȭ
				  @Override
				  public void mouseClicked(MouseEvent e) {
				    Object ob = e.getSource();
				    if (ob == empMain.tabFrame.empMovieEditDelete.movieDeleteBtn) { //��ȭ������ư
				    	empMain.empMovieEditDelete.startDateTf.setText("");
				    } else if (ob == empMain.empMovieEditDelete.endDateTf) { //��������
				    	empMain.empMovieEditDelete.endDateTf.setText("");
				    } else if (ob == empMain.empMovieEditDelete.time1Tf) { //�󿵽ð�1
				    	empMain.empMovieEditDelete.time1Tf.setText("");
				    } else if (ob == empMain.empMovieEditDelete.time2Tf) { //�󿵽ð�2
				    	empMain.empMovieEditDelete.time2Tf.setText("");
				    } else if (ob == empMain.empMovieEditDelete.time3Tf) { //�󿵽ð�3
				    	empMain.empMovieEditDelete.time3Tf.setText("");
				    } else if (ob == empMain.empMovieEditDelete.movieNoL) { //��ȭ��ȣ
				    	empMain.empMovieEditDelete.movieNoL.setText("");
				    } else if (ob == empMain.empMovieEditDelete.movieGenreTF) {//��Ƚ��
				    	empMain.empMovieEditDelete.movieGenreTF.setText("");
				    } else if (ob == empMain.empMovieEditDelete.branchNameL) {//����
				    	
				    }
				  }
				  
				  @Override
				  public void mouseEntered(MouseEvent e) {
		
				    
				  }
				  
				  @Override
				  public void mouseExited(MouseEvent e) {
				
				    
				  }
				  
				  @Override
				  public void mousePressed(MouseEvent e) {
				
				    
				  }
				  
				  @Override
				  public void mouseReleased(MouseEvent e) {
				 
				    
				  }			
			}
	