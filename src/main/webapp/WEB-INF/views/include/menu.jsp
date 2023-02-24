<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <!DOCTYPE html>
<html>
<head> -->
<style type="text/css">
a{
	text-decoration: none; /* 링크의 밑줄 제거 */
  color: inherit; /* 링크의 색상 제거 */
  }
@font-face {
	font-family:'Apple_Gothic_Neo';
	src:url('/resources/fonts/AppleSDGothicNeoH.ttf') format('truetype');
	}

body {
	font-family:'Apple_Gothic_Neo';
   background-color: transparent;
   }
li.menu {
	text-align: center;
	position: absolute;
	left:50%;
	transform: translate(-50%);
	z-index:1;	
	  list-style:none;
}
div.login{
text-align: center;
position: absolute;
right:0px;
	z-index:1;
}

</style>
<!-- </head> -->
<div class = "login" style="text-align:right; margin:0; ">
<c:choose>
<c:when test="${sessionScope.userid == null}">
<a href="/member/write.do">회원가입</a> |
<a href="/member/login.do">로그인</a> | 
<a href="/admin/login.do">관리자 로그인</a> |
</c:when>
<c:otherwise>
${sessionScope.name}님| 
<a href="/member/logout.do">로그아웃</a> | 
<a href="/shop/cart/list.do">장바구니</a>|
</c:otherwise>
</c:choose>

<c:if test="${sessionScope.userid == 'admin'}">
<a href="/product/product/write.do">상품등록</a>
</c:if>

</div>
<!-- <body> -->
<!-- <div style="text-align:center;">
 -->
 
 
 
 <ul class= menu style="margin:0;">
<li class= menu style="margin:0;">
<a href="/member/list.do">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/board/list.do">게시판</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/member/f.do">이벤트</a>&nbsp;&nbsp;</li>

<!-- </div> -->
</ul>



<!-- </body>

</html> -->