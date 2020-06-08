<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript">
	function go_Id_search() {
		document.frm.action = "admin_member_list";
		document.frm.submit();
	}
</script>
<section class="ftco-section ftco-cart">
	<table class="table">
		<tr class="text-center">
			<td width="642">상품명 <input type="text" name="key"> <input class="btn btn-primary" type="button" name="btn_search" value="검색" onClick="go_Id_search()">
			</td>
		</tr>
	</table>
	<form name="formm" method="post">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
					<div class="cart-list">
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>아이디(사용중지여부)</th>
									<th>이름</th>
									<th>이메일</th>
									<th>우편번호</th>
									<th>주소</th>
									<th>연락처</th>
									<th>가입일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${memberList}" var="memberVO">
									<tr class="text-center">
										<td>${memberVO.id}<c:choose>
												<c:when test='${memberVO.useyn=="y"}'>
													<span style="font-weight: bold; color: blue">(사용중</span>
													<input type="checkbox" name="id" value="${memberVO.id}">)
													<input type="hidden" name="usey" value="y">
													<input type="hidden" name="usen" value="">
												</c:when>
												<c:otherwise>
													<span style="font-weight: bold; color: red">(휴먼ID</span>
													<input type="checkbox" name="id" value="${memberVO.id}">)
													<input type="hidden" name="usey" value="">
													<input type="hidden" name="usen" value="n">
												</c:otherwise>
											</c:choose>
										</td>
										<td>${memberVO.name}</td>
										<td>${memberVO.email}</td>
										<td>${memberVO.zip_num}</td>
										<td>${memberVO.address}</td>
										<td>${memberVO.phone}</td>
										<td><fmt:formatDate value="${memberVO.regdate}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-12" align="right">
				<input type="button" class="btn btn-primary py-3 px-4" value="비활성화 ID전환" onclick="go_sleep_id()">
				<input type="button" class="btn btn-primary py-3 px-4" value="활성화 ID전환" onclick="go_activation_id()">
			</div>
		</div>
	</form>
	<div class="row mt-5">
		<div class="col text-center">
			<div class="block-27">

				<ul>

					<c:if test="${pageMaker.prev}">
						<li><a href="aadmin_member_list${pageMaker.makeQuery(pageMaker.startPage-1)}">이전</a></li>
					</c:if>

					<!-- 페이지 숫자 표시부분 -->
					<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
						<li><a href="admin_member_list${pageMaker.makeQuery(index)}">${index}</a></li>
					</c:forEach>

					<c:if test="${pageMaker.next}">
						<li><a href="admin_member_list${pageMaker.makeQuery(pageMaker.endPage+1)}">다음</a></li>
					</c:if>

				</ul>
			</div>
		</div>
	</div>
</section>


<%@ include file="../footer.jsp"%>