<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<h5>${sessionScope.message}</h5>
	<%-- <h6>${sessionScope.user_details}</h6>
 --%>
	<h5>Your Account Details</h5>

	<table style="background-color: #D7BDE2; margin: auto">
	<c:forEach var="accHolder" items="${requestScope.accList}">
		<tr>
			<%-- <td>${}</td> --%> 
			<td>${accHolder.accType}</td>
			<td>${accHolder.balance}</td>
		</tr>
		</c:forEach>
	</table>

	Amount:
	<input type="text"></input>
	<h5>
		<input type="button" value="Withdraw"></input> <input type="button"
			value="Deposit"></input> <input type="button" value="Close Account"></input>
		<input type="button" value="Create account"></input> <a
			href="<spring:url value='/user/logout'/>">Logout</a>
	</h5>
</body>
</html>