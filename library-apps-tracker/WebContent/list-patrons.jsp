<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*, au.com.nla2.library.*" 
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> NLA Patrons list </title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>National Library Australia2 - Patrons List</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Patron ID</th>
					<th>Patron Name</th>
					<th>Patron Address</th>
					<th>Patron Email</th>
					<th>Action</th>
					
				</tr>
				<c:forEach var="tempPatrons" items="${PATRONS_LIST}">
					<c:url var="selectLink" value="PatronsControllerServlet">
						<c:param name="command" value="LOAD"/>
						<c:param name="patronBook" value="${tempPatrons.patronBook}"/>
					</c:url>
					
					
					<tr>
						<td> ${tempPatrons.patronId} </td>
						<td> ${tempPatrons.name} </td>
						<td> ${tempPatrons.address} </td>
						<td> ${tempPatrons.email} </td>
						<td> <a href="${selectLink}"> Lending Info </a> </td>
					</tr>
				
				</c:forEach>
				
				
			</table>
		</div>
	
	</div>
	
</body>
</html>