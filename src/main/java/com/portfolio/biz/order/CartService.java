package com.portfolio.biz.order;

import java.util.List;

public interface CartService {

	//장바구니에 담기
	void insertCart(CartVO cartVO);
	//장바구니 목록
	List<CartVO> listCart(String userId);
	//장바구니 ID별 갯수
	int countCartList(String userId);
	//장바구니 취소
	void deleteCart(int cseq);
	//장바구니 목록 갱신 - 장바구니 물품 주문 처리
	void updateCart(int cseq);
	//장바구리 상품 수량 변경
	void changequanity(CartVO vo);
	
	//장바구니 체크값 따로 담아야함.
	CartVO checkListCart(int cseq);
}


