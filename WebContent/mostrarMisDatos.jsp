<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.sopra.tienda.util.Rutinas,com.sopra.tienda.dominio.Usuario" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis Datos</title>
<link rel="stylesheet" type="text/css" href="estilos.css">

</head>

<body>

	<div id="header">Cabeceira</div>
	<div id="contedor">
		<div id="menu">
			Menú
			<ul>
				<li><a href="homeUser.jsp" id="actual">Inicio</a></li>
				<li><a href="Tenda">Ir a la tienda</a>
				<li><a href="Carrito">Ir a mi carrito</a>
				<li><a href="MostrarMisDatos">Ver mis datos</a>
				<li><a href="Desconectarse"><b>Desconectarse</b></a></li>
				<li><a href="http://www.google.com" target=_blank>Ir a
						Google</a></li>
				<li><a href="http://recursosformacion.com" target=_blank>Ir
						a Recursos Formación</a></li>

			</ul>
		</div>
		<div id="corpo">
			<h1>Mis datos</h1>
			<% Usuario user = (Usuario) session.getAttribute("myUser"); %>
			<form action="ModificarDatos" method=post>
				<table>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input name="user_nombre" type="text"
							value="${user.user_nombre }" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><input name="user_email" type="text"
							value="${user.user_email }" /></td>
					</tr>
					<tr>
						<td><label>Tipo:</label></td>
						<td><input name="user_tipo" type="number"
							value="${user.user_tipo }" /></td>
					</tr>
					<tr>
						<td><label>DNI:</label></td>
						<td><input name="user_dni" type="text"
							value="${user.user_dni }" /></td>
					</tr>
					<tr>
						<td><label>Nueva contraseña:</label></td>
						<td><input name="user_pas" type="password" /></td>
					</tr>
					<tr>
						<td><label>Fecha de alta:</label></td>
						<td><input name="user_fecAlta" type="text" value="<%Rutinas.convierteAString(user.getUser_fecAlta()); %>" readonly /></td>
					</tr>
					<tr>
						<td><label>Fecha de confirmación:</label></td>
						<td><input name="user_fecConfirmacion" type="text" value="<%Rutinas.convierteAString(user.getUser_fecConfirmacion()); %>" readonly /></td>
					</tr>
				</table>
				<input name="id_usuario" type="hidden"
					value="${MostrarUser.id_usuario }" /> <input type="submit"
					value="Guardar" />
			</form>

		</div>
	</div>
	<div id="pe">Pé</div>

</body>
</html>