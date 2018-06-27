package com.kitri.project.user.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.kitri.project.sql.CarSql;
import com.kitri.project.user.dto.UserDto;

public class UserDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt;
	ResultSet rs = null;
	CarSql carsql = null;
	UserDto userDto = null;
	List list;

	public static int num = 0;

	public UserDao() {
		carsql = new CarSql();
	}

	public UserDto select(UserDto user) {
		return null;
	}

	public int register(UserDto userDto) {
		return 0;
	}

	public UserDto getUserByName(String name) {
		UserDto user = new UserDto();
		String sql = "SELECT * FROM user_info WHERE user_name= ?";

		try {
			con = carsql.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				user.setUser_id(rs.getString("user_id"));
				user.setUser_pwd(rs.getString("user_pwd"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_phone(rs.getString("user_phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			carsql.close(rs, pstmt, con);
		}

		return user;
	}

	/*
	 * public void insert_user() { String sql=
	 * "INSERT INTO member_info VALUES(user_no_seq.nexval, ?, ?, ?, ?, ?, ?, ?)";
	 * 
	 * try { Connection con= carsql.connect(); //conn= drivemanager pstmt=
	 * con.prepareStatement(sql); pstmt.setString(1, x); pstmt.setString(2, x);
	 * pstmt.setString(3, x); pstmt.setString(4, x); pstmt.setString(5, x);
	 * pstmt.setString(6, x); pstmt.setString(7, x); //�޾ƿ� ���� �Է�(user_no�� �ڵ��Է�)
	 * 
	 * pstmt.executeUpdate(); } catch (Exception e) { } }
	 */

	// carType Ÿ�� ��� String�� ��ȯ
	// public int modifyUserInfo(String id, String pwd, int carType, String name,
	// String year, String month, String day,
	public int modifyUserInfo(String id, String pwd, String carType, String name, String email, String phone) {

		String sql = "UPDATE user_info SET user_pwd= ?, cartype_name= ?, user_name= ?, user_email= ?, user_phone= ? ";
		sql+= "WHERE user_id= ?";

		try {
			con = carsql.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, pwd);
			pstmt.setString(2, carType);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			pstmt.setString(6, id);
			
			num = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			carsql.close(pstmt, con);
		}

		return num;
	}
	
//	maSuchId - �������� Ȯ��
  public UserDto maSuchId(String name) {
//  public UserDto login(UserDto userDto) {
    System.out.println("DAO - Dto : "+ name);
    //UserDto userDto
       try {
      con = carsql.connect();
      // DriverManager ��ü�κ��� Connection ��ü�� ���´�.
      String sql = ""; //string sql ���� ����
      sql += " select MAX(TICKET_PAY.TICKET_PAYNO) AS TICKET_PAYNO, \n";
      sql += " MAX(USER_INFO.USER_ID) KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS USER_ID, \n";
      sql += " MAX(TICKET_PAY.USER_NO) KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS USER_NO, \n";
      sql += " MAX( TO_char(TICKET_PAY.MOVIE_PALYDATE, 'YYYY-MM-DD HH24:MI')) KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc)as MOVIE_PALYDATE, \n";
      sql += " MAX( MOVIE_INFO.MOVIE_TITLE)  KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS MOVIE_TITLE, \n";
      sql += " MAX( BRANCH.BRANCH_NAME)  KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS BRANCH_NAME, \n";
      sql += " MAX( TICKET_PAY.TICKET_PAYCASH)  KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS TICKET_PAYCASH, \n";
      sql += " MAX( TICKET_PAY.TICKET_PAYMILEAGE)  KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS TICKET_PAYMILEAGE, \n";
      sql += " MAX( TICKET_PAY.TICKET_PAYTOTAL)  KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS TICKET_PAYTOTAL \n";
      sql += " from USER_INFO, MOVIE_INFO, BRANCH, TICKET_PAY  \n";
      
      sql += " where USER_INFO.USER_name = ? ";
          
      
//    select MAX(TICKET_PAY.TICKET_PAYNO) AS TICKET_PAYNO,
//    MAX(USER_INFO.USER_ID) KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS USER_ID,
//    MAX(TICKET_PAY.USER_NO) KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS USER_NO,
//    MAX( TO_char(TICKET_PAY.MOVIE_PALYDATE, 'YYYY-MM-DD HH24:MI')) KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc)as MOVIE_PALYDATE,
//     MAX( MOVIE_INFO.MOVIE_TITLE)  KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS MOVIE_TITLE,
//     MAX( BRANCH.BRANCH_NAME)  KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS BRANCH_NAME,
//     MAX( TICKET_PAY.TICKET_PAYCASH)  KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS TICKET_PAYCASH,
//     MAX( TICKET_PAY.TICKET_PAYMILEAGE)  KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS TICKET_PAYMILEAGE,
//     MAX( TICKET_PAY.TICKET_PAYTOTAL)  KEEP(DENSE_RANK FIRST ORDER BY TICKET_PAYNO desc) AS TICKET_PAYTOTAL
//    from USER_INFO, MOVIE_INFO, BRANCH, TICKET_PAY 
//    where USER_INFO.USER_id = 'user1';          

      
      pstmt = con.prepareStatement(sql); //prepareStatement���� �ش� sql�� �̸� �������Ѵ�.
      System.out.println("pstmt ����: " + pstmt);
      pstmt.setString(1, name); //1���� id�� 
      rs = pstmt.executeQuery();  // ������ �����ϰ� ����� ResultSet ��ü�� ��´�.
   
      while(rs.next()) {
        // ����� �� �྿ ���ư��鼭 �����´�.
        userDto = new UserDto(); //MemberDto �� memberDto ��ü ����
        userDto.setaTICKET_PAYNO(rs.getInt("TICKET_PAYNO")); //memberDto�� id �� ��������
        userDto.setaUSER_ID(rs.getString("USER_ID"));  //memberDto�� name �� ��������
        userDto.setaUSER_NO(rs.getInt("USER_NO"));  //memberDto�� name �� ��������
        userDto.setaMOVIE_PALYDATE(rs.getString("MOVIE_PALYDATE")); //memberDto�� id �� ��������
//        java.sql.Date movie_PalyDate = rs.getDate("MOVIE_PALYDATE");
//        userDto.setaMOVIE_PALYDATE("movie_PalyDate");  //memberDto�� name �� ��������
        userDto.setaMOVIE_TITLE(rs.getString("MOVIE_TITLE")); //memberDto�� id �� ��������
        userDto.setaBRANCH_NAME(rs.getString("BRANCH_NAME"));  //memberDto�� name �� ��������
        userDto.setaTICKET_PAYCASH(rs.getInt("TICKET_PAYCASH"));  //memberDto�� name �� ��������
        userDto.setaTICKET_PAYMILEAGE(rs.getInt("TICKET_PAYMILEAGE"));  //memberDto�� name �� ��������
        userDto.setaTICKET_PAYTOTAL(rs.getInt("TICKET_PAYTOTAL"));  //memberDto�� name �� ��������
      }  
      System.out.println("dao : " + userDto.getaTICKET_PAYNO()+ "" 
                                  + userDto.getaUSER_ID()+ "" 
                                  + userDto.getaUSER_NO()+ ""
                                  + userDto.getaMOVIE_PALYDATE()+ ""
                                  + userDto.getaMOVIE_TITLE()+ ""
                                  + userDto.getaBRANCH_NAME()+ ""
                                  + userDto.getaTICKET_PAYCASH()+ "" 
                                  + userDto.getaTICKET_PAYMILEAGE()+ "" 
                                  + userDto.getaTICKET_PAYTOTAL()
                                  );
      
    } catch (SQLException e) {// ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
      e.printStackTrace();
    } finally {
      carsql.close(rs, pstmt, con);
      System.out.println(userDto.getUser_id() + userDto.getUser_pwd() + userDto.getUser_name());
    } 
    return userDto;  //return memberDto;��ȯ
  } 
  
  //���� ��� ����
  public int deletPayNo(String name) {
    String sql = "DELETE FROM TICKET_PAY WHERE TICKET_PAY.TICKET_PAYNO = \n";
    sql += "( select MAX(TICKET_PAY.TICKET_PAYNO) AS TICKET_PAYNO \n";
    sql += " from TICKET_PAY, USER_INFO \n";
    sql += " where USER_INFO.USER_name = ? \n)";

//  ���� ����
//  DELETE FROM TICKET_PAY WHERE TICKET_PAY.TICKET_PAYNO = 
//
//        (select MAX(TICKET_PAY.TICKET_PAYNO) AS TICKET_PAYNO
//        from TICKET_PAY, USER_INFO
//        where USER_INFO.USER_name = '������');
//
//  select MAX(TICKET_PAY.TICKET_PAYNO) AS TICKET_PAYNO
//  from TICKET_PAY, USER_INFO
//  where USER_INFO.USER_name = '������';
//       
//  select * from TICKET_PAY; 

    try {
      con = carsql.connect();
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, name);
      num = pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      carsql.close(pstmt, con);
    }
    return num;
  }
  
}