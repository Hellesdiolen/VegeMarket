package com.portfolio.biz.product.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.biz.product.ProductCommentVO;
import com.portfolio.biz.product.ProductVO;
import com.portfolio.biz.util.Criteria;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//상품번호로 하나의 상품정보 얻어오기
	public ProductVO getProduct(ProductVO vo) {
		System.out.println("==> 상품번호로 하나의 상품정보 얻어오기");
		return (ProductVO)mybatis.selectOne("productDAO.getProduct",vo);
	}
	
	/*
	 * 총 상품 조회
	 */
	public int countProductList(String name) {
		System.out.println("==> 총 상품 개수 조회");
		
		return mybatis.selectOne("productDAO.countProductList", name);
	}
	/*
	 * 상품 분류별 갯수 조회
	 */

	public int countProductListByKind(String kind) {
		System.out.println("상품 분류별 갯수 조회");
		return mybatis.selectOne("productDAO.countProductListByKind", kind);
	}
	
	/*
	 * 메인에 노출시킬 상품 리스트
	 */
	public List<ProductVO> mainListProduct() {
		System.out.println("==> 메인에 노출시킬 상품 리스트");
		
		return mybatis.selectList("productDAO.mainListProduct");
	}	
	
	/*
	 * 상품 목록 조회
	 */
	public List<ProductVO> listProduct(String name) {
		System.out.println("==> 상품 목록 조회");
		
		return mybatis.selectList("productDAO.listProduct", name);
	}
	
	/*
	 * 상품 등록
	 */
	public void insertProduct(ProductVO vo) {
		System.out.println("==> 상품 등록");
		
		mybatis.insert("productDAO.insertProduct", vo);
	}
	
	/*
	 * 상품 수정
	 */
	public void updateProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		System.out.println("==> 상품 수정");
		
		mybatis.insert("productDAO.updateProduct", vo);
	}

	
	//페이징부분 일단 구현만
	 
	
	public List<ProductVO> getListWithPaging(Criteria criteria, String key){
		System.out.println("==> 페이지별 상품 목록 조회");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("criteria",criteria);
		map.put("key",key);
		
		return mybatis.selectList("productDAO.listWithPaging", map);
	}

	public List<ProductVO> listByKindWithPaging(Criteria criteria, String kind) {
		System.out.println("==> 페이지별 상품 목록 조회");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("criteria",criteria);
		map.put("kind",kind);
		
		return mybatis.selectList("productDAO.listByKindWithPaging", map);
	}

	public List<ProductCommentVO> getCommentList(int pseq) {
		// TODO Auto-generated method stub
		return mybatis.selectList("commentDAO.getCommentList", pseq);
	}

	public void saveComment(ProductCommentVO commentVO) {
		// TODO Auto-generated method stub
		mybatis.insert("commentDAO.saveComment", commentVO);
	}

	public void updateComment(ProductCommentVO commentVO) {
		// TODO Auto-generated method stub
		mybatis.update("commentDAO.updateComment", commentVO);
	}

	public void deleteComment(int commentSeq) {
		// TODO Auto-generated method stub
		mybatis.delete("commentDAO.deleteComment", commentSeq);
	}

}
