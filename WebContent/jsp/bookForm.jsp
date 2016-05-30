<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.biblioteca.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Book</h1>
	<%--	Author author = (Author) request.getAttribute("author");
	 		out.println(author.getID());
	 		out.println(author.getAName());
		
	--%>
	<form:form method="post" action="../save">
		<form:input type="text" path="ID" />
		<form:label path="title">Title</form:label>
		<form:input type="text" path="title" />
		</br>
		<form:label path="countrycode">Country Code</form:label>
		<form:input type="text" path="countrycode" />
		</br>
		<form:label path="ISBN">ISBN</form:label>
		<form:input type="text" path="ISBN" />
		</br>
		<form:label path="genreID">Genre</form:label>
		<form:input type="text" path="genreID" />
		</br>
		<form:label path="pages">Number of Pages</form:label>
		<form:input type="text" path="pages" />
		</br>
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>