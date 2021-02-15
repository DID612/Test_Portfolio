<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" >
</head>
<body>
	<div class="container">
	  <h1>회원가입 페이지</h1>
	  <h5>정보를 정확히 입력해주세요 :</h5>
	  <form action="/action_page.php">
	    <div class="form-group">
	      <label for="usr">아이디:</label>
	      <input type="text" class="form-control" id="usr" name="username">
	    </div>
	    <div class="form-group">
	      <label for="pwd">비밀번호:</label>
	      <input type="password" class="form-control" id="pwd" name="password">
	    </div>
	    <div class="form-group">
	      <label for="pwd2">비밀번호 재입력:</label>
	      <input type="password" class="form-control" id="pwd2" name="password2">
	    </div>
	    <div class="form-group">
	      <label for="age">나이:</label>
	      <input type="text" class="form-control" id="age" name="age">
	    </div>
	    <div class="form-group">
	      <label for="name">이름:</label>
	      <input type="text" class="form-control" id="age" name="age">
	    </div>
	    <div class="form-group">
	      <label for="email">이메일:</label>
	      <input type="email" class="form-control" id="email" name="email">
	    </div>
	    <div class="form-group">
	      <label for="sex">성별:</label>
	      <select class="form-control" id="sex" name="sex">
	        <option>M</option>
	        <option>F</option>
	      </select>
	    </div>
	    <div class="form-group">
	      <label for="pNum">휴대폰 인증:</label>
	      <input type="text" class="form-control" id="pNum" name="pNum">
	    </div>
	    <button type="submit" class="btn btn-primary">Submit</button>
	  
	  </form>
	</div>
	
</body>
</html>