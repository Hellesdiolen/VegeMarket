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

	// 전체 QnA 목록 조회
	public List<QnaVO> listQna(String id) {
		System.out.println("==>전체 QnA 목록 조회");
		return mybatis.selectList("qnaDAO.listQna", id);
	}

	// 일련번호 별 게시글 한 건 조회
	public QnaVO getQna(int seq) {
		System.out.println("일련번호 별 게시글 한 건 조회");
		return mybatis.selectOne("qnaDAO.getQna", seq);
	}

	// 게시글 insert
	public void insertQna(QnaVO vo) {
		System.out.println("==>게시글 입력");
		mybatis.insert("qnaDAO.insertQna", vo);
	}

	// 게시판 전체 조회 (관리자)
	public List<QnaVO> listAllQna() {
		System.out.println("==>게시판 전체 조회");
		return mybatis.selectList("qnaDAO.listAllQna");
	}

	// 게시판 답변 처리
	public void updateQna(QnaVO vo) {
		System.out.println("게시판 답변 처리");
		mybatis.update("qnaDAO.updateQna", vo);

	}
}
