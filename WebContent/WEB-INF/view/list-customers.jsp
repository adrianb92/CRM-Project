<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
		<title>List Customers</title>
	</head>
	<body>
		<header id="header">
			<h2>CRM Application Demo</h2>
			<h5>by @adrianb92</h5>
		</header>
		
		<section id="container">
			<div id="content">
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>email</th>
					</tr>
					
					<c:forEach var="tempCustomer" items="${customers}">
						<tr>
							<td> ${tempCustomer.firstName}</td>
							<td> ${tempCustomer.lastName}</td>
							<td> ${tempCustomer.email}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</section>
	</body>
</html>