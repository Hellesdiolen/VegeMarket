<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- link rel="stylesheet" href="css/bootstrap.min.css"> -->
</head>
<body>
	<div class="pt-5 mt-5 col-md-12">
		<!-- END comment-list -->

		<div class="comment-form-wrap pt-5">
			<div id="insert_comment">
				<form id="commentForm" name="commentForm" method="post" class="p-5">

					<div class="form-group">
						<label for="message">댓글 작성 </label>
						<textarea rows="3" cols="30" id="reply" name="reply" class="form-control"></textarea>
					</div>
					<div class="form-group">
						<input type="button" onClick="save_comment('${productVO.pseq }')" value="등록" class="btn py-3 px-4 btn-primary">
					</div>
					<input type="hidden" id="pseq" name="pseq" value="${productVO.pseq }" />
				</form>
			</div>

			<form id="commentListForm" name="commentListForm" method="post" class="p-5">
				<label style="font-size: 18px; color: black;" for="message">댓글 : <span id="cCnt"></span>
				</label>
				<c:forEach items="commentList" var="commentVO">
					<div id="commentList"></div>
				</c:forEach>
			</form>
		</div>
	</div>

	<script>
		/*
		 * 초기 로딩시 상품평 목록 불러오기
		 */
		$(function() {
			getCommentList();
		});

		function fn_validation() {
			var id = '${sessionScope.loginUser.id}';
			if (id == null || id == '') {
				alert("로그인 후 이용할수 있습니다.");
				return false;
			}
			return true;
		}
		/*
		 * 상품명 등록
		 */
		function save_comment(pseq) {
			if (!fn_validation()) {
				return false;
			}

			$.ajax({
				type : 'POST',
				url : 'save_comment',
				data : $("#commentForm").serialize(), //form 내의 입력 데이터 전송
				success : function(data) {
					if (data = "success") { // 상품명 등록 성공
						alert("댓글이 작성 되었습니다.")
						getCommentList(); //상품평 목록 요청
						$("#reply").val("");
					}
				},
				error : function(request, status, error) {
					alert("error:" + error);
				}

			});

		}
		function delete_comment(comment_seq, writer) {

			if (!fn_validation()) {
				return false;
			}

			var alldata = "comment_seq=" + comment_seq + "&writer=" + writer;

			$.ajax({
				type : 'POST',
				url : 'delete_comment',
				dataType : 'text',
				data : alldata,
				success : function(data) {
					if (data == "success") { // 상품명 등록 성공
						alert("댓글이 삭제되었습니다.");
						getCommentList(); //상품평 목록 요청
						$("#reply").val("");
					} else if (data == "fail") {
						alert("댓글은 본인만 삭제 가능합니다.");
						getCommentList(); //상품평 목록 요청
						$("#reply").val("");
					}
				},
				error : function(request, status, error) {
					alert("error:" + error);
				}

			});

		}

		var click = true;  
		var count = 0;

		function display_comment(comment_seq, writer) {

			var comment_seq = comment_seq;
			var id = '${sessionScope.loginUser.id}';
			var writer = writer;				

			if(writer != id){
				alert("작성자 본인만 댓글 삭제 및 수정가능합니다.");
				return false;				
			}			
			
			if (!fn_validation()) {
				return false;
			}
				
			//넣엇다 지웟다 하는용도
			if(click){
				$("#update_comment_item").remove();
				click = false;
			} else {
				click = true;
				$("#update_comment_item").remove();
				return true;
			}

			
			var html = "";
			html += "<div id=\"update_comment_item\">"
			html += "<form id=\"updateForm\" name=\"updateForm\" method=\"post\" class=\"p-5\">"
			html += "<div class=\"form-group\">"
			html += "<label for=\"message\">댓글 수정</label>"
			html += "<textarea rows=\"3\" cols=\"30\" id=\"reply\" name=\"reply\" class=\"form-control\"></textarea>"
			html += "</div>"
			html += "<div class=\"form-group\">"
			html += "<input type=\"button\" onClick=\"update_comment()\" value=\"등록\" class=\"btn py-3 px-4 btn-primary\">"
			html += "</div>"
			html += "<input type=\"hidden\" id=\"pseq\" name=\"pseq\" value=\"${productVO.pseq }\" />"
			html += "<input type=\"hidden\" id=\"writer\" name=\"writer\" value=\""+writer+"\" />"
			html += "<input type=\"hidden\" id=\"comment_seq\" name=\"comment_seq\" value=\""+comment_seq+"\" />"
			html += "</form>"
			html += "</div>";
			$("#update_comment").append(html); // update_comment에 html추가
		}

		//댓글 수정
		function update_comment() {

			if (!fn_validation()) {
				return false;
			}

			$.ajax({
				type : 'POST',
				url : 'update_comment',
				data : $("#updateForm").serialize(), //form 내의 입력 데이터 전송
				success : function(data) {
					if (data == "success") { // 상품명 등록 성공
						alert("댓글이 수정되었습니다.");
						getCommentList(); //상품평 목록 요청
						$("#reply").val("");
						once = true; // 중복클릭방지용 변수 초기화
					} else if (data == "fail") {
						alert("댓글은 본인만 수정 가능합니다.");
						getCommentList(); //상품평 목록 요청
						$("#reply").val("");
						once = true; // 중복클릭방지용 변수 초기화
					}
				},
				error : function(request, status, error) {
					alert("error:" + error);
				}

			});

		}

		/*
		 * 상품평 목록 불러오기
		 */
		function getCommentList() {

			$.ajax({
						type : 'GET',
						url : 'comment_list',
						dataType : "json",
						data : $("#commentForm").serialize(),
						contentType : "application/x-www-form-urlencoded; charset=UTF-8",
						success : function(data) {
							var html = "";
							var cCnt = data.length;

							if (data.length > 0) {

								html += "<ul class=\"comment-list\">";

								for (i = 0; i < data.length; i++) {
									html += "<li class=\"comment\">";
									html += "<input type=\"hidden\" id=\"comment_seq\" name=\"comment_seq\" value=\""+ data[i].comment_seq+"\">";
									html += "<input type=\"hidden\" id=\"writer\" name=\"writer\" value=\""+ data[i].writer+"\">";
									html += "<div class=\"comment-body\">";
									html += "<div id=\"comment_item\"> <h5>작성자: "
											+ data[i].writer + "</h5></div>"
									html += "<div class=\"meta\">"
											+ displayTime(data[i].regDate)
											+ "<input type=\"button\" class=\"btn py-1 px-1 btn-primary\" value=\"삭제\" onClick =\"delete_comment("
											+ data[i].comment_seq
											+ ",'"
											+ data[i].writer
											+ "')\">"
											+ "<input type=\"button\" class=\"btn py-1 px-1 btn-primary\" value=\"수정\" onClick =\"display_comment("
											+ data[i].comment_seq + ",'"
											+ data[i].writer + "')\">"
											+ "</div>"
									html += "<p>" + data[i].reply + "</p>"
									html += "</div>";
									html += "</li>";

								}
								html += "<div id=\"update_comment\">";
								html += "</div>";
								html += "</ul>";
							} else {
								html += "</ul>";
								html += "<div>";
								html += "<div class=\"col-md-12\"><h5>등록된 상품평이 없습니다.</h5></div>";
								html += "</div>";
							}

							$("#cCnt").html(cCnt); // 상품평의 갯수 출력

							$("#commentList").html(html);
						},
						error : function(request, status, error) {
							alert("상품평 목록을 조회하지 못했습니다.");
						}
					});
		}

		/*
		 * 작성일 출력 함수
		 */

		function displayTime(timeValue) {
			var today = new Date();

			// 24시간 이내인지 계산하기 위함
			var gap = today.getTime() - timeValue;

			var dateObj = new Date(timeValue);
			var str = "";

			// 24시간 이내일 경우 시,분,초만 표시
			if (gap < (1000 * 60 * 60 * 24)) {
				var hh = dateObj.getHours();
				var mi = dateObj.getMinutes();
				var ss = dateObj.getSeconds();

				return [ (hh > 9 ? '' : '0') + hh, ':',
						(mi > 9 ? '' : '0') + mi, ':', (ss > 9 ? '' : '0') + ss ]
						.join('');
			} else {
				var yy = dateObj.getFullYear();
				var mm = dateObj.getMonth() + 1;
				var dd = dateObj.getDate();

				return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/',
						(dd > 9 ? '' : '0') + dd ].join('');
			}
		}
	</script>
</body>
</html>