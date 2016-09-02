package com.sopra.tienda.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.tienda.dominio.Usuario;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.objetos.daos.UsuarioDAOH;

/**
 * Servlet implementation class BorrarUser
 */
@WebServlet("/BorrarUser")
public class BorrarUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAOH uDAOH = new UsuarioDAOH();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarUser() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Usuario userID = new Usuario();
		int id_usuario = Integer.valueOf(request.getParameter("id"));
		userID.setId_usuario(id_usuario);
		try {
			uDAOH.borrarRegistro(userID);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarUsuarios");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
