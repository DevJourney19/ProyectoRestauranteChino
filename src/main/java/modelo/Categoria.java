package modelo;

public class Categoria {
	public enum TipoCategoria {
		Inventario, Menu
	}
	
	private int id;
	private String nombre;
	private TipoCategoria tipo;
	
	
	
	public TipoCategoria getTipo() {
		return tipo;
	}
	public void setTipo(TipoCategoria tipo) {
		this.tipo = tipo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	
	
}
