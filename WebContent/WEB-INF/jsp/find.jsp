<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--  author  木村 -->
<html>

	<head>
		<meta charset="UTF-8">

		<link href="./css/header.css" rel="stylesheet">
		<link href="./css/top.css" rel="stylesheet">
		<link rel="stylesheet"
			href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
		<title>ユーザ検索フォーム</title>
	</head>

	<body>
		<jsp:include page="./header.jsp" />

		<p style="color: red;">${errormsg}</p>

		<form action="find" method="post">
			<p>
				<input type="radio" name="search" value="0" checked="checked">
				ID検索：<input type="text" name="uid">
			</p>
			<h1></h1>
			<p>
				<input type="radio" name="search" value="1"> 名前と来館日から検索：<br>
				名前：<input type="text" name="name" placeholder="名前">or<input
					type="text" name="ruby" placeholder="ふりがな"><br> 来館日：<input
					type="date" name="date1">～<input type="date" name="date2">
			</p>

			<input type="submit" value="検索">
		</form>

	</body>

</html>