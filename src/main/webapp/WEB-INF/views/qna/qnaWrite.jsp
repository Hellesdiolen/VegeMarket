<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<section class="ftco-section ftco-degree-bg">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 ftco-animate">
				<div class="comment-form-wrap pt-5">
					<h3 class="mb-5">문의</h3>
					<form name="formm" action="qna_write" class="p-5 bg-light" method="post">
						<div class="form-group">
							<label for="subject">제목</label> <input type="text" class="form-control" name="subject" id="subject">
						</div>

						<div class="form-group">
							<label for="content">내용</label>
							<textarea name="content" id="content" cols="30" rows="10" class="form-control"></textarea>
						</div>
						<div class="form-group">
							<input type="submit" value="저장" class="btn py-3 px-4 btn-primary">
							<input type="button" value="Q&A 게시판으로가기" class="btn py-3 px-4 btn-primary" onclick='history.back(-1)'>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="../footer.jsp"%>