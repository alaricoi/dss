<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="hidden" id ="currentPage" name="currentPage" value="${currentPage}"/>
		    <input type="hidden" id ="filtrado" name="filtrado" value="${filtrado}"/>
			
        <div class="form-horizontal">
			<div class="col-sm-6">
				<div class="form-group">
					<label class="control-label" for="titulo">Título:</label>
					
						<input type="text" class="form-control" id="titulo"
							placeholder="Filtrar por Titulo" name="titulo" value="${filtro.titulo}">
				
				</div>
				</div>
				<div class="col-sm-6">
				<div class="form-group">
					<label class="control-label" for="director">Director:</label>
					
						<input type="text" class="form-control" id="director"
							placeholder="Filtrar por Director" name="director" value="${filtro.director}">
					
				</div>
				</div>
</div>
				<div class="form-group">
					<div class="col-sm-2">
						<button type="button" class="btn btn-default" onclick="filtrar()">Filtrar</button>
					</div>
				</div>
			

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
									<td>${titulo.dsTitulo}</td>
									<td>${titulo.dsDirector}</td>
									<td>${titulo.nmAnyo}</td>
									<td>${titulo.genero.dsGenero}</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-md-12 text-center">
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
			</div>
			</form>
		</div>


	</c:if>

<script>
function paginar(pagina){
	
	 document.getElementById("currentPage").value = pagina;
	 document.forms["formulario"].submit();
}

function filtrar(){
	
	 document.getElementById("filtrado").value = true;
	 document.forms["formulario"].submit();
}

</script>

</body>
</html>