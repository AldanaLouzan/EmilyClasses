<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Bookings</title>
    </head>
    <body>
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    </body>
    
    <div class="container">
	<h2>My Bookings</h2>
	<!-- Formulario buscar Estudiante -->
	<form action="booking" method="get" id="searchBookingForm"
		role="form">
		<input type="hidden" id="searchAction" name="searchAction"
			value="searchByName">
		<div class="form-group col-xs-5">
			<input type="text" name="nameClass" id="nameClass"
				class="form-control" required="true"
				placeholder="Write the name of the Class or Id" />
		</div>
		<button type="submit" class="btn btn-info">
			<span class="glyphicon glyphicon-search"></span> Search
		</button>
	</form>

	<form action="booking" method="get">
		<input type="hidden" id="searchAction" name="searchAction"
			value="new"> <br></br>
		<button type="submit" class="btn btn-primary  btn-md">New Booking</button>
	</form>

	<c:if test="${not empty message}">
		<div class="alert alert-success">${message}</div>
	</c:if>
	<form action="booking" method="post" id="bookingForm" role="form">
		<input type="hidden" id="idClass" name="idClass"> <input
			type="hidden" id="action" name="action">
		<c:choose>
			<c:when test="${not empty listaEstudiantes}">
				<table class="table table-striped">
					<thead>
						<tr>
							<td>Id</td>
							<td>Nombre</td>
							<td>Apellido</td>
							<td>Fecha de Nacimiento</td>
							<td>Carrera</td>
							<td>Semestre</td>
							<td>E-mail</td>
						</tr>
					</thead>
					<c:forEach var="estudiante" items="${listaEstudiantes}">
						<c:set var="classSucess" value="" />
						<c:if test="${idClass == estudiante.id}">
							<c:set var="classSucess" value="info" />
						</c:if>
						<tr class="${classSucess}">
							<td><a
								href="estudiante?idEstudiante=${estudiante.id}&buscarAction=buscarPorId">${estudiante.id}</a></td>
							<td>${estudiante.nombre}</td>
							<td>${estudiante.apellido}</td>
							<td>${estudiante.fechaNacimiento}</td>
							<td>${estudiante.carrera}</td>
							<td>${estudiante.semestre}</td>
							<td>${estudiante.email}</td>
							<td><a href="#" id="eliminar"
								onclick="document.getElementById('idEstudiante').value='${estudiante.id}';
            									document.getElementById('action').value='eliminar';
            									document.getElementById('estudianteForm').submit();">
									<span class="glyphicon glyphicon-trash" />
							</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<br>
				<div class="alert alert-info">No se encontraron registros para
					la búsqueda</div>
			</c:otherwise>
		</c:choose>
	</form>
    </div>
    
</html>
