<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Singup.html</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
	<form method="POST" action="NewUserServlet">
		<div class="login-form">

			<div class="field">
				<input type="text" name="mail" value="Email">
			</div>
			<div class="field">
				<input type="text" name="fName" value="First name">
			</div>
			<div class="field">
				<input type="text" name="lName" value="Last name">
			</div>

			<button colspan="2" type="submit" value="Submit">Sing me up!</button>

			<p class="message">
				<a href="${pageContext.request.contextPath}/login">Log In</a>
			</p>
		</div>
	</form>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>

</html>
