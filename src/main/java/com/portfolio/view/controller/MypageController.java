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
	
	
	// ��ٱ��� �߰�
	@RequestMapping(value = "/cart_insert")
	public String cartInsert(CartVO vo, Model model, HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			System.out.println("��ٱ��� ��ǰ�߰�");
			vo.setId(loginUser.getId());
			System.out.println(vo.getPseq());
			cartService.insertCart(vo);

			// ����� ȭ�鿡�� Servlet���� ��û�ϴ� ���ڿ�
			return "redirect:cart_list";
		}
	}

	// ��ٱ��� ����Ʈ �̵�
	@RequestMapping(value = "/cart_list")
	public String cartList(Model model, HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			System.out.println("��ٱ��� ����Ʈ");

			String userId = loginUser.getId();
			List<CartVO> cartList = cartService.listCart(userId);

			int totalPrice = 0;
			int discountPrice = 0;
			// ���� ����� �ѱݾ�
			for (CartVO cartVO : cartList) {
				totalPrice += cartVO.getTotalprice();
			}
			// ���� �� �ݾ�
			for (CartVO cartVO : cartList) {
				discountPrice += cartVO.getDiscountprice();
			}
			// ��ٱ��Ͽ� ������ǰ ���
			int countCart = cartService.countCartList(userId);

			model.addAttribute("countCart", countCart);

			model.addAttribute("cartList", cartList);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("discountPrice", discountPrice);

			model.addAttribute("loginUser", loginUser);

			// ����� ȭ�鿡�� Servlet���� ��û�ϴ� ���ڿ�
			return "mypage/cartList";
		}
	}

	// ���� ����
	@RequestMapping(value = "/change_quantity")
	public String changeQuanity(@RequestParam(value = "one_cseq", required = false) int[] cseq,
			@RequestParam(value = "quantity", required = false) int[] quantity) {
		System.out.println("��ٱ��� ��ǰ ��������");

		for (int i = 0; i < cseq.length; i++) {
			CartVO vo = new CartVO();
			vo.setCseq(cseq[i]);
			vo.setQuantity(quantity[i]);
			cartService.changequanity(vo);
		}

		return "redirect:cart_list";
	}

	// ��ٱ��� ��ǰ ���� ����
	@RequestMapping(value = "/cart_delete")
	public String cartDelete(@RequestParam(value = "one_cseq", required = false, defaultValue = "0") int cseq) {

		System.out.println("��ٱ��� ����Ʈ ���� : " + cseq);
		cartService.deleteCart(cseq);

		return "redirect:cart_list";
	}

	// üũ �ڽ� �̿��ؼ� ����
	@RequestMapping(value = "/cart_delete_Checkbox")
	public String cartDeleteCheckbox(
			@RequestParam(value = "cseq", required = false, defaultValue = "0") int[] cseqChecked, CartVO vo) {

		System.out.println("üũ�ڽ��� �̿��� ��ٱ��� ����Ʈ ����");

		for (int i = 0; i < cseqChecked.length; i++) {
			System.out.println(cseqChecked[i]);
		}

		for (int cseq : cseqChecked) {
			cartService.deleteCart(cseq);
		}

		return "redirect:cart_list";
	}

	// ��ٱ��Ͽ��� ������ ��ǰ �ֹ�
	@RequestMapping(value = "order_insert")
	public String orderInsert(@RequestParam(value = "cseq", required = false, defaultValue = "0") int[] cseqChecked,
			@RequestParam(value = "destination", required = false, defaultValue = "0") int[] destinationChecked,
			OrderVO vo, Model model, HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		// 1�̸� �����ּҷ� ��� , 2�� �ű� ������� �����.
		int destination = destinationChecked[0];

		if (loginUser == null) {
			return "member/login";
		} else {

			if (destination == 1) { // ���� ID������ �ּҷ� ���
				System.out.println("�⺻ ����� �ֹ�ó��");
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
			} else { // �ۼ��� �������
				System.out.println("�ű� ����� �ֹ�ó��");
				vo.setId(loginUser.getId());
				vo.setResult("1");

				int oseq = orderService.insertOrder(vo, cseqChecked);

				model.addAttribute("oseq", oseq);

				return "redirect:order_check";
			}

		}
	}

	// �ֹ� ���� ����Ʈ �׼�
	@RequestMapping(value = "/order_check")
	public String orderCheck(@RequestParam(value = "oseq") int oseq, Model model, OrderVO order,
			HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			System.out.println("�ֹ� ��ǰ ó��");
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

	// �������� �ֹ� ����
	@RequestMapping(value = "order_list")
	public String orderList(OrderVO order, Model model, HttpServletRequest request) {
		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			System.out.println("�ֹ� ��ǰ ���");

			List<Integer> oseqList = orderService.selectSeqOrdering(loginUser.getId());

			// ������� ��ü �ֹ� ���� ���
			List<OrderVO> orderList = new ArrayList<OrderVO>();

			for (int oseq : oseqList) {

				order.setId(loginUser.getId());
				order.setOseq(oseq);
				order.setResult("1");
				// �ֹ���ȣ�� �ֹ����� ��ȸ
				List<OrderVO> listByseq = orderService.listOrderById(order);

				OrderVO vo = new OrderVO();

				// �ֹ���¥
				vo.setIndate(listByseq.get(0).getIndate());

				// �ֹ���ȣ
				vo.setOseq(listByseq.get(0).getOseq());

				// ��ǰ��
				if (listByseq.size() > 1) {
					vo.setPname(listByseq.get(0).getPname() + " �� " + (listByseq.size() - 1) + "��");
				} else {
					vo.setPname(listByseq.get(0).getPname());
				}

				// ���� �ݾ�
				int totalPrice = 0;
				// �Ѱ��� = ��ǰ���� * ���� * ������(100-����)
				for (int i = 0; i < listByseq.size(); i++) {
					totalPrice += listByseq.get(i).getTotalprice();
				}
				vo.setImage(listByseq.get(0).getImage());
				vo.setTotalprice(totalPrice);
				vo.setPseq(listByseq.get(0).getPseq());
				orderList.add(vo);

				model.addAttribute("orderList", orderList);
				model.addAttribute("title", "�������� �ֹ� ����");
				model.addAttribute("loginUser", loginUser);

				// ��ٱ��Ͽ� ������ǰ ���
				String userId = loginUser.getId();
				int countCart = cartService.countCartList(userId);
				model.addAttribute("countCart", countCart);
			}
			return "/mypage/orderList";
		}

	}

	// �� �ֹ�����
	@RequestMapping(value = "/order_detail")
	public String orderDetailView(@RequestParam(value = "oseq") int oseq, OrderVO order, Model model,
			HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			System.out.println("�ֹ� �� ���� ����");

			order.setId(loginUser.getId());
			order.setResult("");
			order.setOseq(oseq);

			// �ֹ� ��ǰ����
			List<OrderVO> orderList = orderService.listOrderById(order);

			// �ֹ��� ����
			OrderVO orderDetail = new OrderVO();
			orderDetail.setIndate(orderList.get(0).getIndate());
			orderDetail.setOseq(orderList.get(0).getOseq());
			orderDetail.setName(orderList.get(0).getName());
			orderDetail.setResult(orderList.get(0).getResult());

			// �ѱݾ�
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

	// �Ϸ� �ֹ�����
	@RequestMapping(value = "/order_complete")
	public String orderAllView(OrderVO order, Model model, HttpServletRequest request) {

		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			System.out.println("�ֹ� ��ǰ ���");

			List<Integer> oseqList = orderService.selectSeqOrderComplete(loginUser.getId());

			// ������� ��ü �ֹ� ���� ���
			List<OrderVO> orderList = new ArrayList<OrderVO>();

			for (int oseq : oseqList) {

				order.setId(loginUser.getId());
				order.setOseq(oseq);
				order.setResult("2");
				// �ֹ���ȣ�� �ֹ����� ��ȸ
				List<OrderVO> listByseq = orderService.listOrderById(order);

				OrderVO vo = new OrderVO();

				// �ֹ���¥
				vo.setIndate(listByseq.get(0).getIndate());

				// �ֹ���ȣ
				vo.setOseq(listByseq.get(0).getOseq());

				// ��ǰ��
				if (listByseq.size() > 1) {
					vo.setPname(listByseq.get(0).getPname() + " �� " + (listByseq.size() - 1) + "��");
				} else {
					vo.setPname(listByseq.get(0).getPname());
				}

				// ���� �ݾ�
				int totalPrice = 0;
				// �Ѱ��� = ��ǰ���� * ���� * ������(100-����)
				for (int i = 0; i < listByseq.size(); i++) {
					totalPrice += listByseq.get(i).getTotalprice();
				}
				vo.setImage(listByseq.get(0).getImage());
				vo.setTotalprice(totalPrice);
				vo.setPseq(listByseq.get(0).getPseq());
				orderList.add(vo);

				model.addAttribute("orderList", orderList);
				model.addAttribute("title", "ó���� �ֹ� ����");
				model.addAttribute("loginUser", loginUser);

				// ��ٱ��Ͽ� ������ǰ ���
				String userId = loginUser.getId();
				int countCart = cartService.countCartList(userId);
				model.addAttribute("countCart", countCart);
			}
			return "/mypage/orderList";
		}
	}

}
