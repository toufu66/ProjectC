<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/header.css" rel="stylesheet">
<link href="./css/table.css" rel="stylesheet">
<link href="./css/top.css" rel="stylesheet">
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
<title>リスト</title>
</head>
<body>
<jsp:include page = "./header.jsp" />
<c:if test="${date1  == null and date2 == null}">
<h1>ユーザ一覧</h1>
<a href="insert?uid=${ulist.uid }">追加</a>
</c:if>
	<c:if test="${date1  != null and date2 != null}">
	<h1>${date1 }～${date2 }の入館者一覧</h1>
	</c:if>
	<c:if test="${date1  == null and date2 != null}">
	<h1>${date2 }以前の入館者一覧</h1>
	</c:if>
	<c:if test="${date1  != null and date2 == null}">
	<h1>${date1 }以降の入館者一覧</h1>
	</c:if>
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

<c:if test="{$page}!=1"><a href="list?page=1">1</a></c:if>
<a href="list?page={$page}">${page} </a>
<c:if test="{$page}!=lastPage"><a href="list?page=${lastPage}">${lastPage}</a></c:if>
</body>
</html>