<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!--  author  木村 -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="./css/header.css" rel="stylesheet">
		<link href="./css/top.css" rel="stylesheet">
		<title>エラー</title>
	</head>
	<body>
		<jsp:include page = "./header.jsp" />
		<h1 style="color: red; text-align: center">エラー</h1>

		<p style="text-align: center">ごめんなさい、エラーが発生しました。</p>
		<p style="text-align: center">エラー内容：${emsg }</p>

		<p style="text-align: center"><a href="top">戻る</a>
	</body>
</html>