package com.sopra.tienda.objetos.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sopra.tienda.dominio.Categoria;
import com.sopra.tienda.dominio.Usuario;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.exception.DomainException;
import com.sopra.tienda.interfaces.daos.InterfacesDAO;
import com.sopra.tienda.util.Conexion;
import com.sopra.tienda.util.Rutinas;

public class UsuarioDAO implements InterfacesDAO<Usuario> {
	private static Connection conn;
	static Statement stm;
	static final String SELECT = "SELECT * FROM usuario";
	static final String LEER_REGISTRO = "SELECT * FROM usuario WHERE id_usuario = ";
	static final String UPDATE = "UPDATE usuario SET ";
	static final String INSERT = "INSERT INTO usuario VALUES ( ";
	static final String DELETE = "DELETE FROM usuario WHERE id_usuario = ";

	// constructor que inicia la conexión
	public UsuarioDAO() throws DAOException, SQLException {
		conn = Conexion.getConnection();
		stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	}

	@Override
	public List<Usuario> leerTodos() throws DAOException, SQLException, DomainException {
		// Ejecutamos un SELECT de todos los registros, los guardamos en una
		// lista
		ResultSet rs = stm.executeQuery(SELECT);
		List<Usuario> salida = new ArrayList<Usuario>();
		while (rs.next()) {
			Usuario user = new Usuario();
			user.setId_usuario(rs.getInt("id_usuario"));
			user.setUser_nombre(rs.getString("user_nombre"));
			user.setUser_email(rs.getString("user_email"));
			user.setUser_pass(rs.getString("user_pass"));
			user.setUser_tipo(rs.getInt("user_tipo"));
			user.setUser_dni(rs.getString("user_dni"));
			// variable cal donde guardar la fecha en formato Date proveniente de la BBDD
			Calendar cal = Calendar.getInstance();
			cal.setTime(rs.getDate("user_fecAlta"));
			user.setUser_fecAlta(cal);
			cal.setTime(rs.getDate("user_fecConfimracion"));
			user.setUser_fecConfirmacion(cal);
			salida.add(user);
			
		}
		return salida;
	}

	@Override
	public List<Usuario> leerRegistros(Usuario clase) throws DAOException, SQLException, DomainException {
		List<Usuario> salida = new ArrayList<Usuario>();
		String where = ""; // aquí se guardará lo que viene después de WHERE
		// se añaden al WHERE sólo los campos no vacíos
		// no interesa filtrar a los usuarios por dni o contraseña
		if (clase.getId_usuario() != 0) {
			where = Rutinas.addSalida(where, "id_usuario", clase.getId_usuario(), "AND");
		} else if (!clase.getUser_nombre().isEmpty()) {
			where = Rutinas.addSalida(where, "user_nombre", clase.getUser_nombre(), "AND");
		} else if (!clase.getUser_email().isEmpty()) {
			where = Rutinas.addSalida(where, "user_email", clase.getUser_email(), "AND");
		} else if (clase.getUser_tipo() < 0) {
			where = Rutinas.addSalida(where, "user_tipo", clase.getUser_tipo(), "AND");
		} else if (clase.getUser_fecAlta() != null) {
			where = Rutinas.addSalida(where, "user_fecAlta", clase.getUser_fecAlta(), "AND");
		} else if (clase.getUser_fecConfirmacion() != null) {
			where = Rutinas.addSalida(where, "user_fecConfirmacion", clase.getUser_fecConfirmacion(), "AND");
		}
		// si no se hay campos en clase, no se añade el WHERE, por lo que se
		// quedará en un simple leerTodos()
		if (where != "") {
			where = " WHERE " + where;
		}
		// se ejecuta y se guarda en un rs
		ResultSet rs = stm.executeQuery(SELECT + where);
		// si no está vacío, se introducen los registros en una lista, que se
		// entregará
		if (rs == null) {
			return null;
		} else {
			while (rs.next()) {
				Usuario user = new Usuario();
				user.setId_usuario(rs.getInt("id_usuario"));
				user.setUser_nombre(rs.getString("user_nombre"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_pass(rs.getString("user_pass"));
				user.setUser_tipo(rs.getInt("user_tipo"));
				user.setUser_dni(rs.getString("user_dni"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("user_fecAlta"));
				user.setUser_fecAlta(cal);
				cal.setTime(rs.getDate("user_fecConfimracion"));
				user.setUser_fecConfirmacion(cal);
				salida.add(user);
			}
			return salida;
		}
	}

	@Override
	public Usuario leerRegistro(Usuario clase) throws DAOException, SQLException, DomainException {
		// se ejecuta la sentencia, buscando un registro que coincida en ID, la
		// cual es única
		ResultSet rs = stm.executeQuery(LEER_REGISTRO + clase.getId_usuario());
		if (!rs.next()) {
			return null;
		} else {
			Usuario user = new Usuario();
			user.setId_usuario(rs.getInt("id_usuario"));
			user.setUser_nombre(rs.getString("user_nombre"));
			user.setUser_email(rs.getString("user_email"));
			user.setUser_pass(rs.getString("user_pass"));
			user.setUser_tipo(rs.getInt("user_tipo"));
			user.setUser_dni(rs.getString("user_dni"));
			Calendar cal = Calendar.getInstance();
			cal.setTime(rs.getDate("user_fecAlta"));
			user.setUser_fecAlta(cal);
			cal.setTime(rs.getDate("user_fecConfimracion"));
			user.setUser_fecConfirmacion(cal);
			return user;
		}
	}

	@Override
	public int actualizarRegistro(Usuario clase) throws DAOException, SQLException {
		ResultSet rs = stm.executeQuery(LEER_REGISTRO+clase.getId_usuario());
		if (rs==null){
			return 0;
		}else{
			String update ="";
			if (!clase.getUser_nombre().isEmpty()) {
				update = Rutinas.addSalida(update, "user_nombre", clase.getUser_nombre(), "AND");
			} else if (!clase.getUser_email().isEmpty()) {
				update = Rutinas.addSalida(update, "user_email", clase.getUser_email(), "AND");
			} else if (clase.getUser_tipo() < 0) {
				update = Rutinas.addSalida(update, "user_tipo", clase.getUser_tipo(), "AND");
			} else if (clase.getUser_fecAlta() != null) {
				update = Rutinas.addSalida(update, "user_fecAlta", clase.getUser_fecAlta(), "AND");
			} else if (clase.getUser_fecConfirmacion() != null) {
				update = Rutinas.addSalida(update, "user_fecConfirmacion", clase.getUser_fecConfirmacion(), "AND");
			} else if(clase.getUser_pass().isEmpty()){
				update = Rutinas.addSalida(update, "user_pass", clase.getUser_pass(), "AND");
			} else if(clase.getUser_dni().isEmpty()){
				update = Rutinas.addSalida(update, "user_dni", clase.getUser_dni(), "AND");
			}
			
			update = UPDATE + update + " WHERE id_usuario = "+clase.getId_usuario();
			return stm.executeUpdate(update);
		}
	}

	@Override
	public int insertarRegistro(Usuario clase) throws DAOException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrarRegistro(Usuario clase) throws DAOException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
