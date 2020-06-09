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
				<c:forEach var="glist" items="${glist}">
				<option value="${glist.gid }" <c:if test="${user.gid == glist.gid}"> selected </c:if>>${glist.gender }</option>
				</c:forEach>
			</select><br>
会員区分:<select name="uclass" >
				<c:forEach var="uclist" items="${uclist}">
				<option value="${uclist.cid }" <c:if test="${user.uclass == uclist.cid}"> selected </c:if>>${uclist.uclass }</option>
				</c:forEach>
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

