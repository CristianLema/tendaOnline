<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="temp" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<temp:plantillas title="Inicio - Identificaci�n" type="0" pos="index">
	<jsp:attribute name="content">
			Corpo
			<h1>Identif�quese</h1>
			<p>Indique a continuaci�n su nombre de usuario o email y su
				contrase�a</p>
			<br>
			<c:choose>
				<c:when test="${error == 1 }">
					<p class="error">Contrase�a incorrecta</p>
				</c:when>
				<c:when test="${error == 2}">
					<p class="error">Usuario no registrado</p>
				</c:when>
			</c:choose>
			<form action="IdentificarUsuario" method=post>
				<p>E-mail:</p>
				</br> <input name="user_email" type="text" />
				<p>Contrase�a:</p>
				<input name="user_pass" type="password" /></br>
				<input type="submit" value="Identificarse" />
			</form>

			<p>
				Si no est� registrado, h�galo <a href="crearUsuario.jsp">aqu�</a>
			</p>
	</jsp:attribute>
</temp:plantillas>
		