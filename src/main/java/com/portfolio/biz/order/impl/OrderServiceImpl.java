package com.portfolio.biz.order.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.biz.order.CartService;
import com.portfolio.biz.order.CartVO;
import com.portfolio.biz.order.OrderService;
import com.portfolio.biz.order.OrderVO;
import com.portfolio.biz.util.Criteria;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private CartService cartService;

	@Override
	public int selectMaxOseq() {
		// TODO Auto-generated method stub
		return orderDAO.selectMaxOseq();
	}

	@Override
	public int insertOrder(OrderVO vo, int[] cseqChecked) {
		// TODO Auto-generated method stub
		int oseq = selectMaxOseq();

		vo.setOseq(oseq);
		// �ֹ� ���̺� �ֹ���ȣ�� ���̵� ����
		orderDAO.insertOrder(vo);

		// üũ�� �Ǿ� �ִ³� ���� �޼����ʿ�.
		List<CartVO> cartList = new ArrayList<CartVO>();

		for (int cseq : cseqChecked) {

			cartList.add(cartService.checkListCart(cseq));
		}
		System.out.println(cartList);

		for (CartVO cartVO : cartList) {
			System.out.println("��ٱ��� ���� :" + cartVO);

			OrderVO order = new OrderVO();

			order.setOseq(oseq);
			order.setPseq(cartVO.getPseq());
			order.setQuantity(cartVO.getQuantity());

			insertOrderDetail(order);
			// ��ٱ��� ���̺� �ֹ�ó�� �Ϸ� ���� updateCart
			cartService.updateCart(cartVO.getCseq());
		}

		// List<CartVO> cartList = cartService.listCart(vo.getId());

		// ��ٱ��Ͽ� �ִ� �ֹ����� ����order_detail�� ����
		return oseq;
	}

	@Override
	public void insertOrderDetail(OrderVO vo) {
		// TODO Auto-generated method stub
		orderDAO.insertOrderDetail(vo);
	}

	@Override
	public List<OrderVO> listOrderById(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.listOrderById(vo);
	}

	@Override
	public List<Integer> selectSeqOrdering(String id) {
		// TODO Auto-generated method stub
		return orderDAO.selectSeqOrdering(id);
	}

	@Override
	public List<Integer> selectSeqOrderComplete(String id) {
		// TODO Auto-generated method stub
		return orderDAO.selectSeqOrderComplete(id);
	}

	@Override
	public List<OrderVO> listOrder(String member_name) {
		// TODO Auto-generated method stub
		return orderDAO.listOrder(member_name);
	}

	@Override
	public void updateOrderResult(String oseq) {
		// TODO Auto-generated method stub
		orderDAO.updateOrderResult(oseq);
	}

	@Override
	public List<OrderVO> getListWithPaging(Criteria criteria, String key) {
		// TODO Auto-generated method stub
		return orderDAO.getListWithPaging(criteria, key);
	}

	@Override
	public int countOrderList(String id) {
		// TODO Auto-generated method stub
		return orderDAO.countOrderList(id);
	}

}
