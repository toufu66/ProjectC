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
<p>名前：${name }</p>
<p>ふりがな：${ruby }</p>
<p>性別：${gid }</p>
<p>誕生日：${birthday }</p>
<p>メールアドレス：${mail }</p>
<p>所有ポイント：${point }</p>
<p>区分：${uclass }</p>

<form action="update"method="post">

<input type="hidden" name="uid" value="${uid }">
<input type="hidden" name="name" value="${name }">
<input type="hidden"name="ruby" value="${ruby }">
<input type="hidden" name="gid" value="${gid }">
<input type="hidden"name="birthday" value="${birthday }">
<input type="hidden" name="mail" value="${mail }">
<input type="hidden"name="point" value="${point }">
<input type="hidden" name="password" value="${password }">
<input type="hidden"name="uclass" value="${uclass }">

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