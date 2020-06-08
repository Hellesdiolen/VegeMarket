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

	// ID 존재여부 조회
	public MemberVO getMember(String id) {
		System.out.println("==>회원 여부 조회");
		return mybatis.selectOne("memberDAO.getMember", id);
	}

	// 관리자 로그인
	public MemberVO getAdminMember(String id) {
		System.out.println("==>관리자 여부 조회");
		return mybatis.selectOne("memberDAO.getMember", id);
	}

	// 로그인 정보 확인
	public MemberVO loginMember(MemberVO vo) {
		System.out.println("==>로그인 정보 확인");
		return mybatis.selectOne("memberDAO.loginMember", vo);
	}

	// 회원 등록
	public void insertMember(MemberVO vo) {
		System.out.println("==>회원등록");
		mybatis.insert("memberDAO.insertMember", vo);
	}

	// 회원 정보 수정
	public void updateMember(MemberVO vo) {
		System.out.println("==>회원정보 수정");
		mybatis.update("memberDAO.updateMember", vo);

	}

	// 주소 목록 검색
	public List<AddressVO> selectAddressByDong(String dong) {
		System.out.println("==>주소검색");
		return mybatis.selectList("memberDAO.selectAddressByDong", dong);
	}

	// 이름 이메일로 아이디 찾기
	public MemberVO getMemberByNameAndEmail(MemberVO vo) {
		System.out.println("==>이름 이메일로 아이디찾기");
		return mybatis.selectOne("memberDAO.getMemberByNameAndEmail", vo);
	}

	// 아이디 이름 이메일로 비밀번호 찾기
	public MemberVO findPassword(MemberVO vo) {
		System.out.println("==>아이디 이름 이메일로 비밀번호 찾기");
		return mybatis.selectOne("memberDAO.findPassword", vo);
	}

	// 회원 조회
	public List<MemberVO> listMember(String member_name) {
		System.out.println("==>이름으로 회원 조회");
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
