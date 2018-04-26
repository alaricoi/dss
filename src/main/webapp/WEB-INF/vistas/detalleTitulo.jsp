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

<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet"></link>

<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<body>
	<div id="container">
	<div class="page-header center">
			<h2>${titulo.dsTitulo}</h2>
		</div>
	
		<dl class="dl-horizontal">
			<dt>Director</dt>
			<dd>${titulo.dsDirector}</dd>
			<dt>Año</dt>
			<dd>${titulo.nmAnyo}</dd>
			<dt>Genero</dt>
			<dd>${titulo.genero.dsGenero}</dd>
		</dl>
	</div>
</body>
</html>