package com.sopra.tienda.interfaces.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.exception.DomainException;
import com.sopra.tienda.util.HibernateUtil;

public abstract class ClasesDAOH<T> {
	private Session sesion;
	private Transaction tx;
	private String tipoClase;
	
	public String getTipoClase() {
		return tipoClase;
	}

	/**
	 * Establece el nombre de la clase
	 * @param tipoClase
	 */
	public void setTipoClase(String tipoClase) {
		this.tipoClase = tipoClase;
	}

	/**
	 * Muestra una lista con todas las entradas de una clase
	 * @return List<T>
	 * @throws DAOException
	 */
	public List<T> leerTodos() throws DAOException {
		List<T> lista = null;
		try {
			iniciaOperacion();
			lista = sesion.createQuery("from " + this.getTipoClase()).list();
		} finally {
			sesion.close();
		}
		return lista;
	}

	/**
	 * Muestra una lista de todos los registros que cumplen unos requisitos
	 * @param clase
	 * @return List<T>
	 * @throws DAOException
	 */
	public List<T> leerRegistros(T clase) throws DAOException {
		String where = obtenWhere(clase);
		List<T> lista = null;
		try {
			iniciaOperacion();
			lista = sesion.createQuery("from " + this.getTipoClase() + " " + where).list();
		} finally {
			sesion.close();
		}
		return lista;
	}

	/**
	 * Muestra una entrada
	 * @param clase
	 * @return T
	 * @throws DAOException
	 */
	public T leerRegistro(T clase) throws DAOException {
		List<T> lista = leerRegistros(clase);
		if (lista.size() == 1) {
			return lista.get(0);
		} else
			throw new DAOException("Demasiados registros en " + this.getTipoClase());
	}

	/**
	 * Modifica una entrada de la BBDD
	 * @param clase
	 * @return
	 * @throws DAOException
	 */
	public int actualizarRegistro(T clase) throws DAOException {
		try {
			iniciaOperacion();
			sesion.update(clase);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
		return 1;
	}

	/**
	 * Crea una nueva entrada en la BBDD
	 * @param clase
	 * @return
	 * @throws DAOException
	 * @throws DomainException
	 */
	public int insertarRegistro(T clase) throws DAOException, DomainException{
		long id = 0;

		try {
			iniciaOperacion();
			sesion.save(clase);
			tx.commit();
			/*
			if(clase instanceof Categoria){
				((Categoria)clase).setId_categoria((int) id);
			}
			if(clase instanceof Usuario){
				((Usuario)clase).setId_usuario((int)id);
			}
			if(clase instanceof Producto){
				((Producto)clase).setId_producto(String.valueOf(id));
			}
			*/
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			if (sesion!=null)
				sesion.close();
		}
		return 1;
	}

	/**
	 * Borra un registro de la BBDD
	 * @param clase
	 * @return
	 * @throws DAOException
	 */
	public int borrarRegistro(T clase) throws DAOException {
		try {
			iniciaOperacion();
			sesion.delete(clase);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
		return 1;
	}

	/**
	 * Crea un String con las condiciones que cumplirá un/varios registros para enviar a BBDD
	 * @param clase
	 * @return
	 */
	protected String obtenWhere(T clase) {

		String salida = obtenLista(clase, "AND");
		if (salida.length() > 0)
			salida = "WHERE " + salida;
		System.out.println("obtenwhere(): "+salida);
		return salida;
	}

	/**
	 * Crea un String a partir de los atributos de un objeto para enviar a la BBDD
	 * @param clase
	 * @param separador
	 * @return
	 */
	protected abstract String obtenLista(T clase, String separador);

	protected void iniciaOperacion() throws HibernateException {
		sesion = HibernateUtil.getSession();
		tx = sesion.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
	}
}
