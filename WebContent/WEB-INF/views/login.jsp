<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>LogIn.html</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
	<form method="POST" action="doLogin">
		<div class="login-form">

			<div class="field">
				<input type="text" name="mail" value="Email">
			</div>

			<div class="field">
				<input type="text" name="password" value="Password">
			</div>

			<button colspan="2" type="submit" value="Submit">Log In</button>

			<p class="message">
				<a href="${pageContext.request.contextPath}/SingUp">or Sing UP
					Now</a>
			</p>
		</div>
	</form>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>

</html>
