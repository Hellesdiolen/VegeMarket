package com.portfolio.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolio.biz.member.MemberVO;
import com.portfolio.biz.order.CartService;
import com.portfolio.biz.product.ProductService;
import com.portfolio.biz.product.ProductVO;
import com.portfolio.biz.util.Criteria;
import com.portfolio.biz.util.PageMaker;

@Controller
public class MainpageController {

		@Autowired
		private ProductService productService;
	
		@Autowired
		private CartService cartService;
		
		@RequestMapping(value="/")
		public String MainPageView() {
			
			return "index";
		}
		
		//shop ������ �̵�
		@RequestMapping(value="/go_shop")
		public String getProduct(@RequestParam(value = "key", defaultValue = "") String key,
				Criteria criteria,Model model, HttpServletRequest request) {
			//System.out.println(vo.toString());
			MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");
			
			if(loginUser == null) {
				return "index";
			} else {
				criteria.setNumPerPage(8); // �� �������� 8�� ��ǰ ���̰� ��.
				//List<ProductVO> ProductList = productService.listProduct("");
				List<ProductVO> productList = productService.getListWithPaging(criteria, key);
				PageMaker pageMaker = new PageMaker();
				pageMaker.setCri(criteria);
				
				// �� ��ϼ��� DB���� ��ȸ
				int totalCount = productService.countProductList("");
				pageMaker.setTotalCount(totalCount);
				System.out.println("����¡ ����: " + pageMaker);

				model.addAttribute("productList", productList);
				model.addAttribute("productListSize", productList.size());
				model.addAttribute("pageMaker", pageMaker);				
				
				
				//��ٱ��Ͽ� ������ǰ ��� 
				String userId = loginUser.getId();
				int countCart = cartService.countCartList(userId);
				model.addAttribute("countCart", countCart);
				
				return "product/getProduct";
			}
			
		}

}	
