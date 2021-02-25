<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>

<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${user != null}">
	<h2>
		${user.id}님 환영합니다.
	</h2>
</c:if>


</body>
</html>
