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
<title>Insert title here</title>
</head>
<body>
<jsp:include page = "./header.jsp" />

<form action="update" method="get">
名前:<input type="text" name="name" value="${user.name }">
ふりがな:<input type="text" name="ruby" value="${user.ruby }">
性別:<select name="gender" >
				<option value="1" <c:if test="${user.gid == 1}"> selected </c:if>>男</option>
				<option value="2" <c:if test="${user.gid == 2}"> selected </c:if>>女</option>
				<option value="3" <c:if test="${user.gid == 3}">selected </c:if>>その他</option>
			</select><br>
会員区分:<select name="uclass" >
				<option value="1" <c:if test="${user.uclass == 1}"> selected </c:if>>子供、シニア</option>
				<option value="2" <c:if test="${user.uclass == 2}"> selected </c:if>>学生</option>
				<option value="3" <c:if test="${user.uclass == 3}">selected </c:if>>一般</option>
			</select>
生年月日:<input type="date" name="birthday" value="${birthday }"><br>
メールアドレス:<input type="email" name="mail" value="${user.mail }"><br>
保有ポイント:<input type="text" name="point" value="${user.point }"><br>
<input type="hidden" name="uid" value="${user.uid }">
<input type="hidden" name="pass" value="${user.password }">
<input type="submit" value="更新">

</form>


</body>
</html>