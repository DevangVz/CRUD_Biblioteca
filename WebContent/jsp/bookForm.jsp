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
		
		<form:select  path="countrycode">
			<c:forEach items="${Countries}" var="country">
				<form:option value="${country}" >${country} </form:option>
			</c:forEach>
		</form:select>
		</br>
		<select  name="publisherID">
			<c:forEach items="${PublisherList}" var="publisher2">
				<option value="${publisher2.ID}">${publisher2.PName}</option>
			</c:forEach>
		</select>
		</br>
		<select  name="authors" multiple>
			<c:forEach items="${AuthorList}" var="author">
				<option value="${author.ID}">${author.lastName}, ${author.aName}  </option>
			</c:forEach>
		</select>
		</br>
		<form:select  path="genreID">
			<c:forEach items="${GenreList}" var="genre">
				<form:option value="${genre.ID}" >${genre.genreName} </form:option>
			</c:forEach>
		</form:select>
		
		</br>
		<form:label path="ISBN">ISBN</form:label>
		<form:input type="text" path="ISBN" />
		</br>
	
		<form:label path="pages">Number of Pages</form:label>
		<form:input type="text" path="pages" />
		</br>

		<label name="publishedDate">Publication Date</label>
		<input type="date" name="publishedDate" />
		</br>
 
		<label name="numEdition">Edition Number</label>
		<input type="text" name="numEdition" />
		</br>

		<input type="submit" value="Save" />
	</form:form>
</body>
</html>