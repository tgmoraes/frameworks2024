package exemplo1;

import java.util.InputMismatchException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class MotoTest {

	@BeforeAll
	public static void fazAntes() {
		System.out.println("-inicio testes-");
	}

	@AfterAll
	public static void fazDepois() {
		System.out.println("-fim testes-");
	}

	@BeforeEach
	public void fazAntesCada() {
		System.out.println("===inicio novo teste===");
	}

	@AfterEach
	public void fazDepoisCada() {
		System.out.println("===fim teste===");
	}

	@Test
	@DisplayName("Testa Acelerar valor positivo")
	public void testaAcelerarPositivo() {
		Moto moto = new Moto("CG Titan");

		moto.acelera(60);
		Assertions.assertEquals(62, moto.getVelocidade(), 0.0001);
		Assertions.assertEquals(63, moto.getVelocidade(), 0.0001);
	}

	@Test
	@DisplayName("Testa Acelerar zero")
	public void testaAcelerarZero() {
		Moto moto = new Moto("CG Titan");

		moto.acelera(0);
		Assertions.assertEquals(0, moto.getVelocidade(), 0.0001);
	}

	@Test
	@DisplayName("Testa Acelerar valor negativo")
	public void testaAcelerarNegativo() {
		Moto moto = new Moto("CG Titan");
		Assertions.assertThrows(RuntimeException.class, () -> {
			moto.acelera(-5);
		});
	}
	
	@Test
	@DisplayName("Testa exception divisao zero")
	public void testaException() {
		int x =0;
		Assertions.assertThrows(ArithmeticException.class, () -> {
			int y =5/x;
		});
	}

	@Test
	@DisplayName("Teste simples com timeout")
	@Timeout(3)
	// metodo não pode demorar mais que 3 segundos para nao falhar
	public void testaTempo() throws InterruptedException {
		Thread.sleep(2000); // espera 2 segundos
		// Thread.sleep(4000); //descomentar para falhar
	}

	@Test
	@DisplayName("varias assertivas no teste")
	public void multiAssertivas() {
		int x=3;
		String str = null;
		Assertions.assertAll(
			()-> Assertions.assertEquals(3,x),
			()-> Assertions.assertTrue(3==x),
			()-> Assertions.assertFalse(3==x), //erro
			()-> Assertions.assertNull(str),
			()-> {
				String str2 = "oi";
				Assertions.assertNotNull(str); //erro
			});
	}
}
