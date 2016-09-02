package com.sopra.tienda.objetos.daos;

import com.sopra.tienda.dominio.Usuario;
import com.sopra.tienda.interfaces.daos.ClasesDAOH;
import com.sopra.tienda.util.Rutinas;

public class UsuarioDAOH extends ClasesDAOH<Usuario> {

	public UsuarioDAOH(){
		super.setTipoClase("Usuario");
	}

	@Override
	protected String obtenLista(Usuario clase, String separador) {
		String salida="";
		if (clase.getId_usuario() >0){
			salida = Rutinas.addSalida(salida, "id_usuario", clase.getId_usuario(), separador);
		} else if (clase.getUser_nombre() != null && clase.getUser_nombre().compareTo("") != 0) {
			salida = Rutinas.addSalida(salida, "user_nombre", clase.getUser_nombre(), separador);
		} else if (!clase.getUser_email().isEmpty()) {
			salida = Rutinas.addSalida(salida, "user_email", clase.getUser_email(), separador);
		} else if (clase.getUser_tipo() > 0) {
			salida = Rutinas.addSalida(salida, "user_tipo", clase.getUser_tipo(), separador);
		} else if (clase.getUser_fecAlta() != null) {
			salida = Rutinas.addSalida(salida, "user_fecAlta", clase.getUser_fecAlta(), separador);
		} else if (clase.getUser_fecConfirmacion() != null) {
			salida = Rutinas.addSalida(salida, "user_fecConfirmacion", clase.getUser_fecConfirmacion(), separador);
		} else if(!clase.getUser_pass().isEmpty()){
			salida = Rutinas.addSalida(salida, "user_pass", clase.getUser_pass(), separador);
		} else if(!clase.getUser_dni().isEmpty()){
			salida = Rutinas.addSalida(salida, "user_dni", clase.getUser_dni(), separador);
		}
		return salida;
	}

}
