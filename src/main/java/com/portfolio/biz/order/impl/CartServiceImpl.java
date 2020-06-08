package com.portfolio.biz.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.biz.order.CartService;
import com.portfolio.biz.order.CartVO;


@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public void insertCart(CartVO cartVO) {
		// TODO Auto-generated method stub
		cartDAO.insertCart(cartVO);
	}

	@Override
	public List<CartVO> listCart(String userId) {
		// TODO Auto-generated method stub
		return cartDAO.listCart(userId);
	}

	@Override
	public int countCartList(String userId) {
		// TODO Auto-generated method stub
		return cartDAO.countCartList(userId);
	}
	
	@Override
	public void deleteCart(int cseq) {
		// TODO Auto-generated method stub
		cartDAO.deleteCart(cseq);
	}

	@Override
	public void updateCart(int cseq) {
		// TODO Auto-generated method stub
		cartDAO.updateCart(cseq);
	}

	@Override
	public void changequanity(CartVO vo) {
		// TODO Auto-generated method stub
		cartDAO.changequanity(vo);
	}

	@Override
	public CartVO checkListCart(int cseq) {
		// TODO Auto-generated method stub
		return cartDAO.checkListCart(cseq);
	}


	
}

