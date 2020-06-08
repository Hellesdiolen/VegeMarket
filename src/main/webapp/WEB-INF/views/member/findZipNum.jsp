<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">	
<head>
<meta charset="UTF-8">
<title>우편 번호 검색</title>

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

<!--  -->
<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript" src="js/mypage.js"></script>

<script type="text/javascript">
function result(zip_num,sido,gugun,dong) {
   opener.document.formm.zip_num.value=zip_num;
   opener.document.formm.addr1.value=sido+" "+gugun+" "+dong;
   self.close();
};
</script>
</head>
<body>
  <h1>우편번호검색</h1>
  <form method=post name=formm action="find_zip_num">
    동 이름 : <input name="dong" type="text">
            <input type="submit" value="찾기"  class="submit">
  </form>
  <table id="zipcode">
    <tr>
      <th>우편번호</th>
      <th>주소</th>
    </tr>
    <c:forEach items="${addressList}" var="addressVO">
    <tr>
      <td>${addressVO.zip_num}</td>
        <td>
          <a href="#" onclick="return result('${addressVO.zip_num}'
,'${addressVO.sido}', '${addressVO.gugun}','${addressVO.dong}')">
            ${addressVO.sido} ${addressVO.gugun} ${addressVO.dong} 
          </a>
        </td>
    </tr>
    </c:forEach>
  </table>
</body>
</html>