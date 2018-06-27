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
				System.out.println("영화조회");		
				empMain.empMovieEditDelete.setVisible(true);
			}else if(obj == empMain.tabFrame.empMovieEditDelete.movieDeleteBtn) {
				System.out.println("영화삭제");
				JOptionPane.showMessageDialog(empMain,"삭제되었습니다.","메시지",JOptionPane.WARNING_MESSAGE);
				empMain.empMovieEditDelete.setVisible(true);
				}else if(obj == empMain.tabFrame.empMovieEditDelete.movieEditBtn) {
				System.out.println("영화수정");
				JOptionPane.showMessageDialog(empMain,"수정되었습니다.","메시지", 0);	
				
				
				
			}
		}
				   //마우스 리스너 통해서 클릭시 텍스트 값 초기화
				  @Override
				  public void mouseClicked(MouseEvent e) {
				    Object ob = e.getSource();
				    if (ob == empMain.tabFrame.empMovieEditDelete.movieDeleteBtn) { //영화삭제버튼
				    	empMain.empMovieEditDelete.startDateTf.setText("");
				    } else if (ob == empMain.empMovieEditDelete.endDateTf) { //상영종료일
				    	empMain.empMovieEditDelete.endDateTf.setText("");
				    } else if (ob == empMain.empMovieEditDelete.time1Tf) { //상영시간1
				    	empMain.empMovieEditDelete.time1Tf.setText("");
				    } else if (ob == empMain.empMovieEditDelete.time2Tf) { //상영시간2
				    	empMain.empMovieEditDelete.time2Tf.setText("");
				    } else if (ob == empMain.empMovieEditDelete.time3Tf) { //상영시간3
				    	empMain.empMovieEditDelete.time3Tf.setText("");
				    } else if (ob == empMain.empMovieEditDelete.movieNoL) { //영화번호
				    	empMain.empMovieEditDelete.movieNoL.setText("");
				    } else if (ob == empMain.empMovieEditDelete.movieGenreTF) {//상영횟수
				    	empMain.empMovieEditDelete.movieGenreTF.setText("");
				    } else if (ob == empMain.empMovieEditDelete.branchNameL) {//지점
				    	
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
	