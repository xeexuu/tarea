package tareafinal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalcularTestTest {

	/**
	 * Atributos
	 * LOG es el logger que imprimirá por consola y en el fichero
	 */
	public static final Logger LOG = LogManager.getLogger(CalcularTest.class);

	CalcularTest cT = new CalcularTest();

	@Test
	void testNotaExacta() {
		LOG.debug("Primera prueba.");
		double nota = 5.2;
		Assertions.assertEquals(nota, cT.notaExacta(nota));
	}

	@Test
	void testAprobar() {
		LOG.debug("Segunda prueba, primer intento.");
		int aciertos0 = 63;
		Assertions.assertEquals(true, cT.aprobar(aciertos0));

		LOG.debug("Segunda prueba, segundo intento.");
		int aciertos1 = 5;
		Assertions.assertEquals(false, cT.aprobar(aciertos1));
	}

}
