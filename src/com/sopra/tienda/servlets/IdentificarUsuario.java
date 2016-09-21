package com.sopra.tienda.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sopra.tienda.dominio.Usuario;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.exception.DomainException;
import com.sopra.tienda.objetos.daos.UsuarioDAOH;

/**
 * Servlet implementation class IdentificarUsuario
 */
@WebServlet("/IdentificarUsuario")
public class IdentificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAOH uDAOH = new UsuarioDAOH();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IdentificarUsuario() {
		super();
		// TODO Auto-generated constructor stub
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

		String user_email = request.getParameter("user_email");
		String user_pass = request.getParameter("user_pass");

		// Suponiendo que no hay emails repetidos

		Usuario user = new Usuario();
		user.setId_usuario(0);
		
		try {
			user.setUser_email(user_email);
		} catch (DomainException e1) {
			out.print(e1.getMessage());
		}
		
		

		try {
			user=uDAOH.leerRegistro(user);
			if (user != null) {
				if (user_pass.equals(user.getUser_pass())) {
					HttpSession session = request.getSession();
					session.setAttribute("myUser", user);
					if (user.getUser_tipo() == 9) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/homeAdmin.jsp");
						if (dispatcher != null) {
							dispatcher.forward(request, response);
						}
					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/homeUser.jsp");
						if (dispatcher != null) {
							dispatcher.forward(request, response);
						}
					}
				} else {
					
					request.setAttribute("error", 1);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/identificacion.jsp");
					if (dispatcher != null) {
						dispatcher.forward(request, response);
					}
					
				}
			} else {
				
				request.setAttribute("error", 2);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/identificacion.jsp");
				if (dispatcher != null) {
					dispatcher.forward(request, response);
				}
				
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

}
