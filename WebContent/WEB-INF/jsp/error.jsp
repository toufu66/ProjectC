<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー</title>
</head>
<body>
<jsp:include page = "./header.jsp" />

<h1 style="color: red;">エラー</h1>

<p>ごめんなさい、エラーが発生しました。</p>
<p>エラー内容：${msg }</p>

<p><a href="${ url}">戻る</a>
</body>
</html>