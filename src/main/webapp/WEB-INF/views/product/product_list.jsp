<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
$(function(){
	$("#btnAdd").click(function(){
		location.href="/shop/product/write.do";
	});
});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<c:if test="${sessionScope.admin_userid != null }">
	<button type="button" id="btdAdd">상품등록</button>
</c:if>
</body>
</html>