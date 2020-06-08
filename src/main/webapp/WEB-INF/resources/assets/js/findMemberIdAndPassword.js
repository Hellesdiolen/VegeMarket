/**
 * 
 */
function find_id_form(){
	
	var url = "find_id_form";
	
	window.open(url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no," +
	"width=550, height=450, top=300, left=300");
		
}

function findMemberId(){
	
	if(document.findId.name.value == ""){
		alert("이름을 입력해주세요.");
		document.findId.name.focus();
		return;
	} else if(document.findId.email.value == ""){
		alert("이메일을 입력해주세요.");
		document.findId.email.focus();
		return;
	} else{
		document.findId.action = "find_id";
		document.findId.submit();
	}
	
}

function findPassword(){
	
	if(document.findPW.id.value == ""){
		alert("아이디를 입력해주세요.");
		document.findPW.id.focus();
		return;
	} else if(document.findPW.name.value == ""){
		alert("이름을 입력해주세요.");
		document.findPW.name.focus();
		return;
	} else if(document.findPW.email.value == ""){
		alert("이메일을 입력해주세요.");
		document.findPW.email.focus();
		return;
	} else{
		document.findPW.action = "find_password";
		document.findPW.submit();
	}
}