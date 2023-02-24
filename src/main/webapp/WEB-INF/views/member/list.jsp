<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/css/list.css?after"/>
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
$(function(){
	$("#slideShow").css("width","700px");
	$("#slideShow").css("height","100px");
	
});

</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %><br>
<%-- <%@ include file="../include/category.jsp" %><br> --%>
<%@ include file="../include/banner.jsp" %>
<div class ="division-line"></div>
<table border ="1"  class= "product">
<tr>
<c:forEach var="row" items="${list}" varStatus="vs">
<td>
<c:choose>
<c:when test="${row.filename != '-'}">
<img src="/resources/images/${row.filename}" width="300px" height="300px" ><br>
</c:when>
<c:otherwise>
[상품 이미지 미등록]<br>
</c:otherwise>
</c:choose>
<a href="/product/product/detail/${row.product_code}">
${row.product_name}<br>
${row.description}<br>
<fmt:formatNumber value="${row.price}" pattern="#,###"/>원</a>
</td>
<c:if test="${vs.count mod 4 ==0}">
</tr><tr>
</c:if>
</c:forEach>
</tr>
</table>
</body>
</html>
