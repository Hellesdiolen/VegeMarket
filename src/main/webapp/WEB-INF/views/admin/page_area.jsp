<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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