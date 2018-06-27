package com.kitri.project.movie.service;

import java.awt.FileDialog;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.kitri.project.emp.view.EmpMain;
import com.kitri.project.movie.dto.MovieDto;
import com.kitri.project.sql.CarSql;
import com.kitri.project.superadmin.service.SuperAdminDao;
import com.kitri.project.superadmin.view.SuperAdminMenu;

public class SuperAdminMovieDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CarSql myCon = null;
	EmpMain menu;
	int num;

	public SuperAdminMovieDao(EmpMain menu) {
		myCon = new CarSql();
		this.menu = menu;
	}

	// TODO admin용 영화등록 메소드
	public int insertMovieByAdmin(MovieDto dto) {
		try {
			// no, title, poster, genre, story, actor, runtime
			con = myCon.connect();
			String sql = "insert into movie_info values(movie_no_seq.nextval,?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMovie_title());
			pstmt.setString(2, dto.getMovie_poster()); // 파일이름 저장돼있음
			pstmt.setString(3, dto.getMovie_genre());
			pstmt.setString(4, dto.getMovie_story());
			pstmt.setString(5, dto.getMovie_actor());
			pstmt.setInt(6, dto.getMovie_runningtime());

			num = pstmt.executeUpdate();
			// System.out.println(num);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			myCon.close(pstmt, con);
		}
		return num;
	}

	// TODO admin용 영화수정 메소드
	public int updateMovieByAdmin(MovieDto dto) {
		return 0;
	}

	// TODO admin용 영화삭제 메소드
	public int deleteMovieByAdmin(int movie_no) {
		return 0;
	}

	// TODO admin용 영화 조회 메소드
	public List<MovieDto> selectAllMovieByAdmin() {
		return null;
	}

}
