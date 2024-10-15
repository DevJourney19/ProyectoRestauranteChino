package modelo;

public class Rol {
	private int id;
	private String nombre;

	public Rol(int id) {
		this.id = id;

		switch (id) {
		case 1: {
			this.nombre = "Administrador";
			break;
		}
		case 2: {
			this.nombre = "Cocinero";
			break;
		}
		case 3: {
			this.nombre = "Mozo";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + id);

		}

	}

	public Rol(String nombre) {
		this.nombre = nombre;
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

}
