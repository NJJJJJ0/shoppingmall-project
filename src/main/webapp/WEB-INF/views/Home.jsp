<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
a{
color:white;
}
body{
padding: 0px; margin: 0px;
}
.jb-box{
 width: 100%; height: 80%; overflow: hidden; margin: 0px auto; position: relatives;
 }
video{
width: 100%;
}
.jb-text{
position: absolute; top:50%; width: 100%;
}
.jb-text p {
margin-top: -24px; text-align: center; font-size: 40px; color: #ffffff;
}
.slideshow-container {
	width: 100%;
	height: 300px;
	position: static;
	margin: auto;
	margin-top: 50px;
}
.main_slideImg{
	width: 100%; 
	height: 300px; 
	top : 100px;	
}
.prev, .next {
  cursor: pointer;
  position: absolute;
  text-align : center;
  top: 0;
  top: 20%;
  width: 3%;
  padding: 16px;
  margin-top: -22px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  z-index: 100;
}
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}


</style>
</head>
<body>
<%@ include file="include/menu2.jsp" %>
<div class="jb-box">
<video muted autoplay loop>
<source src="/resources/videos/fendi.mp4" type="video/mp4">
</video>
<div class="jb-text">
<p></p>
</div>
</div>


</body>
</html>