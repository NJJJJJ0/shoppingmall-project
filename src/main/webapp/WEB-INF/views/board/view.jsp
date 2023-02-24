<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<script src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<style type="text/css">
@font-face {
	font-family:'Apple_Gothic_Neo';
	src:url('/resources/fonts/AppleSDGothicNeoH.ttf') format('truetype');
	}

#title{
border:none;
border-right:0px; 
border-top:0px;
border-left:0px;
border-bottom:0px;
font-family:'Apple_Gothic_Neo';
background-color: transparent;
}
#writer{
border:none;
border-right:0px; 
border-top:0px;
border-left:0px;
border-bottom:0px;
font-family:'Apple_Gothic_Neo';
background-color: transparent;
}
#filename{
border:none;
border-right:0px; 
border-top:0px;
border-left:0px;
border-bottom:0px;
}
#likedCnt{
border:none;
border-right:0px; 
border-top:0px;
border-left:0px;
border-bottom:0px;
}
textarea {
width:100%;
height: 20em;
border:none;
resize:none;
}
</style>
<script>
$(function(){
	$("#btnList").click(function(){
		location.href="/board/list.do";
	});
	listReply("1");
	$("#btnReply").click(function(){
		reply();
	});	
	$("#btnUpdate").click(function(){
		document.form1.action="/board/update.do";
		document.form1.submit();
	});
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="/board/delete.do";
			document.form1.submit();
		}
	});
	$("#likeBtn").click(function() {
		let idx = $("#idx").val()
		$.ajax({
			url:"/board/like/"+idx,
			success: function(result){
				if(result == "I") {
					let liked = Number($('#likedCnt').val()) + 1;
					alert("좋아요!")
					$('#likedCnt').val(liked);
				} else if (result == "D"){
					let liked = Number($('#likedCnt').val()) - 1;
					alert("좋아요 취소 ㅠㅠ")
					$('#likedCnt').val(liked);
				} else {
					alert("에러발생")
				}
			}
		});
	})
});

function getFileInfo(file_name){
	var get_link="/upload/display_file?file_name="+file_name;
	original_name=file_name.substr(file_name.indexOf("_")+1);
	return {original_name: original_name, get_link:get_link, file_name: file_name};
}
function listAttach(){
	$.ajax({
		type: "post",
		url: "/board/list_attach/${dto.idx}",
		success: function(list){
			$(list).each(function(){
			var fileInfo=getFileInfo(this);
			var html="<div><a href='"+fileInfo.get_link+"'>"+fileInfo.original_name+"</a>&nbsp;&nbsp;";
			html+="<a href='#' class='file_del' data-src='"+this+"'>[삭제]</a></div>";
			$("#uploadedList").append(html);
			});
		}
	});
}
function reply(){
	var reply_text=$("#reply_text").val();
	var board_idx="${dto.idx}";
	var params={"reply_text": reply_text, "board_idx": board_idx};
	$.ajax({
		type:"post",
		url:"/reply/insert.do",
		data:params,
		success:function(){
			alert("댓글이 등록되었습니다.");
			listReply("1");
		}
	});
}

function listReply(num){
	console.log("page:"+"/reply/list.do?board_idx=${dto.idx}&curPage="+num);
	$.ajax({
		url: "/reply/list.do?board_idx=${dto.idx}&curPage="+num,
		success:function(result){
			$("#listReply").html(result);
		}
	});
}

function showModify(idx){
	$.ajax({
		url:"/reply/detail/"+idx,
		success: function(result){
			$("#modifyReply").html(result);
			$("#modifyReply").css("visibility","visible");
		}
	});
}
</script>

</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>게시물 보기</h2>
<input id="idx" type='hidden' value="${dto.idx}">

<form id ="form1" class="form1" name='form1' method="post">
<div>제목:<input name ="title" id="title" value="${dto.title}" > &nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd a HH:mm:ss" /></div>
<div>아이디: <input name="writer" id="writer" value= "${dto.writer}" readonly/>&nbsp;&nbsp;&nbsp;&nbsp; 조회수:${dto.hit}</div>
 <%-- <p class="contents2">${dto.contents}</p><br>
  <input name="contents" type="hidden" value= "${dto.contents}" > --%>
  <textarea name="contents" id="contents" rows="2" cols="80" >${dto.contents}</textarea>
<div>첨부파일&nbsp;&nbsp;<input name ="filename" id="filename" value="${dto.filename}"  readonly></div>
	 <input id="likedCnt" type="number" value="${dto.cnt1}" style="border:none;" readonly />
	 <button id="likeBtn" type="button">좋아요</button>
<div id="uploadedList"></div>
<div>
<input type="hidden" name="idx" value="${dto.idx}">
<c:if test="${sessionScope.userid == dto.writer}">
<button type="button" id="btnUpdate">수정</button>
<button type="button" id="btnDelete">삭제</button>
</c:if>
<button type="button" id="btnList">목록</button>
</div>
</form>

<div id= "listReply"></div>
<div id="modifyReply"></div>
<div style="width:700px; text-align:center;">
<c:if test="${sessionScope.userid != null}">
<textarea rows="5" cols="80" id="reply_text" placeholder="댓글을 작성하세요."></textarea>
<br>
<button type="button" id="btnReply">댓글쓰기</button>
</c:if>
</div>
</body>
