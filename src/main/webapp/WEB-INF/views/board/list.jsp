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
	  <br>
	  <br>
	  <br>
	  <br>
	  ${index} 인덱스가 머냐
	  ${pm.startPage}스타트
	  ${pm.endPage}엔드
	  
	  
	<ul class="pagination" style="justify-content: center;">
	    <c:if test="${pm.prev}">
	        <li class="page-item">
	            <a class="page-link" href="${pageContext.request.contextPath}/list?page=${pm.startPage-1}">이전</a>
	        </li>
	    </c:if>
		<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="index">
	        <li class="page-item">
	            <a class="page-link" href="${pageContext.request.contextPath}/list?page=${index}">${index}</a>
	        </li>
	    </c:forEach>
<%-- 		<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="index"><!-- i a index 아무거나 상관없음 -->
	    	<c:if test="${index == pm.criteria.page}">
	        	<li class="page-item active"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}&search=${pm.criteria.search}&type=${pm.criteria.type}">${index}</a></li>
	        </c:if>
	        <c:if test="${index != pm.criteria.page}">
	        	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}&search=${pm.criteria.search}&type=${pm.criteria.type}">${index}</a></li>
	        </c:if>
	    </c:forEach> --%>
	    <c:if test="${pm.next}">
	        <li class="page-item">
	            <a class="page-link" href="${pageContext.request.contextPath}/list?page=${pm.endPage+1}">다음</a>
	        </li>
	    </c:if>
	</ul>
</body>
</html>