import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class LivroTest {

	@Test
	@DisplayName("testa leitura positiva")
	public void testaLerPos() {
		Livro l = new Livro("Harry Potter 1", 300);
		l.ler(10);
		Assertions.assertEquals(10, l.getPaginasLidas());
	}

	@Test
	@DisplayName("testa leitura positiva de muitas paginas")
	public void testaLerPos2() {
		Livro l = new Livro("Harry Potter 1", 300);
		l.ler(350);
		Assertions.assertEquals(300, l.getPaginasLidas());

	}

	@Test
	@DisplayName("teste simples de sintaxe do mockito")
	public void testaMockito() {
		// import static org.mockito.Mockito.*;
		Livro livroFalso = mock(Livro.class);

		String titulo = "senhor dos aneis";
		livroFalso.setTitulo(titulo);
		System.out.println(livroFalso.getTitulo());

		when(livroFalso.getTitulo()).thenReturn(titulo);
		System.out.println(livroFalso.getTitulo());

		verify(livroFalso, atLeast(2)).getTitulo();
	}

}
