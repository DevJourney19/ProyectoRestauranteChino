package datos.impl;

import java.sql.*;
import java.util.*;

import datos.DaoMesa;
import modelo.Mesa;
import util.Conexion;

public class DaoMesaImpl implements DaoMesa {
	
	Conexion con;
	
	public DaoMesaImpl() {
        con = new Conexion();
    }

	@Override
	public List<Mesa> consultar() {
		List<Mesa> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id, n_salon, n_mesa, estado")
                .append(" FROM mesa");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString()); ResultSet rs = ps.executeQuery();) {
            lista = new ArrayList<>();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setId(rs.getInt(1));
                mesa.setN_salon(rs.getInt(2));
                mesa.setN_mesa(rs.getInt(3));
                mesa.setEstado(Mesa.EstadoMesa.valueOf(rs.getString(4)));
                lista.add(mesa);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
	}

	@Override
	public boolean agregar(Mesa objeto) {
		 StringBuilder sql = new StringBuilder();
	        sql.append("INSERT INTO mesa(")
	                .append("id,")
	                .append("n_salon,")
	                .append("n_mesa")
	                .append(") VALUES (null,?,?)");

	        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
	            ps.setInt(1, objeto.getN_salon());
	            ps.setInt(2, objeto.getN_mesa());
	            return (ps.executeUpdate() != 0);

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        return false;
	}

	@Override
	public boolean editar(Mesa objeto) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE mesa SET ")
                .append("n_salon = ?,")
                .append("n_mesa = ?,")
                .append("estado = ?")
                .append(" WHERE id = ?");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, objeto.getN_salon());
            ps.setInt(2, objeto.getN_mesa());
            ps.setString(3, objeto.getEstado().toString());
            ps.setInt(4, objeto.getId());

            return (ps.executeUpdate() != 0);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
		return false;
	}

	@Override
	public boolean eliminar(int codigo) {
		StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM mesa ")
                .append("WHERE id = ?");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, codigo);
            return (ps.executeUpdate() != 0);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        return false;
	}

	@Override
	public Mesa obtener(int codigo) {
		Mesa mesa = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("n_salon,")
                .append("n_mesa,")
                .append("estado")
                .append(" FROM mesa")
                .append(" WHERE id = ?");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    mesa = new Mesa();
                    mesa.setId(rs.getInt(1));
                    mesa.setN_salon(rs.getInt(2));
                    mesa.setN_mesa(rs.getInt(3));
                    mesa.setEstado(Mesa.EstadoMesa.valueOf(rs.getString(4)));
                }
            } catch (Exception e) {
            	System.out.println(e.getMessage());
            }

        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        return mesa;
	}

}
