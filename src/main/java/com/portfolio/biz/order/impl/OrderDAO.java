package com.portfolio.biz.order.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.biz.order.OrderVO;
import com.portfolio.biz.util.Criteria;


@Repository
public class OrderDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int selectMaxOseq() {
		System.out.println("==>MaxOseq����");
		return mybatis.selectOne("orderDAO.selectMaxOseq");
	}
	public void insertOrder(OrderVO vo) {
		System.out.println("==>�ֹ� ����");
		mybatis.insert("orderDAO.insertOrder", vo);
	}
	public void insertOrderDetail(OrderVO vo) {
		System.out.println("==> �� �ֹ� ����");
		mybatis.insert("orderDAO.insertOrderDetail", vo);

	}	
	public List<OrderVO> listOrderById(OrderVO vo) {
		System.out.println("==> �ֹ� ID�� ����Ʈ");
		return mybatis.selectList("orderDAO.listOrderById", vo);
	}

	public List<Integer> selectSeqOrdering(String id) {
		System.out.println("==>������ seq �ֹ�");
		return mybatis.selectList("orderDAO.selectSeqOrdering", id);
	}
	
	public List<Integer> selectSeqOrderComplete(String id) {
		System.out.println("==>�Ϸ�� �ֹ� ����");
		return mybatis.selectList("orderDAO.selectSeqOrderComplete", id);
	}
	
	public List<OrderVO> listOrder(String member_name){
		System.out.println("==>�ֹ� ��ü ��ȸ");
		return mybatis.selectList("orderDAO.listOrder", member_name);
	}
	
	public void updateOrderResult(String oseq) {
		System.out.println("==>�ֹ� ���� ����");
		mybatis.update("orderDAO.updateOrderResult", oseq);
	}
	
	public List<OrderVO> getListWithPaging(Criteria criteria, String key) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("criteria",criteria);
		map.put("key",key);
		
		return mybatis.selectList("orderDAO.listWithPaging", map);
	}
	public int countOrderList(String id) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("orderDAO.countOrderList", id);
	}
}
