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
			Menú
			<ul>
				<li><a href="engadir.jsp">Crear nueva categoría</a></li>
				<li><a href="ListarCategoria" id="actual">Mostrar todas las
						categorías</a></li>
				<li><a href="http://www.google.com" target=_blank>Ir a
						Google</a></li>
				<li><a href="http://recursosformacion.com" target=_blank>Ir
						a Recursos Formación</a></li>

			</ul>
		</div>
		<div id="corpo">
			<h1>Mis datos</h1>
			<form action="ModificarDatos" method=post>
				<table>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input name="user_nombre" type="text"
							value="${MostrarUser.user_nombre }" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><input name="user_email" type="text"
							value="${MostrarUser.user_email }" /></td>
					</tr>
					<tr>
						<td><label>Tipo:</label></td>
						<td><input name="user_tipo" type="number"
							value="${MostrarUser.user_tipo }" /></td>
					</tr>
					<tr>
						<td><label>DNI:</label></td>
						<td><input name="user_dni" type="text"
							value="${MostrarUser.user_dni }" /></td>
					</tr>
					<tr>
						<td><label>Nueva contraseña:</label></td>
						<td><input name="user_pas" type="password" /></td>
					</tr>
					<tr>
						<td><label>Fecha de alta:</label></td>
						<td><input name="user_fecAlta" type="text" value="${Rutinas.convierteAString(MostrarUser.user_fecAlta) }" readonly /></td>
					</tr>
					<tr>
						<td><label>Fecha de confirmación:</label></td>
						<td><input name="user_fecConfirmacion" type="text" value="${Rutinas.convierteAString(MostrarUser.user_fecConfirmacion) }" readonly /></td>
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