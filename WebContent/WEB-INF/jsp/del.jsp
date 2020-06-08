<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/header.css" rel="stylesheet">
<title>削除の確認</title>
</head>
<body>
<jsp:include page = "./header.jsp" />
<h1>削除の確認</h1>


<p>以下を削除します。よろしいですか

<p>ユーザID:${user.uid }</p>


<form action="delete" method="post">
<input type="hidden" name="uid" value="${user.uid }">

<input type="submit" value="削除">

</form>

</body>
</html>