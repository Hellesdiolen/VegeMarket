<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div class="hero-wrap hero-bread" style="background-image: url('images/bg_2.jpg');">
	<div class="container">
		<div class="row no-gutters slider-text align-items-center justify-content-center">
			<div class="col-md-9 ftco-animate text-center">
				<p class="breadcrumbs">
					<span class="mr-2"><a href="index">Home</a></span>
				</p>
				<h1 class="mb-0 bread">${title}</h1>
			</div>
		</div>
	</div>
</div>

<form name="formm" method="post">
	<section class="ftco-section ftco-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
					<div class="cart-list">
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>주문일자</th>
									<th>주문번호</th>
									<th>&nbsp;</th>
									<th>상품명</th>
									<th>총 주문 가격(배송비 포함)</th>
									<th>주문상세</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${orderList}" var="orderVO">
									<tr class="text-center">
										<td><fmt:formatDate value="${orderVO.indate}" type="date" /></td>
										<td>${orderVO.oseq}</td>
										<td class="image-prod">
											<div class="img" style="background-image: url(images/${orderVO.image});" OnClick="location.href ='product_detail?pseq=${orderVO.pseq}'"></div>
										</td>
										<td>${orderVO.pname}</td>
										<td class="price"><c:choose>
												<c:when test="${orderVO.totalprice < 30000}">
											₩<fmt:formatNumber value="${orderVO.totalprice + 3000}" pattern="#,###"></fmt:formatNumber>
												</c:when>
												<c:otherwise>
											₩<fmt:formatNumber value="${orderVO.totalprice}" pattern="#,###"></fmt:formatNumber>
												</c:otherwise>
											</c:choose></td>
										<td><a href="order_detail?oseq=${orderVO.oseq}"> 조회 </a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</form>
<div class="col-md-10" align="right">
	<a href="go_shop" class="btn btn-primary py-3 px-4">쇼핑 계속하기</a>
</div>

<%@ include file="../footer.jsp"%>