<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="hero-wrap hero-bread" style="background-image: url('images/bg_1.jpg');">
	<div class="container">
		<div class="row no-gutters slider-text align-items-center justify-content-center">
			<div class="col-md-9 ftco-animate text-center">
				<p class="breadcrumbs">
					<span class="mr-2"><a href="index">Home</a></span> <span>Q&amp;A</span>
				</p>
				<h1 class="mb-0 bread">Q&amp;A게시판</h1>
			</div>
		</div>
	</div>
</div>

<section class="ftco-section ftco-cart">

	<form name="formm">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
					<div class="cart-list">
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>번호</th>
									<th>제목</th>
									<th>등록일</th>
									<th>답변 여부</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${qnaList}" var="qnaVO">
									<tr class="text-center">
										<td>${qnaVO.qseq}</td>
										<td><a href="qna_view?qseq=${qnaVO.qseq}">${qnaVO.subject}</a></td> 
										<td><fmt:formatDate value="${qnaVO.indate}" type="date" /></td>
										<td><c:choose>
												<c:when test="${qnaVO.rep==1}"> no </c:when>
												<c:when test="${qnaVO.rep==2}"> yes </c:when>
											</c:choose></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-12" align="right">
				<a href="qna_write_form" class="btn btn-primary py-3 px-4">1:1 질문하기</a>
				<!--  <input type="button" value="쇼핑 계속하기" class="btn btn-primary py-3 px-4" onclick='history.back(-1)'>-->
			</div>

		</div>
	</form>

</section>


<%@ include file="../footer.jsp"%>