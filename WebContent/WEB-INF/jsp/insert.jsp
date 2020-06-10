<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  author  古閑 -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="./css/header.css" rel="stylesheet">
		<link href="./css/top.css" rel="stylesheet">
		<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
		<title>ユーザ追加</title>
	</head>
	<body onload = "datein()">
		<jsp:include page = "./header.jsp" />

		<form name="insertform" action="" method="post">
			氏名 <input type = "text" name = "name" placeholder="蛸崎太郎" required><br>
			ふりがな <input type = "text" pattern="[\u3041-\u3096]*" name = "ruby" placeholder="たこさきたろう" required><br>
			性別
			<select name="gid">
				<option value="1">男</option>
				<option value="2">女</option>
				<option value="3">その他</option>
			</select><br>

			誕生日<input type="date" name="birthday" id="birthday" placeholder="年-月-日" required><br>
			<script>
			function datein() {
			    var today = new Date();
			    today.setDate(today.getDate());
			    var yyyy = today.getFullYear()-24;
			    var mm = ("0"+(today.getMonth()+1)).slice(-2);
			    var dd = ("0"+today.getDate()).slice(-2);
			    document.getElementById("birthday").value=yyyy+'-'+mm+'-'+dd;
			    //document.getElementById("birthday").placeholder=yyyy+'-'+mm+'-'+dd;
			}
			</script>
			メールアドレス<input type="email" name = "mail" placeholder="example@aquarium.com" required><br>


			<label for="pass">パスワード:</label>
			<input type="password" pattern="^[0-9A-Za-z]+$" name="pass" id="pass" required><br>

			<label for="passconf">パスワード（確認）:</label>
			<input type="password" pattern="^[0-9A-Za-z]+$" name="passconf" id="passconf" required><br>

			 会員区分
			<select name="uclass">
				<option value="1">子供、シニア</option>
				<option value="2">学生</option>
				<option value="3">一般</option>
			</select><br>
			<button onclick = "checkPass()">送信</button>

			<div id="errorMessage"></div>
		</form>
		<script>

			function checkPass() {
				// エラーメッセージをクリアする
				//var form = document.forms[0];
				var form = document.insertform;
				//form.passconf.setCustomValidity("");
				//alert(form.pass.value);
				//alert(form.passconf.value);
				// パスワードの一致確認
				if (form.password.value != form.passconf.value) {
					  // 一致していなかったら、エラーメッセージを表示する

					  form.passconf.setCustomValidity("パスワードと確認用パスワードが一致しません");

					  return false;
					}
					else{
						form.passconf.setCustomValidity("");
						form.action="insert";
						form.submit();


					}

			};



			// 入力値チェックエラーが発生したときの処理
			form.addEventListener("invalid", function() {
			  document.getElementById("errorMessage").innerHTML = "入力値にエラーがあります";
			}, false);
		</script>





	</body>
</html>