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
<link href="./css/button.css" rel="stylesheet">
<title>リスト</title>
</head>
<body>
<jsp:include page = "./header.jsp" />
<c:if test="${date1  == null and date2 == null}">
<h1>ユーザ一覧</h1>
<a href="insert" class="btn-square">追加</a>
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
			<th >詳細</th>
			<th >削除</th>

		</tr>
		<c:forEach var="ulist" items="${list}">

			<tr >
				<td><c:out value ="${ulist.uid }" ></c:out></td>
				<td><c:out value ="${ulist.name }"> </c:out> </td>
				<td><c:out value ="${ulist.ruby }"></c:out></td>
				<td><a href="detail?uid=${ulist.uid }" class="btn-square">詳細</a></td>
				<td><a href="delete?uid=${ulist.uid }" class="btn-square-del">削除</a></td>
			</tr>



		</c:forEach>
	</table>

<c:forEach var="i" begin="1" end="${lastPage}" step="1">

<c:choose>
		<c:when test="${i != page}" >
			<a href="list?page=${i}">${i} </a>
		</c:when>
		<c:when test="${i == page}" >
			${i}
		</c:when>
</c:choose>
</c:forEach>


</body>
</html>