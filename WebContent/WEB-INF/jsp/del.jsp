<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  author  田尻 -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="./css/header.css" rel="stylesheet">
		<link href="./css/top.css" rel="stylesheet">
		<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
		<link href="./css/del.css" rel="stylesheet">
		<title>ユーザデータ削除確認</title>
	</head>
	<body>
		<jsp:include page="./header.jsp" />
		<h1>削除の確認</h1>
		<p>以下を削除します。よろしいですか
		<p>ユーザID:${user.uid }</p>
		<p>名前：${name }</p>
		<p>ふりがな：${ruby }</p>
		<p>性別：${genderstr }</p>
		<p>誕生日：${birthday }</p>
		<p>メールアドレス：${mail }</p>
		<p>所有ポイント：${point }</p>
		<p>区分：${uclassstr }</p>

		<table>
			<tr>
				<th>
					<form action="delete" method="post">
						<input type="hidden" name="uid" value="${user.uid }">
						<input type="submit" value="はい">
					</form>
				</th>
				<th>
					<form action="list" method="get">
						<input type="hidden" name="page" value="1">
						<input type="submit" value="いいえ">
					</form>
				</th>
			</tr>
		</table>
</body>
</html>