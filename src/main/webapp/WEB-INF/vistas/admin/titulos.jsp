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
	<c:if test="${not empty listaPelis}">
		<div class="container">



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

			<div class="row">
				<div class="table-responsive">
					<table class="table table-striped table-bordered" id="t_titulos"
						style="width: 100%">
						<thead>
							<tr>
								<th>Titulo</th>
								<th>Director</th>
								<th>Año</th>
								<th>Genero</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="titulo" items="${listaPelis}">
								<tr>
									
									
									<td><a href="titulo/${titulo.idTitulo}">${titulo.dsTitulo}</a></td>
									<td><a href="titulo/${titulo.idTitulo}">${titulo.dsDirector}</a></td>
									<td><a href="titulo/${titulo.idTitulo}">${titulo.nmAnyo}</a></td>
									<td><a href="titulo/${titulo.idTitulo}">${titulo.genero.dsGenero}</a></td>
								
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<form class="form-horizontal" action="" method="POST"
					name="paginacion" id="paginacion">
					<sec:csrfInput />

					<input type="hidden" id="currentPage" name="currentPage"
						value="${currentPage}" /> <input type="hidden" id="titulo"
						name="titulo" value="${filtro.titulo}">
					<div class="col-md-12 text-center">
						<input type="hidden" id="director" name="director"
							value="${filtro.director}">

						<ul class="pagination pagination-lg pager" id="myPager">
							<%--For displaying Previous link except for the 1st page --%>
							<c:if test="${currentPage != 1}">
								<li><a href="#" onclick="paginar(${currentPage - 1})">Anterior</a></li>
							</c:if>


							<%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>


							<c:forEach begin="1" end="${noOfPages}" var="i">
								<c:choose>
									<c:when test="${currentPage eq i}">
										<li class="active"><a href="#">${i}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="#" onclick="paginar(${i})">${i}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>


							<%--For displaying Next link --%>
							<c:if test="${currentPage lt noOfPages}">

								<li><a href="#" onclick="paginar(${currentPage + 1})">Siguiente</a></li>
							</c:if>
						</ul>
					</div>
				</form>
			</div>

		</div>


	</c:if>

	<script>
function paginar(pagina){
	
	 document.getElementById("currentPage").value = pagina;
	 document.forms["paginacion"].submit();
}

function filtrar(){
	
	 document.forms["formulario"].submit();
}

</script>

</body>
</html>