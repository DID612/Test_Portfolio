<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
	<script src="https://kit.fontawesome.com/b1e3c8f87d.js" crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/rolling.js"></script>	
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
	<a class="prev">
		<i class="fas fa-chevron-circle-left fa-3x"></i>
	</a>
	<a class="next">
		<i class="fas fa-chevron-circle-right fa-3x"></i>
	</a>
	<div class="today-banner-container">
		<ul class="rolling-box">		
			<li class="rolling-banner">
				<img alt="" src="${pageContext.request.contextPath}/resources/image/banner1.jfif">
			</li>
			<li class="rolling-banner">
				<img alt="" src="${pageContext.request.contextPath}/resources/image/banner2.jfif">
			</li>
			<li class="rolling-banner">
				<img alt="" src="${pageContext.request.contextPath}/resources/image/banner3.jfif">
			</li>
			<li class="rolling-banner">
				<img alt="" src="${pageContext.request.contextPath}/resources/image/banner4.jfif">
			</li>
			<li class="rolling-banner">
				<img alt="" src="${pageContext.request.contextPath}/resources/image/banner5.jfif">
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

<script type="text/javascript">

</script>
</body>
</html>
