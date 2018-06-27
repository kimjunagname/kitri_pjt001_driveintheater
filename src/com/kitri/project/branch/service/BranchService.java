package com.kitri.project.branch.service;

import java.util.List;

public class BranchService {
	BranchDao dao;

	public BranchService() {
		this.dao = new BranchDao();
	}

	public List<String> getBranchNames() {
		return dao.selectBranchNameAll();
	}

}
