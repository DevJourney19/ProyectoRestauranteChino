package modelo;

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
	private int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	private Cliente getCliente() {
		return cliente;
	}
	private void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	private Mesa getMesa() {
		return mesa;
	}
	private void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	private EstadoPedido getEstado() {
		return estado;
	}
	private void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
	private TipoRecibo getTipo_recibo() {
		return tipo_recibo;
	}
	private void setTipo_recibo(TipoRecibo tipo_recibo) {
		this.tipo_recibo = tipo_recibo;
	}
	private MetodoPago getMetodo_pago() {
		return metodo_pago;
	}
	private void setMetodo_pago(MetodoPago metodo_pago) {
		this.metodo_pago = metodo_pago;
	}
	private double getTotal() {
		return total;
	}
	private void setTotal(double total) {
		this.total = total;
	}
	private Trabajador getTrabajador() {
		return trabajador;
	}
	private void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	public Pedido(int id, Cliente cliente, Mesa mesa, EstadoPedido estado, TipoRecibo tipo_recibo,
			MetodoPago metodo_pago, double total, Trabajador trabajador) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.mesa = mesa;
		this.estado = estado;
		this.tipo_recibo = tipo_recibo;
		this.metodo_pago = metodo_pago;
		this.total = total;
		this.trabajador = trabajador;
	}
	public Pedido() {
		super();
	}
	
	

}
