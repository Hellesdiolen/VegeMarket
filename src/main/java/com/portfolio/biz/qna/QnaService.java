package com.portfolio.biz.qna;

import java.util.List;

public interface QnaService {

	//��ü Qna ��� ��ȸ
	List<QnaVO> listQna(String id);
	
	//�Ϸù�ȣ �� �Խñ� �� �� ��ȸ
	QnaVO getQna(int seq);
	
	//�Խñ� insert
	void insertQna(QnaVO vo);
	
	//�Խ��� ��ü ��ȸ(������)
	List<QnaVO> listAllQna();
	
	//�Խ��� �亯 ó��
	void updateQna(QnaVO vo);
}
