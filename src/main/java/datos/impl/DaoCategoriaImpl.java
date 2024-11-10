package datos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.DaoCategoria;
import modelo.Categoria;
import modelo.Mesa;
import util.Conexion;

public class DaoCategoriaImpl implements DaoCategoria {
	Conexion con;

	public DaoCategoriaImpl() {
		con = new Conexion();
	}

	@Override
	public List<Categoria> consultar() {
		List<Categoria> lista = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append("id, nombre, tipo").append(" FROM categoria");
		try (Connection c = con.getConexion();
				PreparedStatement ps = c.prepareStatement(sql.toString());
				ResultSet rs = ps.executeQuery();) {
			lista = new ArrayList<>();
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt(1));
				categoria.setNombre(rs.getString(2));
				categoria.setTipo(Categoria.TipoCategoria.valueOf(rs.getString(3)));
				lista.add(categoria);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Override
	public boolean agregar(Categoria objeto) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO categoria(").append("id,").append("nombre,").append("tipo").append(") VALUES (null,?,?)");

		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
			ps.setString(1, objeto.getNombre());
			ps.setString(2, objeto.getTipo().toString());
			return (ps.executeUpdate() != 0);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean editar(Categoria objeto) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE categoria SET ").append("nombre = ?,").append("tipo = ?")
				.append(" WHERE id = ?");
		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
			ps.setString(1, objeto.getNombre());
			ps.setString(2, objeto.getTipo().toString());
			ps.setInt(3, objeto.getId());

			return (ps.executeUpdate() != 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean eliminar(int codigo) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM categoria ").append("WHERE id = ?");
		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
			ps.setInt(1, codigo);
			return (ps.executeUpdate() != 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public Categoria obtener(int codigo) {
		Categoria categoria = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre,")
                .append("tipo")
                .append(" FROM categoria")
                .append(" WHERE id = ?");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	categoria = new Categoria();
                	categoria.setId(rs.getInt(1));
                	categoria.setNombre(rs.getString(2));
                	categoria.setTipo(Categoria.TipoCategoria.valueOf(rs.getString(3)));
                }
            } catch (Exception e) {
            	System.out.println(e.getMessage());
            }

        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        return categoria;
	}

	@Override
	public List<Categoria> filtrar(String tipo) {
		List<Categoria> lista = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append("id, nombre, tipo").append(" FROM categoria").append(" WHERE tipo = ?");
		 try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
	            ps.setString(1, tipo);
	            try (ResultSet rs = ps.executeQuery()) {
	            	lista = new ArrayList<>();
	    			while (rs.next()) {
	    				Categoria categoria = new Categoria();
	    				categoria.setId(rs.getInt(1));
	    				categoria.setNombre(rs.getString(2));
	    				categoria.setTipo(Categoria.TipoCategoria.valueOf(rs.getString(3)));
	    				lista.add(categoria);
	                }
	            } catch (Exception e) {
	            	System.out.println(e.getMessage());
	            }

	        } catch (Exception e) {
	        	System.out.println(e.getMessage());
	        }
		return lista;
	}
}
