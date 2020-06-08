<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<head>
<title>한다 야채가게를</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/ionicons.min.css">

<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<link rel="stylesheet" href="css/jquery.timepicker.css">


<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/icomoon.css">
<link rel="stylesheet" href="css/style.css">

<!-- 함수 들어가 있는 자바스크립트 -->
<script type="text/javascript" src="js/admin.js"></script>
</head>
<body class="goto-here">
	<header>
		<div class="py-1 bg-primary">
			<div class="container">
				<div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
					<div class="col-lg-12 d-block">
						<div class="row d-flex">
							<div class="col-md pr-3 d-flex topper align-items-center">
								<span class="text">관리자 페이지</span>

							</div>
							<div class="col-md pr-3 d-flex topper align-items-center">
								<div class="icon mr-2 d-flex justify-content-center align-items-center">
									<a href="index"><span class="text">Home</span></a>
								</div>
							</div>
							<div class="col-md pr-3 d-flex topper align-items-center text-lg-right">
								<div class="icon mr-2 d-flex justify-content-center align-items-center">
									<span class="text">${sessionScope.adminUser.name}(${sessionScope.adminUser.id})</span>
								</div>
								<div class="icon mr-2 d-flex justify-content-center align-items-center">
									<span class="icon-registered"></span> <a href="admin_logout"><span class="text">로그아웃</span></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="hero-wrap hero-bread" style="background-image: url('images/bg_2.jpg');">
		<div class="container">
			<div class="row justify-content-center">
				<c:choose>
					<c:when test="${empty sessionScope.adminUser}">
					</c:when>
					<c:otherwise>
						<div class="col-md-10 mb-5 text-center">
							<ul class="product-category">
								<li><a href="admin_product_list" class="active">상품리스트</a></li>
								<li><a href="admin_order_list" class="active">주문리스트</a></li>
								<li><a href="admin_qna_list" class="active">Q&amp;A리스트</a></li>
								<li><a href="admin_member_list" class="active">회원리스트</a></li>
							</ul>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>