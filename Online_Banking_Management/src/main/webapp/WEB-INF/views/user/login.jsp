<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--Form will be submitted to http://host:port/day14/user/login , method=post --%>
<h5>${requestScope.message}</h5>
	<form  method="post">
		<table style="background-color: #D7BDE2; margin: auto">
			<tr>
				<td>Enter User Email</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="pass" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>

</body>
</html>