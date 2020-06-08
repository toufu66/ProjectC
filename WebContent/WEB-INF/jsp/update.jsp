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
<form action="update"method="post">
<input type="hidden" name="uid" value="${user.uid }">
ユーザ名:<input type="text" name="name" value="${user.name }"><br>
ふりがな:<input type="text"name="ruby" value="${user.ruby }"><br>
性別:<input type="text" name="gid" value="${user.gid }"><br>
生年月日:<input type="date"name="birthday" value="${user.birthday }"><br>
メールアドレス:<input type="text" name="mail" value="${user.mail }"><br>
保有ポイント:<input type="text"name="point" value="${user.point }"><br>
パスワード:<input type="text" name="password" value="${user.pass }"><br>
区分:<input type="date"name="uclass" value="${user.uclass }"><br>
<input type="submit"value="送信"><br>
</form>
</body>
</html>