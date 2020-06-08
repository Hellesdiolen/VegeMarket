<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="hero-wrap hero-bread" style="background-image: url('images/bg_1.jpg');">
	<div class="container">
		<div class="row no-gutters slider-text align-items-center justify-content-center">
			<div class="col-md-9 ftco-animate text-center">
				<p class="breadcrumbs">
					<span class="mr-2"><a href="index">Home</a></span> <span><a href="qna_list">Q&amp;A</a></span>
				</p>
				<h1 class="mb-0 bread">Q&amp;A게시판</h1>
			</div>
		</div>
	</div>
</div>
<section class="ftco-section ftco-degree-bg">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 ftco-animate">
				<div class="comment-form-wrap pt-5" style="color: black;">
					<h3 class="mb-5">문의내용</h3>
					<form name="formm" action="qna_write" class="p-5 bg-light" method="post">
						<div class="form-group">
							<label>제목</label>
							<p>${qnaVO.subject}</p>
							<label>등록일</label>
							<p>
								<fmt:formatDate value="${qnaVO.indate}" type="date" />
							</p>
						</div>
						<div class="form-group">
							<label>질문</label>
							<p>
								<textarea name="content" id="content" cols="30" rows="10" class="form-control" readonly="readonly">${qnaVO.content}</textarea></p>
						</div>
						<div class="form-group">
							<label>답변</label>
							<p style="color: blue;">${qnaVO.reply}</p>
						</div>

						<div class="form-group">
							<a href="go_shop" class="btn btn-primary py-3 px-4">쇼핑 계속하기</a> <input type="button" value="Q&A 게시판으로가기" class="btn py-3 px-4 btn-primary" onclick='history.back(-1)'>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="../footer.jsp"%>