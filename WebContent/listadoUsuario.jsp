<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de usuarios</title>
<link rel="stylesheet" type="text/css" href="estilos.css">

</head>

<body>

	<div id="header">Cabeceira</div>
	<div id="contedor">
		<div id="menu">
			Menú
			<ul>
				<li><a href="homeUser.jsp">Inicio</a></li>
				<li><a href="ListarCategoria">Ver Categorías</a>
				<li><a href="ListarProductos">Ver Productos</a>
				<li><a href="ListarUsuarios" id="actual">Ver Usuarios</a>
				<li><a href="Tenda">Ir a la tienda</a>
				<li><a href="MostrarMisDatos">Ver mis datos</a>
				<li><a href="Desconectarse"><b>Desconectarse</b></a></li>
				<li><a href="http://www.google.com" target=_blank>Ir a
						Google</a></li>
				<li><a href="http://recursosformacion.com" target=_blank>Ir
						a Recursos Formación</a></li>

			</ul>
		</div>
		<div id="corpo">
			<h1>Usuarios actuales</h1>
			<p>Pulse sobre el nombre de un usuario para modificarlo</p>
			<c:choose>
				<c:when test="${listado != null }">
					<table id="listado">
						<tr>
							<th>ID</th>
							<th>Usuario</th>
							<th>Correo</th>
							<th>Tipo</th>
							<th>Borrar</th>
						</tr>
						<c:forEach var="row" items="${listado}">
							<tr>
								<c:url value="MostrarUser" var="URLmostrar">
									<c:param name="id" value="${row.id_usuario}" />
								</c:url>
								<c:url value="BorrarUser" var="URLborrar">
									<c:param name="id" value="${row.id_usuario}" />
								</c:url>
								<td><c:out value="${row.id_usuario}" /></td>
								<td><a href='<c:out value="${URLmostrar}" />'><c:out
											value="${row.user_nombre}" /></a></td>
								<td><c:out value="${row.user_email}" /></td>
								<td><c:out value="${row.user_tipo }"/></td>
								<td><form action="${URLborrar }" method=post>
										<input type="submit" value="Borrar" class="botonborrar">
									</form></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<p>No hay usuarios que mostrar</p>
				</c:otherwise>
			</c:choose>
			<br> <br> <a href="engadirUsuario.jsp">Crear nuevo usuario</a><br>
			<a href="index.jsp">Volver</a>
		</div>
	</div>
	<div id="pe">Pé</div>

</body>
</html>