package com.portfolio.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.biz.member.MemberVO;
import com.portfolio.biz.product.ProductCommentVO;
import com.portfolio.biz.product.ProductService;

@RestController // 결과 데이터를 리턴 해주는 컨트롤러
public class CommentController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "save_comment", method = RequestMethod.POST)
	@ResponseBody
	public String saveComment(ProductCommentVO commentVO, HttpSession session) {

		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser == null) {

			return "fail";
		} else {
			String userId = loginUser.getId();

			commentVO.setWriter(userId);

			productService.saveComment(commentVO);
			return "success";
		}
	}

	@RequestMapping(value = "comment_list", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductCommentVO> getCommentList(ProductCommentVO commentVO) {

		int pseq = commentVO.getPseq();
		System.out.println("상품번호= " + pseq);
		List<ProductCommentVO> commentList = productService.getCommentList(pseq);

		return commentList;
	}

	@RequestMapping(value = "delete_comment", method = RequestMethod.POST)
	@ResponseBody
	public String deleteComment(ProductCommentVO commentVO, HttpSession session) {

		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			return "fail";
		} else {

			int comment_seq = commentVO.getComment_seq();

			productService.deleteComment(comment_seq);
			return "success";
		}
	}

	@RequestMapping(value = "update_comment", method = RequestMethod.POST)
	@ResponseBody
	public String updateComment(ProductCommentVO commentVO, HttpSession session) {

		System.out.println(commentVO);

		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			return "fail";
		} else {

			productService.updateComment(commentVO);
			return "success";
		}
	}

}
