import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LivroTest {

	@Test
	@DisplayName("testa leitura positiva")
	public void testaLerPos() {
		Livro l =  new Livro("Harry Potter 1", 300);
		l.ler(10);
		Assertions.assertEquals(10,l.getPaginasLidas());
	}
	@Test
	@DisplayName("testa leitura positiva de muitas paginas")
	public void testaLerPos2() {
		Livro l =  new Livro("Harry Potter 1", 300);
		l.ler(350);
		Assertions.assertEquals(300,l.getPaginasLidas());
	}

}
