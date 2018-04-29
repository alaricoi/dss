<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Película</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

	<div id="container">
	<div class="page-header center">
			<h2>${titulo.dsTitulo}</h2>
		</div>
	<ul class="nav nav-pills">
<sec:authorize access="isAnonymous()">

         <li role="presentation"><a href="<c:url value="/login.htm"/>">Login</a></li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">

        <li  role="presentation"><a href="<c:url value="/logout" />">Salir</a></li>
    </sec:authorize>
     <li  role="presentation"><a href="<c:url value="/" />">Volver</a></li>
</ul>
		<dl class="dl-horizontal">
			<dt>Director</dt>
			<dd>${titulo.dsDirector}</dd>
			<dt>Año</dt>
			<dd>${titulo.nmAnyo}</dd>
			<dt>Genero</dt>
			<dd>${titulo.genero.dsGenero}</dd>
			<dt>Sinopsis</dt>
			<dd>${titulo.tlSinopsis}</dd>
			<dt>Repato</dt>
			<dd>${titulo.tlReparto}</dd>
		</dl>
	</div>
	
	<c:choose>
	
		<c:when test="${not empty opiniones}">
			<h3>Opiniones</h3>
		<c:forEach var="opinion" items="${opiniones}">
		<dl class="dl-horizontal">
		<dt>usuario</dt>
		  <dd>${opinion.user.email}</dd>
		<dt>valoracion</dt>
		  <dd>${opinion.nmOpinion}</dd>
		 <dt>texto</dt>
		  <dd>${opinion.tlOpinion}</dd>
		  </dl>
		</c:forEach>
		
		</c:when>
		<c:otherwise>
		  			<h3>Sin Opiniones</h3>
		</c:otherwise>
	</c:choose>

</body>
</html>