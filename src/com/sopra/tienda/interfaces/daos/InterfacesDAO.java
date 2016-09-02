package com.sopra.tienda.interfaces.daos;

import java.sql.SQLException;
import java.util.List;

import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.exception.DomainException;

public interface InterfacesDAO<T> {
	/**
	 * Muestra todas las categorías
	 * 
	 * @return
	 * @throws DAOException
	 * @throws SQLException 
	 * @throws DomainException 
	 */
	public List<T> leerTodos() throws DAOException, SQLException, DomainException;

	// O obxecto de tipo T define o WHERE
	public List<T> leerRegistros(T clase) throws DAOException, SQLException, DomainException;

	/**
	 * Devuelve un elemento con el id que se indica; si no existe, devuelve null
	 * 
	 * @param clase
	 * @return
	 * @throws DAOException
	 * @throws SQLException 
	 * @throws DomainException 
	 */
	public T leerRegistro(T clase) throws DAOException, SQLException, DomainException;

	/**
	 * Actualiza la BBDD con el registro que se le pasa
	 * @param clase
	 * @return
	 * @throws DAOException
	 * @throws SQLException 
	 */
	public int actualizarRegistro(T clase) throws DAOException, SQLException;

	/**
	 * Inserta en la BBDD el registro que se le pasa. Modifica el objeto que
	 * recibe con el id que se ha grabado en la BBDD. Devuelve el número de
	 * registros afectados, el cual es 1
	 * @param clase
	 * @return
	 * @throws DAOException
	 * @throws SQLException 
	 */
	public int insertarRegistro(T clase) throws DAOException, SQLException;
	
	/**
	 * Borra un registro
	 * @param clase
	 * @return
	 * @throws DAOException
	 * @throws SQLException 
	 */
	public int borrarRegistro(T clase) throws DAOException, SQLException;
	
}
