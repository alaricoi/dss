<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	

<!DOCTYPE html>
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
<div class="container">


<%@ include file="template/cabecera.jsp" %>

<sec:authorize access="hasRole('ADMIN')">
		

				<button type="button" class="btn btn-default"  onclick="preparaAlta()"
					data-toggle="modal"  data-target="#myModal">
      Alta <span class="glyphicon glyphicon-plus"></span>
      </button>


<form name="genero" action="${pageContext.request.contextPath}/admin/generos/alta" method="post">
<sec:csrfInput />

<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">


    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title" id="titulo">Actualiza Género</h4>
      </div>
      <div class="modal-body" id="contenido">
      <input type="hidden" id="idGenero" name="idGenero"/>
   
   
			<label for="dsGenero">Descripción</label>
		 <input type="text" id="dsGenero" name="dsGenero" maxlength="45"/></dd>
			
	
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        <input  type="submit"  id="submit" name="submit"
         class="btn btn-default"  value="Aceptar"/>
      </div>
    </div>

  </div>
</div>
</form>
<form name="generoBaja" action="" method="post">
<sec:csrfInput />
<div id="bajaModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

 
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title" id="titulo">Baja Género</h4>
      </div>
      <div class="modal-body" id="contenido">
      <h3 id="texto"></h3>
      <input type="hidden" id="idGeneroBaja" name="idGenero"/>	
	<input type="hidden" id="dsGeneroBaja" name="dsGenero"/>		
		 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        <input  type="submit"  id="submit" name="submit"
         class="btn btn-default"  value="Aceptar"/>
      </div>
    </div>

  </div>
</div>


</form>
</sec:authorize>
 <p class="bg-danger">${error}</p>
	<c:if test="${not empty listaGeneros}">
		<div class="container">
			<div class="row">
				<div class="table-responsive">
					<table class="table table-striped table-bordered" id="t_titulos"
						style="width: 100%">
						  <caption>Generos</caption>
						<thead>
							<tr>
								<th>id</th>
								<th>Descripción</th>
								
								<sec:authorize access="hasRole('ADMIN')">
									<td></td>
									</sec:authorize>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="genero" items="${listaGeneros}">
								<tr>


									<td><a href="genero/${genero.idGenero}">${genero.idGenero}</a></td>
							       <td><a href="genero/${genero.idGenero}">${genero.dsGenero}</a></td>
									
									<sec:authorize access="hasRole('ADMIN')">
										<td style="width:10%">
										<button type="button" class="btn btn-default"
										data-toggle="modal"  data-target="#myModal"
										onclick="preparaMod('${genero.idGenero}','${genero.dsGenero}')">
     										 <span class="glyphicon glyphicon-pencil"></span>
   										 </button>
 										<button type="button" class="btn btn-default"
 										data-toggle="modal"  data-target="#bajaModal"
											onclick="preparaBaja('${genero.idGenero}','${genero.dsGenero}')">
      										<span class="glyphicon glyphicon-trash"></span>
    									</button>
										</td>
									</sec:authorize>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			

					
					
			</div>

		</div>


	</c:if>
</div>

<sec:authorize access="hasRole('ADMIN')">
	<script>
function preparaAlta(){
	 document.forms["genero"].action ="${pageContext.request.contextPath}/admin/generos/alta";
	 
}
function preparaMod(idGenero, dsGenero){
	 document.forms["genero"].action ="${pageContext.request.contextPath}/admin/generos/mod";
	 document.getElementById("idGenero").value = idGenero;
	 document.getElementById("dsGenero").value = dsGenero;
	 
}

function preparaBaja(idGenero, dsGenero){
	 document.forms["generoBaja"].action ="${pageContext.request.contextPath}/admin/generos/baja";
	 document.getElementById("idGeneroBaja").value = idGenero;
	 document.getElementById("dsGeneroBaja").value = dsGenero;
	document.getElementById('texto').innerHTML = '¿Desea borrar "'+ dsGenero +'"?';
}

	</script>

</sec:authorize>
</body>
</html>