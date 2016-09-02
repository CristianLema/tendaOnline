package com.sopra.tienda.objetos.daos;

import com.sopra.tienda.dominio.Producto;
import com.sopra.tienda.interfaces.daos.ClasesDAOH;
import com.sopra.tienda.util.Rutinas;

public class ProductoDAOH extends ClasesDAOH<Producto>{

	public ProductoDAOH(){
		this.setTipoClase("producto");
	}
	
	@Override
	protected String obtenLista(Producto clase, String separador) {
		String salida="";
		if (!clase.getId_producto().isEmpty()) {
			salida = Rutinas.addSalida(salida, "id_producto", clase.getId_producto(), separador);
		} else if (!clase.getPro_descripcion().isEmpty()) {
			salida = Rutinas.addSalida(salida, "pro_descripcion", clase.getPro_descripcion(), separador);
		} else if (!clase.getPro_desLarga().isEmpty()) {
			salida = Rutinas.addSalida(salida, "pro_desLarga", clase.getPro_desLarga(), separador);
		} else if (clase.getPro_precio() >0.0) {
			salida = Rutinas.addSalida(salida, "pro_precio", clase.getPro_precio(), separador);
		} else if (clase.getPro_stock() >0) {
			salida = Rutinas.addSalida(salida, "pro_stock", clase.getPro_stock(), separador);
		} else if(clase.getPro_fecRepos() != null){
			salida = Rutinas.addSalida(salida, "pro_fecRepos", clase.getPro_fecRepos(), separador);
		} else if(clase.getPro_fecActi() != null){
			salida = Rutinas.addSalida(salida, "pro_fecActi", clase.getPro_fecActi(), separador);
		}else if(clase.getPro_fecDesacti() != null){
			salida = Rutinas.addSalida(salida, "pro_fecDesacti", clase.getPro_fecDesacti(), separador);
		}else if(!clase.getPro_uniVenta().isEmpty()){
			salida = Rutinas.addSalida(salida, "pro_uniVenta", clase.getPro_uniVenta(), separador);
		}else if(clase.getPro_cantXUniVenta()>0){
			salida = Rutinas.addSalida(salida, "pro_cantXUniVenta", clase.getPro_cantXUniVenta(), separador);
		}else if(!clase.getPro_uniUltNivel().isEmpty()){
			salida = Rutinas.addSalida(salida, "pro_uniUltNivel", clase.getPro_uniUltNivel(), separador);
		}else if(clase.getId_pais() >=0){
			salida = Rutinas.addSalida(salida, "id_pais", clase.getId_pais(), separador);
		}else if(!clase.getPro_usoRecomendado().isEmpty()){
			salida = Rutinas.addSalida(salida, "pro_usoRecomendado", clase.getPro_usoRecomendado(), separador);
		}else if(clase.getId_categoria() >=0){
			salida = Rutinas.addSalida(salida, "pro_fecActi", clase.getId_categoria(), separador);
		}else if(clase.getPro_stkReservado() >= 0){
			salida = Rutinas.addSalida(salida, "pro_stkReservado", clase.getPro_stkReservado(), separador);
		}else if(clase.getPro_nStkAlto() >= 0){
			salida = Rutinas.addSalida(salida, "pro_nStkAlto", clase.getPro_nStkAlto(), separador);
		}else if(clase.getPro_nStkBajo() >= 0){
			salida = Rutinas.addSalida(salida, "pro_nStkBajo", clase.getPro_nStkBajo(), separador);
		}else if(clase.getPro_stat() != '\0'){
			salida = Rutinas.addSalida(salida, "pro_stat", clase.getPro_stat(), separador);
		}
		return salida;
	}

}
