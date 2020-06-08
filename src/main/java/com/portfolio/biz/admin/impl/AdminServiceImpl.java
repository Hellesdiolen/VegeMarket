package com.portfolio.biz.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.biz.admin.AdminService;
import com.portfolio.biz.admin.EmployeeVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public int workerCheck(String id, String pwd) {
		int result = -1;
		
		// 테이블에서 조회된 pwd를 저장
		String pwd_in_db = adminDAO.workerCheck(id);
		
		if (pwd_in_db != null) {	// 사용자 아이디를 조건으로 조회해서 나온 pwd와 비교
			if (pwd.equals(pwd_in_db)) {	// 화면에서 입력한 암호하고 테이블의 암호가 일치
				result = 1;	// 정상적인 로그인
			} else {
				result = 0;	// 암호가 불일치
			}
		} else {
			result = -1;	// 아이디가 존재 하지 않음
		}
		return result;
		
	}

	@Override
	public EmployeeVO getEmployee(String id) {
		// TODO Auto-generated method stub
		return adminDAO.getEmployee(id);
	}
	
	
}
