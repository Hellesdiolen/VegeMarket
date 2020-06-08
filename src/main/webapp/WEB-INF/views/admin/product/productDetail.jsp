<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<form name="formm" method="post">
	<section class="ftco-section" onload="go_ab()">
		<div class="container">
			<h3 class="mb-0 bread">제품 상세보기</h3>
			<div class="row">
				<!--  <input type="hidden" name="pseq" value="${productVO.pseq}">-->
				<div class="col-lg-6 mb-5 ftco-animate">
					<a href="images/${productVO.image}" class="image-popup"><img src="images/${productVO.image}" class="img-fluid" alt="Colorlib Template"></a>
				</div>
				<div class="col-lg-6 product-details pl-md-5 ftco-animate">
					<h5>상품분류 : ${kind}</h5>
					<h5>상품명 : ${productVO.name}</h5>
					<p>
						<span>원가 : <fmt:formatNumber value="${productVO.price1}" pattern="#,###"></fmt:formatNumber>원
						</span>
					</p>
					<p>
						<span>판매가 : <fmt:formatNumber value="${productVO.price2}" pattern="#,###"></fmt:formatNumber>원
						</span>
					</p>
					<p>
						<span>순이익(판매가 - 원가) : <fmt:formatNumber value="${productVO.price3}" pattern="#,###"></fmt:formatNumber>원
						</span>
					</p>
					<p>상세설명 : ${productVO.content}</p>
					<div class="row mt-4"></div>

					<p>
						<input type="button" class="btn btn-black py-3 px-4" onClick="go_mod('${productVO.pseq}')" value="수정">
						<input type="button" class="btn btn-black py-3 px-4" onClick="go_list('${criteria.pageNum}', '${criteria.numPerPage}')" value="목록으로 돌아가기">
					</p>
				</div>
			</div>			
		</div>
	</section>
</form>
<%@ include file="../footer.jsp"%>