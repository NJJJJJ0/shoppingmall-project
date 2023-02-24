<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>상품정보</h2>
<table>
<tr>
	<td><img src="/resources/images/${dto.filename}" width="300px" height="300px"></td>
<td align="center">
<table>
<tr>
<td>상품명</td>
<td>${dto.product_name}</td>
</tr>
<tr>
<td>재고</td>
<td>${dto.amount}</td>
</tr>
<tr>
<td>가격</td>
<td>${dto.price}</td>
</tr>
<tr>
<td>&nbsp;</td>
<td>${dto.description}</td>
</tr>
<tr>
	<td colspan="2">
	<form name="form1" method="post"
	action="/shop/cart/insert.do">
	<input type="hidden" name="product_code" value="${dto.product_code}">
	<select name="amount">
	<c:forEach begin="1" end="10" var="i">
	<option value="${i}">${i}</option>
	</c:forEach>
	</select> &nbsp;개
	<input type="image" src="/resources/images/cart.png" width= "25px" height="25px">
	</form>
	<a href="/product/product/list.do"></a>
	</td>
	</tr>
</table>
</td>
</tr>
</table>


</body>
</html>


















