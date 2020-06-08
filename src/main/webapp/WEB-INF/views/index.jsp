<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<section id="home-section" class="hero">
	<div class="home-slider owl-carousel">
		<div class="slider-item" style="background-image: url(images/bg_1.jpg);">
			<div class="overlay"></div>
			<div class="container">
				<div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

					<div class="col-md-12 ftco-animate text-center">
						<h1 class="mb-2">We serve Fresh Vegetables &amp; Fruits</h1>
						<h2 class="subheading mb-4">We deliver organic vegetables &amp; fruits</h2>
						<p>
							<a href="go_shop" class="btn btn-primary" >보러가기</a>
						</p>
					</div>

				</div>
			</div>
		</div>

		<div class="slider-item" style="background-image: url(images/bg_2.jpg);">
			<div class="overlay"></div>
			<div class="container">
				<div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

					<div class="col-sm-12 ftco-animate text-center">
						<h1 class="mb-2">100% Fresh &amp; Organic Foods</h1>
						<h2 class="subheading mb-4">We deliver organic vegetables &amp; fruits</h2>
						<p>
							<a href="go_shop" class="btn btn-primary" >보러가기</a>
						</p>
					</div>

				</div>
			</div>
		</div>
	</div>
</section>

<section class="ftco-section">
	<div class="container">
		<div class="row no-gutters ftco-services">
			<div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
				<div class="media block-6 services mb-md-0 mb-4">
					<div class="icon bg-color-1 active d-flex justify-content-center align-items-center mb-2">
						<span class="flaticon-shipped"></span>
					</div>
					<div class="media-body">
						<h3 class="heading">무료배송</h3>
						<span>주문금액 3만원 이상</span>
					</div>
				</div>
			</div>
			<div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
				<div class="media block-6 services mb-md-0 mb-4">
					<div class="icon bg-color-2 d-flex justify-content-center align-items-center mb-2">
						<span class="flaticon-diet"></span>
					</div>
					<div class="media-body">
						<h3 class="heading">신선도 유지</h3>
						<span>꼼꼼한 포장</span>
					</div>
				</div>
			</div>
			<div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
				<div class="media block-6 services mb-md-0 mb-4">
					<div class="icon bg-color-3 d-flex justify-content-center align-items-center mb-2">
						<span class="flaticon-award"></span>
					</div>
					<div class="media-body">
						<h3 class="heading">우수한 품질</h3>
						<span>높은수준의 제품</span>
					</div>
				</div>
			</div>
			<div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
				<div class="media block-6 services mb-md-0 mb-4">
					<div class="icon bg-color-4 d-flex justify-content-center align-items-center mb-2">
						<span class="flaticon-customer-service"></span>
					</div>
					<div class="media-body">
						<h3 class="heading">지원</h3>
						<span>빠른 응대서비스</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="ftco-section ftco-category ftco-no-pt">
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<div class="row">
					<div class="col-md-6 order-md-last align-items-stretch d-flex">
						<div class="category-wrap-2 ftco-animate img align-self-stretch d-flex" style="background-image: url(images/category.jpg);">
							<div class="text text-center">
								<h2>Vegetables</h2>
								<p>Protect the health of every home</p>
								<p>
									<!-- 제품목록 불러오기 -->
									<a href="go_shop" class="btn btn-primary">구매 하러가기</a>
								</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="category-wrap ftco-animate img mb-4 d-flex align-items-end" style="background-image: url(images/category-1.jpg);">
							<div class="text px-3 py-1">
								<h2 class="mb-0">
									<a href="Kategorie?kind=1">과일</a>
								</h2>
							</div>
						</div>
						<div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(images/category-2.jpg);">
							<div class="text px-3 py-1">
								<h2 class="mb-0">
									<a href="Kategorie?kind=2">야채</a>
								</h2>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="category-wrap ftco-animate img mb-4 d-flex align-items-end" style="background-image: url(images/category-3.jpg);">
					<div class="text px-3 py-1">
						<h2 class="mb-0">
							<a href="Kategorie?kind=3">유기농 쥬스</a>
						</h2>
					</div>
				</div>
				<div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(images/category-4.jpg);">
					<div class="text px-3 py-1">
						<h2 class="mb-0">
							<a href="Kategorie?kind=4">견과류</a>
						</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center mb-3 pb-3">
			<div class="col-md-12 heading-section text-center ftco-animate">
				<span class="subheading">주요 제품</span>
				<h2 class="mb-4">Our Products</h2>
				<p>항상 내가족이 먹는다 생각하고 키운 제품</p>
			</div>
		</div>
	</div>
	<!-- 이부분은 내가 올린 제품에 따라서 리스트 바껴야 한다 이건 다바껴야됨. -->

	<div class="container">

		<div class="row">
			<c:forEach items="${ProductList}" var="productVO">
				<div class="col-md-6 col-lg-3 ftco-animate">
					<div class="product">
						<a href="product_detail?pseq=${productVO.pseq}" class="img-prod"><img class="img-fluid" src="images/${productVO.image}"> <c:if test="${productVO.discount>'0'}">
								<p class="price">
									<span class="status">${productVO.discount}%</span>
								</p>
							</c:if>
							<div class="overlay"></div> </a>
						<div class="text py-3 pb-4 px-3 text-center">
							<h3>
								<span>${productVO.name}</span>
							</h3>
							<div class="d-flex">
								<c:choose>
									<c:when test="${productVO.discount>'0'}">
										<div class="pricing">
											<p class="price">
												<span class="mr-2 price-dc">₩<fmt:formatNumber value="${productVO.price2}" pattern="#,###"></fmt:formatNumber></span> <span class="price-sale">₩<fmt:formatNumber value="${productVO.price2 * ('100'-productVO.discount)/'100'}"></fmt:formatNumber></span>
											</p>
										</div>
									</c:when>
									<c:otherwise>
										<div class="pricing">
											<p class="price">
												<span class="price-sale">₩<fmt:formatNumber value="${productVO.price2}" pattern="#,###"></fmt:formatNumber></span>
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
	</div>

</section>
<%@ include file="footer.jsp"%>
