<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
				<input type="button" value="Add new customer"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button"
				/>
				<form:form action="search" method="POST">
	                <p><strong>Search by name: </strong><input type="text" name="searchName" />
	                <input type="submit" value="Search" class="add-button" /></p>
            	</form:form>
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Edit</th>
					</tr>
					
					<c:forEach var="customer" items="${customers}">
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<tr>
							<td> ${customer.firstName}</td>
							<td> ${customer.lastName}</td>
							<td> ${customer.email}</td>
							<td>
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}" onclick="if (!(confirm('Are you sure to delete this customer?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</section>
	</body>
</html>