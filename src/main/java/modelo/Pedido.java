package modelo;

import java.util.Date;

public class Pedido {
	public enum EstadoPedido {
		Cancelado, Pendiente, Completado
	}

	public enum TipoRecibo {
		Factura, Boleta
	}

	public enum MetodoPago {
		Efectivo, Tarjeta, Transferencia
	}

	private int id;
	private Cliente cliente;
	private Mesa mesa;
	private EstadoPedido estado;
	private TipoRecibo tipo_recibo;
	private MetodoPago metodo_pago;
	private double total;
	private Trabajador trabajador;
	private Date created_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public TipoRecibo getTipo_recibo() {
		return tipo_recibo;
	}

	public void setTipo_recibo(TipoRecibo tipo_recibo) {
		this.tipo_recibo = tipo_recibo;
	}

	public MetodoPago getMetodo_pago() {
		return metodo_pago;
	}

	public void setMetodo_pago(MetodoPago metodo_pago) {
		this.metodo_pago = metodo_pago;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
}
