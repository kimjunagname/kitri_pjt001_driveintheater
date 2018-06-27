package com.kitri.project.emp.movie.service;

import java.util.List;

import com.kitri.project.movie.dto.MovieDto;

public class EmpMovieService {
	EmpMovieDao dao;

	public EmpMovieService() {
		this.dao = new EmpMovieDao();
	}

	public List<MovieDto> selectAllMovie(){
		return dao.selectAllMovieByBranch();
	}
	
	public int registerMovie(MovieDto dto) {
		return dao.insertMovieByBranch(dto);
	}
/*	
	public int updateMovieByBranch(MovieDto dto)
	public int deleteMovieByBranch(int movie_no)
	public List<MovieDto> selectAllMovieByBranch()
*/	
}
