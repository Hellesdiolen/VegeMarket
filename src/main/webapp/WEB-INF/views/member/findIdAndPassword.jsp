<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">	
<head>
<meta charset="UTF-8">
<title>아이디 , 비밀번호 찾기</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap"
	rel="stylesheet">

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

<script src="js/jquery.min.js"></script>
<script src="js/jquery-migrate-3.0.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/aos.js"></script>
<script src="js/jquery.animateNumber.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/scrollax.min.js"></script>

<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript" src="js/findMemberIdAndPassword.js"></script>
</head>
<body>
		<h1>아이디, 비밀번호 찾기</h1>
		<br>
		<form name="findId" action="find_id" method="get">
			<table>
				<tr>
					<td align="right"><label> 이름</label></td>
					<td><input type="text" name="name" value=""></td>
				</tr>
				<tr>
					<td align="right"><label> 이메일</label></td>
					<td><input type="text" name="email" value=""></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="button"
						value="아이디 찾기" onclick="findMemberId()"></td>
				</tr>
			</table>
		</form>
		<p>
		<p>
		<p>
		<p>
		<p>
		<p>
		<p>
		<p>
		<p>
		<p>
		<p>
		<p>
		<form name="findPW" action="find_password" method="get">
			<table>
				<tr>
					<td align="right"><label> 아이디</label></td>
					<td><input type="text" name="id" value=""></td>
				</tr>
				<tr>
					<td align="right"><label> 이름</label></td>
					<td><input type="text" name="name" value=""></td>
				</tr>
				<tr>
					<td align="right"><label> 이메일</label></td>
					<td><input type="text" name="email" value=""></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="button"
						value="비밀번호 찾기" onclick="findPassword()"></td>
				</tr>
			</table>
		</form>
</body>
</html>