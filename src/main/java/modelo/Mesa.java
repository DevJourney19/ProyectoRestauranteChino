package modelo;

public class Mesa {
	public enum EstadoMesa {
		Libre, Reservado, Ocupado, Limpieza
	}
	private int id;
	private int n_salon;
	private int n_mesa;
	private EstadoMesa estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getN_salon() {
		return n_salon;
	}

	public void setN_salon(int n_salon) {
		this.n_salon = n_salon;
	}

	public int getN_mesa() {
		return n_mesa;
	}

	public void setN_mesa(int n_mesa) {
		this.n_mesa = n_mesa;
	}

	public EstadoMesa getEstado() {
		return estado;
	}

	public void setEstado(EstadoMesa estado) {
		this.estado = estado;
	}

	public Mesa() {
		super();
	}
	
	

}
