package modelo;

public class Trabajador {
	private int codigo;
	private String nombre;
	private String apellido;
	private int id_rol;
	private String celular;
	private String nombreUsuario;
	private String contrasenia;

	public Trabajador() {
		// TODO Auto-generated constructor stub
	}
	
	public Trabajador(int codigo, String nombre, String apellido, int id_rol, String celular, String nombreUsuario, String contrasenia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_rol = id_rol;
        this.celular = celular;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

	public int getCodigo() {
		return codigo;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
	public String getRolNombre() {
	    switch (this.id_rol) {
	        case 1:
	            return "Administrador";
	        case 2:
	            return "Mesero";
	        case 3:
	            return "Cajero";
	        default:
	            return "Desconocido";
	    }
	}   
}
