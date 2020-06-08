package com.portfolio.biz.admin.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.biz.admin.EmployeeVO;


@Repository
public class AdminDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public String workerCheck(String id) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("adminDAO.workerCheck", id);
	}

	public EmployeeVO getEmployee(String id) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("adminDAO.getEmployee", id);
	}

}
