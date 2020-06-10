<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>入館日追加用ページ</title>
		<link href="./css/header.css" rel="stylesheet">
	</head>

	<body>
		<jsp:include page = "./header.jsp" />

		<form action="TimeTable" method="post">
		<p>UID:<input type="text" name="uid"></p>
		<p>入館日：<input type="date" name="date" value="${today }"></p>
		<input type="submit" value="追加">
		</form>

	</body>
</html>