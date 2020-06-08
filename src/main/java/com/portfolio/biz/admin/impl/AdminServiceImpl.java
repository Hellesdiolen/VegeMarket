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
		
		// ���̺��� ��ȸ�� pwd�� ����
		String pwd_in_db = adminDAO.workerCheck(id);
		
		if (pwd_in_db != null) {	// ����� ���̵� �������� ��ȸ�ؼ� ���� pwd�� ��
			if (pwd.equals(pwd_in_db)) {	// ȭ�鿡�� �Է��� ��ȣ�ϰ� ���̺��� ��ȣ�� ��ġ
				result = 1;	// �������� �α���
			} else {
				result = 0;	// ��ȣ�� ����ġ
			}
		} else {
			result = -1;	// ���̵� ���� ���� ����
		}
		return result;
		
	}

	@Override
	public EmployeeVO getEmployee(String id) {
		// TODO Auto-generated method stub
		return adminDAO.getEmployee(id);
	}
	
	
}
