package com.kitri.project.job.service;

import java.util.List;

public class JobService {
	JobDao dao;

	public JobService() {
		this.dao = new JobDao();
	}

	public List<String> getJobNames() {
		return dao.selectJobNameAll();
	}

}
