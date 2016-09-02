package com.sopra.tienda.objetos.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sopra.tienda.dominio.Categoria;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.interfaces.daos.ClasesDAOH;
import com.sopra.tienda.interfaces.daos.InterfacesDAO;
import com.sopra.tienda.util.HibernateUtil;
import com.sopra.tienda.util.Conexion;
import com.sopra.tienda.util.Rutinas;

public class CategoriaDAOH extends ClasesDAOH<Categoria> {

	public CategoriaDAOH() {
		super.setTipoClase("Categoria");
		//Categoria e non categoria pq non é unha query, se non que se chama a unha clase
	}

	protected String obtenLista(Categoria clase, String separador) {
		String salida = "";
		if (clase.getId_categoria() > 0) {
			salida = Rutinas.addSalida(salida, "id_categoria", clase.getId_categoria(), separador);
		}
		if (clase.getCat_nombre() != null && clase.getCat_nombre().compareTo("") != 0) {
			salida = Rutinas.addSalida(salida, "cat_nombre", clase.getCat_nombre(), separador);
		}
		return salida;
	}

}
