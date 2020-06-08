package com.portfolio.view.controller;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.portfolio.biz.member.MemberVO;
import com.portfolio.biz.order.CartService;
import com.portfolio.biz.product.ProductService;
import com.portfolio.biz.product.ProductVO;


/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("product")
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index")
	public String home(Locale locale, Model model, HttpServletRequest request) {
		
		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");
		
		//판매 상품 조회
		List<ProductVO> ProductList = productService.mainListProduct();
		
		model.addAttribute("ProductList", ProductList);
		System.out.println(ProductList);
		
		if (loginUser == null) {
			return "index";
		} else {

			//장바구니에 담은물품 출력 
			String userId = loginUser.getId();
			int countCart = cartService.countCartList(userId);
			
			model.addAttribute("countCart", countCart);
			return "index";
		}

	}
	
}
