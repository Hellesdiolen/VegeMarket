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

	// �α��� ������ �̵�
	@RequestMapping(value = "/login_form", method = RequestMethod.GET)
	public String loginView() {

		return "member/login";
	}

	// �α��� üũ
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

	// �α׾ƿ��� ���������ϰ� �α���ȭ������ �̵�
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus sessionStatus) {

		sessionStatus.setComplete();

		return "member/login";
	}

	// ȸ������ ��� �̵�
	@RequestMapping(value = "/contract", method = RequestMethod.GET)
	public String contractView() {

		return "member/contract";
	}

	// ȸ������ ������ �̵�
	@RequestMapping(value = "/join_form", method = RequestMethod.GET)
	public String joinView() {

		return "member/join";
	}

	// ID�ߺ� üũ ���Ŀ� ID�� ���� �ǰԲ� �ؾߵǹǷ� ����Ʈ������� �ϳ� �� �޾ƾ��Ѵ�.
	@RequestMapping(value = "/join_form", method = RequestMethod.POST)
	public String joinForm() {

		return "member/join";
	}

	// ID �ߺ� üũ
	@RequestMapping(value = "/id_check_form", method = RequestMethod.GET)
	public String idCheckView(@RequestParam(value = "id", defaultValue = "", required = false) String id, Model model) {

		model.addAttribute("id", id);
		return "member/idcheck";
	}

	/*
	 * ȭ���� id�� �������� ,������ ���̽� id ���� �ϴ��� ��ȸ message = 1 �̸� ����� ����� ������ message = -1
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

	// ID �ߺ� üũ �� , reid �� ���簪���� ID �ش�
	@RequestMapping(value = "/id_check_confirm", method = RequestMethod.GET)
	public String idCheckConfirmed(MemberVO mVo, Model model) {

		model.addAttribute("reid", mVo.getId());

		return "member/join";
	}

	// �ּ� ã�� ��ư Ŭ��
	@RequestMapping(value = "/find_zip_num", method = RequestMethod.GET)
	public String findZipNum(@RequestParam(value = "id", defaultValue = "", required = false) String zip_num) {

		return "member/findZipNum";
	}

	// �ּ� �˻� ��ư Ŭ��
	@RequestMapping(value = "/find_zip_num", method = RequestMethod.POST)
	public String findZipNumAction(@RequestParam(value = "dong", defaultValue = "", required = false) String dong,
			Model model) {

		AddressVO aVo = new AddressVO();
		aVo.setDong(dong);

		List<AddressVO> addressList = memberService.selectAddressByDong(aVo);
		model.addAttribute("addressList", addressList);

		return "member/findZipNum";
	}

	// ȸ������ ��ư Ŭ��
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public String insertMember(MemberVO vo, Model model) {

		memberService.insertMember(vo);
		model.addAttribute("id", vo.getId());
		System.out.println("ȸ������ �Ϸ�");
		return "success";
	}

	// ���̵� ��й�ȣ ã�� ȭ��
	@RequestMapping(value = "/find_id_form", method = RequestMethod.GET)
	public String findIdForm() {

		return "member/findIdAndPassword";
	}

	// �̸� �̸��Ϸ� ��й�ȣ ã��
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

	// ���̵� �̸����� ��й�ȣ ã��
	@RequestMapping(value = "/find_password", method = RequestMethod.GET)
	public String find_Pw(MemberVO vo, Model model) {

		MemberVO user = memberService.findPassword(vo);

		if (user != null) {
			model.addAttribute("message", 1);
			model.addAttribute("pwd", user.getPwd());
		} else {
			model.addAttribute("message", -1);
		}

		// �ٸ� jsp���� ���ٵ�
		return "member/findPasswordResult";
	}

	// ȸ�� ���� ������ ��й�ȣ üũ ������ �̵�
	@RequestMapping(value = "/go_check_member")
	public String checkMember(MemberVO vo, Model model, HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			return "member/modifyMember";
		}
	}

	// ȸ�� ���� ����
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
				model.addAttribute("message", "��й�ȣ�� Ȯ���ϼ���.");
				return "member/modifyMember";
			}

		}

	}

	// ������ ȸ�� ���� �Է�
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
