<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/header.css" rel="stylesheet">
<link href="./css/top.css" rel="stylesheet">
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
<title>ユーザデータ削除確認</title>
</head>
<body>
<jsp:include page = "./header.jsp" />
<h1>削除の確認</h1>


<p>以下を削除します。よろしいですか

<p>ユーザID:${user.uid }</p>


<form action="delete" method="post">
<input type="hidden" name="uid" value="${user.uid }">

<input type="submit" value="はい">
</form>
<form action="list" method="post">
<input type="hidden" name="uid" value="${user.uid }">

<input type="submit" value="いいえ">
</form>


</body>
</html>