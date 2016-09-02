<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
<link rel="stylesheet" type="text/css" href="estilos.css">

</head>

<body>

	<div id="header">Cabeceira</div>
	<div id="contedor">
		<div id="menu">
			Menú
			<ul>
				<li><a href="index.jsp" id="actual">Inicio</a></li>
				<li><a href="ListarCategoria">Mostrar todas las categorías</a></li>
				<li><a href="ListarProductos">Mostrar todos los productos</a></li>
				<li><a href="http://www.google.com" target=_blank>Ir a
						Google</a></li>
				<li><a href="http://recursosformacion.com" target=_blank>Ir
						a Recursos Formación</a></li>

			</ul>
		</div>
		<div id="corpo">
			Corpo
			<h1>Identifíquese</h1>
			<p>Indique a continuación su nombre de usuario o email y su
				contraseña</p>
			<br>
			<c:choose>
				<c:when test="${error == 1 }">
					<p class="error">Contraseña incorrecta</p>
				</c:when>
				<c:when test="${error == 2}">
					<p class="error">Usuario no registrado</p>
				</c:when>
			</c:choose>
			<form action="IdentificarUsuario" method=post>
				<p>E-mail:</p>
				</br> <input name="user_email" type="text" />
				<p>Contraseña:</p>
				<input name="user_pass" type="password" /></br>
				<input type="submit" value="Identificarse" />
			</form>

			<p>
				Si no está registrado, hágalo <a href="crearUsuario.jsp">aquí</a>
			<p>
		</div>
	</div>
	<div id="pe">Pé</div>

</body>
</html>