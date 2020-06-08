package com.portfolio.biz.qna;

import java.util.List;

public interface QnaService {

	//전체 Qna 목록 조회
	List<QnaVO> listQna(String id);
	
	//일련번호 별 게시글 한 건 조회
	QnaVO getQna(int seq);
	
	//게시글 insert
	void insertQna(QnaVO vo);
	
	//게시판 전체 조회(관리자)
	List<QnaVO> listAllQna();
	
	//게시판 답변 처리
	void updateQna(QnaVO vo);
}
