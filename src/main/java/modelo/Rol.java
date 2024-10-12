package modelo;

public class Rol {
	private int codigo;
	private String nombre;

	public Rol(int codigo) {
		this.codigo = codigo;
	}

	public Rol(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
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

}
