<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.id_ok{
color:#008000;
display:none;
}
.id_already{
color:#6A82FB;
display:none;
}
</style>
</head>
<script src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
$(function(){
	$("#alert-success").css("visibility","hidden");
	$("#alert-danger").css("visibility","hidden");
	$("#btnJoin").click(function(){
		var name=$("#name").val();
		var userid=$("#userid").val();
		var pwd1=$("#pwd1").val();
		var pwd2=$("#pwd2").val();
		var postcode=$("#postcode").val();
		var detailAddress=$("#detailAddress").val();
		var tel=$("#tel").val();
		var email=$("#email").val();
		if(name==""){
			alert("이름을 입력하세요."); 
			$("#name").focus();
			return;
			}
		if(userid==""){
			alert("아이디를 입력하세요."); 
			$("#userid").focus();
			return;
		}
		 else if((userid < "0" || userid > "9") && (userid < "A" || userid > "Z") && (userid < "a" || userid > "z")){ 
             alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
             return false;
		  }
		if(pwd1==""){
			alert("비밀번호를 입력하세요."); 
			$("#pwd1").focus();
			return;
		}
		if(pwd2==""){
			alert("비밀번호를 입력하세요."); 
			$("#pwd2").focus();
			return;
		}
		if(pwd1 != "" || pwd2 != ""){
			if(pwd1 == pwd2){
				$("#alert-success").css("visibility","visible");
				$("#alert-danger").css("visibility","hidden");
				$("#submit").removeAttr("disabled");
			} else {
				$("#alert-success").css("visibility","hidden");
				$("#alert-danger").css("visibility","visible");
				$("#submit").attr("disabled","disabled");
				return;
			}
		}
		/* if(form.idDuplication.value != "idCheck"){
             alert("아이디 중복체크를 해주세요.");
             return false;
         }  */
		if(postcode==""){
			alert("우편번호를 입력하세요."); 
			$("#postcode").focus();
			return;
			}
		if(detailAddress==""){
			alert("상세주소를 입력하세요."); 
			$("#detailAddress").focus();
			return;
			}
		if(tel==""){
			alert("전화번호를 입력하세요."); 
			$("#tel").focus();
			return;
			}
		if(email==""){
			alert("이메일 주소를 입력하세요."); 
			$("#email").focus();
			return;
			}
				
		document.form1.action="/member/insert.do";
		document.form1.submit();
		alert("가입을 환영합니다. 로그인 해주세요."); 
	});

});		
 /* function checkId(){
	var id=$('#userid').val();
	$.ajax({
		url:'./idcheck',
		type: 'post',
		data:{id:id},
		success:function(cnt){
			if(cnt==0){
				$('.id_ok').css("display", "inline-block");
				$('.id_already').css("display", "none");
			} else{
				$('.id_already').css("display", "inline-block");
				$('.id_ok').css("display", "none");
				alert("아이디를 다시 입력해주세요");
				$('#userid').val('');
			}
		},
		error:function(){
			alert("에러입니다");
		}
	});
}		  */
function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();        
    }
    
</script>
<body>
<%@ include file="../include/menu.jsp" %><br>
<h2>회원가입</h2>
<form method="post" name="form1" action="/member/insert.do">
<table border="1" width="600px">

<tr>
<td>이름</td>
<td><input name="name" id="name"></td>
</tr>

<tr>
<td>아이디</td>
<td><input type ="text" name="userid" id="userid" oninput="checkId()">
	<!-- <input type="button" value="중복확인" class ="dup" onclick="idCheck()"> -->
	<span class="id_ok">사용 가능한 아이디입니다.</span>
	<span class="id_already">이미 사용중인 아이디 입니다.</span>
</td>
</tr>

<tr>
<td>비밀번호</td>
<td><input type="password" id="pwd1" name="passwd" class="form-control" required/></td>
</tr>

<tr>
<td>비밀번호 확인</td>
<td><input type="password" id="pwd2" name="passwd1" class="form-control"  required/>
<div id ="alert-success">비밀번호가 일치합니다.</div>
<div id="alert-danger">비밀번호가 일치하지 않습니다.</div>
</td>
</tr>

<tr>
<td>주소</td>
<td><input type="text" id="postcode" name="postcode" placeholder="우편번호">
<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="roadAddress"  name="roadAddress" placeholder="도로명주소">
<input type="text" id="jibunAddress" name="jibunAddress"placeholder="지번주소">
<span id="guide" style="color:#999;display:none"></span>
<input type="text" id="detailAddress" name="detailAddress"placeholder="상세주소">
<input type="text" id="extraAddress" name="extraAddress" placeholder="참고항목"></td>
</tr>

<tr>
<td>전화번호</td>
<td><input type="text" name="tel" id ="tel"></td>
</tr>

<tr>
<td>이메일 주소</td>
<td><input name="email" id ="email"></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="button" id="btnJoin" value="확인">
</td>
</tr>

</table>
</form>
</body>
</html>