<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div class="hero-wrap hero-bread" style="background-image: url('images/bg_1.jpg');">
	<div class="container">
		<div class="row no-gutters slider-text align-items-center justify-content-center">
			<div class="col-md-9 ftco-animate text-center">
				<p class="breadcrumbs">
					<span class="mr-2"><a href="index">Home</a></span> <span>Cart</span>
				</p>
				<h1 class="mb-0 bread">My Cart</h1>
			</div>
		</div>
	</div>
</div>

<form name="formm" method="post">
	<section class="ftco-section ftco-cart">
		<div class="container">

			<div class="row">
				<c:choose>
					<c:when test="${cartList.size()==0}">
						<div class="col-md-12" align="center">
							<h2>장바구니에 물품이 없습니다.</h2>
							<a href="go_shop" class="btn btn-primary py-3 px-2">상품 구매하러 가기</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col-md-12 ftco-animate">
							<div class="cart-list">
								<table class="table">
									<thead class="thead-primary">
										<tr class="text-center">
											<th><input id="allCheck" name="allCheck" type="checkbox" onclick="allChk(this);" /></th>
											<th>&nbsp;</th>
											<th>상품명</th>
											<th>가격</th>
											<th>수량</th>
											<th>합계</th>
											<th>&nbsp;</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${cartList}" var="cartVO">
											<input type="hidden" name="one_cseq" value="${cartVO.cseq}">
											<tr class="text-center">
												<td class="product-remove"><input type="checkbox" name="cseq" value="${cartVO.cseq}"></td>

												<td class="image-prod">
													<div class="img" style="background-image: url(images/${cartVO.image});"></div>
												</td>

												<td>${cartVO.pname}</td>

												<td class="price"><span> <c:choose>
															<c:when test="${cartVO.discount>'0'}">
																<div class="pricing">
																	<p class="price">
																		<span class="price-sale">₩<fmt:formatNumber value="${cartVO.price2 * ('100'-cartVO.discount)/'100'}" pattern="#,###"></fmt:formatNumber>
																		</span>
																	</p>
																</div>
															</c:when>
															<c:otherwise>
																<div class="pricing">
																	<p class="price">
																		<span class="price-sale">₩<fmt:formatNumber value="${cartVO.price2}" pattern="#,###"></fmt:formatNumber></span>
																	</p>
																</div>
															</c:otherwise>
														</c:choose>
												</span></td>

												<td class="quantity">
													<div class="input-group">
														<input type="text" name="quantity" class="form-control input-number" value="${cartVO.quantity}" min="1" max="100"> <input type="button" class="btn btn-primary py-3 px-4" onclick="go_change_quantity()" value="수량변경">
													</div>
												</td>
												<!-- 제품당 합계 가격 -->
												<td class="total"><c:choose>
														<c:when test="${cartVO.discount>'0'}">
															<div class="pricing">
																<p class="price">
																	<span class="price-sale"> ₩<fmt:formatNumber value="${cartVO.price2 * ('100'-cartVO.discount)/'100' * cartVO.quantity}" pattern="#,###"></fmt:formatNumber>
																	</span>
																</p>
															</div>
														</c:when>
														<c:otherwise>
															<div class="pricing">
																<p class="price">
																	<span class="price-sale">₩<fmt:formatNumber value="${cartVO.price2 * cartVO.quantity}" pattern="#,###"></fmt:formatNumber></span>
																</p>
															</div>
														</c:otherwise>
													</c:choose></td>
												<td class="product-remove"><a href="cart_delete?one_cseq=${cartVO.cseq}"> <span class="ion-ios-close"></span>
												</a></td>
											</tr>
											<!-- END TR-->

										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>


	</section>


		<div class="col-md-10" align="right">
			<a href="go_shop" class="btn btn-primary py-3 px-4">계속 구매하기</a> <input onclick="go_cart_delete()" class="btn btn-primary py-3 px-4" value="삭제">
		</div>

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">

				<div class="col-xl-7 ftco-animate">

					<h3 class="mb-4 billing-heading">배송정보</h3>

					<!-- 회원 기본배송지 -->
					<div id="default_info" class="row align-items-end" style="display: inherit;">
						<div class="col-md-6">
							<div class="form-group">
								<label>수령인</label>&nbsp;&nbsp;&nbsp;<span>${loginUser.name}</span>
							</div>
						</div>
						<div class="w-100"></div>

						<div class="col-md-6">
							<div class="form-group">
								<label>연락처</label>&nbsp;&nbsp;&nbsp;<span>${loginUser.phone}</span>
							</div>
						</div>
						<div class="w-100"></div>

						<div class="col-md-4">
							<div class="form-group">
								<label>배송지 주소</label>&nbsp;&nbsp;&nbsp;<span>${loginUser.address}</span>
							</div>
						</div>
						<div class="w-100"></div>
					</div>

					<!-- 새로운 배송지 -->
					<div id="new_info" class="row align-items-end" style="display: none;">
						<div class="col-md-4">
							<div class="form-group">
								<label for="name">수령인</label> <input type="text" class="form-control" name="name" id="name">
							</div>
						</div>
						<div class="w-100"></div>
						<div class="col-md-5">
							<label>연락처</label>
							<div class="form-group d-inline-flex" style="vertical-align: middle;">
								<input type="hidden" name="phone" value=""> <input type="text" class="form-control" name="phone1" placeholder="" value="010"> - <input type="text" class="form-control" name="phone2" placeholder="" maxlength="4"> - <input type="text" class="form-control" name="phone3" placeholder="" maxlength="4">

							</div>
						</div>
						<div class="w-100"></div>
						<div class="col-md-3">
							<div class="form-group">
								<label>우편번호</label> <input type="text" class="form-control" name="zip_num" placeholder="우편번호" readonly="readonly">
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<input type="button" class="btn btn-primary py-2 px-2" value="주소 찾기" onclick="post_zip()">
							</div>
						</div>
						<div class="w-100"></div>
						<div class="col-md-7">
							<div class="form-group">
								<input type="hidden" name="address" /> <input type="text" class="form-control" name="addr1" placeholder="주소1" readonly="readonly">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<input type="text" class="form-control" name="addr2" placeholder="주소2">
							</div>
						</div>
						<div class="w-100"></div>

					</div>
					<div class="row align-items-end">
						<div class="col-md-6">
							<div class="form-group">
								<label for="memo">배송메모</label> <input type="text" name="memo" id="memo" class="form-control" placeholder="20자 이내로작성" maxlength="20">
							</div>
						</div>
					</div>
					<!-- <div class="form-group mt-4"> -->
					<div class="radio">
						<label class="mr-3"> <input type="radio" class="mr-2" name="destination" checked="checked" value="1" onclick="div_OnOff(this.value,'default_info','new_info')">기본배송지
						</label> <label> <input type="radio" class="mr-2" name="destination" value="2" onclick="div_OnOff(this.value,'default_info','new_info')"> 신규배송지
						</label>
					</div>
					<!--</div> -->



					<!-- END -->
				</div>


				<div class="col-xl-5">
					<h3 class="billing-heading mb-4">Cart Total</h3>
					<!--  <div class="row mt-5 pt-3">-->
						<div class="col-md-12 d-flex mb-5">
							<div class="cart-detail cart-total p-3 p-md-4">
								<p class="d-flex">
									<span>총상품가격</span> <span>₩<fmt:formatNumber value="${totalPrice}" pattern="#,###"></fmt:formatNumber></span>
									<input type="hidden" id="totalPrice" value="${totalPrice}">
								</p>
								<p class="d-flex">
									<c:choose>
										<c:when test="${totalPrice >= 30000}">
											<span>배송비</span>
											<span>₩0<input type="hidden" name="delivery" value="0"></span>
										</c:when>
										<c:otherwise>
											<span>배송비</span>
											<span>₩<fmt:formatNumber value="3000" pattern="#,###"></fmt:formatNumber><input type="hidden" name="delivery" value="3000"></span>
										</c:otherwise>
									</c:choose>
								</p>discountPrice
								<p class="d-flex">
									<span>할인금액</span> <span>₩<fmt:formatNumber value="${discountPrice}" pattern="#,###"></fmt:formatNumber><input type="hidden" name="discountPrice" value="${discountPrice}"></span>
								</p>
								<hr>
								<p class="d-flex total-price">
									<c:choose>
										<c:when test="${totalPrice >= 30000}">
											<span>총금액</span>
											<span>₩<fmt:formatNumber value="${totalPrice}" pattern="#,###"></fmt:formatNumber><input type="hidden" name="totalPrice" value="${totalPrice}"></span>
										</c:when>
										<c:otherwise>
											<span>총금액</span>
											<span>₩<fmt:formatNumber value="${totalPrice + 3000}" pattern="#,###"></fmt:formatNumber><input type="hidden" name="totalPrice" value="${totalPrice + 3000}"></span>
										</c:otherwise>
									</c:choose>
								</p>
							</div>
						</div>
						<div class="col-md-12">
							<div class="cart-detail p-3 p-md-4">

								<p>
									<input type="button" class="btn btn-primary py-3 px-4 submit" onclick="go_order_insert()" value="주문하기">
								</p>
							</div>
						</div>
					<!-- </div> -->
				</div>

			</div>

			<!-- .col-md-8 -->
		</div>
	</section>
	<!-- .section -->
</form>
<%@ include file="../footer.jsp"%>
