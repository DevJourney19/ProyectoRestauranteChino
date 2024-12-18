package datos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import datos.DaoCliente;
import datos.DaoMesa;
import datos.DaoPedido;
import datos.DaoTrabajador;
import modelo.Cliente;
import modelo.Pedido;
import util.Conexion;

public class DaoPedidoImpl implements DaoPedido {

	Conexion con;
	private DaoCliente cli;
	private DaoMesa mes;
	private DaoTrabajador tra;
	public static Integer idPed;

	public DaoPedidoImpl() {
		con = new Conexion();
		cli = new DaoClienteImpl();
		tra = new DaoTrabajadorImpl();
		mes = new DaoMesaImpl();
	}

	@Override
	public List<Pedido> consultar() {
		List<Pedido> lista = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("Select ").append("id, ").append("id_cliente, ").append("id_mesa, ").append("estado, ")
				.append("tipo_recibo, ").append("metodo_pago, ").append("importe, ").append("impuesto, ")
				.append("total, ").append("id_trabajador, ").append("created_at ").append("from ").append("pedido");

		try (Connection c = con.getConexion();
				PreparedStatement ps = c.prepareStatement(sql.toString());
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(rs.getInt(1));
				pedido.setCliente(cli.obtener(rs.getInt(2)));
				pedido.setMesa(mes.obtener(rs.getInt(3)));
				pedido.setEstado(Pedido.EstadoPedido.valueOf(rs.getString(4)));
				pedido.setTipo_recibo(Pedido.TipoRecibo.valueOf(rs.getString(5)));
				pedido.setMetodo_pago(Pedido.MetodoPago.valueOf(rs.getString(6)));
				pedido.setImporte(rs.getDouble(7));
				pedido.setImpuesto(rs.getDouble(8));
				pedido.setTotal(rs.getDouble(9));
				pedido.setTrabajador(tra.obtener(rs.getInt(10)));
				pedido.setCreated_at(rs.getDate(11));

				lista.add(pedido);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Override
	public Pedido agregar(Pedido objeto) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO pedido(").append("id_cliente,").append("id_mesa,").append("tipo_recibo,")
				.append("metodo_pago,").append("importe,").append("impuesto,").append("total, ").append("id_trabajador")
				.append(") VALUES (?,?,?,?,?,?,?,?)");

		try (Connection c = con.getConexion();
				PreparedStatement ps = c.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);) {
			ps.setInt(1, objeto.getCliente().getId());
			ps.setInt(2, objeto.getMesa().getId());
			if (objeto.getTipo_recibo() != null) {
				ps.setString(3, objeto.getTipo_recibo().toString());
			} else {
				ps.setString(3, "Factura");
			}
			if (objeto.getMetodo_pago() != null) {
				ps.setString(4, objeto.getMetodo_pago().toString());
			} else {
				ps.setString(4, "Efectivo");
			}
			ps.setDouble(5, objeto.getImporte());
			ps.setDouble(6, objeto.getImpuesto());
			ps.setDouble(7, objeto.getTotal());

			ps.setInt(8, objeto.getTrabajador().getId());

			int resultSet = ps.executeUpdate();

			if (resultSet > 0) {
				try (ResultSet generatedKeys = ps.getGeneratedKeys()) {

					if (generatedKeys.next()) {
						// Asignar el ID generado al objeto Pedido
						objeto.setId(generatedKeys.getInt(1)); // Suponiendo que 'id' es de tipo INT
					}
				}
			}

			return objeto;

		} catch (Exception e) {
			System.out.println("Error en agregar pedido: " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean editar(Pedido objeto) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE pedido SET ").append(
				"id_cliente = ?, id_mesa = ?, estado = ?, tipo_recibo = ?, metodo_pago = ?, importe = ?,impuesto = ?,total = ?")
				.append(" WHERE id = ?");
		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
			ps.setInt(1, objeto.getCliente().getId());
			ps.setInt(2, objeto.getMesa().getId());
			ps.setString(3, objeto.getEstado().toString());
			ps.setString(4, objeto.getTipo_recibo().toString());
			ps.setString(5, objeto.getMetodo_pago().toString());
			ps.setDouble(6, objeto.getImporte());
			ps.setDouble(7, objeto.getImpuesto());
			ps.setDouble(8, objeto.getTotal());
			ps.setInt(9, objeto.getId());
			return (ps.executeUpdate() != 0);
		} catch (Exception e) {
			System.out.println("Error en editar el pedido: " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean eliminar(int codigo) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM pedido ").append("WHERE id = ?");
		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
			ps.setInt(1, codigo);
			return (ps.executeUpdate() != 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public Pedido obtener(int codigo) {
		String sql = "SELECT id, id_cliente, id_mesa, estado, tipo_recibo, metodo_pago, total, id_trabajador FROM pedido WHERE id = ?";
		try (Connection conn = con.getConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, codigo);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Pedido ped = new Pedido();
					ped.setId(rs.getInt(1));
					ped.setCliente(cli.obtener(rs.getInt(2)));
					ped.setMesa(mes.obtener(rs.getInt(3)));
					ped.setEstado(Pedido.EstadoPedido.valueOf(rs.getString(4)));
					ped.setTipo_recibo(Pedido.TipoRecibo.valueOf(rs.getString(5)));
					ped.setMetodo_pago(Pedido.MetodoPago.valueOf(rs.getString(6)));
					ped.setTotal(Double.valueOf(rs.getDouble(7)));
					ped.setTrabajador(tra.obtener(rs.getInt(8)));
					return ped;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Object[]> verData() {
		List<Object[]> lista = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append("id,").append("dni_ruc,").append("n_mesa,").append("estado,")
				.append("tipo_recibo,").append("metodo_pago,").append("total,").append("nombre,").append("created_at")
				.append(" FROM pedidosview");
		try (Connection c = con.getConexion();
				PreparedStatement ps = c.prepareStatement(sql.toString());
				ResultSet rs = ps.executeQuery();) {
			lista = new ArrayList<>();
			while (rs.next()) {
				Object[] obj = new Object[9];
				obj[0] = rs.getInt(1);
				obj[1] = rs.getString(2);
				obj[2] = rs.getInt(3);
				obj[3] = rs.getString(4);
				obj[4] = rs.getString(5);
				obj[5] = rs.getString(6);
				obj[6] = rs.getDouble(7);
				obj[7] = rs.getString(8);
				obj[8] = rs.getString(9);
				lista.add(obj);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Override
	public Cliente dataCliente(Integer idPed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> pedidoCocinero() {
	    List<Object[]> lista = null;
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT id, n_mesa, created_at, nombre, cantidad, estado ")
	       .append("FROM pedidococineroview ")
	       .append("WHERE DATE(created_at) = CURDATE()");

	    try (Connection c = con.getConexion();
	         PreparedStatement ps = c.prepareStatement(sql.toString());
	         ResultSet rs = ps.executeQuery()) {

	        lista = new ArrayList<>();
	        while (rs.next()) {
	            Object[] obj = new Object[6];
	            obj[0] = rs.getInt("id");
	            obj[1] = rs.getString("n_mesa");
	            obj[2] = rs.getTimestamp("created_at");
	            obj[3] = rs.getString("nombre");
	            obj[4] = rs.getInt("cantidad");
	            obj[5] = rs.getString("estado");
	            lista.add(obj);
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    return lista;
	}


	@Override
	public boolean editarEstadoCocinero(Pedido ped) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE pedido SET ").append(
				"estado = ?")
				.append(" WHERE id = ?");
		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
			ps.setString(1, ped.getEstado().toString());
			ps.setInt(2, ped.getId());
			return (ps.executeUpdate() != 0);
		} catch (Exception e) {
			System.out.println("Error en editar el pedido: " + e.getMessage());
		}
		return false;

	}

}
