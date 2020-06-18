package com.portfolio.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.portfolio.biz.member.MemberVO;
import com.portfolio.biz.order.CartService;
import com.portfolio.biz.product.ProductService;
import com.portfolio.biz.product.ProductVO;
import com.portfolio.biz.util.Criteria;
import com.portfolio.biz.util.PageMaker;

@Controller
@SessionAttributes("product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	// ��ǰ�� ������ �̵�
	@RequestMapping(value = "/Kategorie", method = RequestMethod.GET)
	public String productKindAction(@RequestParam(value = "kind", defaultValue = "0", required = true) String kind,
			Criteria criteria, ProductVO vo, Model model,
			HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {

			System.out.println("�з��� ��ǰ ��Ϻ���");
			vo.setKind(kind);
			criteria.setNumPerPage(8); // �� �������� 8�� ��ǰ ���̰� ��.
			// List<ProductVO> productKindList = productService.getProductListByKind(vo);
			List<ProductVO> productKindList = productService.listByKindWithPaging(criteria, kind);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);

			// �� ��ϼ��� DB���� ��ȸ
			int totalCount = productService.countProductListByKind(vo.getKind());
			pageMaker.setTotalCount(totalCount);
			System.out.println("����¡ ����: " + pageMaker);

			model.addAttribute("productKindList", productKindList);
			model.addAttribute("productKindListSize", productKindList.size());
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("vo", vo.getKind()); // kind ��
			// ��ٱ��Ͽ� ������ǰ ���
			String userId = loginUser.getId();
			int countCart = cartService.countCartList(userId);
			model.addAttribute("countCart", countCart);

			return "product/getProductKindList";
		}
	}

	@RequestMapping(value = "/product_detail", method = RequestMethod.GET)
	// ProductVO Ŀ�ǵ� ��ü �̿��� ���
	public String productDetailAction(ProductVO vo, Model model, HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		System.out.println("��ǰ �󼼺��� ");

		// ���� ��ǰ
		ProductVO product = productService.getProduct(vo);

		model.addAttribute("productVO", product);

		if (loginUser != null) {
			// ��ٱ��Ͽ� ������ǰ ���
			String userId = loginUser.getId();
			int countCart = cartService.countCartList(userId);
			model.addAttribute("countCart", countCart);

			return "product/productDetail";

		} else {

			return "product/productDetail";
		}

	}

}
