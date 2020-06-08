<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div class="hero-wrap hero-bread" style="background-image: url('images/bg_2.jpg');">
	<div class="container">
		<div class="row no-gutters slider-text align-items-center justify-content-center">
			<div class="col-md-9 ftco-animate text-center">
				<p class="breadcrumbs">
					<span class="mr-2"><a href="index">Home</a></span>
				</p>
				<h1 class="mb-0 bread">주문 상세 보기</h1>
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
									<th>&nbsp;</th>
									<th>상품별 주문번호</th>
									<th>상품명</th>
									<th>가격</th>
									<th>수량</th>
									<th>진행 상태</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${orderList}" var="orderVO">
									<tr class="text-center">
										<td class="image-prod">
											<div class="img" style="background-image: url(images/${orderVO.image});" OnClick="location.href ='product_detail?pseq=${orderVO.pseq}'"></div>
										</td>
										<td>${orderVO.odseq}</td>
										<td>${orderVO.pname}</td>
										<td class="price"><span> <c:choose>
													<c:when test="${orderVO.discount>'0'}">
																₩<fmt:formatNumber value="${orderVO.price2 * ('100'-productVO.discount)/'100'}" pattern="#,###"></fmt:formatNumber>
													</c:when>
													<c:otherwise>
																₩<fmt:formatNumber value="${orderVO.price2}" pattern="#,###"></fmt:formatNumber>
													</c:otherwise>
												</c:choose>
										</span></td>
										<td class="quantity">${orderVO.quantity}</td>
										<td><c:choose>
												<c:when test='${orderVO.result=="1"}'> 진행중 </c:when>
												<c:otherwise>
													<span style="color: red"> 처리완료 </span>
												</c:otherwise>
											</c:choose></td>
									</tr>
								</c:forEach>
								<tr>
									<!-- 제품당 합계 가격 -->
									<th colspan="2">총 액</th>
									<th>
									<c:choose>
									<c:when test="${totalPrice} >= 30000">
									₩<fmt:formatNumber value="${totalPrice}" pattern="#,###"></fmt:formatNumber>
									</c:when>
									<c:otherwise>
									₩<fmt:formatNumber value="${totalPrice + 3000}" pattern="#,###"></fmt:formatNumber> (배송비 추가)
									</c:otherwise>
									</c:choose>
									</th>
									<th colspan="4">주문 처리가 진행 중 입니다.</th>
									
								</tr>
								<!-- END TR-->
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</form>

<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">

			<h3 class="mb-4 billing-heading">배송정보</h3>
			<div class="col-md-10">
				<!-- 회원 기본배송지 -->
				<c:forEach items="${orderList}" begin="${order.last}" end="${order.last}" varStatus="order" var="orderVO">
					<div id="default_info" class="row align-items-end" style="display: inherit;">
						<div class="col-md-6">
							<div class="form-group">
								<label>수령인</label>&nbsp;&nbsp;&nbsp;<span>${orderVO.name}</span>
							</div>
						</div>
						<div class="w-100"></div>

						<div class="col-md-6">
							<div class="form-group">
								<label>연락처</label>&nbsp;&nbsp;&nbsp;<span>${orderVO.phone}</span>
							</div>
						</div>
						<div class="w-100"></div>

						<div class="col-md-4">
							<div class="form-group">
								<label>주소</label>&nbsp;&nbsp;&nbsp;<span>${orderVO.address}</span>
							</div>
						</div>
						<div class="w-100"></div>
					</div>

					<!-- 새로운 배송지 -->
					<div class="row align-items-end">
						<div class="col-md-6">
							<div class="form-group">
								<label for="memo">배송메모</label>&nbsp;&nbsp;&nbsp;<span>${orderVO.memo}</span>
							</div>
						</div>
					</div>
				</c:forEach>
				<!-- END -->
			</div>
		</div>
	</div>
</section>

<div class="col-md-10" align="right">
	<input type="button" onclick='history.back(-1)' class="btn btn-primary py-3 px-4" value="이전페이지로 돌아가기">
	<a href="go_shop" class="btn btn-primary py-3 px-4">쇼핑 계속하기</a>
</div>


<%@ include file="../footer.jsp"%>