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
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript" src="js/product.js"></script>
<script type="text/javascript" src="js/mypage.js"></script>
<script type="text/javascript" src="js/findMemberIdAndPassword.js"></script>

</head>
<body class="goto-here">
	<header>
		<div class="py-1 bg-primary">
			<div class="container">
				<div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
					<div class="col-lg-12 d-block">
						<div class="row d-flex">
							<div class="col-md pr-3 d-flex topper align-items-center">
								<div class="icon mr-2 d-flex justify-content-center align-items-center">
									<span class="icon-phone2"></span>
								</div>
								<span class="text">+ 82 10 8211 7604</span>
							</div>
							<div class="col-md pr-3 d-flex topper align-items-center">
								<div class="icon mr-2 d-flex justify-content-center align-items-center">
									<span class="icon-paper-plane"></span> <span class="text">kimkyu0806@email.com</span>
								</div>
							</div>
							<div class="col-md pr-3 d-flex topper align-items-center text-lg-right">
								<c:choose>
									<c:when test="${empty sessionScope.loginUser}">
										<div class="icon mr-2 d-flex justify-content-center align-items-center">
											<span class="icon-registered"></span> <a href="login_form"><span class="text">Login</span></a>
										</div>
										<div class="icon mr-2 d-flex justify-content-center align-items-center">
											<span class="icon-registered"></span> <a href="contract"><span class="text">회원가입</span></a>
										</div>
									</c:when>
									<c:otherwise>
										<div class="icon mr-2 d-flex justify-content-center align-items-center">
											<span class="text">${sessionScope.loginUser.name}(${sessionScope.loginUser.id})</span>
										</div>
										<div class="icon mr-2 d-flex justify-content-center align-items-center">
											<span class="icon-registered"></span> <a href="logout"><span class="text">로그아웃</span></a>
										</div>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
			<div class="container">
				<a class="navbar-brand" href="index">VegeMarket</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
					<span class="oi oi-menu"></span> Menu
				</button>

				<div class="collapse navbar-collapse" id="ftco-nav">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a href="index" class="nav-link">Home</a></li>
						<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="go_shop" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Shop</a>
							<div class="dropdown-menu" aria-labelledby="dropdown04">
								<a href="go_shop" class="dropdown-item">Shopping</a>

							</div></li>
						<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="order_list" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Mypage</a>
							<div class="dropdown-menu" aria-labelledby="dropdown04">
								<a class="dropdown-item" href="cart_list">CartList</a>
								<a class="dropdown-item" href="order_list">진행 중인 주문 내역</a>
								<a class="dropdown-item" href="order_complete">처리된 주문 내역</a>
								<a class="dropdown-item" href="qna_list">Q&amp;A</a>
								<c:choose>
									<c:when test="${empty sessionScope.loginUser}">
									</c:when>
									<c:otherwise>
										<a class="dropdown-item" href="go_check_member">회원정보 수정</a>
									</c:otherwise>
								</c:choose>
							</div></li>
						<c:choose>
							<c:when test="${empty sessionScope.loginUser}">
								<li class="nav-item cta cta-colored"><a href="cart_list" class="nav-link"><span class="icon-shopping_cart"></span>[0]</a></li>
							</c:when>
							<c:otherwise>
								<li class="nav-item cta cta-colored"><a href="cart_list" class="nav-link"><span class="icon-shopping_cart"></span>[${countCart}]</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</nav>
	</header>