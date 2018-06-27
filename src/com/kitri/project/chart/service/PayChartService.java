package com.kitri.project.chart.service;

import java.util.ArrayList;
import java.util.List;

import com.kitri.project.chart.dto.PayChartDto;


public class PayChartService {

	PayChartDao dao;

	public PayChartService() {
		this.dao = new PayChartDao();
	}
	
	public List<PayChartDto> getChartByYear(int branch_no, String year) {
		List<PayChartDto> list = new ArrayList<>();
		list.add(dao.selectChartByYear(branch_no, year));
		return list;
	}
	
	public List<PayChartDto> getChartByLast3Years(int branch_no, String year){
		return dao.selectChartByLast3Years(branch_no, year);
		
	}
	
	public List<PayChartDto> getChartByYearAllBranchs(String year){
		return dao.selectChartByYearAllBranchs(year);
	}

	public List<PayChartDto> getAllYearsPayChartByBranchNo(int branch_no) {
		return dao.selectAllYearsPayChartByBranchNo(branch_no);
	}

	public List<PayChartDto> getAllMonthsPayChartByBranchNo(int branch_no) {
		return dao.selectAllMonthsPayChartByBranchNo(branch_no);
	}
}
