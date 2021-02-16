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
	  <form action="<%=request.getContextPath()%>/signup" method="post">
	    <div class="form-group">
	      <label for="usr">아이디:</label>
	      <input type="text" class="form-control col-3" id="id" name="id">
	      <button type="button" class="id-check" id="iCheck">중복검사</button>
	    </div>
	    <div class="form-group">
	      <label for="pwd">비밀번호:</label>
	      <input type="password" class="form-control" id="pwd" name="password">
	    </div>
	    <div class="form-group">
	      <label for="pwd2">비밀번호 재입력:</label>
	      <input type="password" class="form-control" id="pwd2" name="password2">
	      <button type="button" class="pw-check" id="pCheck">비밀번호 재확인</button>
	    </div>
	    <div class="form-group">
	      <label for="age">나이:</label>
	      <input type="text" class="form-control" id="age" name="age">
	    </div>
	    <div class="form-group">
	      <label for="name">이름:</label>
	      <input type="text" class="form-control" id="name" name="name">
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
	<script type="text/javascript">
		var iCheck = false;
	
		$('#iCheck').click(function(){
			var id = $('#id').val();
			if(id == ''){
				alert('아이디를 입력하세요')
				return;
			}
			var data
		})
	</script>
</body>
</html>