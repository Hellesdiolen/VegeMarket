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
	
	//��ǰ��ȣ�� �ϳ��� ��ǰ���� ������
	public ProductVO getProduct(ProductVO vo) {
		System.out.println("==> ��ǰ��ȣ�� �ϳ��� ��ǰ���� ������");
		return (ProductVO)mybatis.selectOne("productDAO.getProduct",vo);
	}
	
	/*
	 * �� ��ǰ ��ȸ
	 */
	public int countProductList(String name) {
		System.out.println("==> �� ��ǰ ���� ��ȸ");
		
		return mybatis.selectOne("productDAO.countProductList", name);
	}
	/*
	 * ��ǰ �з��� ���� ��ȸ
	 */

	public int countProductListByKind(String kind) {
		System.out.println("��ǰ �з��� ���� ��ȸ");
		return mybatis.selectOne("productDAO.countProductListByKind", kind);
	}
	
	/*
	 * ���ο� �����ų ��ǰ ����Ʈ
	 */
	public List<ProductVO> mainListProduct() {
		System.out.println("==> ���ο� �����ų ��ǰ ����Ʈ");
		
		return mybatis.selectList("productDAO.mainListProduct");
	}	
	
	/*
	 * ��ǰ ��� ��ȸ
	 */
	public List<ProductVO> listProduct(String name) {
		System.out.println("==> ��ǰ ��� ��ȸ");
		
		return mybatis.selectList("productDAO.listProduct", name);
	}
	
	/*
	 * ��ǰ ���
	 */
	public void insertProduct(ProductVO vo) {
		System.out.println("==> ��ǰ ���");
		
		mybatis.insert("productDAO.insertProduct", vo);
	}
	
	/*
	 * ��ǰ ����
	 */
	public void updateProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		System.out.println("==> ��ǰ ����");
		
		mybatis.insert("productDAO.updateProduct", vo);
	}

	
	//����¡�κ� �ϴ� ������
	 
	
	public List<ProductVO> getListWithPaging(Criteria criteria, String key){
		System.out.println("==> �������� ��ǰ ��� ��ȸ");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("criteria",criteria);
		map.put("key",key);
		
		return mybatis.selectList("productDAO.listWithPaging", map);
	}

	public List<ProductVO> listByKindWithPaging(Criteria criteria, String kind) {
		System.out.println("==> �������� ��ǰ ��� ��ȸ");
		
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
