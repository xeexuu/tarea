/*
 * 
 */
package tareafinal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Jesús Morgado Fernández
 * @version 1.0
 * @implNote Fecha: miércoles 02 de junio de 2021
 */

public class CalcularTest {
	/**
	 * Atributos
	 * LOG es el logger que imprimirá por consola y en el fichero
	 */
	public static final Logger LOG = LogManager.getLogger(CalcularTest.class);

	/**
	 * Método que calcula, si es posible, sacar una nota exacta en el examen
	 * propuesto contestando todas las preguntas.
	 * 
	 * @param meta = es la nota que quieres comprobar si es posible obtener en el examen propuesto
	 * @return la nota que has introducido, si es posible, sino devuelve la más próxima
	 */
	public double notaExacta(double meta) {
		double penalizacion, preguntas, aciertos, fallos, nota;
		LOG.debug("Entrando en el primer método.");
		LOG.info("Suponiendo un examen de 100 preguntas donde cada 3 fallos te restan 1 acierto.");
		penalizacion = 3;
		preguntas = 100;
		aciertos = ((preguntas * meta) / 10);
		aciertos = (Math.ceil(aciertos));
		fallos = (preguntas - aciertos);
		fallos = (fallos / (1 + (1 / penalizacion)));
		aciertos = (aciertos + (fallos / penalizacion));
		aciertos = (Math.ceil(aciertos));
		fallos = (preguntas - aciertos);
		nota = (((aciertos - (fallos / penalizacion)) * 10) / preguntas);
		LOG.info("Deber acertar " + aciertos + " si fallas " + fallos + "\t\tNota: " + nota);
		return nota;
	}

	/**
	 * Método que calcula, si es posible, aprobar en el examen propuesto.
	 * 
	 * @param aciertos = las preguntas que vas a acertar en el examen propuesto
	 * @return si aprobarás o no con esos aciertos en el examen propuesto
	 */
	public boolean aprobar(double aciertos) {
		double penalizacion, preguntas, fallos, nota;
		boolean aprobado = false;
		LOG.debug("Entrando en el segundo método.");
		LOG.info("Suponiendo un examen de 100 preguntas donde cada 3 fallos te restan 1 acierto.");
		penalizacion = 3;
		preguntas = 100;
		aciertos = (Math.ceil(aciertos));
		fallos = (preguntas - aciertos);
		nota = (((aciertos - (fallos / penalizacion)) * 10) / preguntas);
		if (nota >= 5) {
			LOG.info("Apruebas.");
			aprobado = true;
		} else {
			LOG.warn("No apruebas.");
		}
		return aprobado;
	}
}
