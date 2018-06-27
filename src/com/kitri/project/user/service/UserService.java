package com.kitri.project.user.service;

import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.kitri.project.branch.service.BranchService;
import com.kitri.project.cartype.CarTypeService;
import com.kitri.project.chart.dto.PayChartDto;
import com.kitri.project.chart.service.PayChartDao;
import com.kitri.project.emp.dto.EmpTimeMngDto;
import com.kitri.project.movie.dto.MovieDto;
import com.kitri.project.movie.service.UserMovieDao;
import com.kitri.project.user.controller.UserLoginController;
import com.kitri.project.user.dto.UserDto;
import com.kitri.project.user.view.UserLogin;
import com.kitri.project.user.view.UserMenu;

public class UserService {
	public UserDao userDao;
	public UserMenu menu;
	public UserService register;
	public UserDto userDto;
	public UserLoginController userLoginController = null;
	// UserLogin ���� ����
	public UserLogin login;
	public UserMovieDao movieDao;
	BranchService bservice = new BranchService();
	CarTypeService cservice = new CarTypeService();

	public UserService(UserMenu menu) {
		this.menu = menu;
		userDao = new UserDao();

		List<String> list = bservice.getBranchNames();
		int len = list.size();
		for (int i = 0; i < len; i++) {
			menu.p2_1.choice.add(list.get(i));
			// choice���� select�� �����ͼ� db�� ������ �� 1 ���������
		}

		// ��ȭ����2 ���̽� ������Ʈ
		List<String> list2 = cservice.selectCarTypeNameAll();
		len = list2.size();
		menu.p2_2.cartypeC.add("�������ּ���");
		menu.p5.carModelC.add("�̼���");
		for (int i = 0; i < len; i++) {
			menu.p2_2.cartypeC.add(list2.get(i)); // ��ȭ���� ����
			menu.p5.carModelC.add(list2.get(i)); // �������� ����
		}

		// // ��ȭ���� ����
		// for (int i = 1; i <= 10; i++)
		// menu.p2_2.quentityC.add(i + "");

//		// �������� birth
//		for (int i = 1950; i <= 2010; i++)
//			menu.p5.yearC.add(i + "");
//
//		for (int i = 1; i <= 12; i++)
//			menu.p5.monthC.add(i + "");
//
//		for (int i = 1; i <= 31; i++)// ���� ������ 1��
//			menu.p5.dayC.add(i + "");

		// �������� �⺻ ����
		// List list3 = userDao.selectModifyUserInfo();
		// menu.p5.idF.setText(list3.get(0) + "�׽�Ʈ1");
		// menu.p5.nameF.setText(list3.get(1) + "�׽�Ʈ2");
		// menu.p5.emailF.setText(list3.get(2) + "�׽�Ʈ3");

		// ��ȭ���� �ʱⰪ
		movieDao = new UserMovieDao();
		List<MovieDto> list4 = movieDao.selectAllMovieByUser(1); // ó�������� 1����
		String filePath = list4.get(0).getMovie_poster();
		menu.p2_1.p1_1.posterL.setIcon(new ImageIcon(filePath));
		menu.p2_1.p1_1.titleL.setText(list4.get(0).getMovie_title());
		// ImageIcon icon= new ImageIcon(filePath);
		// Image scaleImage= icon.getImage().getScaledInstance(width, height,
		// Image.SCALE_DEFAULT);
		// SELECT to_date(180710, 'yymmdd')- to_date(180701, 'yymmdd') from dual
		// ù° ��¥���� ��° ��¥�� �� ���ڹ����� ���� (ex, 10)
	}

	public int register(UserDto userDto) {
		return userDao.register(userDto);
	}

	public int modifyUserInfo(String id, String pwd, String re_pwd, String carType, String name, String email,
			String phone) {
		// if (menu.p5.passwordField_1.getPassword().equals("")
		// ||menu.p5.passwordField_2.getPassword().equals("")) {
		// JOptionPane.showMessageDialog(menu.panel, "��й�ȣ�� null���� �ֽ��ϴ�", "��й�ȣ �Է� ����",
		// JOptionPane.WARNING_MESSAGE);
		// } else if(!pwd.equals(re_pwd)) {// �н����尡 ���� �ʴ´ٸ�
		// JOptionPane.showMessageDialog(menu.panel, "��й�ȣ�� ���� �ʽ��ϴ�", "��й�ȣ �Է� ����",
		// JOptionPane.WARNING_MESSAGE);
		// } else {
		userDao.modifyUserInfo(id, pwd, carType, name, email, phone);
		JOptionPane.showMessageDialog(menu.panel, "������Ʈ�� �����߽��ϴ�");
		// }
		return userDao.num;
	}

	//�������
  public int deletPayNo(String name) {
    
    userDao.deletPayNo(name);
    JOptionPane.showMessageDialog(menu.panel, "���Ű� ��� �Ǿ����ϴ�.");
    
    return userDao.num;
    
  }
  
	
//	public void changeDay() {
//		if (Integer.parseInt(menu.p5.monthC.getSelectedItem()) == 1
//				|| Integer.parseInt(menu.p5.monthC.getSelectedItem()) == 3
//				|| Integer.parseInt(menu.p5.monthC.getSelectedItem()) == 5
//				|| Integer.parseInt(menu.p5.monthC.getSelectedItem()) == 8
//				|| Integer.parseInt(menu.p5.monthC.getSelectedItem()) == 10
//				|| Integer.parseInt(menu.p5.monthC.getSelectedItem()) == 12) {
//			menu.p5.dayC.removeAll(); // ������ �ִ� �� �����ֱ�
//			for (int i = 1; i <= 31; i++) {
//				menu.p5.dayC.add(i + "");
//			}
//		} else if (Integer.parseInt(menu.p5.monthC.getSelectedItem()) == 4
//				|| Integer.parseInt(menu.p5.monthC.getSelectedItem()) == 6
//				|| Integer.parseInt(menu.p5.monthC.getSelectedItem()) == 7
//				|| Integer.parseInt(menu.p5.monthC.getSelectedItem()) == 9
//				|| Integer.parseInt(menu.p5.monthC.getSelectedItem()) == 11) {
//			menu.p5.dayC.removeAll();
//			for (int i = 1; i <= 30; i++) {
//				menu.p5.dayC.add(i + "");
//			}
//		} else {// 2��
//			menu.p5.dayC.removeAll();
//			for (int i = 1; i <= 28; i++) {
//				menu.p5.dayC.add(i + "");
//			}
//		}
//	}

	public void changeMovieInfo(int no, int value) {
		// value�� ���� ��ȭ������ŭ... ����...
		// value�� �Ű����� list�� ����ִ� ���� ��������...��
		// movieDao = new UserMovieDao();
		// List<MovieDto> list4 = movieDao.selectAllMovieByUser(1); // ó�������� 1����
		// String filePath = list4.get(0).getMovie_poster();
		// menu.p2_1.p1_1.posterL.setIcon(new ImageIcon(filePath));
		// menu.p2_1.p1_1.titleL.setText(list4.get(0).getMovie_title());
		UserMovieDao dao = new UserMovieDao();
		List<MovieDto> list = new ArrayList<MovieDto>();
		list = dao.selectDetailMovie(no);

		String startdate = list.get(value).getMovie_startdate();
		String enddate = list.get(value).getMovie_enddate();
		List<String> date = getDate(startdate.substring(0, 10), enddate.substring(0, 10));

		String branchname = "";
		if (no == 1)
			branchname = "����";
		else
			branchname = "��õ";
		
		menu.p2_2.title.setText(list.get(value).getMovie_title());
		menu.p2_2.branchL.setText(branchname + "");

		// System.out.println(date.isEmpty());
		// System.out.println("����");
		menu.p2_2.showdayC.removeAll();
		for (int i = 0; i < date.size(); i++) {
			menu.p2_2.showdayC.add(date.get(i));
			// System.out.println("�ȿ�������");
		}

		menu.p2_2.showtimeC.removeAll();
		menu.p2_2.showtimeC.add(list.get(value).getMovie_start1());
		menu.p2_2.showtimeC.add(list.get(value).getMovie_start2());
		menu.p2_2.showtimeC.add(list.get(value).getMovie_start3());

		if (no == 1) {
			System.out.println("1��");
			menu.p2_1.p1_1.posterL.setIcon(new ImageIcon(list.get(value).getMovie_poster()));
			menu.p2_1.p1_1.titleL.setText(list.get(value).getMovie_title());
		} else if (no == 2) {
			System.out.println("2��");
			menu.p2_1.p1_2.posterL.setIcon(new ImageIcon(list.get(value).getMovie_poster()));
			menu.p2_1.p1_2.titleL.setText(list.get(value).getMovie_title());
		} else
			JOptionPane.showMessageDialog(menu, "changeMovieInfo �̻�", "error", JOptionPane.WARNING_MESSAGE);
	}

	public UserDto getUserByName(String Name) {
		return userDao.getUserByName(Name);
	}

	private List<String> getDate(String startdate, String enddate) {
		String start = startdate;
		String end = enddate;
		// System.out.println("Start�� "+ startdate+ "\tend�� "+ enddate);
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<String> list = new ArrayList<String>();

		try {
			Date startDate = sdf.parse(start);
			Date endDate = sdf.parse(end);
			cal.setTime(startDate);
			// int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

			long diff = endDate.getTime() - startDate.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);

			for (int i = 0; i < (int) diffDays; i++) {
				cal.add(Calendar.DAY_OF_YEAR, 1);
				System.out.println(sdf.format(cal.getTime()));
				list.add(sdf.format(cal.getTime()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return list;
	}

	public void getMovieDetail() {
		// choice�� 0����, �����̴��� 1����
		int bnum = menu.p2_1.choice.getSelectedIndex() + 1;
		int mnum = 0; // ��ȭ��ȣ

		if (bnum == 1) {
			mnum = menu.p2_1.p1_1.slider.getValue() - 1;
			// System.out.println(menu.p2_1.p1_1.slider.getValue());
		} else if (bnum == 2) {
			mnum = menu.p2_1.p1_2.slider.getValue() - 1;
			// System.out.println(menu.p2_1.p1_2.slider.getValue());
		}

		List<MovieDto> list = new ArrayList<MovieDto>();

		list = movieDao.selectDetailMovie(bnum); // ��� ��ȭ������ ������
		menu.p9.titleL.setText(list.get(mnum).getMovie_title());
		menu.p9.actorL.setText(list.get(mnum).getMovie_actor());
		menu.p9.runningTimeL.setText(list.get(mnum).getMovie_runningtime() + "");
		menu.p9.storyTA.setText(list.get(mnum).getMovie_story());
	}

  public UserDto maSuchId(String userName) {
    System.out.println("userservice userName ���Ⱑ ����" + userName);
    
    userDto = userDao.maSuchId(userName);
    JOptionPane.showMessageDialog(menu.panel, "��ȭ���ų��� �޴� �Դϴ�.");
    
    System.out.println("userDto : " + userDto);
    
    System.out.println("dao : " + userDto.getaUSER_ID()+ "" 
        + userDto.getaUSER_NO()+ ""
        + userDto.getaMOVIE_PALYDATE()+ ""
        + userDto.getaMOVIE_TITLE()+ ""
        + userDto.getaBRANCH_NAME()+ ""
        + userDto.getaTICKET_PAYCASH()+ "" 
        + userDto.getaTICKET_PAYMILEAGE()+ "" 
        + userDto.getaTICKET_PAYTOTAL());
    
    
    return userDto;
  }


  
public int insertReservation(String userName, int branchNo, int movieNo, String showDay, String showTime,
		String carType, int total, int mileage) {
	PayChartDao dao = new PayChartDao();
	return dao.insertReservation(userName, branchNo, movieNo, showDay, showTime, carType, total, mileage);
}



//	public PayChartDto insertReservation(String userName, int branchNo, int movieNo, String showDay, String showTime,
//			String carType, int total, int mileage) {
//		PayChartDao dao = new PayChartDao();
//		return dao.insertReservation(userName, branchNo, movieNo, showDay, showTime, carType, total, mileage);
//	}
}