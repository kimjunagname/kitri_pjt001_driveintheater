package com.kitri.project.chart.service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.kitri.project.chart.dto.PayChartDto;
import com.kitri.project.sql.CarSql;

public class PayChartDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CarSql myCon = null;

	public PayChartDao() {
		myCon = new CarSql();
	}

	//TODO selectChartByYear ������ year�� �Ѹ���, �����ݰ����ݾ�, �Ѹ��ϸ��������ݾ�
	public PayChartDto selectChartByYear(int branch_no, String year){
		PayChartDto dto = null;
		try {
			con = myCon.connect();
			StringBuffer sb = new StringBuffer();
			sb.append("select sub.branch_no, branch_name, sub.ticket_paytotal, sub.ticket_paycash, sub.ticket_paymileage from branch, ");
			sb.append("(select branch_no, sum(ticket_paytotal) ticket_paytotal, sum(ticket_paycash) ticket_paycash, sum(ticket_paymileage) ticket_paymileage ");
			sb.append("from TICKET_PAY ");
			sb.append("where branch_no = ? ");
			sb.append("and ticket_paydate ");
			sb.append("between to_date(?, 'yyyymmdd') and last_day(to_date(?, 'yyyymmdd')) ");
			sb.append("group by branch_no) sub ");
			sb.append("where branch.branch_no = sub.branch_no");
			
			System.out.println(sb.toString());
 /*				 String sql = "select branch_no, ticket_paytotal, ticket_paycash, ticket_paymileage";
				 sql += "from TICKET_PAY where branch_no = ?";
				 sql += "and ticket_paydate";
				 sql += "between to_date(?, 'yyyymmdd') and last_day(to_date(?, 'yyyymmdd'))";
*/
		 	pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, branch_no);
			pstmt.setString(2, year+"0101");
			pstmt.setString(3, year+"1201");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new PayChartDto();
				dto.setBranch_no(branch_no);
				dto.setBranch_name(rs.getString("branch_name"));
				dto.setTicket_paytotal(rs.getLong("ticket_paytotal"));
				dto.setTicket_paycash(rs.getLong("ticket_paycash"));
				dto.setTicket_paymileage(rs.getLong("ticket_paymileage"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
			return dto;
		}
	}

//	selectAllYearsPayChartByBranchNo ������ ����� ��� ���� ��ȸ
	public List<PayChartDto> selectAllYearsPayChartByBranchNo(int branch_no) {
		List<PayChartDto> list = null;
		try {
			list = new ArrayList<>();
			con = myCon.connect();
			String sql = "select branch_no, trunc(ticket_paydate, 'yyyy') year, ";
				 sql += "sum(ticket_paytotal) total, sum(ticket_paycash) cash, sum(ticket_paymileage) mileage ";
				 sql += "from TICKET_PAY ";
				 sql += "where branch_no = ? ";
				 sql += "and trunc(ticket_paydate, 'yyyy') = trunc(ticket_paydate, 'yyyy') ";
				 sql += "group by branch_no, trunc(ticket_paydate, 'yyyy') ";
				 sql += "order by year desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, branch_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PayChartDto dto = new PayChartDto();
				dto.setBranch_no(rs.getInt("branch_no"));
				dto.setTerm(rs.getString("year"));
				dto.setTicket_paytotal(rs.getLong("total"));
				dto.setTicket_paycash(rs.getLong("cash"));
				dto.setTicket_paymileage(rs.getLong("mileage"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
		}
		return list;
	}

//	selectAllMonthsPayChartByBranchNo ������ ������ ��� ���� ��ȸ
	public List<PayChartDto> selectAllMonthsPayChartByBranchNo(int branch_no) {
		List<PayChartDto> list = null;
		try {
			list = new ArrayList<>();
			con = myCon.connect();
			String sql = "select branch_no, trunc(ticket_paydate, 'mm') month, ";
				 sql += "sum(ticket_paytotal) total, sum(ticket_paycash) cash, sum(ticket_paymileage) mileage ";
				 sql += "from TICKET_PAY ";
				 sql += "where branch_no = ? ";
				 sql += "and trunc(ticket_paydate, 'mm') = trunc(ticket_paydate, 'mm') ";
				 sql += "group by branch_no, trunc(ticket_paydate, 'mm') ";
				 sql += "order by month desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, branch_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PayChartDto dto = new PayChartDto();
				dto.setBranch_no(rs.getInt("branch_no"));
				dto.setTerm(rs.getString("month"));
				dto.setTicket_paytotal(rs.getLong("total"));
				dto.setTicket_paycash(rs.getLong("cash"));
				dto.setTicket_paymileage(rs.getLong("mileage"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
		}
		return list;
	}
	
	
//	TODO selectCharByLast3Years ������ �ֱ� 3�Ⱓ ����
	public List<PayChartDto> selectChartByLast3Years(int branch_no, String year) {
		List<PayChartDto> list = null;
		try {
			list = new ArrayList<>();
			con = myCon.connect();
			String sql = "select branch_no, ticket_paytotal, ticket_paycash, ticket_paymileage";
				 sql += "from TICKET_PAY where branch_no = ?";
				 sql += "and ticket_paydate";
				 sql += "between to_date(?, 'yyyymmdd') and last_day(to_date(?, 'yyyymmdd'))";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, branch_no);
			pstmt.setString(2, year+"0101");
			pstmt.setString(3, year+"1201");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PayChartDto dto = new PayChartDto();
				dto.setBranch_no(rs.getInt("branch_no"));
				dto.setTicket_paytotal(rs.getLong("ticket_paytotal"));
				dto.setTicket_paycash(rs.getLong("ticket_paycash"));
				dto.setTicket_paymileage(rs.getLong("ticket_paymileage"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
			return list;
		}
	}

//	TODO selectChartByYearAllBranchs �ְ������ڿ� year�� �� ������ �Ѹ���, �����ݰ����ݾ�, �Ѹ��ϸ��������ݾ�
	public List<PayChartDto> selectChartByYearAllBranchs(String year) {
		List<PayChartDto> list = null;
		try {
			list = new ArrayList<>();
			con = myCon.connect();
			String sql = "select branch_no, sum(ticket_paytotal) ticket_paytotal, sum(ticket_paycash) ticket_paycash, sum(ticket_paymileage) ticket_paymileage";
				 sql += "from TICKET_PAY";
				 sql += "where ticket_paydate";
				 sql += "between to_date(?, 'yyyymmdd') and last_day(to_date(?, 'yyyymmdd'))";
				 sql += "group by branch_no";
				 sql += "order by branch_no asc";
				 
/*				 
//yyyy�⵵ branch_no �� ����
select branch_no, trunc(ticket_paydate, 'yyyy'), sum(ticket_paytotal) ticket_paytotal, sum(ticket_paycash) ticket_paycash, sum(ticket_paymileage) ticket_paymileage 
from TICKET_PAY 
where trunc(ticket_paydate, 'yyyy') = trunc(to_date(2018, 'yyyy'), 'yyyy')
group by branch_no, trunc(ticket_paydate, 'yyyy');
*/	
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, year+"0101");
			pstmt.setString(2, year+"1201");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PayChartDto dto = new PayChartDto();
				dto.setBranch_no(rs.getInt("branch_no"));
				dto.setTicket_paytotal(rs.getLong("ticket_paytotal"));
				dto.setTicket_paycash(rs.getLong("ticket_paycash"));
				dto.setTicket_paymileage(rs.getLong("ticket_paymileage"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
			return list;
		}
	}

	public int insertReservation(String userName, int branchNo, int movieNo, String showDay, String showTime,
			String carType, int total, int mileage) {
		int num= 0;
		int user_no= 0;
		
		try {
			con= myCon.connect();
			
			String sql= "SELECT user_no ";
			sql+= "FROM user_info ";
			sql+= "WHERE user_name= ?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, userName);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				user_no= rs.getInt("user_no");
			}
			
			System.out.println("user_no�� : "+user_no);
			
			//������ȣ, ȸ����ȣ, ������ȣ, ��ȭ��ȣ, �Ѱ����ݾ�, ���ݰ����ݾ�, ���ϸ��������ݾ�, ����, ���ż���, ��������
			//+ �󿵽ð�
			sql= "INSERT INTO ticket_pay(ticket_payno, user_no, branch_no, movie_no, ticket_paytotal, ticket_paycash, movie_palydate, "; 
			sql+= "ticket_paymileage, ticket_salcount, ticket_paydate) ";
			sql+= "VALUES(ticket_payno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, user_no); //uesrName���� idã��
			pstmt.setInt(2, branchNo);
			pstmt.setInt(3, movieNo);
			pstmt.setInt(4, total);
			pstmt.setInt(5, total- mileage);
			
//			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//			Date date= sdf.parse(showDay);
			pstmt.setString(6, showDay); // ����
			
//			System.out.println("date�� : "+ date);
			
			pstmt.setInt(7, mileage);
			pstmt.setInt(8, 1);
			
			num= pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(pstmt, con);
		}
		
		return num;
	} 
	
//	public PayChartDto insertReservation(String userName, int branchNo, int movieNo, String showDay, String showTime,
//			String carType, int total, int mileage) {
//		PayChartDto dto = null;
//		try {
//			con= myCon.connect();
//			String sql= "insert into ticket_pay values(ticket_payno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate, ?)";
//			
//			pstmt= con.prepareStatement(sql);
//			pstmt.setString(1, userName);
//			pstmt.setInt(2, branchNo);
//			pstmt.setInt(3, movieNo);
//			pstmt.setInt(4, total);
//			pstmt.setInt(5, total-mileage); //paycash
//			pstmt.setInt(6, mileage); //paymileage
//			pstmt.setInt(7, 1); //salcount
////			pstmt.setDate(8, showDay); showDay�� date�� �ٲٱ�..?
//			
//			int num= pstmt.executeUpdate(); //insert
//			
//			rs= pstmt.executeQuery();
//			if(rs.next()) {
//				dto= new PayChartDto();
//				dto.setTicket_payno(rs.getInt("ticket_payno"));
//				dto.setUser_no(rs.getInt("user_no"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			
//		}
//		
//		return dto;
//	}

	//TODO selectByPeriod �Ⱓ�� ��ȭ ���� ���
//	List<PayChartDto> selectByPeriod(String date)
	
	
}