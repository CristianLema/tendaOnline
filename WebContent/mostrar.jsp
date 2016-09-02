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
				<li><a href="engadir.jsp">Crear nueva categor�a</a></li>
				<li><a href="ListarCategoria" id="actual">Mostrar todas las
						categor�as</a></li>
				<li><a href="http://www.google.com" target=_blank>Ir a
						Google</a></li>
				<li><a href="http://recursosformacion.com" target=_blank>Ir
						a Recursos Formaci�n</a></li>

			</ul>
		</div>
		<div id="corpo">
			<h1>Modificar Categor�a</h1>
			<p>Categor�a ID="${MostrarCategoria.id_categoria}"</p>
			<p>Nombre actual: "${MostrarCategoria.cat_nombre }"</p>
			<p>Descripci�n actual: "${MostrarCategoria.cat_descripcion }"</p>
			<br>
			<form action="Modificar" method=post>
				<label>Nuevo nombre:</label></br> <input name="cat_nombre" type="text" value="${MostrarCategoria.cat_nombre }"/></br>
				</br> <label>Nueva descripci�n:</label></br> <input name="cat_descripcion"
					type="text" value="${MostrarCategoria.cat_descripcion }"/></br>
					<input name="id_categoria" type="hidden" value="${MostrarCategoria.id_categoria }"/>
					<input type="submit" value="Enviar" />
			</form>
			<br>

		</div>
	</div>
	<div id="pe">P�</div>

</body>
</html>