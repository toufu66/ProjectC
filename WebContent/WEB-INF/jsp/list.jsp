<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>リスト</title>
</head>
<body>
	<h1>ユーザ一覧</h1>

	<table>
		<tr>
			<th>ユーザID</th>
			<th>名前</th>
			<th>ふりがな</th>
		</tr>
		<c:forEach var="ulist" items="${list}">

			<tr>
				<td>${ulist.uid }</td>
				<td>${ulist.name }</td>
				<td>${ulist.ruby }</td>
				<td><a href="delete?uid=${ulist.uid }">削除</a></td>
			</tr>



		</c:forEach>
	</table>
</body>
</html>