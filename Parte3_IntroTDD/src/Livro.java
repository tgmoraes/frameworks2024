//num paginas
//num lidas
//titulo
//autores
public class Livro {
	private int paginasLidas;
	private int paginas;
	public Livro(String titulo, int paginas) {
		this.paginas = paginas;
		this.paginasLidas = 0;
	}

	public void ler(int pags) {
		if(this.paginasLidas+pags<this.paginas) {
				paginasLidas =+ pags;
		}else {
			this.paginasLidas = this.paginas;
		}
		
	}

	public int getPaginasLidas() {
		return this.paginasLidas;
	}
}
