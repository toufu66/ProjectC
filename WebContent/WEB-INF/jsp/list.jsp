<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/header.css" rel="stylesheet">
<link href="./css/list.css" rel="stylesheet">
<title>リスト</title>
</head>
<body>
<jsp:include page = "./header.jsp" />
	<h1>ユーザ一覧</h1>
<a href="insert?uid=${ulist.uid }">追加</a>
	<table>
		<tr >
			<th>ユーザID</th>
			<th>名前</th>
			<th>ふりがな</th>
			<th>詳細</th>
			<th>削除</th>

		</tr>
		<c:forEach var="ulist" items="${list}">

			<tr >
				<td>${ulist.uid }</td>
				<td>${ulist.name }</td>
				<td>${ulist.ruby }</td>
				<td><a href="detail?uid=${ulist.uid }">詳細</a></td>
				<td><a href="delete?uid=${ulist.uid }">削除</a></td>
			</tr>



		</c:forEach>
	</table>
</body>
</html>