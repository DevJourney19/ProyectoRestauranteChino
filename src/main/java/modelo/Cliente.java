package modelo;

public class Cliente {
	public enum Tipo{
		RUC, DNI
	}
	
	private int id;
	private String dni_ruc;
	private String telefono;
	private String correo;
	private Tipo tipo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni_ruc() {
		return dni_ruc;
	}
	public void setDni_ruc(String dni_ruc) {
		this.dni_ruc = dni_ruc;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Cliente() {
		super();
	}
	
	
}
