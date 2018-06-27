package com.kitri.project.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.kitri.project.branch.service.BranchService;
import com.kitri.project.cartype.CarTypeService;
import com.kitri.project.user.controller.UserLoginController;
import com.kitri.project.user.dto.UserDto;
import com.kitri.project.user.view.UserLogin;
import com.kitri.project.user.view.UserMenu;

public class UserLoginService {
  public UserLoginDao userLoginDao;
  public UserMenu menu;
  public UserLoginService register;
  public UserDto userDto;
  public UserLoginController userLoginController;
  public UserLogin login;
  
  // ��ü ����
  BranchService bservice = new BranchService();
  CarTypeService cservice = new CarTypeService();
  
  public UserLoginService() {
    userLoginDao = new UserLoginDao();
  }
  
  // ��Ʈ�ѷ� �ܿ��� �α��� ȣ��� login �� �ѱ��
  public UserLoginService(UserLogin userLogin) {
    this.login = login;
    userLoginDao = new UserLoginDao();
    
  }
  
  /*
   * public int register(UserDto userdto) { return userDao.register(UserLoginDao);
   * }
   */  
  public UserDto login(String id, String pass) {
    System.out.println("��Ʈ�ѷ����� ������ login �޼ҵ� �� �������� id : " + id + "\t pass: " + pass);
    // id, pass null �� ����
    
    //java���� �����ϴ� �⺻ ���Խ� ǥ�� - Ư������ ����
    //http://superfelix.tistory.com/70 ����
    boolean idCheck = false; 
    idCheck = Pattern.matches("^[a-zA-Z0-9]*$", id);
    //����, ����: true, Ư������: false

    //Ư�� ���� �Է½� �α��� ���� - �α���â ����
    if(idCheck == false) { 
      System.out.println("���� - Ư������ �ԷµǾ����ϴ�.  �ٽ� ���� ���ּ���!!");
      JOptionPane.showMessageDialog(login, "Ư������ �ԷµǾ����ϴ�. �ٽ� ���� ���ּ���!!", "�α��� ����", JOptionPane.INFORMATION_MESSAGE);     
      return null;
    } 
    
     //�ΰ� �Է½� �α��� �Ұ�
     if (id.isEmpty() == true || pass.isEmpty() == true || pass.equals("PWD �Է� ���ּ���") || id.equals("ID �Է� ���ּ���")) {
      System.out.println("���� - �ΰ��� �ֽ��ϴ�.");
      JOptionPane.showMessageDialog(login, "ID �Ǵ� Pass�� ����� �ԷµǾ����ϴ�.", "�α��� ����", JOptionPane.INFORMATION_MESSAGE);
      return null;
    }
    return userLoginDao.login(id, pass);
    // return dao.login(userDto);
    // dao�� login���� ���� ���޵�
  }

  public UserDto idsuch(String nameP3, String emailP3) {
    System.out.println("��Ʈ�ѷ����� ������ login �޼ҵ� �� �������� id :" + nameP3 + "\t pass: " + emailP3);
    if (nameP3.isEmpty() == true || emailP3.isEmpty() == true) {
      System.out.println("���� - �ΰ��� �ֽ��ϴ�.");
      JOptionPane.showMessageDialog(login, "����� �ԷµǾ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
      return null;
    }
    return userLoginDao.idsuch(nameP3, emailP3);
    // dao�� login���� ���� ���޵�
  }
  
  public UserDto pwdsuch(String idTextP4, String emailTextP4) {
    System.out.println("��Ʈ�ѷ����� ������ login �޼ҵ� �� �������� idTextP4 :" + idTextP4 + "\t emailTextP4: " + emailTextP4);
    if (idTextP4.isEmpty() == true || emailTextP4.isEmpty() == true) {
      System.out.println("���� - �ΰ��� �ֽ��ϴ�.");
      JOptionPane.showMessageDialog(login, "����� �ԷµǾ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
      return null;
    }
    return userLoginDao.pwdsuch(idTextP4, emailTextP4);
    // dao�� login���� ���� ���޵�
  }
  
  public UserDto join(String user_ID, String user_PWD, String user_PWD1, String carType_NO, String user_NAME,
      String user_EMAIL, String user_PHONE) {
    System.out.println("��Ʈ�ѷ����� ������ login �޼ҵ� �� ��������  user_ID: " + user_ID + "\t user_PWD: " + user_PWD
        + "\t user_PWD1: " + user_PWD1 + "\t carType_NO: " + carType_NO + "\t user_NAME: " + user_NAME
        + "\t user_EMAIL: " + user_EMAIL + "\t user_PHONE: " + user_PHONE);
    
    // String check = String.valueOf(carType_NO); // (check != null &&
    // !check.isEmpty())
    if (user_ID.isEmpty() == true || user_PWD.isEmpty() == true || user_PWD.isEmpty() == true
        || user_PWD1.isEmpty() == true || user_NAME.isEmpty() == true || user_EMAIL.isEmpty() == true
        || user_PHONE.isEmpty() == true) {
      System.out.println("���� - ȸ������ �Է� ���� ������ �ԷµǾ����ϴ�. �ٽ� �Է��ϼ���");
      JOptionPane.showMessageDialog(login, "ȸ������ �Է� ���� ������ �ԷµǾ����ϴ�. �ٽ� �Է��ϼ���", "����", JOptionPane.INFORMATION_MESSAGE);
      return null;
    }
    
    if (user_PWD.equals(user_PWD1)) {
      System.out.println("���� - ��й�ȣ�� ��ġ�մϴ�.");
      JOptionPane.showMessageDialog(login, "��й�ȣ�� ��ġ�մϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
      // return dao.login(userDto);
      // dao�� login���� ���� ���޵�/ }
      return userLoginDao.join(user_ID, user_PWD, carType_NO, user_NAME, user_EMAIL, user_PHONE);
    } else {
      System.out.println("���� - ��й�ȣ�� ��ġ���� �ʽ��ϴ�..");
      JOptionPane.showMessageDialog(login, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
    }
    return userLoginDao.join(user_ID, user_PWD, carType_NO, user_NAME, user_EMAIL, user_PHONE);
  }
  
  public UserDto nameSuch(String user_ID) {
    
    return userLoginDao.nameJoin(user_ID);
  }
  
  public UserDto gradeSuch(String user_ID) {
    return userLoginDao.gradeSuch(user_ID);
    
  }
  
  
}
