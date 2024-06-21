package persistencia;

import java.time.LocalDate;

import model.Pessoa;

public class testePessoaDaoJdbc {
	public static void main(String[] args) {
		PessoaDaoJpa pdao = new PessoaDaoJpa();
		Pessoa p = new Pessoa("Joao",LocalDate.of(2000, 2, 3));
		Pessoa p2 = new Pessoa("Joaozin", LocalDate.of(1999, 2, 4));
		
		
		pdao.insert(p);
		pdao.insert(p2);

		p.setNome("joao silva Gomes");
		pdao.update(p);
		pdao.delete(p2.getId());
		
		System.out.println("===get==="+pdao.get(1));
		System.out.println("===list===\n"+pdao.list(10, 0));
	}
}
