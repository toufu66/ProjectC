<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>ユーザ追加</title>
	</head>
	<body>

		<form name="insertform" action="" method="post" >

			<label for="password">パスワード:</label>
			<input type="password" name="password" id="password" required><br>

			<label for="passconf">パスワード（確認）:</label>
			<input type="password" name="passconf" id="passconf" required><br>

			 会員区分
			<select name="uclass">
				<option value="0">子供、シニア</option>
				<option value="1">学生</option>
				<option value="2">一般</option>
			</select><br>
			<input type = "submit" onclick="checkPass()" value = "登録"> <br>
			<div id="errorMessage"></div>
		</form>
		<script>

			function checkPass() {
				// エラーメッセージをクリアする
				//var form = document.forms[0];
				var form = document.insertform;
				form.password.setCustomValidity("");
				//alert(form.password.value);
				//alert(form.passconf.value);
				// パスワードの一致確認
				if (form.password.value != form.passconf.value) {
					  // 一致していなかったら、エラーメッセージを表示する

					  form.passconf.setCustomValidity("パスワードと確認用パスワードが一致しません");
					  return false;
					}
					else{

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