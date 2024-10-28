package datos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.DaoCliente;
import datos.DaoPedido;
import datos.DaoTrabajador;
import modelo.Cliente;
import modelo.Mesa;
import modelo.Pedido;
import util.Conexion;
public class DaoPedidoImpl implements DaoPedido{
	
	Conexion con;
    private DaoCliente cli;
    private DaoTrabajador tra;
    public static Integer idPed;

    public DaoPedidoImpl() {
        con = new Conexion();
        cli = new DaoClienteImpl();
        tra = new DaoTrabajadorImpl();
  
    }

	@Override
	public List<Pedido> consultar() {
		return null;
	}

	@Override
	public boolean agregar(Pedido objeto) {
		StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO pedido(")
                .append("id_cliente,")
                .append("id_mesa,")
                .append("tipo_recibo,")
                .append("metodo_pago,")
                .append("total,")
                .append("id_trabajador")
                .append(") VALUES (?,?,?,?,?,?)");

        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, objeto.getCliente().getId());
            ps.setInt(2, objeto.getMesa().getId());
            ps.setString(3, objeto.getTipo_recibo().toString());
            ps.setString(4, objeto.getMetodo_pago().toString());
            ps.setDouble(5, objeto.getTotal());
            ps.setInt(6, objeto.getTrabajador().getId());
            return (ps.executeUpdate() != 0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
	}

	@Override
	public boolean editar(Pedido objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pedido obtener(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> verData() {
		 List<Object[]> lista = null;
	        StringBuilder sql = new StringBuilder();
	        sql.append("SELECT ")
	                .append("id,")
	                .append("dni_ruc,")
	                .append("n_mesa,")
	                .append("estado,")
	                .append("tipo_recibo,")
	                .append("metodo_pago,")
	                .append("total,")
	                .append("created_at")
	                .append(" FROM pedidosView");
	        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString()); ResultSet rs = ps.executeQuery();) {
	            lista = new ArrayList<>();

	            while (rs.next()) {
	                Object[] obj = new Object[8];
	                obj[0] = rs.getInt(1);
	                obj[1] = rs.getString(2);
	                obj[2] = rs.getInt(3);
	                obj[3] = rs.getString(4);
	                obj[4] = rs.getString(5);
	                obj[5] = rs.getString(6);
	                obj[6] = rs.getDouble(7);
	                obj[7] = rs.getString(8);
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

}
