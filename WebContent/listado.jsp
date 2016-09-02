<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeiro HTML noso</title>
<link rel="stylesheet" type="text/css" href="estilos.css">

</head>

<body>

	<div id="header">Cabeceira</div>
	<div id="contedor">
		<div id="menu">
			Men�
			<ul>
				<li><a href="ListarCategoria" id="actual">Mostrar todas las
						categor�as</a></li>
				<li><a href="http://www.google.com" target=_blank>Ir a
						Google</a></li>
				<li><a href="http://recursosformacion.com" target=_blank>Ir
						a Recursos Formaci�n</a></li>

			</ul>
		</div>
		<div id="corpo">
			<h1>Categor�as actuales</h1>
			<p>Pulse sobre el nombre de una categor�a para modificarla</p>
			<c:choose>
				<c:when test="${listado != null }">
					<table id="listado">
						<tr>
							<th>ID</th>
							<th>Categor�a</th>
							<th>Descripci�n</th>
							<th>Borrar</th>
						</tr>
						<c:forEach var="row" items="${listado}">
							<tr>
								<c:url value="MostrarCat" var="URLmostrar">
									<c:param name="id" value="${row.id_categoria}" />
								</c:url>
								<c:url value="Borrar" var="URLborrar">
									<c:param name="id" value="${row.id_categoria}" />
								</c:url>
								<td><c:out value="${row.id_categoria}" /></td>
								<td><a href='<c:out value="${URLmostrar}" />'><c:out
											value="${row.cat_nombre}" /></a></td>
								<td><c:out value="${row.cat_descripcion}" /></td>
								<td><form action="${URLborrar }" method=post>
										<input type="submit" value="Borrar" class="botonborrar">
									</form></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<p>No hay categor�as que mostrar</p>
				</c:otherwise>
			</c:choose>
			<br> <br> <a href="engadir.jsp">Crear nueva categor�a</a><br>
			<a href="index.jsp">Volver</a>
		</div>
	</div>
	<div id="pe">P�</div>

</body>
</html>