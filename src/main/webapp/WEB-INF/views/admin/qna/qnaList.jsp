<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<section class="ftco-section ftco-cart">

	<form name="formm">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
					<div class="cart-list">
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>번호(답변여부)</th>
									<th>제목</th>
									<th>등록일</th>
									<th>작성자</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${qnaList}" var="qnaVO">
									<tr class="text-center">
										<td>${qnaVO.qseq} <c:choose>
												<c:when test='${qnaVO.rep=="1"}'>(미처리)</c:when>
												<c:otherwise>(답변처리완료)</c:otherwise>
											</c:choose>
										</td>
										<td><a href="admin_qna_detail?qseq=${qnaVO.qseq}">${qnaVO.subject}</a></td>
										<td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
										<td> ${qnaVO.id} </td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-12" align="right">
				<input type="button" value="이전 페이지로 이동" class="btn btn-primary py-3 px-4" onclick='history.back(-1)'>
			</div>

		</div>
	</form>

</section>


<%@ include file="../footer.jsp"%>