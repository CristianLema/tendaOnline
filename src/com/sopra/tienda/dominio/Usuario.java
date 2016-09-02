package com.sopra.tienda.dominio;

import java.util.Calendar;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sopra.tienda.exception.DomainException;
import com.sopra.tienda.util.ErrorMessages;
import com.sopra.tienda.util.Rutinas;
import com.sopra.tienda.util.Validator;

@Entity
@Table(schema = "ALUMNO")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id_usuario; // id usuario

	@Column(name="user_nombre")
	private String user_nombre; // nombre de usuario

	@Column(name="user_email")
	private String user_email; // correo electrónico

	@Column(name="user_pass")
	private String user_pass; // contraseña

	@Column(name="user_tipo")
	private int user_tipo; // tipo de usuario según tabla de tipos de usuario

	@Column(name="user_dni")
	private String user_dni; // DNI

	@Column(name="user_fecAlta")
	private Calendar user_fecAlta; // fecha de alta como usuario AUTOMÁTICO

	@Column(name="user_fecConfirmacion")
	private Calendar user_fecConfirmacion; // fecha de confirmación del alta
											// AUTOMÁTICO

	@Embedded
	@AttributeOverrides({@AttributeOverride(name="dir_nombre", column = @Column(name = "nombreEnvio")),
		@AttributeOverride(name = "dir_direccion", column = @Column(name="direccionEnvio")),
		@AttributeOverride(name = "dir_poblacion", column = @Column(name="poblacionEnvio")),
		@AttributeOverride(name = "dir_cPostal", column = @Column(name="cPostalEnvio")),
		@AttributeOverride(name = "dir_provincia", column = @Column(name="provinciaEnvio")),
		@AttributeOverride(name = "dir_correoE", column = @Column(name="correoEEnvio")),
		@AttributeOverride(name = "dir_pais", column = @Column(name="paisEnvio")),
	})
	private Direccion user_envio; // Datos dirección envío

	@Embedded
	@AttributeOverrides({@AttributeOverride(name="dir_nombre", column = @Column(name = "nombreFactura")),
		@AttributeOverride(name = "dir_direccion", column = @Column(name="direccionFactura")),
		@AttributeOverride(name = "dir_poblacion", column = @Column(name="poblacionFactura")),
		@AttributeOverride(name = "dir_cPostal", column = @Column(name="cPostalFactura")),
		@AttributeOverride(name = "dir_provincia", column = @Column(name="provinciaFactura")),
		@AttributeOverride(name = "dir_correoE", column = @Column(name="correoEFactura")),
		@AttributeOverride(name = "dir_pais", column = @Column(name="paisFactura")),
	})
	private Direccion user_pago; // Datos dirección de pago
	
	private static int contador;

	public Usuario() {
	}

	public boolean isValid() {
		return !Validator.isVacio(user_nombre) && !Validator.isVacio(user_email) && !Validator.isVacio(user_pass)
				&& id_usuario >= 0;

	}

	public int getId_usuario() {
		return id_usuario;
	}

	/**
	 * Establecer ID de usuario
	 * 
	 * @param id_usuario
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUser_nombre() {
		return user_nombre;
	}

	/**
	 * Establecer nombre de usuario. Debe contener entre 5 y 100 caracteres
	 * alfanuméricos
	 * 
	 * @param user_nombre
	 * @throws DomainException
	 */
	public void setUser_nombre(String user_nombre) throws DomainException {
		if (Validator.isAlfanumeric(user_nombre) && Validator.cumpleLongitud(user_nombre, 5, 100)) {
			this.user_nombre = user_nombre;
		} else {
			throw new DomainException(ErrorMessages.USERR_001);
		}
	}

	public String getUser_email() {
		return user_email;
	}

	/**
	 * Establecer correo electrónico. Debe cumplir con un formato y tener entre
	 * 6 y 100 caracteres
	 * 
	 * @param user_email
	 * @throws DomainException
	 */
	public void setUser_email(String user_email) throws DomainException {
		if (Validator.isEmailValido(user_email) && Validator.cumpleLongitud(user_email, 6, 100)) {
			this.user_email = user_email;
		} else {
			throw new DomainException(ErrorMessages.USERR_002);
		}
	}

	public String getUser_pass() {
		return user_pass;
	}

	/**
	 * Establecer contraseña. Debe tener entre 8 y 20 caracteres, de los cuales
	 * debe haber unha mayúscula, una minúscula, un número y un caracter
	 * especial. No puede contener el nombre de usuario
	 * 
	 * @param user_pass
	 * @throws DomainException
	 */
	public void setUser_pass(String user_pass) throws DomainException {
		if (Validator.esPasswordValida(user_pass) && !user_pass.contains(getUser_nombre())) {
			this.user_pass = user_pass;
		} else {
			throw new DomainException(ErrorMessages.USERR_003);
		}
	}

	public int getUser_tipo() {
		return user_tipo;
	}

	/**
	 * Establecer tipo de usuario: visitante (0), usuario(1), cliente(2),
	 * empleado(3), terceros(4), administrador(4)
	 * 
	 * @param user_tipo
	 */
	public void setUser_tipo(int user_tipo) {
		// falta filtro
		this.user_tipo = user_tipo;
	}

	public String getUser_dni() {
		return user_dni;
	}

	/**
	 * Establecer DNI. Debe seguir el formato 00.000.000-A. Se verifica si la
	 * letra es correcta
	 * 
	 * @param user_dni
	 * @throws DomainException
	 */
	public void setUser_dni(String user_dni) throws DomainException {
		if (Validator.cumpleDNI(user_dni)) {
			this.user_dni = user_dni;
		} else {
			throw new DomainException(ErrorMessages.USERR_004);
		}
	}

	public Calendar getUser_fecAlta() {
		return user_fecAlta;
	}

	/**
	 * Establecer fecha de alta como usuario
	 * 
	 * @param user_fecAlta
	 * @throws DomainException
	 */
	public void setUser_fecAlta(Calendar user_fecAlta) throws DomainException {
		Calendar hoxe = Calendar.getInstance();
		if (user_fecAlta.get(Calendar.YEAR) == hoxe.get(Calendar.YEAR)
				&& user_fecAlta.get(Calendar.MONTH) == hoxe.get(Calendar.MONTH)
				&& user_fecAlta.get(Calendar.DAY_OF_MONTH) == hoxe.get(Calendar.DAY_OF_MONTH)) {
			//Se eleminan las horas minutos segundos y milisegundos de la fecha
			this.user_fecAlta = Rutinas.convierteACalendar(Rutinas.convierteAString(user_fecAlta));
		} else {
			throw new DomainException(ErrorMessages.USERR_005);
		}
	}

	public Calendar getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}

	/**
	 * Establecer fecha de confirmación de alta de usuario
	 * 
	 * @param user_fecConfirmacion
	 * @throws DomainException
	 */
	public void setUser_fecConfirmacion(Calendar user_fecConfirmacion) throws DomainException {
		Calendar hoxe = Calendar.getInstance();
		if (user_fecConfirmacion.get(Calendar.YEAR) == hoxe.get(Calendar.YEAR)
				&& user_fecConfirmacion.get(Calendar.MONTH) == hoxe.get(Calendar.MONTH)
				&& user_fecConfirmacion.get(Calendar.DAY_OF_MONTH) == hoxe.get(Calendar.DAY_OF_MONTH)) {
			//Se eleminan las horas minutos segundos y milisegundos de la fecha
			this.user_fecConfirmacion = Rutinas.convierteACalendar(Rutinas.convierteAString(user_fecConfirmacion));
		} else {
			throw new DomainException(ErrorMessages.USERR_005);
		}

	}

}
