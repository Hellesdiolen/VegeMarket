<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<form name="formm" action="admin_qna_repsave" class="p-5 bg-light" method="post">
	<input type="hidden" name="qseq" value="${qnaVO.qseq}">
	<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 ftco-animate">
					<div class="comment-form-wrap pt-5">
						<h3 class="mb-5">문의</h3>

						<div class="form-group">
							<label>제목</label>
							<p>${qnaVO.subject}
							<p>
						</div>

						<div class="form-group">
							<label>등록일</label>
							<p>
								<fmt:formatDate value="${qnaVO.indate}" type="date" />
							</p>
						</div>

						<div class="form-group">
							<label for="content">질문</label>
							<p>${qnaVO.content}</p>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 ftco-animate">
					<div class="comment-form-wrap pt-5">
						<c:choose>
							<c:when test='${qnaVO.rep=="1"}'>
								<div class="form-group">
									<label>답변</label>
									<textarea name="reply" cols="30" rows="10" class="form-control"></textarea>
								</div>
							</c:when>
							<c:otherwise>
								<div class="form-group">
									<label>답변</label>
									<p>${qnaVO.reply}</p>
								</div>
							</c:otherwise>
						</c:choose>

						<div class="form-group">
							<c:if test='${qnaVO.rep=="1"}'>
								<input type="submit" class="btn py-3 px-4 btn-primary" value="저장">
							</c:if>
							<input type="button" value="Q&A 게시판으로가기" class="btn py-3 px-4 btn-primary" onclick='history.back(-1)'>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>
</form>
<%@ include file="../footer.jsp"%>