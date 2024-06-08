import java.sql.Connection;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Pessoa;
import persistencia.FabricaConexao;
import persistencia.PessoaDAO;

public class PessoaDAOTest {
	private PessoaDAO pdao;
	public void montaCenario() {
		Connection con = FabricaConexao.getConexao();
		pdao = new PessoaDAO(con);
	}
	
	@Test
	public static void main(String[] args) {
		Pessoa p = new Pessoa("Joao", LocalDate.of(2001, 4, 3));
		PessoaDAO pdao = new PessoaDAO();
		System.out.println(p.getId());
		
		pdao.insert(p);
		
		System.out.println(p.getId());
		
		Assertions.assertNotNull(p.getId());
		
	}
}
