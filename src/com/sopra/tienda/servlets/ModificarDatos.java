package com.sopra.tienda.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.tienda.dominio.Usuario;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.exception.DomainException;
import com.sopra.tienda.objetos.daos.UsuarioDAOH;
import com.sopra.tienda.util.Validator;

/**
 * Servlet implementation class ModificarDatos
 */
@WebServlet("/ModificarDatos")
public class ModificarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAOH uDAOH = new UsuarioDAOH();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarDatos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user_nombre = request.getParameter("user_nombre");
		String user_email = request.getParameter("user_email");
		int user_tipo = Integer.valueOf(request.getParameter("user_tipo"));
		String user_dni = request.getParameter("user_dni");
		int id_usuario = Integer.valueOf(request.getParameter("id_usuario"));
		String user_pass = request.getParameter("user_pass");

		boolean valido = true;

		Usuario user = new Usuario();
		user.setId_usuario(id_usuario);

		try {
			user.setUser_nombre(user_nombre);
		} catch (DomainException e1) {
			e1.printStackTrace();
			valido = false;
		}
		try {
			user.setUser_email(user_email);
		} catch (DomainException e1) {
			e1.printStackTrace();
			valido = false;
		}
		user.setUser_tipo(user_tipo);
		if (!user_dni.equals("")) {
			try {
				user.setUser_dni(user_dni);
			} catch (DomainException e1) {
				e1.printStackTrace();
				valido = false;
			}
		}
		if (user_pass != null && !user_pass.equals("")) {
			try {
				user.setUser_pass(user_pass);
			} catch (DomainException e1) {
				e1.printStackTrace();
				valido = false;
			}
		}
		
		if (valido) {
			try {
				uDAOH.actualizarRegistro(user);
			} catch (DAOException e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarUsuarios");
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			}
		} else {
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Error</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>Usuario no modificado</H1>");
			out.println("<P>Alguno de los datos no son correctos, compruebe que:</P>");
			out.println("<P>El nombre de usuario solo contenga entre 5 y 100 caracteres alfanuméricos.</P>");
			out.println("<P>El email esté bien escrito</P>");
			out.println(
					"<P>La contraseña contenga entre 8 y 20 caracteres. Debe contener al menos una minúscula, una mayúscula, un número y un carácter especial (@ # $ %)</P>");
			out.println("<P>El tipo de usuario esté dentro de rango</P>");
			out.println("<P>El DNI es correcto y escrito en formato 00.000.000-A</P>");
			out.println("<A HREF=\"mostrarDatos.jsp\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
			out.println("</BODY></HTML>");
		}
	}

}
