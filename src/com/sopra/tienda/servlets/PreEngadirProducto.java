package com.sopra.tienda.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.tienda.dominio.Categoria;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.objetos.daos.CategoriaDAOH;

/**
 * Servlet implementation class PreEngadirProducto
 */
@WebServlet("/PreEngadirProducto")
public class PreEngadirProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CategoriaDAOH cDAOH = new CategoriaDAOH();  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreEngadirProducto() {
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
		try {
			List<Categoria> cat = cDAOH.leerTodos();
			request.setAttribute("cat", cat);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/engadirProductos.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
