<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>

<div class="navigation-box">
	<div class="category">
		<button>전체 카테고리</button>
	</div>
	<div class="all-service">
		<ul>
			<li>
				<a href="#">베스트</a>
			</li>
			<li>
				<a href="#">세일</a>
			</li>
			<li>
				<a href="#">이벤트</a>
			</li>
			<li>
				<a href="#">공지사항</a>
			</li>
		</ul>
	</div>
</div>
<div class="today-banner-wrap">
	<div class="today-banner-container">
		<ul>
			<li>
				<img alt="" src="../image/banner1.png">
			</li>
			<li>
				<img alt="" src="../image/banner2.png">
			</li>
			<li>
				<img alt="" src="../image/banner3.png">
			</li>
			<li>
				<img alt="" src="../image/banner4.png">
			</li>
			<li>
				<img alt="" src="../image/banner5.png">
			</li>
		</ul>
	</div>
</div>
<P>  The time on the server is ${serverTime}. </P>

<c:if test="${user != null}">
	<h2>
		${user.id}님 환영합니다.
	</h2>
</c:if>


</body>
</html>
