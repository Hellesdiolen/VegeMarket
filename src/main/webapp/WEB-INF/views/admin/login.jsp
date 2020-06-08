<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<script type="text/javascript">
function id_check()
{
  if(document.frm.id.value==""){
      alert("아이디를 입력하세요.");
      return false;
  }else if(document.frm.pwd.value==""){
     alert("비밀번호를 입력하세요.");
      return false;
    }
    return true;  
}
</script>
<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-7 ftco-animate">
				<form action="admin_login" method="post" class="billing-form center-block">
					<h3 class="mb-4 billing-heading">관리자 로그인</h3>
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
								<input type="submit" class="btn btn-primary py-2 px-2" value="로그인" onclick="return id_check()">
							</div>
							<h4 style="color:red">${message}</h4>
						</div>
					</div>
				</form>
				<!-- END -->
			</div>
		</div>
	</div>
</section>


<%@ include file="footer.jsp"%>