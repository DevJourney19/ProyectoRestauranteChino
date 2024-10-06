package datos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.DaoCliente;
import datos.DaoPedido;
import datos.DaoTrabajador;
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
		List<Pedido> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idPedido,")
                .append("descripcionPedido,")
                .append("fechaPedido,")
                .append("metodoPago,")
                .append("precioTotal")
                .append("idCliente,")
                .append("idVendedor")
                .append(" FROM Pedido");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString()); ResultSet rs = ps.executeQuery();) {
            lista = new ArrayList<>();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                pedido.setDescripcionPedido(rs.getString(2));
                pedido.setFechaPedido(rs.getString(3));
                pedido.setMetodoPago(rs.getString(4));
                pedido.setPrecioTotal(rs.getDouble(5));
                Integer idCli = rs.getInt(6);
                Integer idVen = rs.getInt(7);
                pedido.setCliente(cli.get(idCli));
                pedido.setVendedor(ve.get(idVen));
                lista.add(pedido);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
	}

	@Override
	public boolean agregar(Pedido objeto) {
		// TODO Auto-generated method stub
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

}
