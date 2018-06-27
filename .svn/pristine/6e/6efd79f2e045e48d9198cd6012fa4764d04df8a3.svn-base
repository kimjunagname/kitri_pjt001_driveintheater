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
  
  // 객체 생성
  BranchService bservice = new BranchService();
  CarTypeService cservice = new CarTypeService();
  
  public UserLoginService() {
    userLoginDao = new UserLoginDao();
  }
  
  // 컨트롤러 단에서 로그인 호출시 login 값 넘기기
  public UserLoginService(UserLogin userLogin) {
    this.login = login;
    userLoginDao = new UserLoginDao();
    
  }
  
  /*
   * public int register(UserDto userdto) { return userDao.register(UserLoginDao);
   * }
   */  
  public UserDto login(String id, String pass) {
    System.out.println("컨트롤러에서 서비스의 login 메소드 에 보내진값 id : " + id + "\t pass: " + pass);
    // id, pass null 값 검증
    
    //java에서 지원하는 기본 정규식 표현 - 특수문자 검출
    //http://superfelix.tistory.com/70 참조
    boolean idCheck = false; 
    idCheck = Pattern.matches("^[a-zA-Z0-9]*$", id);
    //영어, 숫자: true, 특수문자: false

    //특수 문자 입력시 로그인 실패 - 로그인창 꺼짐
    if(idCheck == false) { 
      System.out.println("서비스 - 특수값이 입력되었습니다.  다시 실행 해주세요!!");
      JOptionPane.showMessageDialog(login, "특수값이 입력되었습니다. 다시 실행 해주세요!!", "로그인 정보", JOptionPane.INFORMATION_MESSAGE);     
      return null;
    } 
    
     //널값 입력시 로그인 불가
     if (id.isEmpty() == true || pass.isEmpty() == true || pass.equals("PWD 입력 해주세요") || id.equals("ID 입력 해주세요")) {
      System.out.println("서비스 - 널값이 있습니다.");
      JOptionPane.showMessageDialog(login, "ID 또는 Pass에 빈란이 입력되었습니다.", "로그인 정보", JOptionPane.INFORMATION_MESSAGE);
      return null;
    }
    return userLoginDao.login(id, pass);
    // return dao.login(userDto);
    // dao에 login으로 값이 전달됨
  }

  public UserDto idsuch(String nameP3, String emailP3) {
    System.out.println("컨트롤러에서 서비스의 login 메소드 에 보내진값 id :" + nameP3 + "\t pass: " + emailP3);
    if (nameP3.isEmpty() == true || emailP3.isEmpty() == true) {
      System.out.println("서비스 - 널값이 있습니다.");
      JOptionPane.showMessageDialog(login, "빈란이 입력되었습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
      return null;
    }
    return userLoginDao.idsuch(nameP3, emailP3);
    // dao에 login으로 값이 전달됨
  }
  
  public UserDto pwdsuch(String idTextP4, String emailTextP4) {
    System.out.println("컨트롤러에서 서비스의 login 메소드 에 보내진값 idTextP4 :" + idTextP4 + "\t emailTextP4: " + emailTextP4);
    if (idTextP4.isEmpty() == true || emailTextP4.isEmpty() == true) {
      System.out.println("서비스 - 널값이 있습니다.");
      JOptionPane.showMessageDialog(login, "빈란이 입력되었습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
      return null;
    }
    return userLoginDao.pwdsuch(idTextP4, emailTextP4);
    // dao에 login으로 값이 전달됨
  }
  
  public UserDto join(String user_ID, String user_PWD, String user_PWD1, String carType_NO, String user_NAME,
      String user_EMAIL, String user_PHONE) {
    System.out.println("컨트롤러에서 서비스의 login 메소드 에 보내진값  user_ID: " + user_ID + "\t user_PWD: " + user_PWD
        + "\t user_PWD1: " + user_PWD1 + "\t carType_NO: " + carType_NO + "\t user_NAME: " + user_NAME
        + "\t user_EMAIL: " + user_EMAIL + "\t user_PHONE: " + user_PHONE);
    
    // String check = String.valueOf(carType_NO); // (check != null &&
    // !check.isEmpty())
    if (user_ID.isEmpty() == true || user_PWD.isEmpty() == true || user_PWD.isEmpty() == true
        || user_PWD1.isEmpty() == true || user_NAME.isEmpty() == true || user_EMAIL.isEmpty() == true
        || user_PHONE.isEmpty() == true) {
      System.out.println("서비스 - 회원가입 입력 란에 공백이 입력되었습니다. 다시 입력하세요");
      JOptionPane.showMessageDialog(login, "회원가입 입력 란에 공백이 입력되었습니다. 다시 입력하세요", "정보", JOptionPane.INFORMATION_MESSAGE);
      return null;
    }
    
    if (user_PWD.equals(user_PWD1)) {
      System.out.println("서비스 - 비밀번호가 일치합니다.");
      JOptionPane.showMessageDialog(login, "비밀번호가 일치합니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
      // return dao.login(userDto);
      // dao에 login으로 값이 전달됨/ }
      return userLoginDao.join(user_ID, user_PWD, carType_NO, user_NAME, user_EMAIL, user_PHONE);
    } else {
      System.out.println("서비스 - 비밀번호가 일치하지 않습니다..");
      JOptionPane.showMessageDialog(login, "비밀번호가 일치하지 않습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
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
