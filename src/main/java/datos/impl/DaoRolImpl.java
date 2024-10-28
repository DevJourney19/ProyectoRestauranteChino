package datos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.DaoRol;
import modelo.Categoria;
import modelo.Rol;
import util.Conexion;

public class DaoRolImpl implements DaoRol {
	
	Conexion con;

	public DaoRolImpl() {
		con = new Conexion();
	}


	@Override
	public List<Rol> consultar() {
		List<Rol> lista = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append("id, nombre").append(" FROM rol");
		try (Connection c = con.getConexion();
				PreparedStatement ps = c.prepareStatement(sql.toString());
				ResultSet rs = ps.executeQuery();) {
			lista = new ArrayList<>();
			while (rs.next()) {
				Rol rol = new Rol();
				rol.setId(rs.getInt(1));
				rol.setNombre(rs.getString(2));
				lista.add(rol);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Override
	public boolean agregar(Rol objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editar(Rol objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rol obtener(int codigo) {
		Rol rol = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre")
                .append(" FROM rol")
                .append(" WHERE id = ?");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	rol = new Rol();
                	rol.setId(rs.getInt(1));
                	rol.setNombre(rs.getString(2));
                }
            } catch (Exception e) {
            	System.out.println(e.getMessage());
            }

        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        return rol;
	}

}
