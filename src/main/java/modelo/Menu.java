package modelo;

import jakarta.servlet.http.Part;

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
    private Part archivoImagen;
    private String urlImagen;
    private String tipoImagen;

	public String getTipoImagen() {
		return tipoImagen;
	}
	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen = tipoImagen;
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

	public Part getArchivoImagen() {
		return archivoImagen;
	}
	public void setArchivoImagen(Part archivoImagen) {
		this.archivoImagen = archivoImagen;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public Menu() {
		super();
	}



}
