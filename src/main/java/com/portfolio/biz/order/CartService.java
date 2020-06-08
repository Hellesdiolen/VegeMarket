package com.portfolio.biz.order;

import java.util.List;

public interface CartService {

	//��ٱ��Ͽ� ���
	void insertCart(CartVO cartVO);
	//��ٱ��� ���
	List<CartVO> listCart(String userId);
	//��ٱ��� ID�� ����
	int countCartList(String userId);
	//��ٱ��� ���
	void deleteCart(int cseq);
	//��ٱ��� ��� ���� - ��ٱ��� ��ǰ �ֹ� ó��
	void updateCart(int cseq);
	//��ٱ��� ��ǰ ���� ����
	void changequanity(CartVO vo);
	
	//��ٱ��� üũ�� ���� ��ƾ���.
	CartVO checkListCart(int cseq);
}


