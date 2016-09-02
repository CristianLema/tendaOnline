<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de productos</title>
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
				<li><a href="ListarProductos" id="actual">Ver Productos</a>
				<li><a href="ListarUsuarios">Ver Usuarios</a>
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
			<h1>Productos actuales</h1>
			<p>Pulse sobre el nombre de un producto para verlo completamente
				y/o modificarlo</p>

			<c:choose>
				<c:when test="${vacio == true }">
					<a href="PreEngadirProducto">Crear nuevo producto</a>
					<c:choose>
						<c:when test="${listado != null }">
							<c:forEach var="row" items="${listado}">
								<div class="producto">
									<div class="pro_cabeceira">
										<div class="pro_cab_esq">
											<p>
												<b>ID: <c:out value="${row.id_producto }" /></b>
											</p>
											<p>
												Origen:
												<c:out value="${row.id_pais }" />
											</p>
											<p>
												Categoría:
												<c:out value="${row.id_categoria }" />
											</p>
											<p>
												Producto:
												<c:out value="${row.pro_descripcion }" />
											</p>

										</div>
										<div class="pro_cab_der">
											<p style="font-size: 120%;">
												<b><c:out value="${row.pro_precio }" /> €</b>/
												<c:out value="${row.pro_uniVenta }" />
											</p>
											<p>
												Stock:
												<c:out value="${row.pro_stock }" />
											</p>
										</div>
									</div>

									<div>
										<p>
											<c:out value="${row.desLarga }" />
										</p>
									</div>

									<c:url value="MostrarProducto" var="URLmostrar">
										<c:param name="id" value="${row.id_producto}" />
									</c:url>
									<c:url value="BorrarProducto" var="URLborrar">
										<c:param name="id" value="${row.id_producto}" />
									</c:url>

									<div>
										<form action="${URLmostrar}" method=post>
											<input type="submit" value="Ver completo">
										</form>
										<form action="${URLborrar }" method=post>
											<input type="submit" value="Borrar" class="botonborrar">
										</form>
									</div>

								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<p>No hay productos que mostrar</p>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<p>No hay productos que mostrar, ya que no hay categorías</p>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
	<div id="pe">Pé</div>

</body>
</html>