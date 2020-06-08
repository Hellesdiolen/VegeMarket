/**
 * 
 */

function go_cart(){
	document.formm.action= "cart_insert";	//요청 문자열
	document.formm.submit();
	
}

function go_order(){
	document.formm.action= "go_order";	//요청 문자열
	document.formm.submit();	
}

function add () {
	quantity = document.formm.quantity;
	quantity.value ++ ;

}

function del () {
	quantity = document.formm.quantity;
		if (quantity.value > 1) {
			quantity.value -- ;
		}
}

function go_search() {
	document.formm.action = "go_shop";
	document.formm.submit();
}

function go_total() {
	document.formm.action =  "go_shop";
	document.formm.submit();
}