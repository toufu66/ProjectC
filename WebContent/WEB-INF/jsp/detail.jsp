<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="update" method="get">
名前:<input type="text" name="name" value="${user.name }">
性別:<input type="text" name="gender" value="${user.gid }"><br>
会員クラス:<input type="text" name="uclass" value="${user.uclass }"><br>
生年月日:<input type="date" name="birthday" value="${birthday }"><br>
メールアドレス:<input type="email" name="mail" value="${user.mail }"><br>
保有ポイント:<input type="text" name="point" value="${user.point }"><br>
<input type="hidden" name="uid" value="${user.uid }">
<input type="hidden" name="pass" value="${user.password }">
<input type="submit" value="更新">

</form>


</body>
</html>