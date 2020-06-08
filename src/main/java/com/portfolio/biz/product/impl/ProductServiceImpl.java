package com.portfolio.biz.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.biz.product.ProductCommentVO;
import com.portfolio.biz.product.ProductService;
import com.portfolio.biz.product.ProductVO;
import com.portfolio.biz.util.Criteria;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public ProductVO getProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		return productDAO.getProduct(vo);
	}

	@Override
	public int countProductList(String name) {
		// TODO Auto-generated method stub
		return productDAO.countProductList(name);
	}

	@Override
	public List<ProductVO> mainListProduct() {
		// TODO Auto-generated method stub
		return productDAO.mainListProduct();
	}
	
	@Override
	public List<ProductVO> listProduct(String name) {
		// TODO Auto-generated method stub
		return productDAO.listProduct(name);
	}

	@Override
	public void insertProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		productDAO.insertProduct(vo);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		productDAO.updateProduct(vo);
	}

	@Override
	public List<ProductVO> getListWithPaging(Criteria criteria, String key) {
		// TODO Auto-generated method stub
		return productDAO.getListWithPaging(criteria,key);
	}


	@Override
	public List<ProductVO> listByKindWithPaging(Criteria criteria, String kind) {
		// TODO Auto-generated method stub
		return productDAO.listByKindWithPaging(criteria,kind);
	}

	@Override
	public int countProductListByKind(String kind) {
		// TODO Auto-generated method stub
		return productDAO.countProductListByKind(kind);
	}

	@Override
	public List<ProductCommentVO> getCommentList(int pseq) {
		// TODO Auto-generated method stub
		return productDAO.getCommentList(pseq);
	}

	@Override
	public void saveComment(ProductCommentVO commentVO) {
		// TODO Auto-generated method stub
		productDAO.saveComment(commentVO);
	}

	@Override
	public void updateComment(ProductCommentVO commentVO) {
		// TODO Auto-generated method stub
		productDAO.updateComment(commentVO);
	}

	@Override
	public void deleteComment(int commentSeq) {
		// TODO Auto-generated method stub
		productDAO.deleteComment(commentSeq);
	}

	
}
