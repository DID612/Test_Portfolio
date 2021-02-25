<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	  <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>내용</th>
	        <th>작성자</th>
	        <th>작성일</th>
	        <th>조회수</th>
	      </tr>
	    </thead>
	    <tbody>
	    <c:forEach items="${list}" var="board">
	      <tr>
	        <td>${board.bNum}</td>
	        <!-- <td><a href="${pageContext.request.contextPath}/board/detail?bNum=${board.bNum}&search=${pm.criteria.search}&type=${pm.criteria.type}">${board.title}</a></td> -->
	        <td><a href="${pageContext.request.contextPath}/detail?bNum=${board.bNum}">${board.title}</a></td>      
	        <td>${board.content}</td>
	        <td>${board.writer}</td>
	        <td>${board.registerDate}</td>
	        <td>${board.views}</td>
	      </tr>
	    </c:forEach>
	    </tbody>
	  </table>
	  <a href="${pageContext.request.contextPath}/register">
	 	 <button type="button" class="btn btn-primary">글쓰기</button>  		  
	  </a>
</body>
</html>