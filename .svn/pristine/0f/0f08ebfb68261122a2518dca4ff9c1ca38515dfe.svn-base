package com.kitri.project.emp.movie.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.project.movie.dto.MovieDto;
import com.kitri.project.sql.CarSql;

public class EmpMovieDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CarSql myCon = null;

	public EmpMovieDao() {
		myCon = new CarSql();
	}
	
//	TODO branch용 영화등록 메소드
	public int insertMovieByBranch(MovieDto dto) {
		int result = 0;
		try {
			con = myCon.connect();
			String sql = "insert into branch_movie (branch_no, movie_no, movie_startdate, movie_enddate, movie_start1, movie_start2, movie_start3)";
			sql += "values(?, ?, to_date(?, 'yyyymmdd'), to_date(?, 'yyyymmdd'), ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBranch_no());
			pstmt.setInt(2, dto.getMovie_no());
			pstmt.setString(3, dto.getMovie_startdate());
			pstmt.setString(4, dto.getMovie_enddate());
			pstmt.setString(5, dto.getMovie_start1());
			pstmt.setString(6, dto.getMovie_start2());
			pstmt.setString(7, dto.getMovie_start3());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(pstmt, con);
			return result;
		}
	}
	
//	TODO branch용 영화수정 메소드
	public int updateMovieByBranch(MovieDto dto) {
		return 0;
	}
	
//	TODO branch용 영화삭제 메소드
	public int deleteMovieByBranch(int movie_no) {
		int result = 0;
		try {
			con = myCon.connect();
			String sql = "delete branch_movie where movie_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, movie_no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(pstmt, con);
			return result;
		}
	}
	
//	TODO branch용 영화 조회 메소드	- 지점측 영화등록 시 리스트
	public List<MovieDto> selectAllMovieByBranch(){
		List<MovieDto> list = new ArrayList<>();
		try {
			con = myCon.connect();
			String sql = "select movie_no, movie_title, movie_genre, movie_story, movie_actor, movie_runningtime from movie_info";	//movie_poster제외
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieDto dto = new MovieDto();
				dto.setMovie_no(rs.getInt("movie_no"));
				dto.setMovie_title(rs.getString("movie_title"));
				dto.setMovie_genre(rs.getString("movie_genre"));
				dto.setMovie_story(rs.getString("movie_story"));
				dto.setMovie_actor(rs.getString("movie_actor"));
				dto.setMovie_runningtime(rs.getInt("movie_runningtime"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(rs, pstmt, con);
			return list;
		}
	}

}
