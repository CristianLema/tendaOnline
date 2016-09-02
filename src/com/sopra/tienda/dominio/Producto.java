package com.sopra.tienda.dominio;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sopra.tienda.exception.DomainException;
import com.sopra.tienda.util.ErrorMessages;
import com.sopra.tienda.util.Validator;

@Entity
public class Producto {
	@Id
	private String id_producto; // código de producto

	private String pro_descripcion; // descripción corta

	private String pro_desLarga; // explicación

	private double pro_precio; // precio del producto

	private int pro_stock; // stock del producto

	private Calendar pro_fecRepos; // fecha prevista de reposición

	private Calendar pro_fecActi; // Fecha de activación de producto en caso de
									// ser de temporada

	private Calendar pro_fecDesacti; // Fecha de desactivación de producto en
										// caso de ser de temp

	private String pro_uniVenta; // unidad de venta

	private double pro_cantXUniVenta; // cantidad de unidades últimas

	private String pro_uniUltNivel; // unidad última

	private int id_pais;// país de origen en función de una tabla

	private String pro_usoRecomendado; // uso recomendado del producto

	@ManyToOne(targetEntity = Categoria.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	private int id_categoria; // Categoría del producto

	private int pro_stkReservado; // stock reservado

	private int pro_nStkAlto; // stock para nivel alto

	private int pro_nStkBajo; // stock para nivel bajo

	private char pro_stat; // estado en función de una tabla

	public Producto() {
	}

	public boolean isValid() {
		return !Validator.isVacio(id_producto) && !Validator.isVacio(pro_descripcion) && pro_precio >= 0
				&& !Validator.isVacio(pro_uniVenta) && id_pais >= 0 && id_categoria >= 0;
	}

	public String getId_producto() {
		return id_producto;
	}

	/**
	 * Establecer ID producto, debe contener solo 5 caracteres, empezando por
	 * dos mayúsculas y seguido de 3 dígitos
	 * 
	 * @param id_producto
	 * @throws DomainException
	 */
	public void setId_producto(String id_producto) throws DomainException {
		if (Validator.esCodigoProductoValida(id_producto)) {
			if (id_producto.length() == 5) {
				this.id_producto = id_producto;
			} else {
				throw new DomainException(ErrorMessages.PROERR_002);
			}
		} else {
			throw new DomainException(ErrorMessages.PROERR_001);
		}
	}

	public String getPro_descripcion() {
		return pro_descripcion;
	}

	/**
	 * Establecer una descripción a un producto. Debe contener de 5 a 100
	 * caracteres alfanuméricos
	 * 
	 * @param pro_descripcion
	 * @throws DomainException
	 */
	public void setPro_descripcion(String pro_descripcion) throws DomainException {
		if (Validator.cumpleLongitud(pro_descripcion, 5, 100)) {
			if (Validator.isAlfanumeric(pro_descripcion)) {
				this.pro_descripcion = pro_descripcion;
			} else {
				throw new DomainException(ErrorMessages.PROERR_004);
			}
		} else {
			throw new DomainException(
					ErrorMessages.errorLongitud(ErrorMessages.PROERR_003, "Descripcion corta", 5, 100));
		}
	}

	public String getPro_desLarga() {
		return pro_desLarga;
	}

	/**
	 * Establecer explicación larga de un producto. Debe contener de 5 a 2000
	 * caracteres alfanuméricos
	 * 
	 * @param pro_desLarga
	 * @throws DomainException
	 */
	public void setPro_desLarga(String pro_desLarga) throws DomainException {
		if (Validator.cumpleLongitud(pro_desLarga, 5, 2000)) {
			if (Validator.isAlfanumeric(pro_desLarga)) {
				this.pro_desLarga = pro_desLarga;
			} else {
				throw new DomainException(ErrorMessages.PROERR_004);
			}
		} else {
			throw new DomainException(
					ErrorMessages.errorLongitud(ErrorMessages.PROERR_003, "Explicación larga", 5, 2000));
		}
	}

	public double getPro_precio() {
		return pro_precio;
	}

	/**
	 * Establecer precio de un producto, debe estar entre 0 y 100
	 * 
	 * @param pro_precio
	 * @throws DomainException
	 */
	public void setPro_precio(double pro_precio) throws DomainException {
		if (Validator.cumpleRango(pro_precio, 0, 100)) {
			this.pro_precio = pro_precio;
		} else {
			throw new DomainException(ErrorMessages.PROERR_005);
		}
	}

	public int getPro_stock() {
		return pro_stock;
	}

	/**
	 * Establece la cantidad que hay de un producto en stock
	 * 
	 * @param pro_stock
	 */
	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}

	public Calendar getPro_fecRepos() {
		return pro_fecRepos;
	}

	/**
	 * Establece la fecha de reposición de un producto. No puede ser anterior a
	 * la fecha actual
	 * 
	 * @param pro_fecRepos
	 */
	public void setPro_fecRepos(Calendar pro_fecRepos) throws DomainException {
		Calendar cal = Calendar.getInstance();
		if (pro_fecRepos.before(cal)) {
			throw new DomainException(ErrorMessages.PROERR_006);
		} else {
			this.pro_fecRepos = pro_fecRepos;
		}
	}

	public Calendar getPro_fecActi() {
		return pro_fecActi;
	}

	/**
	 * Establece una fecha de activación para un producto de temporada. No puede
	 * ser anterior a la fecha actual
	 * 
	 * @param pro_fecActi
	 * @throws DomainException
	 */
	public void setPro_fecActi(Calendar pro_fecActi) throws DomainException {
		Calendar cal = Calendar.getInstance();
		if (pro_fecActi.before(cal)) {
			throw new DomainException(ErrorMessages.PROERR_006);
		} else {
			this.pro_fecActi = pro_fecActi;
		}
	}

	public Calendar getPro_fecDesacti() {
		return pro_fecDesacti;
	}

	/**
	 * Establecer fecha de desactivación de un producto de temporada. No puede
	 * ser anterior a la fecha actual. Debe tener fecha de activación
	 * 
	 * @param pro_fecDesacti
	 * @throws DomainException
	 */
	public void setPro_fecDesacti(Calendar pro_fecDesacti) throws DomainException {
		Calendar cal = Calendar.getInstance();
		if (this.getPro_fecActi() == null) {
			throw new DomainException(ErrorMessages.PROERR_007);
		} else {
			if (pro_fecDesacti.before(cal)) {
				throw new DomainException(ErrorMessages.PROERR_006);
			} else {
				this.pro_fecDesacti = pro_fecDesacti;
			}
		}
	}

	public String getPro_uniVenta() {
		return pro_uniVenta;
	}

	/**
	 * Establece la unidad de venta
	 * 
	 * @param pro_uniVenta
	 * @throws DomainException
	 */
	public void setPro_uniVenta(String pro_uniVenta) throws DomainException {
		if (Validator.isAlfanumeric(pro_uniVenta)) {
			this.pro_uniVenta = pro_uniVenta;
		} else {
			throw new DomainException(ErrorMessages.PROERR_004);
		}
	}

	public double getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}

	/**
	 * Establece la cantidad de producto que tiene una unidad de venta
	 * 
	 * @param pro_cantXUniVenta
	 */
	public void setPro_cantXUniVenta(double pro_cantXUniVenta) {
		this.pro_cantXUniVenta = pro_cantXUniVenta;
	}

	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}

	/**
	 * Establece la unidad(p.ej:gramos,unidades...) en la que se puede dividir
	 * una unidad de venta(p.ej:caja,pack)
	 * 
	 * @param pro_uniUltNivel
	 */
	public void setPro_uniUltNivel(String pro_uniUltNivel) {
		this.pro_uniUltNivel = pro_uniUltNivel;
	}

	public int getId_pais() {
		return id_pais;
	}

	/**
	 * Establece el país a partir de la base de datos
	 * 
	 * @param id_pais
	 */
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}

	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}

	/**
	 * Establece una descripción del uso recomendado del producto
	 * 
	 * @param pro_usoRecomendado
	 */
	public void setPro_usoRecomendado(String pro_usoRecomendado) {
		this.pro_usoRecomendado = pro_usoRecomendado;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	/**
	 * Establece la categoría a la que pertenece el producto
	 * 
	 * @param id_categoria
	 */
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public int getPro_stkReservado() {
		return pro_stkReservado;
	}

	/**
	 * Establece la cantidad de stock que queda reservado
	 * 
	 * @param pro_stkRservado
	 */
	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}

	public int getPro_nStkAlto() {
		return pro_nStkAlto;
	}

	/**
	 * Establece el nivel de stock para considerarse alto
	 * 
	 * @param pro_nStkAlto
	 */

	public void setPro_nStkAlto(int pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}

	public int getPro_nStkBajo() {
		return pro_nStkBajo;
	}

	/**
	 * Establece el nivel de stock para considerarse bajo
	 * 
	 * @param pro_nStkBajo
	 */
	public void setPro_nStkBajo(int pro_nStkBajo) {
		this.pro_nStkBajo = pro_nStkBajo;
	}

	public char getPro_stat() {
		return pro_stat;
	}

	/**
	 * Establecer el estado del producto. Debe ser un único carácter
	 * alfanumérico
	 * 
	 * @param pro_stat
	 * @throws DomainException
	 */
	public void setPro_stat(char pro_stat) throws DomainException {
		if (Validator.isAlfanumeric(String.valueOf(pro_stat))) {
			this.pro_stat = pro_stat;
		} else {
			throw new DomainException(ErrorMessages.PROERR_004);
		}

	}

}
