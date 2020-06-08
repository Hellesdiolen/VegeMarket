<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>

<div class="hero-wrap hero-bread" style="background-image: url('images/bg_1.jpg');">
	<div class="container">
		<div class="row no-gutters slider-text align-items-center justify-content-center">
			<div class="col-md-9 ftco-animate text-center">
				<p class="breadcrumbs">
					<span class="mr-2"><a href="index">Home</a> </span> <span class="mr-2"><a href="go_shop">제품 목록</a> </span> <span>제품 상세보기</span>
				</p>
				<h1 class="mb-0 bread">제품 상세보기</h1>
			</div>
		</div>
	</div>
</div>

<section class="ftco-section">
	<div class="container">
		<form name="formm" method="post">
			<div class="row">
				<input type="hidden" name="pseq" value="${productVO.pseq}">
				<div class="col-lg-6 mb-5 ftco-animate">
					<a href="images/${productVO.image}" class="image-popup"><img src="images/${productVO.image}" class="img-fluid" alt="Colorlib Template"></a>
				</div>
				<div class="col-lg-6 product-details pl-md-5 ftco-animate">
					<h3>${productVO.name}</h3>
					<!--  
					<div class="rating d-flex">
						<p class="text-left mr-4">
							<a href="#" class="mr-2">이건 평점</a> <a href="#"><span class="ion-ios-star-outline"></span></a> <a href="#"><span class="ion-ios-star-outline"></span></a> <a href="#"><span class="ion-ios-star-outline"></span></a> <a href="#"><span class="ion-ios-star-outline"></span></a> <a href="#"><span class="ion-ios-star-outline"></span></a>
						</p>
						<p class="text-left mr-4">
							<a href="#" class="mr-2" style="color: #000;">이건 평가 <span style="color: #bbb;">Rating</span></a>
						</p>
						<p class="text-left">
							<a href="#" class="mr-2" style="color: #000;">이건 총주문한수량 <span style="color: #bbb;">Sold</span></a>
						</p>
					</div>
					-->
					<p class="price">
						<span> <c:choose>
								<c:when test="${productVO.discount>'0'}">
									<div class="pricing">
										<p class="price">
											<span class="price-sale"> ₩<fmt:formatNumber value="${productVO.price2 * ('100'-productVO.discount)/'100'}" pattern="#,###"></fmt:formatNumber></span>
										<p class="price">
											<span class="status">${productVO.discount}% 세일</span>
										</p>
									</div>
								</c:when>
								<c:otherwise>
									<div class="pricing">
										<p class="price">
											<span class="price-sale"> ₩<fmt:formatNumber value="${productVO.price2}" pattern="#,###"></fmt:formatNumber></span>
										</p>
									</div>
								</c:otherwise>
							</c:choose>
						</span>
					</p>
					<p>${productVO.content}</p>
					<div class="row mt-4">
						<div class="input-group col-md-6 d-flex mb-3">
							<span class="input-group-btn mr-2">
								<button type="button" class="quantity-left-minus btn" onclick="del()">
									<i class="ion-ios-remove"></i>
								</button>
							</span> <input type="text" id="quantity" name="quantity" class="form-control input-number" value="1" min="1" max="100"> <span class="input-group-btn ml-2">
								<button type="button" class="quantity-right-plus btn" onclick="add()">
									<i class="ion-ios-add"></i>
								</button>
							</span>
						</div>
						<div class="w-100"></div>
						<div class="col-md-12">
							<p style="color: #000;">여긴 주문가능수량 표시</p>
						</div>
					</div>

					<p>
						<input type="button" class="btn btn-black py-3 px-4" onclick="go_cart()" value="장바구니에 담기"> <input type="button" onclick='history.back(-1)' class="btn btn-primary py-3 px-4" value="목록으로 돌아가기">
					</p>
				</div>
			</div>
		</form>
		<div class="row">
			<%@ include file="comment.jsp"%>
		</div>
	</div>
</section>


<%@ include file="../footer.jsp"%>