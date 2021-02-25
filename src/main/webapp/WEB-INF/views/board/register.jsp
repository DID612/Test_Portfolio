<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/register" method="post">
    <div class="form-group">
      <label for="usr">제목:</label>
      <input type="text" class="form-control" id="title" name="title" value="${board.title}">
    </div>
    <div class="form-group">
      <label for="pwd">작성자:</label>
      <input type="text" class="form-control" id="writer" name="writer" value="${user.id}" readonly>
    </div>
  	<div class="form-group">
	  <label for="comment">내용:</label>
	  <textarea class="form-control" rows="5" id="content" name="content">${board.content}</textarea>
	</div>
	<button type="submit" class="btn btn-primary">등록</button>  	
  </form>
</body>
</html>