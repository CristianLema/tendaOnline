<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="temp" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<temp:plantillas title="Inicio - Identificación" type="0" pos="index">
	<jsp:attribute name="content">
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
			</p>
	</jsp:attribute>
</temp:plantillas>
		