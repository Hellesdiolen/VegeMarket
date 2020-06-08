package com.portfolio.biz.member;

import java.util.List;

import com.portfolio.biz.util.Criteria;

public interface MemberService {

	//회원 등록
	void insertMember(MemberVO vo);	
	//회원 정보 수정
	void updateMember(MemberVO vo);	
	
	//회원 휴면전환
	void goSleepMember(String id);
	//회원 활성화 전환
	void goActivationMember(String id);
	
	//회원 조회
	MemberVO getMember(MemberVO vo);
	
	//관리자 ID 체크
	MemberVO getAdminMember(MemberVO vo);
	
	//로그인 정보 확인
	MemberVO loginMember(MemberVO vo);			
	
	//주소 동이름 찾기
	List<AddressVO> selectAddressByDong(AddressVO vo);

	//이름 이메일로 아이디 찾기
	MemberVO getMemberByNameAndEmail(MemberVO vo);
	//아이디 이름 이메일로 비밀번호 찾기
	MemberVO findPassword(MemberVO vo);
	
	//회원 조회 (밑에것으로 대체)
	List<MemberVO> listMember(String member_name);
	
	//회원 조회 페이지용도
	List<MemberVO> getListWithPaging(Criteria criteria,String key);
	
	
	
	
}
