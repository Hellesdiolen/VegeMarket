/**
 * 
 */

function allChk(obj) {
	var chkObj = document.getElementsByName("cseq");
	var rowCnt = chkObj.length - 1;
	var check = obj.checked;
	if (check) {
		for (var i = 0; i <= rowCnt; i++) {
			if (chkObj[i].type == "checkbox")
				chkObj[i].checked = true;
		}
	} else {
		for (var i = 0; i <= rowCnt; i++) {
			if (chkObj[i].type == "checkbox") {
				chkObj[i].checked = false;
			}
		}
	}
}

function go_cart_delete() {

	var count = 0;
	/*
	 * 삭제할 항목이 하나일 경우 배열로 체크 되지 않으므로 아래 구문 추가
	 */
	if (document.formm.cseq.length == undefined) {
		if (document.formm.cseq.checked == true) {
			count++;

			document.formm.action = "cart_delete"; // 단일 제품 삭제 요청 문자열
			document.formm.submit();
		}

	}
	/*
	 * 삭제할 항목이 체크되어 있는지 개수 확인
	 */
	for (var i = 0; i < document.formm.cseq.length; i++) {
		if (document.formm.cseq[i].checked == true) {
			count++;
		}
	}

	/*
	 * 삭제 할 항목없이 삭제 버튼 누른 경우
	 */
	if (count == 0) {
		alert("삭제할 항목을 선택 해주세요")
	} else {
		document.formm.action = "cart_delete_Checkbox"; // 요청 문자열
		document.formm.submit();
	}

}

function go_change_quantity() {
	document.formm.action = "change_quantity"; // 요청 문자열
	document.formm.submit();

}
// 기본배송지 , 신규 배송지 div 보엿다안보였다

function div_OnOff(v, id1, id2) {
	// 라디오 버튼 value 값 조건 비교

	if (v == "1") {
		document.getElementById(id1).style.display = ""; // 보여줌
		document.getElementById(id2).style.display = "none";// 숨김

	} else if (v == "2") {
		document.getElementById(id1).style.display = "none"; // 보여줌
		document.getElementById(id2).style.display = "";// 숨김

	}
}

// 주문하기
function go_order_insert() {
	
	
	var chk_radio = document.getElementsByName('destination');

	// 기존 배송지로 체크되어 있는경우
	if (chk_radio[0].checked == true) {
		debugger
		var count=0;
		var totalPrice = document.getElementById('totalPrice').value;
		if (document.formm.memo.value == "") {
			alert("배송 메모를 입력해주세요.");
			document.formm.memo.focus();
			return;
			
		} else if(totalPrice == 0){
			alert("구매할 상품이 없습니다.");
			return;
		} else {
			//구매할 물품 선택을 하나만 했으면 배열안쓴다.
			if (document.formm.cseq.length == undefined) {
				if (document.formm.cseq.checked == true) {
					count++;

					document.formm.action = "order_insert"; // 단일 제품 삭제 요청
																// 문자열
					document.formm.submit();
				}
			 //구매할 물품 두개 이상인 경우는 배열 씀.
			} else {
				for (var i = 0; i < document.formm.cseq.length; i++) {
					if (document.formm.cseq[i].checked == true) {
						count++;
					}
				}
				if (count == 0) {
					alert("구매할 물품을 선택 해주세요")
				} else {
					document.formm.action = "order_insert"; // 요청 문자열
					document.formm.submit();
				}
			}
		}
		//새로운 배송지
	} else{
		
		var count=0;
		var totalPrice = document.getElementById('totalPrice').value;
		if (document.formm.name.value == "") {
			alert("수령인을 입력해주세요.");
			document.formm.name.focus();
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

		} else if (document.formm.zip_num.value == "") {
			alert("주소를 입력해주세요.");
			document.formm.zip_num.focus();
			return;
		} else if (document.formm.addr1.value == "") {
			alert("상세주소1을 입력해주세요.");
			document.formm.addr1.focus();
			return;

		} else if (document.formm.addr2.value == "") {
			alert("상세주소2를 입력해주세요.");
			document.formm.addr2.focus();
			return;
		} else if (document.formm.memo.value == "") {
			alert("배송메모를 입력해주세요.");
			document.formm.memo.focus();
			return;

		} else if(totalPrice == 0){
			alert("구매할 상품이 없습니다.");
			return;
		} else {
			//구매할 물품 선택을 하나만 했으면 배열안쓴다.
			if (document.formm.cseq.length == undefined) {
				if (document.formm.cseq.checked == true) {
					count++;

					document.formm.action = "order_insert"; // 단일 제품 삭제 요청
																// 문자열
					document.formm.submit();
				}
			 //구매할 물품 두개 이상인 경우는 배열 씀.
			} else {
				for (var i = 0; i < document.formm.cseq.length; i++) {
					if (document.formm.cseq[i].checked == true) {
						count++;
					}
				}
				if (count == 0) {
					alert("구매할 물품을 선택 해주세요")
				} else {
					document.formm.address.value = document.formm.addr1.value + " " + document.formm.addr2.value;
					document.formm.phone.value = document.formm.phone1.value + "-" + document.formm.phone2.value + "-" + document.formm.phone3.value;
					
					document.formm.action = "order_insert"; // 요청 문자열
					document.formm.submit();
				}
			}
		}
	}
}