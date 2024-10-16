package modelo;

import java.time.LocalDate;

public class Inventario {
	public enum Unidad {
		KG, L, UN
	}

	private int id;
	private Categoria categoria;
	private String nombre;
	private Unidad unidad;
	private double precioUnitario;
	private int inventarioInicial;
	private int stock;
	private int stockMin;
	private LocalDate caducidad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getInventarioInicial() {
		return inventarioInicial;
	}

	public void setInventarioInicial(int inventarioInicial) {
		this.inventarioInicial = inventarioInicial;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockMin() {
		return stockMin;
	}

	public void setStockMin(int stockMin) {
		this.stockMin = stockMin;
	}

	public LocalDate getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(LocalDate localDate) {
		this.caducidad = localDate;
	}

	public Inventario() {
	}

	public Inventario(int id, Categoria categoria, String nombre, Unidad unidad, double precioUnitario,
			int inventarioInicial, int stock, int stockMin, LocalDate caducidad) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.nombre = nombre;
		this.unidad = unidad;
		this.precioUnitario = precioUnitario;
		this.inventarioInicial = inventarioInicial;
		this.stock = stock;
		this.stockMin = stockMin;
		this.caducidad = caducidad;
	}
	
	
	}
