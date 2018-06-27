package com.kitri.project.movie.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.project.movie.dto.MovieDto;
import com.kitri.project.sql.CarSql;

public class UserMovieDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CarSql myCon = null;
	// Statement stmt;

	public UserMovieDao() {
		myCon = new CarSql();
	}

	// TODO user�� ��ȭ ��ȸ �޼ҵ� - ������� ��ȭ���� �� ����Ʈ
	public List<MovieDto> selectAllMovieByUser(int value) {
		List<MovieDto> list = new ArrayList<MovieDto>();

		try {
			con = myCon.connect();
			// SELECT m.MOVIE_TITLE, m.MOVIE_POSTER
			// FROM movie_info m, branch_movie b
			// WHERE b.branch_no= 1;
			String sql = "SELECT b.branch_no, m.MOVIE_TITLE, m.MOVIE_POSTER FROM movie_info m, branch_movie b WHERE b.branch_no= ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, value); // ������ȣ

			rs = pstmt.executeQuery();
			while (rs.next()) {
				MovieDto in = new MovieDto();
				in.setBranch_no(rs.getInt("branch_no"));
				in.setMovie_title(rs.getString("movie_title"));
				in.setMovie_poster(rs.getString("movie_poster"));
				list.add(in);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
		}

		return list;
	}

	public int getBranchMovieCount(int num) {
		try {
			con = myCon.connect();

			String sql = "SELECT COUNT(m.movie_no) count ";
			sql+= "FROM movie_info m, branch_movie b ";
			sql+= "WHERE BRANCH_NO= ? AND m.movie_no= b.movie_no";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				num = rs.getInt("count");
//				System.out.println("dao num�� ����" + num);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
		}

		return num;
	}

	public List<MovieDto> selectDetailMovie(int no) {
		List<MovieDto> list = new ArrayList<MovieDto>();
		try {
			con = myCon.connect();
			String sql = "SELECT b.branch_no, m.MOVIE_TITLE, m.MOVIE_POSTER, m.movie_story, m.movie_actor, m.movie_runningtime, ";
			sql+= "b.movie_startdate, b.movie_enddate, b.movie_start1, b.movie_start2, b.movie_start3 ";
			sql+= "FROM movie_info m, branch_movie b ";
			sql+= "WHERE b.branch_no= ? AND m.movie_no= b.movie_no";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no); // ������ȣ

			rs = pstmt.executeQuery();
			while (rs.next()) {
				MovieDto in = new MovieDto();
				in.setBranch_no(rs.getInt("branch_no"));
				in.setMovie_title(rs.getString("movie_title"));
				in.setMovie_poster(rs.getString("movie_poster"));
				in.setMovie_story(rs.getString("movie_story"));
				in.setMovie_actor(rs.getString("movie_actor"));
				in.setMovie_runningtime(rs.getInt("movie_runningtime"));
				in.setMovie_startdate(rs.getString("movie_startdate"));
				in.setMovie_enddate(rs.getString("movie_enddate"));
				in.setMovie_start1(rs.getString("movie_start1"));
				in.setMovie_start2(rs.getString("movie_start2"));
				in.setMovie_start3(rs.getString("movie_start3"));
				list.add(in);
			} //sorting�۾� �ʿ���..? ��������

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
		}
		return list;
	}

	// public String setBranchMoviePoster() {
	// try {
	// con = myCon.connect();
	//
	// String sql = "SELECT count FROM movie_info m, branch_movie b WHERE BRANCH_NO=
	// ?";
	// pstmt = con.prepareStatement(sql);
	// pstmt.setInt(1, num);
	// rs = pstmt.executeQuery();
	//
	// while (rs.next()) {
	// num = rs.getInt("count");
	// // System.out.print("num�� ����" + num);
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// myCon.close(rs, pstmt, con);
	// }
	//
	// return num;
	// }

}