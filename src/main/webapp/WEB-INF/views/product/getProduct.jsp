<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


<div class="hero-wrap hero-bread" style="background-image: url('images/bg_1.jpg');">
	<div class="container">
		<div class="row no-gutters slider-text align-items-center justify-content-center">
			<div class="col-md-9 ftco-animate text-center">
				<p class="breadcrumbs">
					<span class="mr-2"><a href="index">Home</a></span> <span>Products</span>
				</p>
				<h1 class="mb-0 bread">Products</h1>
			</div>
		</div>
	</div>
</div>
<form name="formm" action="">
<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<table class="table">
				<tr class="text-center">
					<td width="642">상품명 <input type="text" name="key"> <input class="btn btn-primary" type="button" name="btn_search" value="검색" onClick="go_search()"> <input class="btn btn-primary" type="button" name="btn_total" value="전체보기 " onClick="go_total()">
					</td>
				</tr>
			</table>
			<div class="col-md-10 mb-5 text-center">
				<ul class="product-category">
					<li><a href="go_shop" class="active">All</a></li>
					<li><a href="Kategorie?kind=1">과일</a></li>
					<li><a href="Kategorie?kind=2">야채</a></li>
					<li><a href="Kategorie?kind=3">유기농 쥬스</a></li>
					<li><a href="Kategorie?kind=4">견과류</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${productList}" var="productVO">
				<div class="col-md-6 col-lg-3 ftco-animate">
					<div class="product">
						<a href="product_detail?pseq=${productVO.pseq}" class="img-prod"><img class="img-fluid" src="images/${productVO.image}"> <c:if test="${productVO.discount>'0'}">
								<span class="status">${productVO.discount}%</span>
							</c:if>
							<div class="overlay"></div> </a>
						<div class="text py-3 pb-4 px-3 text-center">
							<h3>
								<span>${productVO.name}</span>
							</h3>
							<div class="d-flex">
								<c:choose>
									<c:when test="${productVO.discount > 0}">
										<div class="pricing">
											<p class="price">
												<span class="mr-2 price-dc">₩<fmt:formatNumber value="${productVO.price2}" pattern="#,###"></fmt:formatNumber></span> <span class="price-sale"> ₩<fmt:formatNumber value="${productVO.price2 * ('100'-productVO.discount)/'100'}" pattern="#,###"></fmt:formatNumber>
												</span>
											</p>
										</div>
									</c:when>
									<c:otherwise>
										<div class="pricing">
											<p class="price">
												<span class="price-sale"> ₩<fmt:formatNumber value="${productVO.price2}" pattern="#,###"></fmt:formatNumber>
												</span>
											</p>
										</div>
									</c:otherwise>
								</c:choose>
							</div>
							<div class="bottom-area d-flex px-3">
								<div class="m-auto d-flex">
									<a href="getProductListByKind?kind=${productVO.kind}" class="add-to-cart d-flex justify-content-center align-items-center text-center"> <span><i class="ion-ios-menu"></i></span>
									</a> <a href="product_detail?pseq=${productVO.pseq}" class="buy-now d-flex justify-content-center align-items-center mx-1"> <span><i class="ion-ios-cart"></i></span>
									</a>

								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<!--  페이징 부분 -->
		<div class="row mt-5">
			<div class="col text-center">
				<div class="block-27">

					<ul>

						<c:if test="${pageMaker.prev}">
							<li><a href="go_shop${pageMaker.makeQuery(pageMaker.startPage-1)}">이전</a></li>
						</c:if>

						<!-- 페이지 숫자 표시부분 -->
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
							<li><a href="go_shop${pageMaker.makeQuery(index)}">${index}</a></li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li><a href="go_shop${pageMaker.makeQuery(pageMaker.endPage+1)}">다음</a></li>
						</c:if>

					</ul>
				</div>
			</div>
		</div>
	</div>
</section>
</form>

<%@ include file="../footer.jsp"%>