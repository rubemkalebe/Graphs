package main.arc.visitor;

/**
 * Classe concreta para visitantes comuns. Utilizada para percussos em grafos.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public class VisitorDefault implements VisitorInterface {

	/**
	 * Verifica se o percusso foi concluido.
	 * 
	 * @return true se o percusso foi concluido, false caso contrario
	 */
	public boolean isDone() {
		return true; // ------
	}
	
	/**
	 * Visita um objeto.
	 * 
	 * @param obj Objeto a ser visitado
	 */
	public void visit(Object obj) {
		
	}
	
}
