<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="hero-wrap hero-bread"
	style="background-image: url('images/bg_1.jpg');">
	<div class="container">
		<div
			class="row no-gutters slider-text align-items-center justify-content-center">
			<div class="col-md-9 ftco-animate text-center">
				<p class="breadcrumbs">
					<span class="mr-2"><a href="index">Home</a></span>
				</p>
				<h1 class="mb-0 bread">회원정보수정</h1>
			</div>
		</div>
	</div>
</div>

<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-12 ftco-animate">
				<form id="formm" method="post" name="formm" class="billing-form">
					<fieldset>
						<legend>회원 정보</legend>
						<div class="row align-items-end">
							<div class="col-md-4">
								<div class="form-group">
									<label for="id">ID</label> <input type="text"
										class="form-control" name="id" id="id" value="${MemberVO.id}" readonly="readonly">
										<input type="hidden" name="reid" value="${MemberVO.id}">
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="pwd">변경할 비밀번호</label> <input type="password" name="pwd"
										id="pwd" class="form-control" value="${MemberVO.pwd}">
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="pwdCheck">비밀번호확인</label> <input type="password"
										name="pwdCheck" id="pwdCheck" class="form-control" value="${MemberVO.pwd}">
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="name">이름</label> <input type="text" name="name"
										id="name" class="form-control" readonly="readonly" value="${MemberVO.name}">
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="email">이메일</label> <input type="text" name="email"
										id="email" class="form-control" value="${MemberVO.email}">
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-2">
								<div class="form-group">
									<label for="zip_num">우편번호</label>
									<input type="text"
										class="form-control" name="zip_num" id="zip_num"
										readonly="readonly" value="${MemberVO.zip_num}">
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<input type="button" class="btn btn-primary py-2 px-2"
										value="주소 찾기" onclick="post_zip()">
								</div>
							</div>
							<div class="w-100"></div>
							<div class="w-100"></div>
							<div class="col-md-7">
								<div class="form-group">
									<label>주소(변경시에만 입력)</label> <input type="hidden" name="address" value="${MemberVO.address}">
									<input type="text" class="form-control" name="addr1"
										readonly="readonly">
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<input type="text" class="form-control" name="addr2"
										placeholder="상세주소">
								</div>
							</div>
							<div class="w-100"></div>
					
							<div class="col-md-3">
								<label for="phone">연락처(변경시에만 입력)</label>
									<div class="form-group d-inline-flex" style="vertical-align: middle;">
										<input type="hidden" name="phone" value="${MemberVO.phone}">
										<input type="text" class="form-control" name="phone1" placeholder=""> -
										<input type="text" class="form-control" name="phone2" placeholder=""> -
										<input type="text" class="form-control" name="phone3" placeholder="">												
									</div>
							</div>

						</div>
						<div class="w-100"></div>
						<div class="col-md-12" align="center"><br>
									<input type="button" class="btn btn-primary py-2 px-2 submit" value="정보수정" onclick="go_mod_save()"/>
									<a href="index" class="btn btn-primary py-2 px-2">취소</a>
						</div>
					</fieldset>



				</form>
				<!-- END -->
			</div>
		</div>
	</div>
</section>
<!-- .section -->
<%@ include file="../footer.jsp"%>