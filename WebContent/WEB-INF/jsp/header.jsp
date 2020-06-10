<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<header>
	<script>
		function logoutConfirm(){
			var result = window.confirm("ログアウトします");
			var btn= document.getElementById("logout");
			if(result){
				btn.href="logout";

			}else{
				//btn.href="";
				btn.preventDefault();
			}
	}
	</script>
		<div class="header_box">
		<div class="2top">
			<h1>
				<a href="top" id ="top_link">多田野水族館web会員管理システム</a>
			</h1>
			</div>
			<nav>
				<ul class="nav-list">
					<li class="nav-list-item"><a href="list?page=1" class="btn-circle-fishy">一覧・追加</a></li>
					<li class="nav-list-item"><a href="find" class="btn-circle-fishy">ユーザ検索</a></li>
					<li class="nav-list-item"><a type = "button" id="logout" onclick="logoutConfirm()" class="btn-circle-fishy">ログアウト</a></li>
				</ul>
			</nav>
		</div>
	</header>
