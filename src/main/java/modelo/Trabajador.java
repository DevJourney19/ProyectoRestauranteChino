package modelo;

public class Trabajador {
	private int id;
	private String apellido;
	private String nombre;
	private String dni;
	private String correo;
	private String nombreUsuario;
	private String contrasenia;
	private String celular;
	private Rol rol;
	private int id_rol;

	public Trabajador() {
		// TODO Auto-generated constructor stub
	}

	public Trabajador(int id, String nombre, String apellido, int id_rol, String celular, String nombreUsuario,
			String contrasenia) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.id_rol = id_rol;
		this.celular = celular;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}

	public int getId() {
		return id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	public String getRolNombre() {
		switch (this.id_rol) {
		case 1:
			return "Administrador";
		case 2:
			return "Cocinero";
		case 3:
			return "Mesero";
		default:
			return "Desconocido";
		}
	}

}
