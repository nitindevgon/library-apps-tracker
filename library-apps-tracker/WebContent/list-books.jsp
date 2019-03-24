<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*, au.com.nla2.library.*" 
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title> NLA Books list </title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%-- <%
	//get the students from the request object (sent by servlet)
	List<Books> theBooks =  (List<Books>) request.getAttribute("BOOKS_LIST");
%>
 --%>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>National Library Australia2 - Books List</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Book ID</th>
					<th>Book Title</th>
					<th>Book Author</th>
					<th>Book ISBN</th>
				</tr>
				<c:forEach var="tempBooks" items="${BOOKS_LIST}">
					
					<tr>
						<td> ${tempBooks.bookId} </td>
						<td> ${tempBooks.bookTitle} </td>
						<td> ${tempBooks.bookAuthor} </td>
						<td> ${tempBooks.bookISBN} </td>
					</tr>
				
				</c:forEach>
				
				
			</table>
		</div>
	
	</div>
	
</body>
</html>