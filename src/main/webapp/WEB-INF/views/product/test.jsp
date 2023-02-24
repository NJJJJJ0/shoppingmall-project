<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<td>
<c:forEach var="row" items="${list}" varStatus="vs">
<c:choose>
<c:when test="${row.filename != '-'}">
<img src="/resources/images/${row.filename}" width="100px" height="100px"><br>
</c:when>
<c:otherwise>
[상품 이미지 미등록]<br>
</c:otherwise>
</c:choose>
<a href="/product/product/detail/${row.product_code}"><br>
${row.product_name}<br>
<fmt:formatNumber value="${row.price}" pattern="#,###"/>원</a>
<c:if test="${vs.count mod 5 ==0}">
</tr><tr>
</c:if>
</c:forEach>
</tr>
</td>


</body>
</html>