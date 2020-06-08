package com.portfolio.biz.member;

import java.util.List;

import com.portfolio.biz.util.Criteria;

public interface MemberService {

	//ȸ�� ���
	void insertMember(MemberVO vo);	
	//ȸ�� ���� ����
	void updateMember(MemberVO vo);	
	
	//ȸ�� �޸���ȯ
	void goSleepMember(String id);
	//ȸ�� Ȱ��ȭ ��ȯ
	void goActivationMember(String id);
	
	//ȸ�� ��ȸ
	MemberVO getMember(MemberVO vo);
	
	//������ ID üũ
	MemberVO getAdminMember(MemberVO vo);
	
	//�α��� ���� Ȯ��
	MemberVO loginMember(MemberVO vo);			
	
	//�ּ� ���̸� ã��
	List<AddressVO> selectAddressByDong(AddressVO vo);

	//�̸� �̸��Ϸ� ���̵� ã��
	MemberVO getMemberByNameAndEmail(MemberVO vo);
	//���̵� �̸� �̸��Ϸ� ��й�ȣ ã��
	MemberVO findPassword(MemberVO vo);
	
	//ȸ�� ��ȸ (�ؿ������� ��ü)
	List<MemberVO> listMember(String member_name);
	
	//ȸ�� ��ȸ �������뵵
	List<MemberVO> getListWithPaging(Criteria criteria,String key);
	
	
	
	
}
