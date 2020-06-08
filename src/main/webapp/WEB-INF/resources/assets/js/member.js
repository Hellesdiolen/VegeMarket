/**
 * 
 */
function go_next() {
	if (document.formm.okon1[0].checked == true) {
		document.formm.action = "join_form"; // 요청 문자열
		document.formm.submit();
	} else if (document.formm.okon1[1].checked == true) {
		alert("약관에 동의하셔야 가입가능 합니다.");
	}
}

function idcheck() {

	if (document.formm.id.value == "") {
		alert("ID를 입력해주세요.");
		document.formm.id.focus();
		return;
	}

	// 중복된 아이디를 확인하는 윈도우를 출력한다.
	var url = "id_check_form?id=" + document.formm.id.value;

	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=350, height=200");

}

function idok() {
	document.formm.action = "id_check_confirmed"; // 요청 문자열
	document.formm.submit();
}

// action: find_zip_num

function post_zip() {

	// 중복된 아이디를 확인하는 윈도우를 출력한다.
	var url = "find_zip_num";

	window
			.open(url, "_blank_2",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=330, height=330");

}

/*
 * 회원가입 완료 버튼
 */
function go_save() {

	if (document.formm.id.value == "") {
		alert("ID를 입력해주세요.");
		document.formm.id.focus();
		return;
	} else if (document.formm.pwd.value == "") {
		alert("password를 입력해주세요.");
		document.formm.id.focus();
		return;
	} else if (document.formm.pwdCheck.value == "") {
		alert("password check를 입력해주세요.");
		document.formm.pwdCheck.focus();
		return;
	} else if (document.formm.name.value == "") {
		alert("이름을 입력해주세요.");
		document.formm.name.focus();
		return;
	} else if (document.formm.email.value == "") {
		alert("email을 입력해주세요.");
		document.formm.email.focus();
		return;
	} else if (document.formm.zip_num.value == "") {
		alert("주소를 입력해주세요.");
		document.formm.zip_num.focus();
		return;
	} else if (document.formm.addr1.value == "") {
		alert("상세주소1을 입력해주세요.");
		document.formm.zip_num.focus();
		return;
	} else if (document.formm.addr2.value == "") {
		alert("상세주소2를 입력해주세요.");
		document.formm.zip_num.focus();
		return;
	} else if (document.formm.phone1.value == "") {
		alert("전화번호 앞자리를 입력해주세요.");
		document.formm.phone1.focus();
		return;
	} else if (document.formm.phone2.value == "") {
		alert("전화번호 중간자리를 입력해주세요.");
		document.formm.phone2.focus();
		return;
	} else if (document.formm.phone3.value == "") {
		alert("전화번호 마지막 자리를 입력해주세요.");
		document.formm.phone3.focus();
		return;
	}
	document.formm.address.value = document.formm.addr1.value + " "
			+ document.formm.addr2.value;
	document.formm.phone.value = document.formm.phone1.value + "-"
			+ document.formm.phone2.value + "-" + document.formm.phone3.value;
	$.ajax({
		type : 'POST',
		url : 'update_member',
		data : $("#join").serialize(), // form 내의 입력 데이터 전송
		success : function(data) {
			if (data = "success") { // 상품명 등록 성공
				alert("회원 가입 완료");
				location.href = "index";
			}
		},
		error : function(request, status, error) {
			alert("error:" + error);
		}

	});
}

/*
 * 회원정보수정 완료 버튼
 */
function go_mod_save() {

	if (document.formm.pwd.value == "") {
		alert("password를 입력해주세요.");
		document.formm.pwd.focus();
		return;
	} else if (document.formm.pwdCheck.value == "") {
		alert("password check를 입력해주세요.");
		document.formm.pwdCheck.focus();
		return;
	} else if (document.formm.pwd.value != document.formm.pwdCheck.value) {
		alert("입력하신 password와 password check값이 다릅니다.");
		document.formm.pwd.focus();
		return;
	} else if (document.formm.name.value == "") {
		alert("이름을 입력해주세요.");
		document.formm.name.focus();
		return;
	} else if (document.formm.email.value == "") {
		alert("email을 입력해주세요.");
		document.formm.email.focus();
		return;
	} else if (document.formm.zip_num.value == "") {
		alert("주소를 입력해주세요.");
		document.formm.zip_num.focus();
		return;

	} else if (document.formm.addr1.value != ""
			&& document.formm.addr2.value != "") {
		if (document.formm.addr1.value == "") {
			alert("상세주소1을 입력해주세요.");
			document.formm.zip_num.focus();
			return;
		} else if (document.formm.addr1.value != ""
				&& document.formm.addr2.value == "") {
			alert("상세주소2를 입력해주세요.");
			document.formm.zip_num.focus();
			return;
		}
		document.formm.address.value = document.formm.addr1.value + " "
				+ document.formm.addr2.value;

	} else if (document.formm.phone1.value != ""
			&& document.formm.phone2.value != ""
			&& document.formm.phone3.value != "") {
		if (document.formm.phone1.value == "") {
			alert("전화번호 앞자리를 입력해주세요.");
			document.formm.phone1.focus();
			return;
		} else if (document.formm.phone2.value == "") {
			alert("전화번호 중간자리를 입력해주세요.");
			document.formm.phone2.focus();
			return;
		} else if (document.formm.phone3.value == "") {
			alert("전화번호 마지막 자리를 입력해주세요.");
			document.formm.phone3.focus();
			return;
		}
		document.formm.phone.value = document.formm.phone1.value + "-"
				+ document.formm.phone2.value + "-"
				+ document.formm.phone3.value;
	}

	$.ajax({
		type : 'POST',
		url : 'update_member',
		data : $("#formm").serialize(), // form 내의 입력 데이터 전송
		success : function(data) {
			if (data = "success") { // 상품명 등록 성공
				alert("회원 정보 수정완료");
				location.href = "index";
			}
		},
		error : function(request, status, error) {
			alert("error:" + error);
		}

	});

	/*
	 * alert("회원 정보 변경 되었습니다."); document.formm.action = "update_member";
	 * document.formm.submit();
	 */
}
