package com.portfolio.biz.order;

import java.util.List;

import com.portfolio.biz.util.Criteria;

public interface OrderService {

	int selectMaxOseq();
	//장바구니상품 주문테이블 삽입
	int insertOrder(OrderVO vo,int[] cseqChecked);
	//
	void insertOrderDetail(OrderVO vo);
	
	List<OrderVO> listOrderById(OrderVO vo);
	
	List<Integer> selectSeqOrdering(String id);
	
	List<Integer> selectSeqOrderComplete(String id);
	//주문 전체 조회
	List<OrderVO> listOrder(String member_name);
	
	//주문 상태 갱신
	void updateOrderResult(String oseq);
	
	//페이징
	List<OrderVO> getListWithPaging(Criteria criteria,String key);
	
	//이름별 주문 갯수 조회 - 이름 없어도 뭐 조회는 됨.
	int countOrderList(String id);
	
}
