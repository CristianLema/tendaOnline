package com.sopra.tienda.objetos.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.sopra.tienda.dominio.Categoria;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.interfaces.daos.InterfacesDAO;
import com.sopra.tienda.util.Conexion;
import com.sopra.tienda.util.Rutinas;

public class CategoriaDAO implements InterfacesDAO<Categoria>{
	private static Connection conn;
	static Statement stm;
	static final String SELECT = "SELECT * FROM categoria";
	static final String LEER_REGISTRO = "SELECT * FROM categoria WHERE id_categoria = ";
	static final String UPDATE = "UPDATE categoria SET ";
	static final String INSERT = "INSERT INTO categoria VALUES ( ";
	static final String DELETE = "DELETE FROM categoria WHERE id_categoria = ";
	
	//constructor que inicia la conexión
	public CategoriaDAO() throws DAOException, SQLException{
		conn = Conexion.getConnection();
		stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	}
	
	/**
	 * Leer todos los registros de la BBDD
	 */
	@Override
	public List<Categoria> leerTodos() throws DAOException, SQLException{
		// Ejecutamos un SELECT de todos los registros, los guardamos en una lista
		ResultSet rs = stm.executeQuery(SELECT);
		List<Categoria> salida = new ArrayList<Categoria>();
		while (rs.next()){
			Categoria cat = new Categoria();
			cat.setId_categoria(rs.getInt("id_categoria"));
			cat.setCat_nombre(rs.getString("cat_nombre"));
			cat.setCat_descripcion(rs.getString("cat_descripcion"));
			salida.add(cat);
		}
		return salida;
	}
	
	
/**
 * Leer todos los registros que coincidan con los campos que se introduzcan
 * @param clase
 */
	@Override
	public List<Categoria> leerRegistros(Categoria clase) throws DAOException, SQLException {
		List<Categoria> salida = new ArrayList<Categoria>();
		String where = ""; //aquí se guardará lo que viene después de WHERE
		//se añaden al WHERE sólo los campos no vacíos
		if (clase.getId_categoria()!=0){
			where=Rutinas.addSalida(where, "id_categoria", clase.getId_categoria(), "AND");
		}else if(!clase.getCat_nombre().isEmpty()){
			where=Rutinas.addSalida(where, "cat_nombre", clase.getCat_nombre(), "AND");
		}else if(!clase.getCat_descripcion().isEmpty()){
			where=Rutinas.addSalida(where, "cat_descripcion", clase.getCat_descripcion(), "AND");
		}
		//si no se hay campos en clase, no se añade el WHERE, por lo que se quedará en un simple leerTodos()
		if (where!=""){
			where = " WHERE " + where;
		}
		//se ejecuta y se guarda en un rs
		ResultSet rs = stm.executeQuery(SELECT + where);
		//si no está vacío, se introducen los registros en una lista, que se entregará
		if (rs==null){
			return null;
		}else{
			while (rs.next()){
				Categoria cat = new Categoria();
				cat.setId_categoria(rs.getInt("id_categoria"));
				cat.setCat_nombre(rs.getString("cat_nombre"));
				cat.setCat_descripcion(rs.getString("cat_descripcion"));
				salida.add(cat);
			}
			return salida;
		}
	}

	/**
	 * Leer un único registro, a partir del ID
	 * @param clase
	 */
	@Override
	public Categoria leerRegistro(Categoria clase) throws DAOException, SQLException {
		//se ejecuta la sentencia, buscando un registro que coincida en ID, la cual es única
		ResultSet rs = stm.executeQuery(LEER_REGISTRO+clase.getId_categoria());
		if (!rs.next()){
			return null;
		}else{
			Categoria cat = new Categoria();
			cat.setId_categoria(rs.getInt("id_categoria"));
			cat.setCat_nombre(rs.getString("cat_nombre"));
			cat.setCat_descripcion(rs.getString("cat_descripcion"));
			return cat;
		}
		
	}

	/**
	 * Modificar un registro
	 * @param clase
	 */
	@Override
	public int actualizarRegistro(Categoria clase) throws DAOException, SQLException {
		ResultSet rs = stm.executeQuery(LEER_REGISTRO+clase.getId_categoria());
		if (rs==null){
			return 0;
		}else{
			String update ="";
			if(!clase.getCat_nombre().isEmpty()){
				update=Rutinas.addSalida(update, "cat_nombre", clase.getCat_nombre(), ",");
			}else if(!clase.getCat_descripcion().isEmpty()){
				update=Rutinas.addSalida(update, "cat_descripcion", clase.getCat_descripcion(), ",");
			} 
			
			update = UPDATE + update + " WHERE id_categoria = "+clase.getId_categoria();
			return stm.executeUpdate(update);
		}
	}
/**
 * Insertar un nuevo registro
 * @param
 */
	@Override
	public int insertarRegistro(Categoria clase) throws DAOException, SQLException {
		String salida = "";
		//se introduce una ID al nuevo registro, el cual es igual a 1 + el ID mayor que exista
		clase.setId_categoria(Conexion.obtenerClave("categoria", "id_categoria"));
		salida = INSERT + Rutinas.addSalida(salida, "", clase.getId_categoria() , ",");
		salida = Rutinas.addSalida(salida, "", clase.getCat_nombre(), ",");
		salida = Rutinas.addSalida(salida, "", clase.getCat_descripcion(), ",");
		salida += ")";
		return stm.executeUpdate(salida);
	}
/**
 * Borrar un registro especificado
 * @param clase
 */
	@Override
	public int borrarRegistro(Categoria clase) throws DAOException, SQLException {
		//Se comprueba que exista dicho registro
		ResultSet rs = stm.executeQuery(LEER_REGISTRO+clase.getId_categoria());
		if (rs==null){
			return 0;
		}else{
			//se borra el registro por su ID
			return stm.executeUpdate(DELETE + clase.getId_categoria());
		}
	}

}
