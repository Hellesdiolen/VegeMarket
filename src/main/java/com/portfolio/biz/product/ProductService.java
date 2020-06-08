package com.portfolio.biz.product;

import java.util.List;

import com.portfolio.biz.util.Criteria;

//import com.portfolio.biz.util.Criteria;

public interface ProductService {
	
	//상품번호로 하나의 상품정보 얻어오기
	ProductVO getProduct(ProductVO vo);
	
	//상품 종류별 상품 목록 얻어오기
	List<ProductVO> listByKindWithPaging(Criteria criteria,String key);
	
	//메인에 띄워둘 상품들
	List<ProductVO> mainListProduct();
	
	// 상품 개수 조회
	int countProductList(String name);
	
	// 상품 분류별 갯수 조회
	int countProductListByKind(String kind);
	
	// 상품 전체 목록 조회
	List<ProductVO> listProduct(String name);
	
	// 상품 등록
	void insertProduct(ProductVO vo);
	
	//상품 갱신
	void updateProduct(ProductVO vo);

	//페이징
	List<ProductVO> getListWithPaging(Criteria criteria,String kind);	

	List<ProductCommentVO> getCommentList(int pseq);
	
	void saveComment(ProductCommentVO commentVO);
	
	void updateComment(ProductCommentVO commentVO);
	
	void deleteComment(int commentSeq);	
	
	
}
