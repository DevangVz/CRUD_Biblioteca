<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<%@ page import="org.biblioteca.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
			<c:forEach items="${list}" var="author">
				<tr>
					<td><c:out value="${author.AName}" /></td>
					<td><c:out value="${author.lastName}" /></td>
					<td><c:out value="${author.nationality}" /></td>
					<td><c:out value="${author.DOB}" /></td>
					<td><c:out value="${author.lastName}" /></td>
					<td><a href="../authors/edit/${author.ID}">Edit</a></td>
					<td><a href="../authors/delete/${author.ID}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</br>
		<a href="authors/form/register">Registro Autores</a></br>
		<a href="">Registro de Libros</a></br>
		<a href="">Registro de editoriales</a></br>
		<a href="">Préstamos</a></br>
		<a href="">Registro Usuarios</a></br>
	</body>
</html>