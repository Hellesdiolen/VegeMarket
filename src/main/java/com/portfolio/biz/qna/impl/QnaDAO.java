package com.portfolio.biz.qna.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.biz.qna.QnaVO;

@Repository
public class QnaDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	// ��ü QnA ��� ��ȸ
	public List<QnaVO> listQna(String id) {
		System.out.println("==>��ü QnA ��� ��ȸ");
		return mybatis.selectList("qnaDAO.listQna", id);
	}

	// �Ϸù�ȣ �� �Խñ� �� �� ��ȸ
	public QnaVO getQna(int seq) {
		System.out.println("�Ϸù�ȣ �� �Խñ� �� �� ��ȸ");
		return mybatis.selectOne("qnaDAO.getQna", seq);
	}

	// �Խñ� insert
	public void insertQna(QnaVO vo) {
		System.out.println("==>�Խñ� �Է�");
		mybatis.insert("qnaDAO.insertQna", vo);
	}

	// �Խ��� ��ü ��ȸ (������)
	public List<QnaVO> listAllQna() {
		System.out.println("==>�Խ��� ��ü ��ȸ");
		return mybatis.selectList("qnaDAO.listAllQna");
	}

	// �Խ��� �亯 ó��
	public void updateQna(QnaVO vo) {
		System.out.println("�Խ��� �亯 ó��");
		mybatis.update("qnaDAO.updateQna", vo);

	}
}
