import java.util.List;

public class GerenciadorLivro {
	private LivroDao lDao;
	public GerenciadorLivro(LivroDao ldao) {
		this.lDao = ldao;
	}
	public void cancelarReservas() {
		//buscar livros reservados 
		List<Livro> reservados = lDao.listarReservados();
		//percorre e verificar se a reserva é maior uqe 7 dias ou nao.
		//caso seja deve cancelarReserva
		//persistir no bd o livro alterado 
	}
}
