package com.sopra.tienda.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.tienda.dominio.Usuario;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.exception.DomainException;
import com.sopra.tienda.objetos.daos.UsuarioDAOH;

/**
 * Servlet implementation class EngadirUser
 */
@WebServlet("/EngadirUser")
public class EngadirUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAOH uDAOH;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EngadirUser() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
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
		// obtener las nuevas variables
		String user_nombre = request.getParameter("user_nombre");
		String user_email = request.getParameter("user_email");
		String user_pass = request.getParameter("user_pass");
		String user_pass2 = request.getParameter("user_pass2");

		if (user_pass.equals(user_pass2)) {
			// se crea un objeto Usuario y se le meten los datos anteriores
			Usuario user = new Usuario();
			try {
				user.setUser_nombre(user_nombre);
			} catch (DomainException e1) {
				e1.printStackTrace();
			}
			try {
				user.setUser_email(user_email);
			} catch (DomainException e1) {
				e1.printStackTrace();
			}
			try {
				user.setUser_pass(user_pass);
			} catch (DomainException e1) {
				e1.printStackTrace();
			}
			Calendar cal = Calendar.getInstance();
			try {
				user.setUser_fecAlta(cal);
			} catch (DomainException e2) {
				e2.printStackTrace();
			}
			try {
				user.setUser_fecConfirmacion(cal);
			} catch (DomainException e1) {
				e1.printStackTrace();
			}

			if (user.isValid()) {
				uDAOH = new UsuarioDAOH();
				try {
					uDAOH.insertarRegistro(user);
				} catch (DAOException e) {
					e.printStackTrace();
				} catch (DomainException e) {
					e.printStackTrace();
				}
				// HTML confirmación de creación de usuario
				out.println("<HTML>");
				out.println("<HEAD><TITLE>Inserción de usuario</TITLE></HEAD>");
				out.println("<BODY>");
				out.println("<H1>El nuevo usuario ha sido creado correctamente con los siguientes datos:</H1>");
				out.println("<P><B>ID :</B> " + user.getId_usuario() + "</P>");
				out.println("<P><B>Nombre de usuario:</B> " + user_nombre + "</P>");
				out.println("<P><B>Email: </B>" + user_email + "</P>");
				out.println("<P><B>Contraseña: </B>" + user_pass + "</P>");
				out.println("<P>Para añadir más datos, vaya a Modificar datos</P>");
				out.println("<A HREF=\"ListarUsuarios\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
				out.println("</BODY></HTML>");
			}else{
				out.println("<HTML>");
				out.println("<HEAD><TITLE>Error</TITLE></HEAD>");
				out.println("<BODY>");
				out.println("<H1>Usuario no creado</H1>");
				out.println("<P>Alguno de los datos no son correctos, compruebe que:</P>");
				out.println("<P>El nombre de usuario solo contenga entre 5 y 100 caracteres alfanuméricos.</P>");
				out.println("<P>El email esté bien escrito</P>");
				out.println("<P>La contraseña contenga entre 8 y 20 caracteres. Debe contener al menos una minúscula, una mayúscula, un número y un carácter especial (@ # $ %)</P>");
				out.println("<A HREF=\"crearUsuario.jsp\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
				out.println("</BODY></HTML>");
			}

		} else {
			// HTML en caso de que la confirmación de la contraseña no coincida
			// con la contraseña
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Error contraseña</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>Usuario no creado</H1>");
			out.println("<P>Las contraseñas deben ser iguales</P>");
			out.println("<A HREF=\"crearUsuario.jsp\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
			out.println("</BODY></HTML>");
		}

	}

}
