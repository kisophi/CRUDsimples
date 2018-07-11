package br.com.akira.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.akira.entidade.Usuario;
import br.com.akira.util.ConnectionFactory;

public class UsuarioDAO {

	Connection conn = ConnectionFactory.getConnection();
	PreparedStatement ps = null;

	String sqlInsere = "INSERT INTO usuario VALUES(null,?,?,?)";
	String sqlAtualiza = "UPDATE usuario SET nome=?,login=?,senha=? WHERE id=?";
	String sqlExclui = "DELETE FROM usuario WHERE id=?";
	String sqlBuscaTodos = "SELECT * FROM usuario";
	String sqlBuscaPorId = "SELECT * FROM usuario WHERE id=?";
	String sqlBuscaPorNome = "SELECT * FROM usuario WHERE nome LIKE ?";
	String sqlAutentica = "SELECT * FROM usuario WHERE login=? AND senha=?";

	public void insere(Usuario u) {
		try {
			ps = conn.prepareStatement(sqlInsere);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			ps.execute();
			System.out.println("Inserido :\n" + ps.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void atualiza(Usuario u) {
		try {
			ps = conn.prepareStatement(sqlAtualiza);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			ps.setInt(4, u.getId());

			ps.execute();
			System.out.println("Atualizado :\n" + ps.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void exclui(Usuario u) {
		try {
			ps = conn.prepareStatement(sqlExclui);
			ps.setInt(1, u.getId());

			ps.execute();
			System.out.println("Excluido :\n" + ps.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Usuario> buscaTodos() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			ps = conn.prepareStatement(sqlBuscaTodos);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				lista.add(u);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Usuario buscaPorId(int id) {
		try {
			ps = conn.prepareStatement(sqlBuscaPorId);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				return u;
			} else {
				System.out.println("Usuario não encotrado !!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Usuario autentica(String login, String senha) {
		try {
			ps = conn.prepareStatement(sqlAutentica);
			ps.setString(1, login);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				return u;
			} else {
				System.out.println("Usuario/Senha incorreta !!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Usuario> buscaPorNome(String nome) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			ps = conn.prepareStatement(sqlBuscaPorNome);
			ps.setString(1, nome + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				lista.add(u);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
