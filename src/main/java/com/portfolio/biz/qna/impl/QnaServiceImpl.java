package com.portfolio.biz.qna.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.biz.qna.QnaService;
import com.portfolio.biz.qna.QnaVO;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<QnaVO> listQna(String id) {
		// TODO Auto-generated method stub
		return qnaDAO.listQna(id);
	}

	@Override
	public QnaVO getQna(int seq) {
		// TODO Auto-generated method stub
		return qnaDAO.getQna(seq);
	}

	@Override
	public void insertQna(QnaVO vo) {
		// TODO Auto-generated method stub
		qnaDAO.insertQna(vo);
	}

	@Override
	public List<QnaVO> listAllQna() {
		// TODO Auto-generated method stub
		return qnaDAO.listAllQna();
	}

	@Override
	public void updateQna(QnaVO vo) {
		// TODO Auto-generated method stub
		qnaDAO.updateQna(vo);
	}
	
	
}
