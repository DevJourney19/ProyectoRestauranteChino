package modelo;

public class Menu {
	public enum Estado {
		Venta, Desactivado
	}
	
	private int id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private double precio;
	private Estado estado;
	private Categoria categoria;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Menu(int id, String nombre, String descripcion, String imagen, double precio, Estado estado,
			Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.estado = estado;
		this.categoria = categoria;
	}
	public Menu() {
		super();
	}
	
	

}
