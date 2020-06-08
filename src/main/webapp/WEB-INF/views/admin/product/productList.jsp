<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>



<section class="ftco-section ftco-cart" onload="go_ab()">
	<table class="table">
		<tr class="text-center">
			<td width="642">상품명 <input type="text" name="key"> <input class="btn btn-primary" type="button" name="btn_search" value="검색" onClick="go_search()"> <input class="btn btn-primary" type="button" name="btn_total" value="전체보기 " onClick="go_total()">\ <input class="btn btn-primary" type="button" name="btn_write" value="상품등록" onClick="go_wrt()">
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
									<th>제품번호</th>
									<th>상품명</th>
									<th>원가</th>
									<th>판매가</th>
									<th>세일률</th>
									<th>세일 적용가</th>
									<th>등록일</th>
									<th>판매유무</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${productList}" var="productVO">
									<tr class="text-center">
										<td>${productVO.pseq}<input type="hidden" name="pseq" value="${productVO.pseq}"></td>
										<td><a href="#" onClick="go_detail('${pageMaker.makeQuery(pageMaker.cri.pageNum)}','${productVO.pseq}')"> ${productVO.name}</a></td>
										<td class="price">₩<fmt:formatNumber value="${productVO.price1}" pattern="#,###"></fmt:formatNumber></td>
										<td class="price">₩<fmt:formatNumber value="${productVO.price2}" pattern="#,###"></fmt:formatNumber></td>
										<td>${productVO.discount}%</td>
										<td class="price"><c:choose>
												<c:when test="${productVO.discount>'0'}">
											₩<fmt:formatNumber value="${productVO.price2 * ('100'-productVO.discount)/'100'}" pattern="#,###"></fmt:formatNumber>
												</c:when>
												<c:otherwise>
											세일 품목 아님
										</c:otherwise>
											</c:choose></td>
										<td><fmt:formatDate value="${productVO.regdate}" type="date" /></td>
										<td><c:choose>
												<c:when test='${productVO.useyn=="n"}'>미사용</c:when>
												<c:otherwise>사용</c:otherwise>
											</c:choose></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
	<div class="row mt-5">
		<div class="col text-center">
			<div class="block-27">

				<ul>

					<c:if test="${pageMaker.prev}">
						<li><a href="admin_product_list${pageMaker.makeQuery(pageMaker.startPage-1)}">이전</a></li>
					</c:if>

					<!-- 페이지 숫자 표시부분 -->
					<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
						<li><a href="admin_product_list${pageMaker.makeQuery(index)}">${index}</a></li>
					</c:forEach>

					<c:if test="${pageMaker.next}">
						<li><a href="admin_product_list${pageMaker.makeQuery(pageMaker.endPage+1)}">다음</a></li>
					</c:if>

				</ul>
			</div>
		</div>
	</div>
</section>

<%@ include file="../footer.jsp"%>