package com.portfolio.biz.order;

import java.util.List;

import com.portfolio.biz.util.Criteria;

public interface OrderService {

	int selectMaxOseq();
	//��ٱ��ϻ�ǰ �ֹ����̺� ����
	int insertOrder(OrderVO vo,int[] cseqChecked);
	//
	void insertOrderDetail(OrderVO vo);
	
	List<OrderVO> listOrderById(OrderVO vo);
	
	List<Integer> selectSeqOrdering(String id);
	
	List<Integer> selectSeqOrderComplete(String id);
	//�ֹ� ��ü ��ȸ
	List<OrderVO> listOrder(String member_name);
	
	//�ֹ� ���� ����
	void updateOrderResult(String oseq);
	
	//����¡
	List<OrderVO> getListWithPaging(Criteria criteria,String key);
	
	//�̸��� �ֹ� ���� ��ȸ - �̸� ��� �� ��ȸ�� ��.
	int countOrderList(String id);
	
}
