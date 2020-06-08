<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>変更</title>
</head>
<body>
<h1>変更</h1>
<p>${name }</p>
<p>${ruby }</p>
<p>${gid }</p>
<p>${birthday }</p>
<p>${mail }</p>
<p>${point }</p>
<p>${uclass }</p>

<form action="update"method="post">

<input type="hidden" name="uid" value="${uid }">
<input type="hidden" name="name" value="${name }">
<input type="hidden"name="ruby" value="${ruby }">
<input type="hidden" name="gid" value="${gid }">
<input type="hidden"name="birthday" value="${birthday }">
<input type="hidden" name="mail" value="${mail }">
<input type="hidden"name="point" value="${point }">
<input type="hidden" name="password" value="${password }">
<input type="hidden"name="uclass" value="${uclass }">

更新してもよろしいですか？<input type="submit"value="更新">
</form>
</body>
</html>