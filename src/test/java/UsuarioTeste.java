import java.util.List;

import br.com.akira.dao.UsuarioDAO;
import br.com.akira.entidade.Usuario;

public class UsuarioTeste {

	public static void main(String[] args) {

//		insere();
//		atualiza();
//		exclui();
//		buscaTodos();
//		buscaPorId();
//		buscaPorNome();
//		autentica();

	}

	private static void autentica() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuAutenticado = dao.autentica("aki", "322");
		System.out.println("ID   : " + usuAutenticado.getId());
		System.out.println("Nome : " + usuAutenticado.getNome());
		System.out.println("Login: " + usuAutenticado.getLogin());
		System.out.println("Senha: " + usuAutenticado.getSenha());
	}

	private static void buscaPorNome() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> lista = dao.buscaPorNome("Aki");
		for (Usuario u : lista) {
			System.out.println("ID   : " + u.getId());
			System.out.println("Nome : " + u.getNome());
			System.out.println("Login: " + u.getLogin());
			System.out.println("Senha: " + u.getSenha());
		}
	}

	private static void buscaPorId() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario objBuscado = dao.buscaPorId(3);
		System.out.println("ID   : " + objBuscado.getId());
		System.out.println("Nome : " + objBuscado.getNome());
		System.out.println("Login: " + objBuscado.getLogin());
		System.out.println("Senha: " + objBuscado.getSenha());
	}

	private static void buscaTodos() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> lista = dao.buscaTodos();
		for (Usuario u : lista) {
			System.out.println("ID   : " + u.getId());
			System.out.println("Nome : " + u.getNome());
			System.out.println("Login: " + u.getLogin());
			System.out.println("Senha: " + u.getSenha());
		}
	}

	private static void exclui() {
		Usuario u = new Usuario();
		u.setId(2);

		UsuarioDAO dao = new UsuarioDAO();
		dao.exclui(u);
	}

	private static void atualiza() {
		Usuario u = new Usuario();
		u.setNome("Leandro");
		u.setLogin("lea");
		u.setSenha("123");
		u.setId(2);

		UsuarioDAO dao = new UsuarioDAO();
		dao.atualiza(u);
	}

	private static void insere() {
		Usuario u = new Usuario();
		u.setNome("Leandro");
		u.setLogin("leo");
		u.setSenha("123");

		UsuarioDAO dao = new UsuarioDAO();
		dao.insere(u);
	}

}
