<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="temp" tagdir="/WEB-INF/tags" %>

<temp:plantillas title="Inicio - Registrarse" type="0" pos="index">
	<jsp:attribute name="content">
			<h1>Crear nuevo usuario:</h1>
			<p>Introduzca los siguientes datos para crear un nuevo usuario</p>
			<br>

			<form action="EngadirUser" method=post>
				<label>Nome de usuario:</label></br> <input name="user_nombre" type="text" /></br>
				<label>E-mail:</label></br> <input name="user_email" type="text" /></br>
				<label>Contrase�a:</label></br> <input name="user_pass" type="password" /></br>
				<label>Repetir contrase�a:</label></br> <input name="user_pass2" type="password" /></br>
				<input type="submit" value="Enviar" />
			</form>
			<br>
			<p>Si ya est� registrado, identif�quese <a href="identificacion.jsp">aqu�</a></p>
	</jsp:attribute>
</temp:plantillas>