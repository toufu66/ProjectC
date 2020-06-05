<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除の確認</title>
</head>
<body>

<h1>削除の確認</h1>


<p>以下を削除します。よろしいですか

<p>ユーザID:${user.uid }</p>


<form action="del" method="post">
<input type="hidden" name="uid" value="${user.uid }">

<input type="submit" value="削除">



</body>
</html>