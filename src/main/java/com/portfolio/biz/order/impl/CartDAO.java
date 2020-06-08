package com.portfolio.biz.order.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.biz.order.CartVO;


@Repository
public class CartDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	//��ٱ��� ���
	public void insertCart(CartVO cartVO) {
		System.out.println("==>��ٱ��� ���");
		mybatis.insert("cartDAO.insertCart", cartVO);
	}	
	//��ٱ��� ���
	public List<CartVO> listCart(String userId){
		System.out.println("==>��ٱ��� ���");
		return mybatis.selectList("cartDAO.listCart", userId);
	}	
	//ID�� ��ٱ��� ��� ���� ���
	public int countCartList(String userId) {
		System.out.println("ID�� ��ٱ��� ��� ���� ���");
		return mybatis.selectOne("cartDAO.countCartList", userId);
	}
	//��ٱ��� ���
	public void deleteCart(int cseq) {
		System.out.println("==>��ٱ��� ����");
		mybatis.delete("cartDAO.deleteCart", cseq);
	}
	//��ٱ��� ��ǰ ����
	public void updateCart(int cseq) {
		System.out.println("==>��ٱ��� ��ǰ ���Ż��·� ����");
		mybatis.update("cartDAO.updateCart", cseq);
	}
	public void changequanity(CartVO vo) {
		System.out.println("==>��ٱ��� ��ǰ ���� ����");
		mybatis.update("cartDAO.changequanity", vo);
	}
	public CartVO checkListCart(int cseq) {
		// TODO Auto-generated method stub
		System.out.println("==> ��ٱ��� ��ǰ �� üũ�ڽ� ģ�͸� �̱�");
		return mybatis.selectOne("cartDAO.checkListCart", cseq);
	}

}
