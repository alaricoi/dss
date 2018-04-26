<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Nuestras Películas favoritas</title>
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet"></link>

<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body>
	<div id="container">
		<div class="page-header center">
			<h2>${message}</h2>
		</div>

	</div>
	
	
	<form class="form-horizontal" action="" method="POST" id="formulario">
				<sec:csrfInput />


				<div class="form-horizontal">
					<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label" for="titulo">Título:</label> <input
								type="text" class="form-control" id="titulo"
								placeholder="Filtrar por Titulo" name="titulo"
								value="${filtro.titulo}">

						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label" for="director">Director:</label> <input
								type="text" class="form-control" id="director"
								placeholder="Filtrar por Director" name="director"
								value="${filtro.director}">

						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2">
						<button type="button" class="btn btn-default" onclick="filtrar()">Filtrar</button>
					</div>
				</div>
			</form>
	
	
<%@ include file="template/listaTitulos.jspf" %>


</body>
</html>