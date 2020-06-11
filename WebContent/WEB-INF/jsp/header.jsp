<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<header>

	<div class="header_box">

		<h2>
			<a href="top" class="btn-circle-stitch" id="top_link">HOME</a>
		</h2>

		<nav>
			<ul class="nav-list">
				<li class="nav-list-item"><a href="list?page=1"
					class="btn-circle-fishy">一覧・追加</a></li>
				<li class="nav-list-item"><a href="find"
					class="btn-circle-fishy">ユーザ検索</a></li>
				<li class="nav-list-item"><a href="javascript:void(0)"
					id="logout" onclick="logoutConfirm()" class="btn-circle-fishy">ログアウト</a></li>
			</ul>
		</nav>
	</div>
	<script>
		function logoutConfirm() {
			var result = window.confirm("ログアウトします");
			var btn = document.getElementById("logout");
			//alert(result);
			if (result) {
				location.href = "logout";

			} else {

				btn.addEventListener('click', function(e) {
					e.preventDefault();
				}, false);
				//alert("aaaa");
			}
		}
	</script>
</header>
