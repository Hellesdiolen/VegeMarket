package com.portfolio.biz.admin;

public interface AdminService {

	public int workerCheck(String id, String pwd);
	
	public EmployeeVO getEmployee(String id);
}
