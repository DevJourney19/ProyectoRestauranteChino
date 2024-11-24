package datos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import datos.DaoCliente;
import modelo.Cliente;
import util.Conexion;

public class DaoClienteImpl implements DaoCliente {
	Conexion con;

	public DaoClienteImpl() {
		con = new Conexion();
	}

	@Override
	public List<Cliente> consultar() {
		List<Cliente> lista = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append("id, dni_ruc, telefono, correo, tipo").append(" FROM cliente");
		try (Connection c = con.getConexion();
				PreparedStatement ps = c.prepareStatement(sql.toString());
				ResultSet rs = ps.executeQuery();) {
			lista = new ArrayList<>();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt(1));
				cliente.setDni_ruc(rs.getString(2));
				cliente.setTelefono(rs.getString(3));
				cliente.setCorreo(rs.getString(4));
				cliente.setTipo(Cliente.Tipo.valueOf(rs.getString(5)));
				lista.add(cliente);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Override
	public Cliente agregar(Cliente cliente) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO cliente(").append("id, dni_ruc, telefono, correo, tipo")
				.append(") VALUES (null,?,?,?,?)");

		try (Connection c = con.getConexion();
				PreparedStatement ps = c.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, cliente.getDni_ruc());
			ps.setString(2, cliente.getTelefono());
			ps.setString(3, cliente.getCorreo());
			if (cliente.getTipo() != null) {
				ps.setString(4, cliente.getTipo().toString());
			} else {
				// Si tipo es null, asigna un valor por defecto o maneja el caso según lo
				// necesites
				ps.setString(4, "DNI"); // O el valor por defecto que decidas
			}

			int resultSet = ps.executeUpdate();

			if (resultSet > 0) {
				try (ResultSet generatedKeys = ps.getGeneratedKeys()) {

					if (generatedKeys.next()) {
						// Asignar el ID generado al objeto Pedido
						cliente.setId(generatedKeys.getInt(1)); // Suponiendo que 'id' es de tipo INT
					}
				}
			}

			return cliente;
		} catch (Exception e) {
			System.out.println("Error al agregar cliente: " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean editar(Cliente cliente) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE cliente SET ").append("dni_ruc = ?,").append("telefono = ?,").append("correo = ?,")
				.append("tipo = ?").append(" WHERE id = ?");
		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
			ps.setString(1, cliente.getDni_ruc());
			ps.setString(2, cliente.getTelefono());
			ps.setString(3, cliente.getCorreo());
			ps.setString(4, cliente.getTipo().toString());
			ps.setInt(5, cliente.getId());

			return (ps.executeUpdate() != 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean eliminar(int codigo) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM cliente ").append("WHERE id = ?");
		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
			ps.setInt(1, codigo);
			return (ps.executeUpdate() != 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public Cliente obtener(int codigo) {
		Cliente cliente = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append("id,").append("dni_ruc,").append("telefono,").append("correo,").append("tipo")
				.append(" FROM cliente").append(" WHERE dni_ruc = ?");
		try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
			ps.setString(1, String.valueOf(codigo));
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					cliente = new Cliente();
					cliente.setId(rs.getInt(1));
					cliente.setDni_ruc(rs.getString(2));
					cliente.setTelefono(rs.getString(3));
					cliente.setCorreo(rs.getString(4));
					cliente.setTipo(Cliente.Tipo.valueOf(rs.getString(5)));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cliente;
	}

}
