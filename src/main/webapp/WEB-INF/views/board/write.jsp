<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
function board_write(){
	var title=document.form1.title.value;
	var contents=document.form1.contents.value;
if(title==""){
	alert("제목을 입력하세요.");
	document.form1.title.focus();
	return;
}
if(contents==""){
	alert("내용을 입력하세요.");
	document.form1.contents.focus();
	return;
}
document.form1.action="/board/insert.do";
document.form1.submit();
}
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>게시물 작성</h2>
<form id="form1" name="form1" method="post" enctype="multipart/form-data">
<table>
<tr>
<td>제목</td>
<td><input name="title"></td>
</tr>
<tr>
<td>내용</td>
<td><input name="contents"></td>
</tr>
<tr>
<td>이미지</td>
<td><input type="file" name="file1"></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="button" value="등록" onclick="board_write()">
<input type="button" value="목록" onclick="location.href='/board/list.do'">
</td>
</tr>
 </table>
</form>
</body>
</html>