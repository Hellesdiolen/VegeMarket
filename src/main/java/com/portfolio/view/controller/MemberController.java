package com.portfolio.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.portfolio.biz.member.AddressVO;
import com.portfolio.biz.member.MemberService;
import com.portfolio.biz.member.MemberVO;

@Controller
@SessionAttributes("loginUser")
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 로그인 페이지 이동
	@RequestMapping(value = "/login_form", method = RequestMethod.GET)
	public String loginView() {

		return "member/login";
	}

	// 로그인 체크
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO vo, Model model) {
		// System.out.println(vo.toString());
		MemberVO loginUser = memberService.loginMember(vo);

		if (loginUser != null) {
			if (loginUser.getUseyn().equals("n")) {
				return "member/sleepMember";
			}
			model.addAttribute("loginUser", loginUser);
			return "redirect:/index";
		} else {
			int countCart = 0;
			model.addAttribute("countCart", countCart);

			return "member/login_fail";
		}

	}

	// 로그아웃시 세션제거하고 로그인화면으로 이동
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus sessionStatus) {

		sessionStatus.setComplete();

		return "member/login";
	}

	// 회원가입 약관 이동
	@RequestMapping(value = "/contract", method = RequestMethod.GET)
	public String contractView() {

		return "member/contract";
	}

	// 회원가입 페이지 이동
	@RequestMapping(value = "/join_form", method = RequestMethod.GET)
	public String joinView() {

		return "member/join";
	}

	// ID중복 체크 이후에 ID값 적용 되게끔 해야되므로 포스트방식으로 하나 더 받아야한다.
	@RequestMapping(value = "/join_form", method = RequestMethod.POST)
	public String joinForm() {

		return "member/join";
	}

	// ID 중복 체크
	@RequestMapping(value = "/id_check_form", method = RequestMethod.GET)
	public String idCheckView(@RequestParam(value = "id", defaultValue = "", required = false) String id, Model model) {

		model.addAttribute("id", id);
		return "member/idcheck";
	}

	/*
	 * 화면의 id를 받은다음 ,데이터 베이스 id 존재 하는지 조회 message = 1 이면 사용중 사용자 없으면 message = -1
	 */
	@RequestMapping(value = "/id_check_form", method = RequestMethod.POST)
	public String idCheckAction(@RequestParam(value = "id", defaultValue = "", required = false) String id,
			Model model) {

		MemberVO mVo = new MemberVO();
		mVo.setId(id);

		MemberVO user = memberService.getMember(mVo);

		if (user != null) {
			model.addAttribute("message", 1);
		} else {
			model.addAttribute("message", -1);
		}

		model.addAttribute("id", id);
		return "member/idcheck";
	}

	// ID 중복 체크 후 , reid 에 히든값으로 ID 준다
	@RequestMapping(value = "/id_check_confirm", method = RequestMethod.GET)
	public String idCheckConfirmed(MemberVO mVo, Model model) {

		model.addAttribute("reid", mVo.getId());

		return "member/join";
	}

	// 주소 찾기 버튼 클릭
	@RequestMapping(value = "/find_zip_num", method = RequestMethod.GET)
	public String findZipNum(@RequestParam(value = "id", defaultValue = "", required = false) String zip_num) {

		return "member/findZipNum";
	}

	// 주소 검색 버튼 클릭
	@RequestMapping(value = "/find_zip_num", method = RequestMethod.POST)
	public String findZipNumAction(@RequestParam(value = "dong", defaultValue = "", required = false) String dong,
			Model model) {

		AddressVO aVo = new AddressVO();
		aVo.setDong(dong);

		List<AddressVO> addressList = memberService.selectAddressByDong(aVo);
		model.addAttribute("addressList", addressList);

		return "member/findZipNum";
	}

	// 회원가입 버튼 클릭
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public String insertMember(MemberVO vo, Model model) {

		memberService.insertMember(vo);
		model.addAttribute("id", vo.getId());
		System.out.println("회원가입 완료");
		return "success";
	}

	// 아이디 비밀번호 찾기 화면
	@RequestMapping(value = "/find_id_form", method = RequestMethod.GET)
	public String findIdForm() {

		return "member/findIdAndPassword";
	}

	// 이름 이메일로 비밀번호 찾기
	@RequestMapping(value = "/find_id", method = RequestMethod.GET)
	public String find_Id(MemberVO vo, Model model) {

		MemberVO user = memberService.getMemberByNameAndEmail(vo);

		if (user != null) {
			model.addAttribute("message", 1);
			model.addAttribute("id", user.getId());
		} else {
			model.addAttribute("message", -1);
		}

		return "member/findResult";
	}

	// 아이디 이름으로 비밀번호 찾기
	@RequestMapping(value = "/find_password", method = RequestMethod.GET)
	public String find_Pw(MemberVO vo, Model model) {

		MemberVO user = memberService.findPassword(vo);

		if (user != null) {
			model.addAttribute("message", 1);
			model.addAttribute("pwd", user.getPwd());
		} else {
			model.addAttribute("message", -1);
		}

		// 다른 jsp파일 써줄듯
		return "member/findPasswordResult";
	}

	// 회원 정보 수정전 비밀번호 체크 페이지 이동
	@RequestMapping(value = "/go_check_member")
	public String checkMember(MemberVO vo, Model model, HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			return "member/modifyMember";
		}
	}

	// 회원 정보 수정
	@RequestMapping(value = "/check_member")
	public String modifyMember(MemberVO vo, Model model, HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {

			vo.setId(loginUser.getId());
			MemberVO loginUserCheck = memberService.loginMember(vo);

			if (loginUserCheck != null) {
				model.addAttribute("MemberVO", loginUserCheck);
				return "member/updateMember";
			} else {
				model.addAttribute("message", "비밀번호를 확인하세요.");
				return "member/modifyMember";
			}

		}

	}

	// 수정한 회원 정보 입력
	@RequestMapping(value = "/update_member", method = RequestMethod.POST)
	@ResponseBody
	public String updateMember(MemberVO vo, Model model, HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "fail";
		} else {
			memberService.updateMember(vo);
			return "success";
		}

	}

}
