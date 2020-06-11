<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">

		<link href="./css/loginstyle.css" rel="stylesheet">
		<title>ログイン</title>
	</head>

	<body>
		<div class="log-form">
		  	<h2>Login to your account</h2>
		  		<form action="login" method= "post">
		    		<input type="text" name = "adminId" title="username" placeholder="username" />
		    		<input type="password" name = "password" title="username" placeholder="password" />
		    		<button type="submit" class="btn">Login</button>
		  		</form>
		  <p> ${mes}</p>
		</div><!--end log form -->
	</body>

</html>