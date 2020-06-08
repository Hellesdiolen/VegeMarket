package com.portfolio.biz.member.Impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.biz.member.AddressVO;
import com.portfolio.biz.member.MemberVO;
import com.portfolio.biz.util.Criteria;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	// ID ���翩�� ��ȸ
	public MemberVO getMember(String id) {
		System.out.println("==>ȸ�� ���� ��ȸ");
		return mybatis.selectOne("memberDAO.getMember", id);
	}

	// ������ �α���
	public MemberVO getAdminMember(String id) {
		System.out.println("==>������ ���� ��ȸ");
		return mybatis.selectOne("memberDAO.getMember", id);
	}

	// �α��� ���� Ȯ��
	public MemberVO loginMember(MemberVO vo) {
		System.out.println("==>�α��� ���� Ȯ��");
		return mybatis.selectOne("memberDAO.loginMember", vo);
	}

	// ȸ�� ���
	public void insertMember(MemberVO vo) {
		System.out.println("==>ȸ�����");
		mybatis.insert("memberDAO.insertMember", vo);
	}

	// ȸ�� ���� ����
	public void updateMember(MemberVO vo) {
		System.out.println("==>ȸ������ ����");
		mybatis.update("memberDAO.updateMember", vo);

	}

	// �ּ� ��� �˻�
	public List<AddressVO> selectAddressByDong(String dong) {
		System.out.println("==>�ּҰ˻�");
		return mybatis.selectList("memberDAO.selectAddressByDong", dong);
	}

	// �̸� �̸��Ϸ� ���̵� ã��
	public MemberVO getMemberByNameAndEmail(MemberVO vo) {
		System.out.println("==>�̸� �̸��Ϸ� ���̵�ã��");
		return mybatis.selectOne("memberDAO.getMemberByNameAndEmail", vo);
	}

	// ���̵� �̸� �̸��Ϸ� ��й�ȣ ã��
	public MemberVO findPassword(MemberVO vo) {
		System.out.println("==>���̵� �̸� �̸��Ϸ� ��й�ȣ ã��");
		return mybatis.selectOne("memberDAO.findPassword", vo);
	}

	// ȸ�� ��ȸ
	public List<MemberVO> listMember(String member_name) {
		System.out.println("==>�̸����� ȸ�� ��ȸ");
		return mybatis.selectList("memberDAO.listMember", member_name);
	}

	public List<MemberVO> getListWithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("criteria", criteria);
		map.put("key", key);
		return mybatis.selectList("memberDAO.getListWithPaging", map);
	}

	public void goSleepMember(String id) {
		// TODO Auto-generated method stub
		mybatis.update("memberDAO.goSleepMember",id);
	}

	public void goActivationMember(String id) {
		// TODO Auto-generated method stub
		mybatis.update("memberDAO.goActivationMember",id);
	}

}
