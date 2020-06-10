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
<title>ユーザデータ更新確認</title>
</head>
<body>
<jsp:include page = "./header.jsp" />
<h1>変更</h1>
<p>名前：${name }</p>
<p>ふりがな：${ruby }</p>
<p>性別：${genderstr }</p>
<p>誕生日：${birthday }</p>
<p>メールアドレス：${mail }</p>
<p>所有ポイント：${point }</p>
<p>区分：${uclassstr }</p>




<form action="update2"method="post">

<input type="hidden" name="uid" value="${uid }">
<input type="hidden" name="name" value="${name }">
<input type="hidden" name="ruby" value="${ruby }">

<input type="hidden" name="gid" value="${gid }">
<input type="hidden" name="birthday" value="${birthday }">
<input type="hidden" name="mail" value="${mail }">
<input type="hidden" name="point" value="${point }">
<input type="hidden" name="password" value="${password }">
<input type="hidden" name="uclass" value="${uclass }">

<p>更新してもよろしいですか？</p>

<input type="submit" value="はい">

</form>
<form action="detail" method="post">
<input type="hidden" name="uid" value="${uid }">
<input type="hidden" name="name" value="${name }">
<input type="hidden"name="ruby" value="${ruby }">
<input type="hidden" name="gid" value="${gid }">
<input type="hidden"name="birthday" value="${birthday }">
<input type="hidden" name="mail" value="${mail }">
<input type="hidden"name="point" value="${point }">
<input type="hidden" name="password" value="${password }">
<input type="hidden"name="uclass" value="${uclass }">

<input type="submit" value="いいえ">

</form>
</body>
</html>