<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type = "text/css">
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
table{
 width :"400px";
 
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
$(function(){
	$("#btnList").click(function(){
	location.href="/shop/product/list.do";
	});

	$("#btnDelete").click(function(){
		if(confirm("장바구니를 비우시겠습니까?")){
		location.href="/shop/cart/deleteAll.do";
		}
	});
	$('#amount').on("change keyup paste",function(){
		alert("수량이 변경되었습니다.");
		document.form1.submit();	
	});
});
function mycount(opt){
	if(opt=="+"){
		$("#amount").val( parseInt($("#amount").val()) + 1);
		(confirm("수량이 변경되었습니다."))
	}else if(opt=="-"){
		$("#amount").val( parseInt($("#amount").val()) - 1);
		(confirm("수량이 변경되었습니다."))
	}
	 document.form1.submit();
}
/* }; */
/* $(function(){

}) 
 */
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>장바구니</h2>
<c:choose>
<c:when test="${map.count == 0}">
장바구니가 비었습니다.
</c:when>
<c:otherwise>
<form name="form1" method="post" action="/shop/cart/update.do">
<table border="1">
<tr>
<th>상품명</th>
<th>단가</th>
<th>수량</th>
<th>금액</th>
<th>&nbsp;</th>
</tr>

<c:forEach var="row" items="${map.list}">
<tr>
<td>${row.product_name}</td>
<td>${row.price}</td>
<td>
<input type="button" value="+" id="btnAdd" onclick='mycount("+")'>
<input type="text" style="width:15px;" min="0" max="100" id="amount" name="amount" value="${row.amt1}">
<input type="button" value="-" id="btnMinus" onclick='mycount("-")'>
<input type="hidden" name="cart_id" value="${row.cart_id}">
</td>
<td>${row.money}</td>
<td>
<a href="/shop/cart/delete.do?cart_id=${row.cart_id}">삭제</a></td>
 </tr>
</c:forEach>
<tr>
<td colspan="5" align="center">
장바구니 금액 합계
<fmt:formatNumber value="${map.sumMoney}"
pattern="#,###,###"/><br>
배송료: ${map.fee}<br>
총합계:
<fmt:formatNumber value="${map.sum}"
pattern="#,###,###"/>
</td>
</tr>
</table>
<!-- <button id ="btnUpdate">수정</button> -->
<button type="button" id="btnDelete">장바구니 비우기</button>
</form>
</c:otherwise>
</c:choose>
</body>
</html>