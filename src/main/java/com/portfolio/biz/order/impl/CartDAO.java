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
	
	//장바구니 담기
	public void insertCart(CartVO cartVO) {
		System.out.println("==>장바구니 담기");
		mybatis.insert("cartDAO.insertCart", cartVO);
	}	
	//장바구니 목록
	public List<CartVO> listCart(String userId){
		System.out.println("==>장바구니 목록");
		return mybatis.selectList("cartDAO.listCart", userId);
	}	
	//ID별 장바구니 목록 갯수 출력
	public int countCartList(String userId) {
		System.out.println("ID별 장바구니 목록 갯수 출력");
		return mybatis.selectOne("cartDAO.countCartList", userId);
	}
	//장바구니 취소
	public void deleteCart(int cseq) {
		System.out.println("==>장바구니 삭제");
		mybatis.delete("cartDAO.deleteCart", cseq);
	}
	//장바구니 물품 구매
	public void updateCart(int cseq) {
		System.out.println("==>장바구니 물품 구매상태로 변경");
		mybatis.update("cartDAO.updateCart", cseq);
	}
	public void changequanity(CartVO vo) {
		System.out.println("==>장바구니 물품 수량 변경");
		mybatis.update("cartDAO.changequanity", vo);
	}
	public CartVO checkListCart(int cseq) {
		// TODO Auto-generated method stub
		System.out.println("==> 장바구니 물품 중 체크박스 친것만 뽑기");
		return mybatis.selectOne("cartDAO.checkListCart", cseq);
	}

}
