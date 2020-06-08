package com.portfolio.biz.member.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.biz.member.AddressVO;
import com.portfolio.biz.member.MemberService;
import com.portfolio.biz.member.MemberVO;
import com.portfolio.biz.util.Criteria;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.insertMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.updateMember(vo);
	}
	@Override
	public MemberVO getMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.getMember(vo.getId());
	}

	@Override
	public MemberVO getAdminMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.getAdminMember(vo.getId());
	}
	
	@Override
	public MemberVO loginMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.loginMember(vo);
	}

	@Override
	public List<AddressVO> selectAddressByDong(AddressVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.selectAddressByDong(vo.getDong());
	}

	@Override
	public MemberVO getMemberByNameAndEmail(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.getMemberByNameAndEmail(vo);
	}

	@Override
	public MemberVO findPassword(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.findPassword(vo);
	}

	@Override
	public List<MemberVO> listMember(String member_name) {
		// TODO Auto-generated method stub
		return memberDAO.listMember(member_name);
	}

	@Override
	public List<MemberVO> getListWithPaging(Criteria criteria, String key) {
		// TODO Auto-generated method stub
		return memberDAO.getListWithPaging(criteria,key);
	}

	@Override
	public void goSleepMember(String id) {
		// TODO Auto-generated method stub
		memberDAO.goSleepMember(id);
	}

	@Override
	public void goActivationMember(String id) {
		// TODO Auto-generated method stub
		memberDAO.goActivationMember(id);
	}

	
	
}
