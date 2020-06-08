package com.portfolio.biz.product;

import java.util.List;

import com.portfolio.biz.util.Criteria;

//import com.portfolio.biz.util.Criteria;

public interface ProductService {
	
	//��ǰ��ȣ�� �ϳ��� ��ǰ���� ������
	ProductVO getProduct(ProductVO vo);
	
	//��ǰ ������ ��ǰ ��� ������
	List<ProductVO> listByKindWithPaging(Criteria criteria,String key);
	
	//���ο� ����� ��ǰ��
	List<ProductVO> mainListProduct();
	
	// ��ǰ ���� ��ȸ
	int countProductList(String name);
	
	// ��ǰ �з��� ���� ��ȸ
	int countProductListByKind(String kind);
	
	// ��ǰ ��ü ��� ��ȸ
	List<ProductVO> listProduct(String name);
	
	// ��ǰ ���
	void insertProduct(ProductVO vo);
	
	//��ǰ ����
	void updateProduct(ProductVO vo);

	//����¡
	List<ProductVO> getListWithPaging(Criteria criteria,String kind);	

	List<ProductCommentVO> getCommentList(int pseq);
	
	void saveComment(ProductCommentVO commentVO);
	
	void updateComment(ProductCommentVO commentVO);
	
	void deleteComment(int commentSeq);	
	
	
}
