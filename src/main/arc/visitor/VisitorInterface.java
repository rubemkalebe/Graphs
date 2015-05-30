package main.arc.visitor;

/**
 * Interface comum a visitantes, utilizados para percussos em grafos.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public interface VisitorInterface {

	/**
	 * Verifica se o percusso foi concluido.
	 * 
	 * @return true se o percusso foi concluido, false caso contrario
	 */
	public boolean isDone();
	
	/**
	 * Visita um objeto.
	 * 
	 * @param obj Objeto a ser visitado
	 */
	public void visit(Object obj);
	
}
