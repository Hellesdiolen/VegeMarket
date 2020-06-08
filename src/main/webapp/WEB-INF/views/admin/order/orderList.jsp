<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript">
	function go_order_save() {
		var count = 0;
		if (document.formm.result.length == undefined) {
			if (document.formm.result.checked == true) {
				count++;
			}
		} else {
			for (var i = 0; i < document.formm.result.length; i++) {
				if (document.formm.result[i].checked == true) {
					count++;
				}
			}
		}
		if (count == 0) {
			alert("주문처리할 항목을 선택해 주세요.");
		} else {
			document.formm.action = "admin_order_save";
			document.formm.submit();
		}
	}
</script>
<form name="formm" method="post">
	<section class="ftco-section ftco-cart">
		<table class="table">
			<tr class="text-center">
				<td width="642">주문자 ID<input type="text" name="key"> <input class="btn btn-primary" type="button" name="btn_search" value="검색" onClick="go_order_search()">
				<input class="btn btn-primary" type="button" name="btn_total" value="전체보기 " onClick="go_order_total()">

				</td>
			</tr>
		</table>

		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
					<div class="cart-list">
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>주문번호(처리여부)</th>
									<th>주문자ID(이름)</th>
									<th>상품명</th>
									<th>수량</th>
									<th>우편번호</th>
									<th>배송지</th>
									<th>전화</th>
									<th>주문일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${orderList}" var="orderVO">
									<tr class="text-center">
										<td><c:choose>
												<c:when test='${orderVO.result=="1"}'>
													<span style="font-weight: bold; color: blue">${orderVO.odseq}</span>
													(<input type="checkbox" name="result" value="${orderVO.odseq}"> 미처리)
        										</c:when>
												<c:otherwise>
													<span style="font-weight: bold; color: red">${orderVO.odseq}</span>
													(<input type="checkbox" checked="checked" disabled="disabled">처리완료)
       											</c:otherwise>
											</c:choose></td>
										<td>${orderVO.id}(${orderVO.name})</td>
										<td>${orderVO.pname}</td>
										<td>${orderVO.quantity}</td>
										<td>${orderVO.zip_num}</td>
										<td>${orderVO.address}</td>
										<td>${orderVO.phone}</td>
										<td><fmt:formatDate value="${orderVO.indate}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-12" align="right">
				<input type="button" class="btn btn-primary py-3 px-4" value="주문처리(입금확인)" onclick="go_order_save()">
			</div>
		</div>

		<div class="row mt-5">
			<div class="col text-center">
				<div class="block-27">

					<ul>

						<c:if test="${pageMaker.prev}">
							<li><a href="admin_order_list${pageMaker.makeQuery(pageMaker.startPage-1)}">이전</a></li>
						</c:if>

						<!-- 페이지 숫자 표시부분 -->
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
							<li><a href="admin_order_list${pageMaker.makeQuery(index)}">${index}</a></li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li><a href="admin_order_list${pageMaker.makeQuery(pageMaker.endPage+1)}">다음</a></li>
						</c:if>

					</ul>
				</div>
			</div>
		</div>
	</section>
</form>
<%@ include file="../footer.jsp"%>