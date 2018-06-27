package com.kitri.project.user.service;

import java.sql.*;
import java.util.List;
import com.kitri.project.sql.CarSql;
import com.kitri.project.user.dto.UserDto;

public class UserLoginDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt;
	ResultSet rs = null;
	int rsr;
	CarSql carsql = null;
	UserDto userDto = null;
	List list;
	
	public int num = 0;

  public UserLoginDao() {
    carsql= new CarSql();
  }
  
  public UserLoginDao select(UserLoginDao userLoginDao) {
    return null;
  }
  
  
  public int register(UserLoginDao userLoginDao) {
    return 0;
  }
  
  
  
  //join   
  public UserDto join(String user_ID, String user_PWD, String carType_NO, String user_NAME, String user_EMAIL, String user_PHONE) {
////  public UserDto login(UserDto userDto) {
    System.out.println("DAO 입력 받는값 user_ID: " + user_ID + "\t user_PWD: " + user_PWD + "\t carType_NO: " + carType_NO
        + "\t user_NAME: " +user_NAME+ "\t user_EMAIL: " + user_EMAIL+ "\t user_PHONE: " + user_PHONE);
    //UserDto userDto
       try {
      con = carsql.connect();
      // DriverManager 객체로부터 Connection 객체를 얻어온다.
      String sql = ""; //string sql 변수 선언
      sql += "INSERT INTO USER_INFO VALUES(USER_NO.nextval, ?, ?, ?, ?, ?, ?) ";
               
      pstmt = con.prepareStatement(sql); //prepareStatement에서 해당 sql을 미리 컴파일한다.
      System.out.println("pstmt 검증: " + pstmt);
      pstmt.setString(1, user_ID); //1값에 id를 
      pstmt.setString(2, user_PWD);
//      pstmt.setInt(3, carType_NO);
      pstmt.setString(3, carType_NO);
      pstmt.setString(4, user_NAME);
      pstmt.setString(5, user_EMAIL);
      pstmt.setString(6, user_PHONE);
      //rs = pstmt.executeQuery();  // 쿼리를 실행하고 결과를 ResultSet 객체에 담는다.
      rsr = pstmt.executeUpdate(); //업데이트시 컬럼갯수 올림
      System.out.println(rsr > 0 ? "등록 성공!" : "등록실패");
    } catch (SQLException e) {// 예외가 발생하면 예외 상황을 처리한다.
      e.printStackTrace();
    } finally {
      carsql.close(rs, pstmt, con);
    }
      System.out.println(userDto);
    return userDto;  //return memberDto;반환
  }
  
  
  //login
  public UserDto login(String id, String pass) {
//  public UserDto login(UserDto userDto) {
    System.out.println("DAO - Dto : "+id + "\t pass:" + pass);
    //UserDto userDto
       try {
      con = carsql.connect();
      // DriverManager 객체로부터 Connection 객체를 얻어온다.
      String sql = ""; //string sql 변수 선언
      sql += "select * \n"; //선택
      sql += "from USER_INFO \n"; //프롬 멤버 테이블
      sql += "where USER_ID = ? and USER_PWD = ?";
      pstmt = con.prepareStatement(sql); //prepareStatement에서 해당 sql을 미리 컴파일한다.
      System.out.println("pstmt 검증: " + pstmt);
      pstmt.setString(1, id); //1값에 id를 
      pstmt.setString(2, pass);
      rs = pstmt.executeQuery();  // 쿼리를 실행하고 결과를 ResultSet 객체에 담는다.
   
      while(rs.next()) {
        // 결과를 한 행씩 돌아가면서 가져온다.
        userDto = new UserDto(); //MemberDto 의 memberDto 객체 생성
        userDto.setUser_id(rs.getString("setUser_id")); //memberDto에 id 값 가져오기
        userDto.setUser_pwd(rs.getString("setUser_pwd"));  //memberDto에 name 값 가져오기
        userDto.setUser_name(rs.getString("user_name"));  //memberDto에 name 값 가져오기
      }  
      
    } catch (SQLException e) {// 예외가 발생하면 예외 상황을 처리한다.
      e.printStackTrace();
    } finally {
      carsql.close(rs, pstmt, con);
//      System.out.println(userDto.getUser_id() + userDto.getUser_pwd() + userDto.getUser_name());
    }
      
    return userDto;  //return memberDto;반환
  }
  
//  nameJoin(user_ID)
//idsunameJoinch
  public UserDto nameJoin(String user_ID) {
//  public UserDto login(UserDto userDto) {
    System.out.println("DAO - user_ID : "+user_ID);
    //UserDto userDto
       try {
      con = carsql.connect();
      // DriverManager 객체로부터 Connection 객체를 얻어온다.
      String sql = ""; //string sql 변수 선언
      sql += "select USER_NAME \n"; //선택
      sql += "from USER_INFO \n"; //프롬 멤버 테이블
      sql += "where USER_ID = ? ";
      pstmt = con.prepareStatement(sql); //prepareStatement에서 해당 sql을 미리 컴파일한다.
      System.out.println("pstmt 검증: " + pstmt);
      pstmt.setString(1, user_ID); //1값에 id를 
      rs = pstmt.executeQuery();  // 쿼리를 실행하고 결과를 ResultSet 객체에 담는다.
     
      while(rs.next()) {
        // 결과를 한 행씩 돌아가면서 가져온다.
        userDto = new UserDto(); //MemberDto 의 memberDto 객체 생성
        userDto.setUser_name(rs.getString("user_name")); //memberDto에 name 값 가져오기
        }  
      System.out.println("userDto.getUser_name():" + userDto.getUser_name());
    } catch (SQLException e) {// 예외가 발생하면 예외 상황을 처리한다.
      e.printStackTrace();
    } finally {
      carsql.close(rs, pstmt, con);
    }
    return userDto;  //return memberDto;반환
  }
  
  
//gradeSuch
  public UserDto gradeSuch(String user_id) {
    System.out.println("UserDto gradeSuch - user_id : "+ user_id );
       try {
      con = carsql.connect();
      String sql = "";
      sql += "select USER_INFO.USER_ID, GRADE_MANAGE.GRADE_NAME  \n"; //선택
      sql += "from USER_INFO, USER_MILEAGE, GRADE_MANAGE \n"; //프롬 멤버 테이블
      sql += "where USER_INFO.USER_NO = USER_MILEAGE.USER_NO \n";
      sql += "AND USER_MILEAGE.USER_RSVCOUNT \n";
      sql += "between GRADE_MANAGE.GRADE_LOCOUNT and GRADE_MANAGE.GRADE_HICOUNT \n";
      sql += "and USER_INFO.USER_ID = ? \n";
      pstmt = con.prepareStatement(sql); //prepareStatement에서 해당 sql을 미리 컴파일한다.
      System.out.println("pstmt1 검증: " + pstmt);
      pstmt.setString(1, user_id); //1값에 id를 
      rs = pstmt.executeQuery();  // 쿼리를 실행하고 결과를 ResultSet 객체에 담는다. 
      while(rs.next()) {
        // 결과를 한 행씩 돌아가면서 가져온다.
        userDto = new UserDto(); //MemberDto 의 memberDto 객체 생성
        userDto.setUser_id(rs.getString("user_id")); 
        userDto.setGrade_name(rs.getString("grade_name")); //memberDto에 id 값 가져오기
        }  
      
      System.out.println("DAO - " + userDto.getGrade_name());
    } catch (SQLException e) {// 예외가 발생하면 예외 상황을 처리한다.
      e.printStackTrace();
    } finally {
      carsql.close(rs, pstmt, con);
    }
    return userDto;  //return memberDto;반환
  }

  

//idsuch
  public UserDto idsuch(String nameP3, String emailP3) {
//  public UserDto login(UserDto userDto) {
    System.out.println("DAO - nameP3 : "+nameP3 + "emailP3:" + emailP3);
    //UserDto userDto
       try {
      con = carsql.connect();
      // DriverManager 객체로부터 Connection 객체를 얻어온다.
      String sql = ""; //string sql 변수 선언
      sql += "select USER_ID \n"; //선택
      sql += "from USER_INFO \n"; //프롬 멤버 테이블
      sql += "where USER_NAME = ? and USER_EMAIL = ?";
      pstmt = con.prepareStatement(sql); //prepareStatement에서 해당 sql을 미리 컴파일한다.
      System.out.println("pstmt 검증: " + pstmt);
      pstmt.setString(1, nameP3); //1값에 id를 
      pstmt.setString(2, emailP3);
      rs = pstmt.executeQuery();  // 쿼리를 실행하고 결과를 ResultSet 객체에 담는다.
     
      while(rs.next()) {
        // 결과를 한 행씩 돌아가면서 가져온다.
        userDto = new UserDto(); //MemberDto 의 memberDto 객체 생성
        userDto.setUser_id(rs.getString("user_id")); //memberDto에 id 값 가져오기
        }  
    } catch (SQLException e) {// 예외가 발생하면 예외 상황을 처리한다.
      e.printStackTrace();
    } finally {
      carsql.close(rs, pstmt, con);
    }
    return userDto;  //return memberDto;반환
  }
  
//pwdsuch
  public UserDto pwdsuch(String idTextP4, String emailTextP4) {
//  public UserDto login(UserDto userDto) {
    System.out.println("DAO - idTextP4 : "+idTextP4 + "\t emailTextP4:" + emailTextP4);
    //UserDto userDto
       try {
      con = carsql.connect();
      // DriverManager 객체로부터 Connection 객체를 얻어온다.
      String sql = ""; //string sql 변수 선언
      sql += "select user_pwd \n"; //선택
      sql += "from USER_INFO \n"; //프롬 멤버 테이블
      sql += "where USER_ID = ? and USER_EMAIL = ?";
      pstmt = con.prepareStatement(sql); //prepareStatement에서 해당 sql을 미리 컴파일한다.
      System.out.println("pstmt 검증: " + pstmt);
      pstmt.setString(1, idTextP4); //1값에 id를 
      pstmt.setString(2, emailTextP4);
      rs = pstmt.executeQuery();  // 쿼리를 실행하고 결과를 ResultSet 객체에 담는다.
      
      while(rs.next()) {
        // 결과를 한 행씩 돌아가면서 가져온다.
        userDto = new UserDto(); //MemberDto 의 memberDto 객체 생성
        userDto.setUser_pwd(rs.getString("user_PWD")); //memberDto에 id 값 가져오기
        }  

    } catch (SQLException e) {// 예외가 발생하면 예외 상황을 처리한다.
      e.printStackTrace();
    } finally {
      carsql.close(rs, pstmt, con);
    }
    return userDto;  //return memberDto;반환
  } 
  


  
}