<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div class="hero-wrap hero-bread"
	style="background-image: url('images/bg_1.jpg');">
	<div class="container">
		<div class="row no-gutters slider-text align-items-center justify-content-center">
			<div class="col-md-9 ftco-animate text-center">
				<p class="breadcrumbs">
					<span class="mr-2"><a href="index">Home</a></span> <span>로그인</span>
				</p>
				<h1 class="mb-0 bread">로그인</h1>
			</div>
		</div>
	</div>
</div>
<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-7 ftco-animate">
				<form action="login" method="post" class="billing-form center-block">
					<h3 class="mb-4 billing-heading">로그인</h3>
					<div class="row align-items-end">
						<div class="col-md-6">
							<div class="form-group">
								<label for="id">ID</label>
								<input type="text" name="id" class="form-control" placeholder="아이디를 입력해주세요">
							</div>
						</div>
						<div class="w-100"></div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="Password">PassWord</label>
								<input type="password" name="pwd" class="form-control"	placeholder="비밀번호를 입력해주세요">
							</div>
						</div>
						<div class="w-100"></div>
						<div class="col-md-12">
							<div class="form-group mt-4">
								<input type="submit" class="btn btn-primary py-2 px-2" value="로그인">
								<input type="button" class="btn btn-primary py-2 px-2" value="회원가입" onclick="location='contract'">
								<input type="button" class="btn btn-primary py-2 px-2" value="아이디 비밀번호 찾기" onclick="find_id_form()">
							</div>
						</div>
					</div>
				</form>
				<!-- END -->
			</div>
		</div>
	</div>
</section>
<!-- .section -->
<%@ include file="../footer.jsp"%>