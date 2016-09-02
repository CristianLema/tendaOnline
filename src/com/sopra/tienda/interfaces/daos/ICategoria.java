package com.sopra.tienda.interfaces.daos;

import java.util.List;

import com.sopra.tienda.dominio.Categoria;

public interface ICategoria {
	public Categoria getRegistro(int num);
	public List<Categoria> lista(Categoria c);
	public boolean guardar(Categoria c);
}
