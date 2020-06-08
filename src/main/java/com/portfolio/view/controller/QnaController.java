package com.portfolio.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portfolio.biz.member.MemberVO;
import com.portfolio.biz.order.CartService;
import com.portfolio.biz.qna.QnaService;
import com.portfolio.biz.qna.QnaVO;

@Controller
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/qna_list")
	public String qnaList(Model model, HttpServletRequest request) {
		
		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			
			List<QnaVO> qnaList = qnaService.listQna(loginUser.getId());
			
			model.addAttribute("qnaList", qnaList);
			
			//장바구니에 담은물품 출력 
			String userId = loginUser.getId();
			int countCart = cartService.countCartList(userId);
			model.addAttribute("countCart", countCart);
			
			return "qna/qnaList";
		}
	}
	@RequestMapping(value="/qna_write_form")
	public String insertQnaForm(HttpServletRequest request,Model model) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			
			String userId = loginUser.getId();
			int countCart = cartService.countCartList(userId);
			model.addAttribute("countCart", countCart);
			
			return "qna/qnaWrite";
		}
		
	}
	
	@RequestMapping(value="/qna_write", method = RequestMethod.POST)
	public String insertQna(QnaVO vo,HttpServletRequest request) {
		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");
		
		//아이디 저장
		vo.setId(loginUser.getId());

		qnaService.insertQna(vo);
		
		return "redirect:qna_list";
	}
	
	@RequestMapping(value="/qna_view")
	public String qnaView(QnaVO vo, Model model, HttpServletRequest request) {
		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			
			String userId = loginUser.getId();
			int countCart = cartService.countCartList(userId);
			model.addAttribute("countCart", countCart);
			
			QnaVO qnaVO = qnaService.getQna(vo.getQseq());
			
			model.addAttribute("qnaVO", qnaVO);
			
			return "qna/qnaView";
		}
	}
	
}
