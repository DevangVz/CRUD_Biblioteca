<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.biblioteca.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Registra Autor</h1>
<%-- 			<% Author author = (Author) request.getAttribute("author");  --%>
// 		out.println(author.getID());
// 		out.println(author.getAName());
		
<%-- 		%> --%>
		<form:form method="post" action="../save" >
			Valor es igual= ${author.ID}
			<form:input type="text"  path="ID"   /> 
			<form:label path="aName">Name</form:label>
			<form:input type="text"  path="aName" /> </br>
			<form:label path="lastName">Last Name</form:label>
			<form:input type="text" path="lastName"/> </br>
			<form:label path="DOB">Date Of Birth</form:label>
			<form:input type="date"  path="DOB"/> </br>
			<form:label path="nationality">Nationality</form:label>
			<form:input type="text"  path="nationality" /> </br>	
			<input type="submit" value="Save" />
		</form:form>	
	</body>
</html>
