package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Pessoa;

public class testePessoaDAo {

	public static void main(String[] args) throws SQLException {
		Connection con = FabricaConexao.getConexao();
		con.setAutoCommit(false);
		
		PessoaDAO pdao = new PessoaDAO(con);
		
		Pessoa p = new Pessoa("teste random", LocalDate.of(2002,10,10));
		
		pdao.insert(p);
		System.out.println(p);
		Pessoa p1 = pdao.get(p.getId());
		System.out.println(p1);
		p1.setDataNascimento(LocalDate.of(1902, 2, 2));
		p1.setNome("novo nome");
		pdao.save(p1);
		System.out.println(pdao.get(p.getId()));
		
		//pdao.delete(p1.getId());
		System.out.println(pdao.list(20, 0));
		con.rollback();
	}

}
