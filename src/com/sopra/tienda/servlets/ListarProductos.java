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
import com.sopra.tienda.dominio.Producto;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.objetos.daos.CategoriaDAOH;
import com.sopra.tienda.objetos.daos.ProductoDAOH;

/**
 * Servlet implementation class ListarProductos
 */
@WebServlet("/ListarProductos")
public class ListarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAOH pDAOH = new ProductoDAOH();
	private CategoriaDAOH cDAOH = new CategoriaDAOH();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProductos() {
        super();
        // TODO Auto-generated constructor stub
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
		try {
			List<Producto> listado = pDAOH.leerTodos();
			request.setAttribute("listado", listado);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		try {
			List <Categoria> cat = cDAOH.leerTodos();
			boolean empty;
			if (cat.isEmpty()){
				empty=true;
			}else{
				empty=false;
			}
			request.setAttribute("vacio", empty);
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listadoProductos.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
