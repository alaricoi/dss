<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Géneros</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

	<div id="container">
	<div class="page-header center">
			<h2>${genero.dsGenero}</h2>
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
			<dt>id</dt>
			
			<dd>${genero.idGenero}</dd>
			<dt>Descripción</dt>
		
			<dd>${genero.dsGenero}</dd>
			
		</dl>
	</div>
	
	

</body>
</html>