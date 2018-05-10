<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Nuestras Películas favoritas</title>


  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>



		<div class="page-header center">
			<h2>${message}</h2>
		</div>

<ul class="nav nav-pills">	
<sec:authorize access="hasRole('ADMIN')">

  <li role="presentation"><a href="${pageContext.request.contextPath}/admin">Títulos</a></li>
  <li role="presentation"><a href="${pageContext.request.contextPath}/admin/generos">Géneros</a></li>
  <li role="presentation"><a href="#">Usuarios</a></li>


</sec:authorize>

<sec:authorize access="isAnonymous()">

         <li role="presentation"><a href="<c:url value="/login.htm"/>">Login</a></li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">

        <li  role="presentation"><a href="<c:url value="/logout" />">Salir</a></li>
    </sec:authorize>
</ul>
