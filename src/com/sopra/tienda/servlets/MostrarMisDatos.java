package com.sopra.tienda.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sopra.tienda.dominio.Usuario;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.objetos.daos.UsuarioDAOH;

/**
 * Servlet implementation class MostrarUser
 */
@WebServlet("/MostrarMisDatos")
public class MostrarMisDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAOH uDAOH = new UsuarioDAOH();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarMisDatos() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		Usuario user = (Usuario) session.getAttribute("myUser");
		int id_usuario = user.getId_usuario();
		try {
			user = uDAOH.leerRegistro(user);
			request.setAttribute("MostrarUser", user);
		} catch (DAOException e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/mostrarMisDatos.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
