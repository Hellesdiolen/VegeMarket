package com.portfolio.view.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolio.biz.member.MemberVO;
import com.portfolio.biz.order.CartService;
import com.portfolio.biz.order.CartVO;
import com.portfolio.biz.order.OrderService;
import com.portfolio.biz.order.OrderVO;

@Controller
public class MypageController {
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	
	
	// 장바구니 추가
	@RequestMapping(value = "/cart_insert")
	public String cartInsert(CartVO vo, Model model, HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			System.out.println("장바구니 물품추가");
			vo.setId(loginUser.getId());
			System.out.println(vo.getPseq());
			cartService.insertCart(vo);

			// 사용자 화면에서 Servlet으로 요청하는 문자열
			return "redirect:cart_list";
		}
	}

	// 장바구니 리스트 이동
	@RequestMapping(value = "/cart_list")
	public String cartList(Model model, HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			System.out.println("장바구니 리스트");

			String userId = loginUser.getId();
			List<CartVO> cartList = cartService.listCart(userId);

			int totalPrice = 0;
			int discountPrice = 0;
			// 할인 적용된 총금액
			for (CartVO cartVO : cartList) {
				totalPrice += cartVO.getTotalprice();
			}
			// 할인 된 금액
			for (CartVO cartVO : cartList) {
				discountPrice += cartVO.getDiscountprice();
			}
			// 장바구니에 담은물품 출력
			int countCart = cartService.countCartList(userId);

			model.addAttribute("countCart", countCart);

			model.addAttribute("cartList", cartList);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("discountPrice", discountPrice);

			model.addAttribute("loginUser", loginUser);

			// 사용자 화면에서 Servlet으로 요청하는 문자열
			return "mypage/cartList";
		}
	}

	// 수량 변경
	@RequestMapping(value = "/change_quantity")
	public String changeQuanity(@RequestParam(value = "one_cseq", required = false) int[] cseq,
			@RequestParam(value = "quantity", required = false) int[] quantity) {
		System.out.println("장바구니 물품 수량변경");

		for (int i = 0; i < cseq.length; i++) {
			CartVO vo = new CartVO();
			vo.setCseq(cseq[i]);
			vo.setQuantity(quantity[i]);
			cartService.changequanity(vo);
		}

		return "redirect:cart_list";
	}

	// 장바구니 상품 단일 삭제
	@RequestMapping(value = "/cart_delete")
	public String cartDelete(@RequestParam(value = "one_cseq", required = false, defaultValue = "0") int cseq) {

		System.out.println("장바구니 리스트 삭제 : " + cseq);
		cartService.deleteCart(cseq);

		return "redirect:cart_list";
	}

	// 체크 박스 이용해서 삭제
	@RequestMapping(value = "/cart_delete_Checkbox")
	public String cartDeleteCheckbox(
			@RequestParam(value = "cseq", required = false, defaultValue = "0") int[] cseqChecked, CartVO vo) {

		System.out.println("체크박스를 이용한 장바구니 리스트 삭제");

		for (int i = 0; i < cseqChecked.length; i++) {
			System.out.println(cseqChecked[i]);
		}

		for (int cseq : cseqChecked) {
			cartService.deleteCart(cseq);
		}

		return "redirect:cart_list";
	}

	// 장바구니에서 선택한 물품 주문
	@RequestMapping(value = "order_insert")
	public String orderInsert(@RequestParam(value = "cseq", required = false, defaultValue = "0") int[] cseqChecked,
			@RequestParam(value = "destination", required = false, defaultValue = "0") int[] destinationChecked,
			OrderVO vo, Model model, HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		// 1이면 기존주소로 배송 , 2면 신규 배송지로 배송함.
		int destination = destinationChecked[0];

		if (loginUser == null) {
			return "member/login";
		} else {

			if (destination == 1) { // 기존 ID정보의 주소로 배송
				System.out.println("기본 배송지 주문처리");
				vo.setId(loginUser.getId());
				vo.setName(loginUser.getName());
				vo.setPhone(loginUser.getPhone());
				vo.setZip_num(loginUser.getZip_num());
				vo.setAddress(loginUser.getAddress());
				vo.setResult("1");

				for (int i = 0; i < cseqChecked.length; i++) {
					System.out.println(cseqChecked[i]);
				}

				int oseq = orderService.insertOrder(vo, cseqChecked);

				model.addAttribute("oseq", oseq);

				return "redirect:order_check";

				// (oseq, id, name, zip_num, address, phone, memo)
			} else { // 작성한 배송정보
				System.out.println("신규 배송지 주문처리");
				vo.setId(loginUser.getId());
				vo.setResult("1");

				int oseq = orderService.insertOrder(vo, cseqChecked);

				model.addAttribute("oseq", oseq);

				return "redirect:order_check";
			}

		}
	}

	// 주문 내역 리스트 액션
	@RequestMapping(value = "/order_check")
	public String orderCheck(@RequestParam(value = "oseq") int oseq, Model model, OrderVO order,
			HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			System.out.println("주문 물품 처리");
			order.setId(loginUser.getId());
			order.setResult("1");
			order.setOseq(oseq);

			List<OrderVO> orderList = orderService.listOrderById(order);

			int totalPrice = 0;

			for (OrderVO OrderVO : orderList) {
				totalPrice += OrderVO.getPrice2() * ((100 - OrderVO.getDiscount()) / 100) * OrderVO.getQuantity();
			}

			model.addAttribute("orderList", orderList);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("loginUser", loginUser);

			String userId = loginUser.getId();
			int countCart = cartService.countCartList(userId);
			model.addAttribute("countCart", countCart);

			return "/mypage/orderCheck";
		}
	}

	// 진행중인 주문 내역
	@RequestMapping(value = "order_list")
	public String orderList(OrderVO order, Model model, HttpServletRequest request) {
		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			System.out.println("주문 제품 목록");

			List<Integer> oseqList = orderService.selectSeqOrdering(loginUser.getId());

			// 사용자의 전체 주문 내역 요약
			List<OrderVO> orderList = new ArrayList<OrderVO>();

			for (int oseq : oseqList) {

				order.setId(loginUser.getId());
				order.setOseq(oseq);
				order.setResult("1");
				// 주문번호별 주문내역 조회
				List<OrderVO> listByseq = orderService.listOrderById(order);

				OrderVO vo = new OrderVO();

				// 주문날짜
				vo.setIndate(listByseq.get(0).getIndate());

				// 주문번호
				vo.setOseq(listByseq.get(0).getOseq());

				// 상품명
				if (listByseq.size() > 1) {
					vo.setPname(listByseq.get(0).getPname() + " 외 " + (listByseq.size() - 1) + "건");
				} else {
					vo.setPname(listByseq.get(0).getPname());
				}

				// 결제 금액
				int totalPrice = 0;
				// 총가격 = 물품가격 * 수량 * 할인율(100-할인)
				for (int i = 0; i < listByseq.size(); i++) {
					totalPrice += listByseq.get(i).getTotalprice();
				}
				vo.setImage(listByseq.get(0).getImage());
				vo.setTotalprice(totalPrice);
				vo.setPseq(listByseq.get(0).getPseq());
				orderList.add(vo);

				model.addAttribute("orderList", orderList);
				model.addAttribute("title", "진행중인 주문 내역");
				model.addAttribute("loginUser", loginUser);

				// 장바구니에 담은물품 출력
				String userId = loginUser.getId();
				int countCart = cartService.countCartList(userId);
				model.addAttribute("countCart", countCart);
			}
			return "/mypage/orderList";
		}

	}

	// 상세 주문내역
	@RequestMapping(value = "/order_detail")
	public String orderDetailView(@RequestParam(value = "oseq") int oseq, OrderVO order, Model model,
			HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			System.out.println("주문 상세 정보 보기");

			order.setId(loginUser.getId());
			order.setResult("");
			order.setOseq(oseq);

			// 주문 상품정보
			List<OrderVO> orderList = orderService.listOrderById(order);

			// 주문자 정보
			OrderVO orderDetail = new OrderVO();
			orderDetail.setIndate(orderList.get(0).getIndate());
			orderDetail.setOseq(orderList.get(0).getOseq());
			orderDetail.setName(orderList.get(0).getName());
			orderDetail.setResult(orderList.get(0).getResult());

			// 총금액
			int totalPrice = 0;

			for (OrderVO OrderVO : orderList) {
				totalPrice += OrderVO.getQuantity() * OrderVO.getPrice2();
			}

			model.addAttribute("orderDetail", orderDetail);
			model.addAttribute("orderList", orderList);
			model.addAttribute("totalPrice", totalPrice);

			String userId = loginUser.getId();
			int countCart = cartService.countCartList(userId);
			model.addAttribute("countCart", countCart);

			return "mypage/orderDetail";
		}

	}

	// 완료 주문내역
	@RequestMapping(value = "/order_complete")
	public String orderAllView(OrderVO order, Model model, HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			System.out.println("주문 제품 목록");

			List<Integer> oseqList = orderService.selectSeqOrderComplete(loginUser.getId());

			// 사용자의 전체 주문 내역 요약
			List<OrderVO> orderList = new ArrayList<OrderVO>();

			for (int oseq : oseqList) {

				order.setId(loginUser.getId());
				order.setOseq(oseq);
				order.setResult("2");
				// 주문번호별 주문내역 조회
				List<OrderVO> listByseq = orderService.listOrderById(order);

				OrderVO vo = new OrderVO();

				// 주문날짜
				vo.setIndate(listByseq.get(0).getIndate());

				// 주문번호
				vo.setOseq(listByseq.get(0).getOseq());

				// 상품명
				if (listByseq.size() > 1) {
					vo.setPname(listByseq.get(0).getPname() + " 외 " + (listByseq.size() - 1) + "건");
				} else {
					vo.setPname(listByseq.get(0).getPname());
				}

				// 결제 금액
				int totalPrice = 0;
				// 총가격 = 물품가격 * 수량 * 할인율(100-할인)
				for (int i = 0; i < listByseq.size(); i++) {
					totalPrice += listByseq.get(i).getTotalprice();
				}
				vo.setImage(listByseq.get(0).getImage());
				vo.setTotalprice(totalPrice);
				vo.setPseq(listByseq.get(0).getPseq());
				orderList.add(vo);

				model.addAttribute("orderList", orderList);
				model.addAttribute("title", "처리된 주문 내역");
				model.addAttribute("loginUser", loginUser);

				// 장바구니에 담은물품 출력
				String userId = loginUser.getId();
				int countCart = cartService.countCartList(userId);
				model.addAttribute("countCart", countCart);
			}
			return "/mypage/orderList";
		}
	}

}
