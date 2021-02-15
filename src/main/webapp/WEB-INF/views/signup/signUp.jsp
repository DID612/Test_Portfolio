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
	  <h2>Form control: input</h2>
	  <p>The form below contains two input elements; one of type text and one of type password:</p>
	  <form action="/action_page.php">
	    <div class="form-group">
	      <label for="usr">Name:</label>
	      <input type="text" class="form-control" id="usr" name="username">
	    </div>
	    <div class="form-group">
	      <label for="pwd">Password:</label>
	      <input type="password" class="form-control" id="pwd" name="password">
	    </div>
	    <button type="submit" class="btn btn-primary">Submit</button>
	  </form>
	</div>
</body>
</html>