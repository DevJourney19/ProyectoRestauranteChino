package datos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.DaoDetalle;
import datos.DaoMenu;
import modelo.DetallePedido;
import util.Conexion;

public class DaoDetalleImpl implements DaoDetalle{
	Conexion con;
    private DaoMenu men;
    public static Integer idPed;

    public DaoDetalleImpl() {
        con = new Conexion();
        men = new DaoMenuImpl();
    }

	@Override
	public List<DetallePedido> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean agregar(DetallePedido objeto) {
		StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO detallepedido(")
                .append("id_menu,")
                .append("cantidad,")
                .append("subtotal,")
                .append("id_pedido")
                .append(") VALUES (?,?,?,?)");

        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, objeto.getMenu().getId());
            ps.setInt(2, objeto.getCantidad());
            ps.setDouble(3, objeto.getSubtotal());
            ps.setInt(4, objeto.getPedido().getId());
            return (ps.executeUpdate() != 0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
	}

	@Override
	public boolean editar(DetallePedido objeto) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE detallepedido SET ").append("id_menu = ?, cantidad = ?, subtotal = ?, id_pedido = ?")
				.append(" WHERE id = ?");
		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
			ps.setInt(1, objeto.getMenu().getId());
            ps.setInt(2, objeto.getCantidad());
            ps.setDouble(3, objeto.getSubtotal());
            ps.setInt(4, objeto.getPedido().getId());
			ps.setInt(5, objeto.getId());
			return (ps.executeUpdate() != 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean eliminar(int codigo) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM detallepedido ").append("WHERE id = ?");
		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
			ps.setInt(1, codigo);
			return (ps.executeUpdate() != 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public DetallePedido obtener(int codigo) {
		return null;
	}

	@Override
	public List<Object[]> verData(int id) {
	    List<Object[]> lista = null;
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT ")
	       .append("id, ")
	       .append("nombre, ")
	       .append("cantidad, ")
	       .append("subtotal ")
	       .append("FROM detallepedidoview WHERE id_pedido = ?");

	    try (Connection c = con.getConexion();
	         PreparedStatement ps = c.prepareStatement(sql.toString())) {

	        ps.setInt(1, id);

	        try (ResultSet rs = ps.executeQuery()) {
	            lista = new ArrayList<>();
	            while (rs.next()) {
	                Object[] obj = new Object[4];
	                obj[0] = rs.getInt("id");
	                obj[1] = rs.getString("nombre");
	                obj[2] = rs.getInt("cantidad");
	                obj[3] = rs.getDouble("subtotal");
	                lista.add(obj);
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error en la consulta: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return lista;
	}



}
