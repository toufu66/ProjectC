<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="./css/header.css" rel="stylesheet">
		<link href="./css/top.css" rel="stylesheet">
		<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
		<title>ユーザデータ更新確認</title>
	</head>

	<body>
		<jsp:include page = "./header.jsp" />
		<h1>変更</h1>
		<p>名前：<c:out value="${name}"></c:out></p>
		<p>ふりがな：<c:out value="${ruby }"></c:out></p>
		<p>性別：<c:out value="${genderstr }"></c:out></p>
		<p>誕生日:<c:out value="${birthday }"></c:out></p>
		<p>メールアドレス：<c:out value="${mail }"></c:out></p>
		<p>所有ポイント：<c:out value="${point }"></c:out></p>
		<p>区分：<c:out value="${uclassstr }"></c:out></p>

		<form action="update"method="post">
			<input type="hidden" name="uid" value="${uid }">
			<input type="hidden" name="name" value="${name }">
			<input type="hidden" name="ruby" value="${ruby }">
			<input type="hidden" name="gid" value="${gid }">
			<input type="hidden" name="birthday" value="${birthday }">
			<input type="hidden" name="mail" value="${mail }">
			<input type="hidden" name="point" value="${point }">
			<input type="hidden" name="password" value="${password }">
			<input type="hidden" name="uclass" value="${uclass }">
			<p>更新してもよろしいですか？</p>
			<input type="submit" value="はい">
		</form>

		<form action="detail" method="post">
			<input type="hidden" name="uid" value="${uid }">
			<input type="hidden" name="name" value="${name }">
			<input type="hidden"name="ruby" value="${ruby }">
			<input type="hidden" name="gid" value="${gid }">
			<input type="hidden"name="birthday" value="${birthday }">
			<input type="hidden" name="mail" value="${mail }">
			<input type="hidden"name="point" value="${point }">
			<input type="hidden" name="password" value="${password }">
			<input type="hidden"name="uclass" value="${uclass }">
			<input type="submit" value="いいえ">
		</form>

	</body>
</html>