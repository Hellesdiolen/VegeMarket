<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<section class="ftco-section" onload="go_ab()">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-12 ftco-animate">
				<form name="formm" action="" method="post" class="billing-form" enctype="multipart/form-data">
					<fieldset>
						<legend>상품수정</legend>
						<div class="row align-items-end">
							<div class="col-md-2">
								<div class="form-group">
									<label for="kind">상품분류</label> <select name="kind" id="kind" class="form-control">
										<c:forEach items="${kindList}" var="kind" varStatus="status">
											<c:choose>
												<c:when test="${productVO.kind == status.count}">
													<option value="${status.count}" selected="selected">${kind}</option>
												</c:when>
												<c:otherwise>
													<option value="${status.count}">${kind}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-3">
								<div class="form-group">
									<label for="name">상품명</label> <input type="text" class="form-control" name="name" id="name" value="${productVO.name}">
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-2">
								<div class="form-group">
									<label for="price1">원가</label> <input type="text" name="price1" id="price1" class="form-control" onKeyUp='NumFormat(this)' value="${productVO.price1}">
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<label for="price2">판매가</label> <input type="text" name="price2" id="price2" class="form-control" onBlur="go_ab()" onKeyUp='NumFormat(this)' value="${productVO.price2}">
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<label for="price3">판매가-원가[순이익]</label> <input type="text" name="price3" id="price3" class="form-control" value="${productVO.price3}" readonly="readonly" onKeyUp='NumFormat(this)'>
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-2">
								<div class="form-group">
									<c:choose>
										<c:when test="${productVO.useyn eq 'y'}">
											<label for="saleyn">제품사용여부</label>
											<input type="checkbox" name="useyn" id="useyn" class="form-control" checked="checked">
										</c:when>
										<c:otherwise>
											<label for="saleyn">제품사용여부</label>
											<input type="checkbox" name="useyn" id="useyn" class="form-control">
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-2">
								<div class="form-group">
									<c:choose>
										<c:when test="${productVO.saleyn eq 'y'}">
											<label for="saleyn">할인여부</label>
											<input type="checkbox" name="saleyn" id="saleyn" class="form-control" checked="checked">
										</c:when>
										<c:otherwise>
											<label for="saleyn">할인여부</label>
											<input type="checkbox" name="saleyn" id="saleyn" class="form-control">
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<c:choose>
										<c:when test="${productVO.discount> '0'}">
										<label for="discount">할인율(%)</label> <input type="text" name="discount" id="discount" class="form-control" value="${productVO.discount}">
										</c:when>
										<c:otherwise>
										<label for="discount">할인율(%)</label> <input type="text" name="discount" id="discount" class="form-control">
										</c:otherwise>
									</c:choose>
									
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="content">상세설명</label>
									<textarea name="content" id="content" cols="30" rows="10" class="form-control" >${productVO.content}</textarea>
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-4">
								<label for="product_images">상품이미지</label>
								<input type="file" class="form-control" name="product_image">
								<input type="hidden" name="image" value="${productVO.image}">
							</div>
						</div>
						<div class="w-100"></div>
						<div class="col-md-12" align="center">
							<br>
							<input type="button" class="btn btn-primary py-2 px-2 submit" value="수정" onclick="go_mod_save('${productVO.pseq}')" />
							<input type="reset" class="btn btn-primary py-2 px-2" onclick="go_mov()" value="취소" />
						</div>
					</fieldset>

				</form>
				<!-- END -->
			</div>
		</div>
	</div>
</section>

<%@ include file="../footer.jsp"%>